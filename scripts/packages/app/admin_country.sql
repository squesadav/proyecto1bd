-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_country IS
    PROCEDURE insert_country(pnName VARCHAR2);
    PROCEDURE update_country(pnId NUMBER, pnName VARCHAR2);
    PROCEDURE remove_country(pnIdCountry NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getAll RETURN sys_refcursor;
END admin_country;
/

CREATE OR REPLACE PACKAGE BODY admin_country AS
    PROCEDURE insert_country(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO country(id, name)
            VALUES (app.seq_country.nextval, pnName);
        END;

    PROCEDURE update_country(pnId NUMBER, pnName VARCHAR2) IS
        BEGIN
            UPDATE country
            SET name = pnName
            WHERE id = pnId;
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

    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT id, name
            INTO rAll
            FROM country;
        RETURN rAll;
    END;
END admin_country;
/