-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_community IS
    PROCEDURE insert_community(pnName VARCHAR2, pnDistrict NUMBER);
    PROCEDURE remove_community(pnIdCommunity NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getIdDistrict (vId NUMBER) RETURN NUMBER;
END admin_community;
/

CREATE OR REPLACE PACKAGE BODY admin_community AS
    PROCEDURE insert_community(pnName VARCHAR2, pnDistrict NUMBER) IS
        BEGIN
            INSERT INTO community(id, name, id_district)
            VALUES (app.seq_community.nextval, pnName, pnDistrict);
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
END admin_community;
/