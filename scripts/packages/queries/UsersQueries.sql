-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020

-- Connected from SYSTEM
grant all on adm.appuser to app;
grant all on adm.usertype to app;
grant all on adm.banned to app;
grant all on adm.bannedreason to app;
grant all on app.type to app;
grant all on app.city to app;
grant all on app.community to app;
grant all on app.country to app;
grant all on app.district to app;
grant all on app.gender to app;
grant all on app.institution to app;
grant all on app.person to app;
grant all on app.record to app;
grant all on app.state to app;
grant all on app.veredict to app;

-- Conected from APP
CREATE OR REPLACE PACKAGE user_queries IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN sys_refcursor;
    FUNCTION recordsByClassification (vid_type NUMBER DEFAULT NULL, 
                                      vdate_start DATE DEFAULT NULL, 
                                      vdate_end DATE DEFAULT NULL, 
                                      vid_district NUMBER DEFAULT NULL,
                                      vid_city NUMBER DEFAULT NULL,
                                      vid_state NUMBER DEFAULT NULL,
                                      vid_country NUMBER DEFAULT NULL) RETURN sys_refcursor;
    FUNCTION user_list RETURN sys_refcursor;
    FUNCTION users_banned RETURN sys_refcursor;
    FUNCTION records_expiring_between(vdate1 DATE, vdate2 DATE) RETURN sys_refcursor;
    FUNCTION user_list_by_type(vid_type NUMBER) RETURN sys_refcursor;
    FUNCTION records_of_person(vid_person NUMBER) RETURN sys_refcursor;
    FUNCTION records_with_name_person (vfirst_name NUMBER) RETURN sys_refcursor;
END;
/


CREATE OR REPLACE PACKAGE BODY user_queries IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN sys_refcursor
    AS 
        cplaces sys_refcursor;
        BEGIN
            OPEN cplaces FOR
                SELECT name_district, quant_records
                FROM (
                        SELECT d.name name_district, count(p.id_district) quant_records
                        FROM record r
                        INNER JOIN person p ON r.id_person = p.id
                        INNER JOIN district d ON p.id_district = d.id
                        WHERE r.approved = 'Y'
                        GROUP BY d.name
                        ORDER BY quant_records DESC
                    )
                WHERE rownum <= vquantity;
            RETURN cplaces;
        END dangerous_places;

    FUNCTION recordsByClassification (vid_type NUMBER DEFAULT NULL, 
                                      vdate_start DATE DEFAULT NULL, 
                                      vdate_end DATE DEFAULT NULL, 
                                      vid_district NUMBER DEFAULT NULL,
                                      vid_city NUMBER DEFAULT NULL,
                                      vid_state NUMBER DEFAULT NULL,
                                      vid_country NUMBER DEFAULT NULL) RETURN sys_refcursor
    AS 
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT r.numberr record_number
                FROM record r
                inner join type t on r.id_type = t.id
                inner join district d on r.id_district = d.id
                inner join city ci on d.id_city = ci.id
                inner join state s on ci.id_state = s.id
                inner join country co on s.id_country = co.id
                WHERE r.approved = 'Y' AND
                      t.id = NVL(vid_type, t.id) AND
                      r.date_crime between NVL(vdate_start, r.date_crime) and NVL(vdate_end, r.date_crime) AND
                      d.id = NVL(vid_district, d.id) AND
                      ci.id = NVL(vid_city, ci.id) AND
                      s.id = NVL(vid_state, s.id) AND
                      co.id = NVL(vid_country, co.id);
            RETURN crecords;
         END recordsByClassification;

    FUNCTION user_list RETURN sys_refcursor
    AS
        cusers sys_refcursor;
        BEGIN
            OPEN cusers FOR
                SELECT au.username username, ut.description user_type
                FROM adm.appuser au
                INNER JOIN adm.usertype ut ON au.id_usertype = ut.id_usertype;
            RETURN cusers;
        END user_list;

    FUNCTION users_banned RETURN sys_refcursor
    AS
        cusersBanned sys_refcursor;
        BEGIN
            OPEN cusersBanned FOR
                SELECT bn.username, bn.ispermanent, br.description
                FROM adm.banned bn
                inner join adm.bannedreason br on bn.id_bannedreason = br.id_bannedreason
                WHERE bn.ispermanent = 'Y' OR NVL(bn.date_finish, SYSDATE) > SYSDATE;
            RETURN cusersBanned;
        END users_banned;

    FUNCTION records_expiring_between(vdate1 DATE, vdate2 DATE) RETURN sys_refcursor
    AS
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT r.numberr record_number
                FROM record r
                inner join veredict v on r.id_veredict = v.id
                WHERE v.date_end BETWEEN vdate1 AND vdate2;
            RETURN crecords;
        END records_expiring_between;
        
    FUNCTION user_list_by_type(vid_type NUMBER) RETURN sys_refcursor
    AS
        cuser sys_refcursor;
        BEGIN
            OPEN cuser FOR
                SELECT username
                FROM adm.appuser
                WHERE id_usertype = vid_type;
            RETURN cuser;
        END user_list_by_type;
        
    FUNCTION records_of_person(vid_person NUMBER) RETURN sys_refcursor
    AS
        cuser sys_refcursor;
        BEGIN
            OPEN cuser FOR
                SELECT r.numberr record_number
                FROM record r
                inner join person p on r.id_person = p.id
                WHERE p.id = vid_person;
            RETURN cuser;
        END records_of_person;
        
    FUNCTION records_with_name_person (vfirst_name NUMBER) RETURN sys_refcursor
    AS
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT r.numberr record_number
                FROM record r
                inner join person p on r.id_person = p.id
                WHERE p.name = vfirst_name;
            RETURN crecords;
        END records_with_name_person;
END user_queries;
/