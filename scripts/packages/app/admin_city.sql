-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_city IS
    PROCEDURE insert_city(pnName VARCHAR2, pnId_State NUMBER);
    PROCEDURE update_city(pnId NUMBER, pnName VARCHAR2, pnState NUMBER);
    PROCEDURE remove_city(pnIdCity NUMBER);
    FUNCTION getName(vId NUMBER) RETURN VARCHAR2;
    FUNCTION getIdState (vId NUMBER) RETURN NUMBER;
    FUNCTION getAll RETURN sys_refcursor;
    FUNCTION getAllInState(vIdState NUMBER) RETURN sys_refcursor;
    FUNCTION getId(vName VARCHAR2) RETURN NUMBER;
END admin_city;
/

CREATE OR REPLACE PACKAGE BODY admin_city AS
    PROCEDURE insert_city(pnName VARCHAR2, pnId_State NUMBER) IS
        BEGIN
            INSERT INTO city(id, name, id_state)
            VALUES (app.seq_city.nextval, pnName, pnId_State);
        END;

    PROCEDURE update_city(pnId NUMBER, pnName VARCHAR2, pnState NUMBER) IS
        BEGIN
            UPDATE city
            SET name = pnName, id_state = pnState
            WHERE id = pnId;
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

    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
        OPEN rALL FOR
            SELECT id, name, id_state
            FROM city;
        RETURN rAll;
    END;

    FUNCTION getAllInState(vIdState NUMBER) RETURN sys_refcursor
    AS
        ccity sys_refcursor;
    BEGIN
            OPEN ccity FOR
                SELECT name
                FROM city
                WHERE id_state = vIdState;
            RETURN ccity;
    END;
    
    FUNCTION getId(vName VARCHAR2) RETURN NUMBER
    AS
        rid NUMBER(4);
    BEGIN
        SELECT id
        INTO rid
        FROM city
        WHERE name = vName;
    RETURN rid;
    END;
END admin_city;

/