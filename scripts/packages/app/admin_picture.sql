-- Conected from APP
-- Author: Sebastián Quesada Velluti
-- Creation date: 27/06/2020

CREATE OR REPLACE PACKAGE admin_picture IS
    PROCEDURE insert_picture(pnPicStr VARCHAR2, pnNumberr VARCHAR2);
    PROCEDURE update_picture(pnId NUMBER, pnPicStr VARCHAR2, pnNumberr VARCHAR2);
    PROCEDURE remove_picture(pnId NUMBER);
    FUNCTION get_pic_str (vId NUMBER) RETURN VARCHAR2;
    FUNCTION get_numberr (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getAll RETURN SYS_REFCURSOR;
END admin_picture;
/

CREATE OR REPLACE PACKAGE BODY admin_picture AS
    PROCEDURE insert_picture(pnPicStr VARCHAR2, pnNumberr VARCHAR2) IS
        BEGIN
            INSERT INTO picture(id, pic_str, numberr)
            VALUES (app.seq_picture.nextval, pnPicStr, pnNumberr);
        END;

    PROCEDURE update_picture(pnId NUMBER, pnPicStr VARCHAR2, pnNumberr VARCHAR2) IS
        BEGIN
            UPDATE picture
            SET pic_str = pnPicStr, numberr = pnNumberr
            WHERE id = pnId;
        END;

    PROCEDURE remove_picture(pnId NUMBER) IS
        BEGIN
            DELETE FROM picture
            WHERE id = pnId;
        END;

    FUNCTION get_pic_str (vId NUMBER) RETURN VARCHAR2
        IS rPicStr VARCHAR2(50);
    BEGIN
        SELECT pic_str
        INTO rPicStr
        FROM picture
        WHERE id = vId;
        RETURN rPicStr;
    END;
    
    FUNCTION get_numberr (vId NUMBER) RETURN VARCHAR2
        IS rNumberr VARCHAR2(20);
    BEGIN
        SELECT numberr
        INTO rNumberr
        FROM picture
        WHERE id = vId;
        RETURN rNumberr;
    END;

    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT pic_str
            FROM picture;
        RETURN rAll;
    END;
END admin_picture;
/