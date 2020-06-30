-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_gender IS
    PROCEDURE insert_gender(pnName VARCHAR2);
    PROCEDURE update_gender(pnId NUMBER, pnName VARCHAR2);
    PROCEDURE remove_gender(pnIdGender NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getAll RETURN sys_refcursor;

END admin_gender;
/

CREATE OR REPLACE PACKAGE BODY admin_gender AS
    PROCEDURE insert_gender(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO gender(id, name)
            VALUES (app.seq_gender.nextval, pnName);
        END;


    PROCEDURE update_gender(pnId NUMBER, pnName VARCHAR2) IS
        BEGIN
            UPDATE gender
            SET name = pnName
            WHERE id = pnId;
        END;

    PROCEDURE remove_gender(pnIdGender NUMBER) IS
        BEGIN
            DELETE FROM gender
            WHERE id = pnIdGender;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(6);
    BEGIN
        SELECT name
        INTO rName
        FROM gender
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
        OPEN rALL FOR
            SELECT id, name
            FROM gender;
        RETURN rAll;
    END;

END admin_gender;
/