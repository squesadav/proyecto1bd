-- Conectado desde APP

CREATE OR REPLACE PACKAGE admin_community IS
    PROCEDURE insert_community(pnName VARCHAR2, pnDistrict NUMBER);
    PROCEDURE remove_community(pnIdCommunity NUMBER);
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
END admin_community;
/