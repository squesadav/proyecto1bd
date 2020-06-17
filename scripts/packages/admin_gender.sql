CREATE OR REPLACE PACKAGE admin_gender IS
    PROCEDURE insert_gender(pnName VARCHAR2);
    PROCEDURE remove_gender(pnIdGender NUMBER);
END admin_gender;
/

CREATE OR REPLACE PACKAGE BODY admin_gender AS
    PROCEDURE insert_gender(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO gender(id, name)
            VALUES (app.seq_gender.nextval, pnName);
        END;
    PROCEDURE remove_gender(pnId NUMBER) IS
        BEGIN
            DELETE FROM gender
            WHERE id = pnId;
        END;
END admin_gender;