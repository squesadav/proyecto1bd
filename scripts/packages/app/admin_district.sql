-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_district IS
    PROCEDURE insert_district(pnName VARCHAR2, pnCity NUMBER);
    PROCEDURE update_district(pnId NUMBER, pnName VARCHAR2, pnCity NUMBER);
    PROCEDURE remove_district(pnIdDistrict NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getIdCity (vId NUMBER) RETURN NUMBER;
END admin_district;
/

CREATE OR REPLACE PACKAGE BODY admin_district AS
    PROCEDURE insert_district(pnName VARCHAR2, pnCity NUMBER) IS
        BEGIN
            INSERT INTO district(id, name, id_city)
            VALUES (app.seq_district.nextval, pnName, pnCity);
        END;

    PROCEDURE update_district(pnId NUMBER, pnName VARCHAR2, pnCity NUMBER) IS
        BEGIN
            UPDATE district
            SET name = pnName, SET id_city = pnCity
            WHERE id = pnId;
        END;

    PROCEDURE remove_district(pnIdDistrict NUMBER) IS
        BEGIN
            DELETE FROM district
            WHERE id = pnIdDistrict;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(20);
    BEGIN
        SELECT name
        INTO rName
        FROM district
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getIdCity (vId NUMBER) RETURN NUMBER
        IS rIdCity NUMBER(4);
    BEGIN
        SELECT id_city
        INTO rIdCity
        FROM district
        WHERE id = vId;
        RETURN rIdCity;
    END;
END admin_district;
/