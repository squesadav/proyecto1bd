-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020


CREATE OR REPLACE PACKAGE user_publishing IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN rcursor;
END user_publishing;
/


CREATE OR REPLACE PACKAGE BODY user_publishing IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN rcursor
    AS 
        cplaces rcursor;
        BEGIN
            OPEN cpassword FOR
                SELECT top vquantity *
                FROM record
                inner join veredict on id_veredict = veredict.id
                order by veredict.id_place;
            RETURN cpassword;
        END no_longer_change_password;
END;
/