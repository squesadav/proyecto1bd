-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE admin_person IS
    PROCEDURE insert_person(pnId NUMBER, pnName VARCHAR2, pnMiddle_Name VARCHAR2, pnLast_Name VARCHAR2, pnBirthday DATE, pnIdGender NUMBER, pnIdInstitution NUMBER, pnIdDistrict NUMBER);
    PROCEDURE update_person(pnId NUMBER, pnName VARCHAR2, pnMiddle_Name VARCHAR2, pnLast_Name VARCHAR2, pnBirthday DATE, pnIdGender NUMBER, pnIdInstitution NUMBER, pnIdDistrict NUMBER);
    PROCEDURE remove_person(pnIdPerson NUMBER);
    FUNCTION getName (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getMiddle_Name (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getLast_Name (vId NUMBER) RETURN VARCHAR2;
    FUNCTION getBirthday (vId NUMBER) RETURN DATE;
    FUNCTION getAge (vId NUMBER) RETURN NUMBER;
    FUNCTION getIdGender (vId NUMBER) RETURN NUMBER;
    FUNCTION getIdInstitution (vId NUMBER) RETURN NUMBER;
    FUNCTION getIdDistrict (vId NUMBER) RETURN NUMBER;
    FUNCTION getALL RETURN sys_refcursor;
    PROCEDURE updateAge (pnId NUMBER);
    PROCEDURE updateAllAges;
END admin_person;
/

CREATE OR REPLACE PACKAGE BODY admin_person AS
    PROCEDURE insert_person(pnId NUMBER, pnName VARCHAR2, pnMiddle_Name VARCHAR2, pnLast_Name VARCHAR2, pnBirthday DATE, pnIdGender NUMBER, pnIdInstitution NUMBER, pnIdDistrict NUMBER) IS
        BEGIN
            INSERT INTO person(id, name, middle_name, last_name, birthday, id_gender, id_institution, id_district)
            VALUES (pnId, pnName, pnMiddle_Name, pnLast_Name, pnBirthday, pnIdGender, pnIdInstitution, pnIdDistrict);
            admin_person.updateAge(pnId);
        END;

    PROCEDURE update_person(pnId NUMBER, pnName VARCHAR2, pnMiddle_Name VARCHAR2, pnLast_Name VARCHAR2, pnBirthday DATE, pnIdGender NUMBER, pnIdInstitution NUMBER, pnIdDistrict NUMBER) IS
        BEGIN
            UPDATE person
            SET name = pnName,
                middle_name = pnMiddle_Name,
                last_name = pnLast_Name,
                birthday = pnBirthday,
                id_gender = pnIdGender,
                id_institution = pnIdInstitution,
                id_district = pnIdDistrict
            WHERE id = pnId;
        END;

    PROCEDURE remove_person(pnIdPerson NUMBER) IS
        BEGIN
            DELETE FROM person
            WHERE id = pnIdPerson;
        END;

    FUNCTION getName (vId NUMBER) RETURN VARCHAR2 
        IS rName VARCHAR2(30);
        BEGIN
            SELECT name
            INTO rName
            FROM person
            WHERE id = vId;
            RETURN rName;
        END;

    FUNCTION getMiddle_Name (vId NUMBER) RETURN VARCHAR2 
        IS rMiddle_Name VARCHAR2(30);
        BEGIN
            SELECT middle_name
            INTO rMiddle_Name
            FROM person
            WHERE id = vId;
            RETURN rMiddle_Name;
        END;

    FUNCTION getLast_Name (vId NUMBER) RETURN VARCHAR2 
        IS rLast_Name VARCHAR2(30);
        BEGIN
            SELECT last_name
            INTO rLast_Name
            FROM person
            WHERE id = vId;
            RETURN rLast_Name;
        END;

    FUNCTION getBirthday (vId NUMBER) RETURN DATE 
        IS rBirthday DATE;
        BEGIN
            SELECT birthday
            INTO rBirthday
            FROM person
            WHERE id = vId;
            RETURN rBirthday;
        END;

    FUNCTION getAge (vId NUMBER) RETURN NUMBER 
        IS rAge NUMBER(9);
        BEGIN
            SELECT age
            INTO rAge
            FROM person
            WHERE id = vId;
            RETURN rAge;
        END;

    FUNCTION getIdGender (vId NUMBER) RETURN NUMBER 
        IS rIdGender NUMBER(2);
        BEGIN
            SELECT id_gender
            INTO rIdGender
            FROM person
            WHERE id = vId;
            RETURN rIdGender;
        END;

    FUNCTION getIdInstitution (vId NUMBER) RETURN NUMBER 
        IS rIdInstitution NUMBER(4);
        BEGIN
            SELECT id_institution
            INTO rIdInstitution
            FROM person
            WHERE id = vId;
            RETURN rIdInstitution;
        END;

    FUNCTION getIdDistrict (vId NUMBER) RETURN NUMBER 
        IS rIdDistrict NUMBER(4);
        BEGIN
            SELECT id_district
            INTO rIdDistrict
            FROM person
            WHERE id = vId;
            RETURN rIdDistrict;
        END;
    
    FUNCTION getALL RETURN sys_refcursor
    AS
        cperson sys_refcursor;
        BEGIN
            OPEN cperson FOR
                SELECT id, name, middle_name, last_name, birthday, age, id_gender, id_institution, id_district
                FROM person;
            RETURN cperson;
        END;
        
    PROCEDURE updateAge (pnId NUMBER) IS
        BEGIN
            UPDATE person
            SET age = trunc(months_between(sysdate, birthday)/12)
            WHERE id = pnId;
        END;
        
    PROCEDURE updateAllAges IS
        BEGIN
            UPDATE person
            SET age = trunc(months_between(sysdate, birthday)/12);
        END;

END admin_person;
/