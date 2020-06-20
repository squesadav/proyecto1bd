-- Conectado desde APP

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
END admin_person;
/