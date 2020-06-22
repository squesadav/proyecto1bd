-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_place IS
    PROCEDURE insert_place(pnName VARCHAR2);
    PROCEDURE remove_place(pnIdPlace NUMBER);
END admin_place;
/

CREATE OR REPLACE PACKAGE BODY admin_place AS
    PROCEDURE insert_place(pnName VARCHAR2) IS
        BEGIN
            INSERT INTO place(id, name)
            VALUES (app.seq_place.nextval, pnName);
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
END admin_place;
/