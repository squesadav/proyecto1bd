-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020

-- Connected from SYSTEM
grant select on adm.appuser to app;
grant select on adm.usertype to app;
grant select on adm.banned to app;
grant select on adm.bannedreason to app;

-- Conected from APP
CREATE OR REPLACE PACKAGE user_publishing IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN sys_refcursor;
    FUNCTION recordInformation RETURN sys_refcursor;
    FUNCTION user_list RETURN sys_refcursor;
    FUNCTION user_banned RETURN sys_refcursor;
    FUNCTION user_banned RETURN sys_refcursor;
    FUNCTION record_list(daterange DATE) RETURN sys_refcursor;
END;
/


CREATE OR REPLACE PACKAGE BODY user_publishing IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN sys_refcursor
    AS 
        cplaces sys_refcursor;
        BEGIN
            OPEN cplaces FOR
                SELECT name_community, quant_records
                FROM (
                        SELECT (SELECT name FROM community WHERE id = p.id_community) as name_community, count(p.id_community) quant_records
                        FROM record r
                        INNER JOIN person p ON r.id_person = p.id
                        WHERE r.approved = 'Y'
                        GROUP BY p.id_community
                        ORDER BY quant DESC
                    )
                WHERE rownum <= vquantity;
            RETURN cplaces;
        END;

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
        END;

    FUNCTION user_list RETURN sys_refcursor
    AS
        cusers sys_refcursor;
        BEGIN
            OPEN cusers FOR
                SELECT au.username username, ut.description user_type
                FROM adm.appuser au
                INNER JOIN adm.usertype ut ON au.id_usertype = ut.id_usertype;
            RETURN cusers;
        END;

    FUNCTION user_banned RETURN sys_refcursor
    AS
        cusersBanned sys_refcursor;
        BEGIN
            OPEN cusersBanned FOR
                SELECT *
                FROM banned
                inner join banned on banned.id_bannedreason = bannedreason.id_bannedreason;
            RETURN cusersBanned;
        END;

    FUNCTION record_list(daterange DATE) RETURN sys_refcursor
    AS
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT *
                FROM record
                inner join person on record.id_person = person.id;
            RETURN crecords;
        END;
END;
/