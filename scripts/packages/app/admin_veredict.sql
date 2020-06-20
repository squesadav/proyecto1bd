-- Conectado desde APP

CREATE OR REPLACE PACKAGE admin_veredict IS
    PROCEDURE insert_veredict(pnYears NUMBER, pnIdPlace NUMBER, pnDateStart DATE, pnDateEnd DATE);
    PROCEDURE remove_veredict(pnIdVeredict NUMBER);
END admin_veredict;
/

CREATE OR REPLACE PACKAGE BODY admin_veredict AS
    PROCEDURE insert_veredict(pnYears NUMBER, pnIdPlace NUMBER, pnDateStart DATE, pnDateEnd DATE) IS
        BEGIN
            INSERT INTO veredict(id, years, id_place, date_start, date_end)
            VALUES (app.seq_veredict.nextval, pnYears, pnIdPlace, pnDateStart, pnDateEnd);
        END;
    PROCEDURE remove_veredict(pnIdVeredict NUMBER) IS
        BEGIN
            DELETE FROM veredict
            WHERE id = pnIdVeredict;
        END;
END admin_veredict;
/