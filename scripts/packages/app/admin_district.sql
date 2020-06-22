-- Connected from APP
-- Autor: Sebastián Quesada Calderón

CREATE OR REPLACE PACKAGE admin_district IS
    PROCEDURE insert_district(pnName VARCHAR2, pnCity NUMBER);
    PROCEDURE remove_district(pnIdDistrict NUMBER);
END admin_district;
/

CREATE OR REPLACE PACKAGE BODY admin_district AS
    PROCEDURE insert_district(pnName VARCHAR2, pnCity NUMBER) IS
        BEGIN
            INSERT INTO district(id, name, id_city)
            VALUES (app.seq_district.nextval, pnName, pnCity);
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