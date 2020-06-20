-- Conectado desde APP

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
END admin_district;
/