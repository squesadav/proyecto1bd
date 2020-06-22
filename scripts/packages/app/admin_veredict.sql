-- Connected from APP
-- Autor: Sebastián Quesada Calderón

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

    FUNCTION getYears (vId NUMBER) RETURN NUMBER IS rYears NUMBER(3);
        BEGIN
            SELECT years
            INTO rYears
            FROM veredict
            WHERE id = vId;
            RETURN rYears;
        END;  

    FUNCTION getIdPlace (vId NUMBER) RETURN NUMBER IS rIdPlace NUMBER(4);
        BEGIN
            SELECT id_place
            INTO rIdPlace
            FROM veredict
            WHERE id = vId;
            RETURN rIdPlace;
        END;  

    FUNCTION getDateStart (vId NUMBER) RETURN DATE IS rDateStart DATE;
        BEGIN
            SELECT date_start
            INTO rDateStart
            FROM veredict
            WHERE id = vId;
            RETURN rDateStart;
        END;  

    FUNCTION getDateEnd (vId NUMBER) RETURN DATE IS rDateEnd DATE;
        BEGIN
            SELECT date_end
            INTO rDateEnd
            FROM veredict
            WHERE id = vId;
            RETURN rDateEnd;
        END;   
END admin_veredict;
/