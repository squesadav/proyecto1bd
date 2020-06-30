-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020
CREATE OR REPLACE PACKAGE admin_type IS
    PROCEDURE insert_type(pnName VARCHAR2);
    PROCEDURE update_type(pnId NUMBER, pnName VARCHAR2);
    PROCEDURE remove_type(pnIdType NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
<<<<<<< HEAD
    FUNCTION getAll RETURN SYS_REFCURSOR;
=======
    FUNCTION getAll RETURN sys_refcursor;
>>>>>>> 73b6856c810704cee17d9d70acd65613d8a5adbf
END admin_type;
/

CREATE OR REPLACE PACKAGE BODY admin_type AS
    PROCEDURE insert_type(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO type(id, name)
            VALUES (app.seq_type.nextval, pnName);
        END;

    PROCEDURE update_type(pnId NUMBER, pnName VARCHAR2) IS
        BEGIN
            UPDATE type
            SET name = pnName
            WHERE id = pnId;
        END;

    PROCEDURE remove_type(pnIdType NUMBER) IS
        BEGIN
            DELETE FROM type
            WHERE id = pnIdType;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(30);
    BEGIN
        SELECT name
        INTO rName
        FROM type
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getAll RETURN sys_refcursor
<<<<<<< HEAD
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT id, name
            INTO rAll
            FROM type;
        RETURN rAll;
    END;
=======
    AS
        ctype sys_refcursor;
        BEGIN
            OPEN ctype FOR
                SELECT id, name
                FROM type;
            RETURN ctype;
        END;
>>>>>>> 73b6856c810704cee17d9d70acd65613d8a5adbf
END admin_type;
/