-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_place IS
    PROCEDURE insert_place(pnName VARCHAR2, pnIdDistrict NUMBER);
    PROCEDURE update_place(pnId NUMBER, pnName VARCHAR2, pnIdDistrict NUMBER);
    PROCEDURE remove_place(pnIdPlace NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION get_id_district (vId NUMBER) RETURN NUMBER;
END admin_place;
/

CREATE OR REPLACE PACKAGE BODY admin_place AS
    PROCEDURE insert_place(pnName VARCHAR2, pnIdDistrict NUMBER) IS
        BEGIN
            INSERT INTO place(id, name, id_district)
            VALUES (app.seq_place.nextval, pnName, pnIdDistrict);
        END;

    PROCEDURE update_place(pnId NUMBER, pnName VARCHAR2, pnIdDistrict NUMBER) IS
        BEGIN
            UPDATE place
            SET name = pnName, id_district = pnIdDistrict
            WHERE id = pnId;
        END;

    PROCEDURE remove_place(pnIdPlace NUMBER) IS
        BEGIN
            DELETE FROM place
            WHERE id = pnIdPlace;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(30);
    BEGIN
        SELECT name
        INTO rName
        FROM place
        WHERE id = vId;
        RETURN rName;
    END;
    
    FUNCTION get_id_district (vId NUMBER) RETURN NUMBER
    AS
        rid NUMBER;
        BEGIN
            SELECT id_district
            INTO rid
            FROM place
            WHERE id = vId;
        RETURN rid;
    END;
END admin_place;
/