-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_veredict IS
    PROCEDURE insert_veredict(pnIdPlace NUMBER, pnDateStart DATE, pnDateEnd DATE);
    PROCEDURE update_veredict(pnIdVeredict NUMBER, pnIdPlace NUMBER, pnDateStart DATE, pnDateEnd DATE);
    PROCEDURE remove_veredict(pnIdVeredict NUMBER);
    FUNCTION getYears (vId NUMBER) RETURN NUMBER;
    FUNCTION getIdPlace (vId NUMBER) RETURN NUMBER;
    FUNCTION getDateStart (vId NUMBER) RETURN DATE;
    FUNCTION getDateEnd (vId NUMBER) RETURN DATE;
END admin_veredict;
/

CREATE OR REPLACE PACKAGE BODY admin_veredict AS
    PROCEDURE insert_veredict(pnIdPlace NUMBER, pnDateStart DATE, pnDateEnd DATE) IS
        BEGIN
            INSERT INTO veredict(id, years, id_place, date_start, date_end)
            VALUES (app.seq_veredict.nextval, round(months_between(pnDateEnd, pnDateStart)/12, 2), pnIdPlace, pnDateStart, pnDateEnd);
        END;

    PROCEDURE update_veredict(pnIdVeredict NUMBER, pnIdPlace NUMBER, pnDateStart DATE, pnDateEnd DATE) IS
        BEGIN
            UPDATE veredict
            SET years = round(months_between(pnDateEnd, pnDateStart)/12, 2),
                id_place = pnIdPlace,
                date_start = pnDateStart,
                date_end = pnDateEnd
            WHERE id = pnIdVeredict;
        END;

    PROCEDURE remove_veredict(pnIdVeredict NUMBER) IS
        BEGIN
            DELETE FROM veredict
            WHERE id = pnIdVeredict;
        END;

    FUNCTION getYears (vId NUMBER) RETURN NUMBER
    IS rYears NUMBER(3);
        BEGIN
            SELECT years
            INTO rYears
            FROM veredict
            WHERE id = vId;
            RETURN rYears;
        END;  

    FUNCTION getIdPlace (vId NUMBER) RETURN NUMBER 
    IS rIdPlace NUMBER(4);
        BEGIN
            SELECT id_place
            INTO rIdPlace
            FROM veredict
            WHERE id = vId;
            RETURN rIdPlace;
        END;  

    FUNCTION getDateStart (vId NUMBER) RETURN DATE 
    IS rDateStart DATE;
        BEGIN
            SELECT date_start
            INTO rDateStart
            FROM veredict
            WHERE id = vId;
            RETURN rDateStart;
        END;  

    FUNCTION getDateEnd (vId NUMBER) RETURN DATE 
    IS rDateEnd DATE;
        BEGIN
            SELECT date_end
            INTO rDateEnd
            FROM veredict
            WHERE id = vId;
            RETURN rDateEnd;
        END;   
END admin_veredict;
/