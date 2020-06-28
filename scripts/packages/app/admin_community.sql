-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_community IS
    PROCEDURE insert_community(pnName VARCHAR2, pnDistrict NUMBER);
    PROCEDURE update_community(pnId NUMBER, pnName VARCHAR2, pnDistrict NUMBER);
    PROCEDURE remove_community(pnIdCommunity NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getIdDistrict (vId NUMBER) RETURN NUMBER;
    FUNCTION getAll RETURN CURSOR;
END admin_community;
/

CREATE OR REPLACE PACKAGE BODY admin_community AS
    PROCEDURE insert_community(pnName VARCHAR2, pnDistrict NUMBER) IS
        BEGIN
            INSERT INTO community(id, name, id_district)
            VALUES (app.seq_community.nextval, pnName, pnDistrict);
        END;

    PROCEDURE update_community(pnId NUMBER, pnName VARCHAR2, pnDistrict NUMBER) IS
        BEGIN
            UPDATE community
            SET name = pnName, SET id_district = pnDistrict
            WHERE id = pnId:
        END;

    PROCEDURE remove_community(pnIdCommunity NUMBER) IS
        BEGIN
            DELETE FROM community
            WHERE id = pnIdCommunity;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2
        IS rName VARCHAR2(20);
    BEGIN
        SELECT name
        INTO rName
        FROM community
        WHERE id = vId;
        RETURN rName;
    END;

    FUNCTION getIdDistrict (vId NUMBER) RETURN NUMBER
        IS rIdDistrict NUMBER(4);
    BEGIN
        SELECT id_district
        INTO rIdDistrict
        FROM community
        WHERE id = vId;
        RETURN rIdDistrict;
    END;

    FUNCTION getAll RETURN CURSOR
        IS rAll CURSOR;
    BEGIN
        SELECT id, name
        INTO rAll
        FROM community;
        RETURN rAll
    END;
END admin_community;
/