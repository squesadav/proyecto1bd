-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_country IS
    PROCEDURE insert_country(pnName VARCHAR2);
    PROCEDURE remove_country(pnIdCountry NUMBER);
END admin_country;
/

CREATE OR REPLACE PACKAGE BODY admin_country AS
    PROCEDURE insert_country(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO country(id, name)
            VALUES (app.seq_country.nextval, pnName);
        END;
    PROCEDURE remove_country(pnIdCountry NUMBER) IS
        BEGIN
            DELETE FROM country
            WHERE id = pnIdCountry;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(20);
    BEGIN
        SELECT name
        INTO rName
        FROM country
        WHERE id = vId;
        RETURN rName;
    END;

END admin_country;
/