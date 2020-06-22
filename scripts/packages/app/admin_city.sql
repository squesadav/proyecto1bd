-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

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

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(20);
    BEGIN
        SELECT name
        INTO rName
        FROM city
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getIdState (vId NUMBER) RETURN NUMBER
        IS rIdState NUMBER(4);
    BEGIN
        SELECT id_state
        INTO rIdState
        FROM city
        WHERE id = vId;
        RETURN rIdState;
    END;
END admin_city;

/