-- Author: Sebastián Quesada Velluti
-- Date: 28/6/2020

-- From SYSTEM
grant select on app.city to adm;
grant select on app.community to adm;
grant select on app.country to adm;
grant select on app.district to adm;
grant select on app.gender to adm;
grant select on app.institution to adm;
grant select on app.person to adm;
grant select on app.picture to adm;
grant select on app.place to adm;
grant select on app.record to adm;
grant select on app.state to adm;
grant select on app.type to adm;
grant select on app.veredict to adm;

-- From ADM
CREATE OR REPLACE PACKAGE statistics IS
    FUNCTION records_classification RETURN sys_refcursor;
    FUNCTION records_by_district(vIdCity NUMBER DEFAULT NULL, vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION records_by_city(vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION records_by_state(vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION records_by_country RETURN sys_refcursor;
    FUNCTION users_age_range RETURN sys_refcursor;
    FUNCTION criminal_age_range RETURN sys_refcursor;
    FUNCTION criminals_by_district(vIdCity NUMBER DEFAULT NULL, vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION criminals_by_city(vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION criminals_by_state(vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION criminals_by_country RETURN sys_refcursor;
    FUNCTION average_record_type_years RETURN sys_refcursor;
    FUNCTION sentence_time_to_expiration RETURN sys_refcursor;
    FUNCTION records_with_house_arrest RETURN sys_refcursor;
END statistics;
/

CREATE OR REPLACE PACKAGE BODY statistics IS
    FUNCTION records_classification RETURN sys_refcursor
    AS 
        cclassification sys_refcursor;
        BEGIN
            OPEN cclassification FOR
                SELECT t.name name, count(r.id_type) quantity, round((ratio_to_report(count(r.id_type)) over ())*100, 2) percentage
                FROM app.record r
                INNER JOIN app.type t ON r.id_type = t.id
                GROUP BY t.name
                ORDER BY quantity DESC;
            RETURN cclassification;
        END;
        
    FUNCTION records_by_district(vIdCity NUMBER DEFAULT NULL, vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS
        cdistrict sys_refcursor;
        BEGIN
            OPEN cdistrict FOR
                SELECT d.name district, ci.name city, s.name state, co.name country, count(d.id) quantity, round((ratio_to_report(count(d.id)) over ())*100, 2) percentage
                FROM app.record r
                INNER JOIN app.district d ON r.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE r.approved = 'Y' AND 
                      (ci.id = NVL(vIdCity, ci.id) OR vIdCity < 1) AND
                      (s.id = NVL(vIdState, s.id) OR vIdState < 1) AND
                      (co.id = NVL(vIdCountry, co.id) OR vIdCountry < 1)
                GROUP BY d.name, ci.name, s.name, co.name
                ORDER BY quantity DESC;
            RETURN cdistrict;
        END;

    FUNCTION records_by_city(vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS
        ccity sys_refcursor;
        BEGIN
            OPEN ccity FOR
                SELECT ci.name city, s.name state, co.name country, count(ci.id) quantity, round((ratio_to_report(count(ci.id)) over ())*100, 2) percentage
                FROM app.record r
                INNER JOIN app.district d ON r.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE r.approved = 'Y' AND 
                      (s.id = NVL(vIdState, s.id) OR vIdState < 1) AND
                      (co.id = NVL(vIdCountry, co.id) OR vIdCountry < 1)
                GROUP BY ci.name, s.name, co.name
                ORDER BY quantity DESC;
            RETURN ccity;
        END;

    FUNCTION records_by_state(vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS
        cstate sys_refcursor;
        BEGIN
            OPEN cstate FOR
                SELECT s.name state, co.name country, count(s.id) quantity, round((ratio_to_report(count(s.id)) over ())*100, 2) percentage
                FROM app.record r
                INNER JOIN app.district d ON r.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE r.approved = 'Y' AND 
                      (co.id = NVL(vIdCountry, co.id) OR vIdCountry < 1)
                GROUP BY s.name, co.name
                ORDER BY quantity DESC;
            RETURN cstate;
        END;
        
    FUNCTION records_by_country RETURN sys_refcursor
    AS
        ccountry sys_refcursor;
        BEGIN
            OPEN ccountry FOR
                SELECT co.name country, count(co.id) quantity, round((ratio_to_report(count(co.id)) over ())*100, 2) percentage
                FROM app.record r
                INNER JOIN app.district d ON r.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE r.approved = 'Y'
                GROUP BY co.name
                ORDER BY quantity DESC;
            RETURN ccountry;
        END;
        
    FUNCTION users_age_range RETURN sys_refcursor
    AS
        cages sys_refcursor;
        BEGIN
            OPEN cages FOR
            select age_range_users, quantity, round((ratio_to_report(quantity) over ())*100, 2) percentage
            from 
            (
                select '0-18' as age_range_users, sum(case when p.age between 0 and 18 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '0-18'
                union all
                select '19-30' as age_range_users, sum(case when age between 19 and 30 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '19-30'
                union all
                select '31-45' as age_range_users, sum(case when age between 31 and 45 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '31-45'
                union all
                select '46-55' as age_range_users, sum(case when age between 46 and 55 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '46-55'
                union all
                select '56-65' as age_range_users, sum(case when age between 56 and 65 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '56-65'
                union all
                select '66-75' as age_range_users, sum(case when age between 66 and 75 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '66-75'
                union all
                select '76-85' as age_range_users, sum(case when age between 76 and 85 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '76-85'
                union all
                select '86+' as age_range_users, sum(case when age >= 86 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '86+'
            )
            order by age_range_users;
        RETURN cages;
    END;
    
    FUNCTION criminal_age_range RETURN sys_refcursor
    AS
        cages sys_refcursor;
        BEGIN
            OPEN cages FOR
            select age_range_criminals, quantity, round((ratio_to_report(quantity) over ())*100, 2) percentage
            from 
            (
                select '0-18' as age_range_criminals, sum(case when p.age between 0 and 18 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '0-18'
                union all
                select '19-30' as age_range_criminals, sum(case when age between 19 and 30 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '19-30'
                union all
                select '31-45' as age_range_criminals, sum(case when age between 31 and 45 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '31-45'
                union all
                select '46-55' as age_range_criminals, sum(case when age between 46 and 55 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '46-55'
                union all
                select '56-65' as age_range_criminals, sum(case when age between 56 and 65 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '56-65'
                union all
                select '66-75' as age_range_criminals, sum(case when age between 66 and 75 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '66-75'
                union all
                select '76-85' as age_range_criminals, sum(case when age between 76 and 85 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM adm.appuser)
                group by '76-85'
                union all
                select '86+' as age_range_criminals, sum(case when age >= 86 then 1 else 0 end) as quantity 
                from app.person p
                where p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                group by '86+'
            )
            order by age_range_criminals;
        RETURN cages;
    END;
    
    FUNCTION criminals_by_district(vIdCity NUMBER DEFAULT NULL, vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS
        cdistrict sys_refcursor;
        BEGIN
            OPEN cdistrict FOR
                SELECT d.name district, ci.name city, s.name state, co.name country, count(d.id) quantity, round((ratio_to_report(count(d.id)) over ())*100, 2) percentage
                FROM app.person p
                INNER JOIN app.district d ON p.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y') AND
                      (ci.id = NVL(vIdCity, ci.id) OR vIdCity < 1) AND
                      (s.id = NVL(vIdState, s.id) OR vIdState < 1) AND
                      (co.id = NVL(vIdCountry, co.id) OR vIdCountry < 1)
                GROUP BY d.name, ci.name, s.name, co.name
                ORDER BY quantity DESC;
            RETURN cdistrict;
        END;

    FUNCTION criminals_by_city(vIdState NUMBER DEFAULT NULL, vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS
        ccity sys_refcursor;
        BEGIN
            OPEN ccity FOR
                SELECT ci.name city, s.name state, co.name country, count(d.id) quantity, round((ratio_to_report(count(d.id)) over ())*100, 2) percentage
                FROM app.person p
                INNER JOIN app.district d ON p.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y') AND
                      (s.id = NVL(vIdState, s.id) OR vIdState < 1)AND
                      (co.id = NVL(vIdCountry, co.id) OR vIdCountry < 1)
                GROUP BY ci.name, s.name, co.name
                ORDER BY quantity DESC;
            RETURN ccity;
        END;
        
    FUNCTION criminals_by_state(vIdCountry NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS
        cstate sys_refcursor;
        BEGIN
            OPEN cstate FOR
                SELECT s.name state, co.name country, count(d.id) quantity, round((ratio_to_report(count(d.id)) over ())*100, 2) percentage
                FROM app.person p
                INNER JOIN app.district d ON p.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y') AND
                      (co.id = NVL(vIdCountry, co.id) OR vIdCountry < 1)
                GROUP BY s.name, co.name
                ORDER BY quantity DESC;
            RETURN cstate;
        END;

    FUNCTION criminals_by_country RETURN sys_refcursor
    AS
        ccountry sys_refcursor;
        BEGIN
            OPEN ccountry FOR
                SELECT co.name country, count(d.id) quantity, round((ratio_to_report(count(d.id)) over ())*100, 2) percentage
                FROM app.person p
                INNER JOIN app.district d ON p.id_district = d.id
                INNER JOIN app.city ci ON d.id_city = ci.id
                INNER JOIN app.state s ON ci.id_state = s.id
                INNER JOIN app.country co ON s.id_country = co.id
                WHERE p.id IN (SELECT id_person FROM app.record WHERE approved = 'Y')
                GROUP BY co.name
                ORDER BY quantity DESC;
            RETURN ccountry;
        END;

    FUNCTION average_record_type_years RETURN sys_refcursor
    AS
        caverage sys_refcursor;
        BEGIN
            OPEN caverage FOR
                SELECT t.name record_type, avg(v.years) avg_years_of_sentence, round(ratio_to_report(avg(v.years)) over () *100, 2) percentage
                FROM app.record r
                INNER JOIN app.type t ON r.id_type = t.id
                INNER JOIN app.veredict v ON r.id_veredict = v.id
                GROUP BY t.name
                ORDER BY avg_years_of_sentence DESC;
            RETURN caverage;
        END;
    
    FUNCTION sentence_time_to_expiration RETURN sys_refcursor
    AS
        csentence sys_refcursor;
        BEGIN
            OPEN csentence FOR
                select range, quantity, round((ratio_to_report(quantity) over ())*100, 2) percentage
                from 
                (
                    SELECT 'expired' as range, sum(case when v.date_end - trunc(sysdate) < 0 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'expired'
                    union all
                    SELECT 'less_than_a_month' as range, sum(case when v.date_end - trunc(sysdate) between 0 and 30 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'less_than_a_month'
                    union all
                    SELECT 'less_than_6_months' as range, sum(case when v.date_end - trunc(sysdate) between 31 and 182 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'less_than_6_months'
                    union all
                    SELECT 'less_than_a_year' as range, sum(case when v.date_end - trunc(sysdate) between 183 and 365 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'less_than_a_year'
                    union all
                    SELECT 'less_than_5_years' as range, sum(case when v.date_end - trunc(sysdate) between 366 and 1826 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'less_than_5_years'
                    union all
                    SELECT 'less_than_10_years' as range, sum(case when v.date_end - trunc(sysdate) between 1827 and 3652 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'less_than_10_years'
                    union all
                    SELECT 'more_than_10_years' as range, sum(case when v.date_end - trunc(sysdate) > 3652 then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'more_than_10_years'
                    union all
                    SELECT 'life_imprisonment' as range, sum(case when v.date_end IS NULL then 1 else 0 end) as quantity
                    FROM app.record r
                    INNER JOIN app.veredict v ON r.id_veredict = v.id
                    WHERE r.approved = 'Y'
                    GROUP BY 'life_imprisonment'
                );
            RETURN csentence;
        END;
        
    FUNCTION records_with_house_arrest RETURN sys_refcursor
    AS
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT t.name, count(v.id) quantity, round((ratio_to_report(count(v.id)) over ())*100, 2) percentage
                FROM app.record r
                INNER JOIN app.type t ON r.id_type = t.id
                INNER JOIN app.veredict v ON r.id_veredict = v.id
                WHERE v.id_place = 1
                GROUP BY t.name
                ORDER BY quantity DESC;
            RETURN crecords;
        END;
        
END statistics;
/