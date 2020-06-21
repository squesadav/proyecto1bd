-- Conectado desde APP

CREATE OR REPLACE PACKAGE admin_institution IS
    PROCEDURE insert_institution(pnName VARCHAR2);
    PROCEDURE remove_institution(pnIdInstitution NUMBER);
END admin_institution;
/

CREATE OR REPLACE PACKAGE BODY admin_institution AS
    PROCEDURE insert_institution(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO institution(id, name)
            VALUES (app.seq_institution.nextval, pnName);
        END;
    PROCEDURE remove_institution(pnIdInstitution NUMBER) IS
        BEGIN
            DELETE FROM institution
            WHERE id = pnIdInstitution;
        END;
END admin_institution;
/