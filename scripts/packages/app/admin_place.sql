-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_place IS
    PROCEDURE insert_place(pnName VARCHAR2);
    PROCEDURE update_place(pnId NUMBER, pnName VARCHAR2);
    PROCEDURE remove_place(pnIdPlace NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION get_id_district (vId NUMBER) RETURN NUMBER;
    FUNCTION getId(vName VARCHAR2) RETURN NUMBER;
    FUNCTION getAll RETURN SYS_REFCURSOR;
END admin_place;
/

CREATE OR REPLACE PACKAGE BODY admin_place AS
    PROCEDURE insert_place(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO place(id, name)
            VALUES (app.seq_place.nextval, pnName);
        END;

    PROCEDURE update_place(pnId NUMBER, pnName VARCHAR2) IS
        BEGIN
            UPDATE place
            SET name = pnName
            WHERE id = pnId;
        END;

    PROCEDURE remove_place(pnIdPlace NUMBER) IS
        BEGIN
            DELETE FROM place
            WHERE id = pnIdPlace;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(30);
    BEGIN
        SELECT name
        INTO rName
        FROM place
        WHERE id = vId;
        RETURN rName;
    END;
    
    FUNCTION get_id_district (vId NUMBER) RETURN NUMBER
    AS
        rid NUMBER;
        BEGIN
            SELECT id_district
            INTO rid
            FROM place
            WHERE id = vId;
        RETURN rid;
    END;
    
    FUNCTION getId(vName VARCHAR2) RETURN NUMBER
    AS
        rid NUMBER(4);
    BEGIN
        SELECT id
        INTO rid
        FROM place
        WHERE name = vName;
    RETURN rid;
    END;

    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT id, name
            FROM place;
        RETURN rAll;
    END;
END admin_place;
/