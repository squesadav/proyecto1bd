-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_institution IS
    PROCEDURE insert_institution(pnName VARCHAR2);
    PROCEDURE update_institution(pnId NUMBER, pnName VARCHAR2);
    PROCEDURE remove_institution(pnIdInstitution NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getAll RETURN sys_refcursor;
    FUNCTION getId(vName VARCHAR2) RETURN NUMBER;
END admin_institution;
/

CREATE OR REPLACE PACKAGE BODY admin_institution AS
    PROCEDURE insert_institution(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO institution(id, name)
            VALUES (app.seq_institution.nextval, pnName);
        END;

    PROCEDURE update_institution(pnId NUMBER, pnName VARCHAR2) IS
        BEGIN
            UPDATE institution
            SET name = pnName
            WHERE id = pnId;
        END;

    PROCEDURE remove_institution(pnIdInstitution NUMBER) IS
        BEGIN
            DELETE FROM institution
            WHERE id = pnIdInstitution;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(50);
    BEGIN
        SELECT name
        INTO rName
        FROM institution
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
        OPEN rAll FOR
            SELECT id, name
            FROM institution;
        RETURN rAll;
    END;
    
    FUNCTION getId(vName VARCHAR2) RETURN NUMBER
    AS
        rid NUMBER(4);
    BEGIN
        SELECT id
        INTO rid
        FROM institution
        WHERE name = vName;
    RETURN rid;
    END;
END admin_institution;
/