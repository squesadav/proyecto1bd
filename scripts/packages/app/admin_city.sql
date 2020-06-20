-- Conectado desde APP

CREATE OR REPLACE PACKAGE admin_city IS
    PROCEDURE insert_city(pnName VARCHAR2, pnState NUMBER);
    PROCEDURE remove_city(pnIdCity NUMBER);
END admin_city;
/

CREATE OR REPLACE PACKAGE BODY admin_city AS
    PROCEDURE insert_city(pnName VARCHAR2, pnState NUMBER) IS
        BEGIN
            INSERT INTO city(id, name, id_state)
            VALUES (app.seq_city.nextval, pnName, pnState);
        END;
    PROCEDURE remove_city(pnIdCity NUMBER) IS
        BEGIN
            DELETE FROM city
            WHERE id = pnIdCity;
        END;
END admin_city;
/
