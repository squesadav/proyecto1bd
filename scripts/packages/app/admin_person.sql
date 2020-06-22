-- Connected from APP
-- Autor: Sebastián Quesada Calderón

CREATE OR REPLACE PACKAGE admin_person IS
    PROCEDURE insert_person(pnId NUMBER, pnName VARCHAR2, pnMiddle_Name VARCHAR2, pnLast_Name VARCHAR2, pnBirthday DATE, pnIdGender NUMBER, pnIdInstitution NUMBER, pnIdCommunity NUMBER);
    PROCEDURE remove_person(pnIdPerson NUMBER);
END admin_person;
/

CREATE OR REPLACE PACKAGE BODY admin_person AS
    PROCEDURE insert_person(pnId NUMBER, pnName VARCHAR2, pnMiddle_Name VARCHAR2, pnLast_Name VARCHAR2, pnBirthday DATE, pnIdGender NUMBER, pnIdInstitution NUMBER, pnIdCommunity NUMBER) IS
        BEGIN
            INSERT INTO person(id, name, middle_name, last_name, birthday, id_gender, id_institution, id_community)
            VALUES (pnId, pnName, pnMiddle_Name, pnLast_Name, pnBirthday, pnIdGender, pnIdInstitution, pnIdCommunity);
        END;
    PROCEDURE remove_person(pnIdPerson NUMBER) IS
        BEGIN
            DELETE FROM person
            WHERE id = pnIdPerson;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2 IS rName VARCHAR2(30);
        BEGIN
            SELECT name
            INTO rName
            FROM person
            WHERE id = vId;
            RETURN rName;
        END;

    FUNCTION getMiddle_Name (vId NUMBER) RETURN VARCHAR2 IS rMiddle_Name VARCHAR2(30);
        BEGIN
            SELECT middle_name
            INTO rMiddle_Name
            FROM person
            WHERE id = vId;
            RETURN rMiddle_Name;
        END;

    FUNCTION getLast_Name (vId NUMBER) RETURN VARCHAR2 IS rLast_Name VARCHAR2(30);
        BEGIN
            SELECT last_name
            INTO rLast_Name
            FROM person
            WHERE id = vId;
            RETURN rLast_Name;
        END;

    FUNCTION getBirthday (vId NUMBER) RETURN DATE IS rBirthday DATE;
        BEGIN
            SELECT birthday
            INTO rBirthday
            FROM person
            WHERE id = vId;
            RETURN rBirthday;
        END;

    FUNCTION getAge (vId NUMBER) RETURN NUMBER IS rAge NUMBER(9);
        BEGIN
            SELECT age
            INTO rAge
            FROM person
            WHERE id = vId;
            RETURN rAge;
        END;

    FUNCTION getIdGender (vId NUMBER) RETURN NUMBER IS rIdGender NUMBER(2);
        BEGIN
            SELECT id_gender
            INTO rIdGender
            FROM person
            WHERE id = vId;
            RETURN rIdGender;
        END;

    FUNCTION getIdInstitution (vId NUMBER) RETURN NUMBER IS rIdInstitution NUMBER(4);
        BEGIN
            SELECT id_institution
            INTO rIdInstitution
            FROM person
            WHERE id = vId;
            RETURN rIdInstitution;
        END;

    FUNCTION getIdCommunity (vId NUMBER) RETURN NUMBER IS rIdCommunity NUMBER(4);
        BEGIN
            SELECT id_community
            INTO rIdCommunity
            FROM person
            WHERE id = vId;
            RETURN rIdCommunity;
        END;

END admin_person;
/