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
END statistics;

CREATE OR REPLACE PACKAGE BODY statistics IS
    FUNCTION records_classification RETURN sys_refcursor
    AS 
        cclassification sys_refcursor;
        BEGIN
            OPEN cclassification FOR
                SELECT t.name, count(r.id_type) quantity, (count(r.id_type)*100/(SELECT sum(count(id_type)) FROM app.record GROUP BY id_type)) percentage
                FROM app.record r
                INNER JOIN app.type t ON r.id_type = t.id
                GROUP BY t.name
                ORDER BY quantity DESC;
            RETURN cclassification;
        END;
END statistics;