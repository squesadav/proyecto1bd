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
    FUNCTION recordInformation RETURN sys_refcursor;
    FUNCTION user_list RETURN sys_refcursor;
    FUNCTION users_banned RETURN sys_refcursor;
    FUNCTION records_expiring_between(vdate1 DATE, vdate2 DATE) RETURN sys_refcursor;
    FUNCTION user_list_by_type(vid_type NUMBER) RETURN sys_refcursor;
    FUNCTION records_of_person(vid_person NUMBER) RETURN sys_refcursor;
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

    FUNCTION recordInformation RETURN sys_refcursor
    AS 
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT *
                FROM record
                inner join type on record.id_type = type.id
                group by id_type;
            RETURN crecords;
         END recordInformation;

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
END user_queries;
/