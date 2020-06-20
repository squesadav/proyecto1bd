-- Conectado desde APP

CREATE OR REPLACE PACKAGE admin_state IS
    PROCEDURE insert_state(pnName VARCHAR2, pnIdCountry NUMBER);
    PROCEDURE remove_state(pnIdState NUMBER);
END admin_state;
/

CREATE OR REPLACE PACKAGE BODY admin_state AS
    PROCEDURE insert_state(pnName VARCHAR2, pnIdCountry NUMBER) IS
        BEGIN
            INSERT INTO state(id, name, id_country)
            VALUES (app.seq_state.nextval, pnName, pnIdCountry);
        END;
    PROCEDURE remove_state(pnIdState NUMBER) IS
        BEGIN
            DELETE FROM state
            WHERE id = pnIdState;
        END;
END admin_state;
/