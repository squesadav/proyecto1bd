-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_state IS
    PROCEDURE insert_state(pnName VARCHAR2, pnIdCountry NUMBER);
    PROCEDURE update_state(pnId NUMBER, pnName VARCHAR2, pnIdCountry NUMBER);
    PROCEDURE remove_state(pnIdState NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getIdCountry (vId NUMBER) RETURN NUMBER;
    FUNCTION getALL RETURN sys_refcursor;
END admin_state;
/

CREATE OR REPLACE PACKAGE BODY admin_state AS
    PROCEDURE insert_state(pnName VARCHAR2, pnIdCountry NUMBER) IS
        BEGIN
            INSERT INTO state(id, name, id_country)
            VALUES (app.seq_state.nextval, pnName, pnIdCountry);
        END;

    PROCEDURE update_state(pnId NUMBER, pnName VARCHAR2, pnIdCountry NUMBER) IS
        BEGIN
            UPDATE state
            SET name = pnName, id_country = pnIdCountry
            WHERE id = pnId;
        END;

    PROCEDURE remove_state(pnIdState NUMBER) IS
        BEGIN
            DELETE FROM state
            WHERE id = pnIdState;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(20);
    BEGIN
        SELECT name
        INTO rName
        FROM state
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getIdCountry (vId NUMBER) RETURN NUMBER
        IS rIdCountry NUMBER(4);
    BEGIN
        SELECT id_country
        INTO rIdCountry
        FROM state
        WHERE id = vId;
        RETURN rIdCountry;
    END;
    
    FUNCTION getALL RETURN sys_refcursor
    AS
        cstate sys_refcursor;
        BEGIN
            OPEN cstate FOR
                SELECT id, name, id_country
                FROM state;
            RETURN cstate;
        END;
        
END admin_state;
/