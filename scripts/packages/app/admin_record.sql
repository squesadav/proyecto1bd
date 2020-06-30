-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020
CREATE OR REPLACE PACKAGE admin_record IS
    PROCEDURE insert_record(pnNumberr VARCHAR2, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER, pnIdDistrict NUMBER, pnUsernameCreator VARCHAR2);
    PROCEDURE update_record(pnNumberr VARCHAR2, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER, pnIdDistrict NUMBER, pnUsernameCreator VARCHAR2);
    PROCEDURE remove_record(pnNumberr VARCHAR2);
    FUNCTION getDescriptionCrime (pnNumberr VARCHAR2) RETURN VARCHAR2;
    FUNCTION getDateCrime (pnNumberr VARCHAR2) RETURN DATE;
    FUNCTION getResolution (pnNumberr VARCHAR2) RETURN VARCHAR2;
    FUNCTION getCrimeExpirationDate (pnNumberr VARCHAR2) RETURN DATE;
    FUNCTION getApproved (pnNumberr VARCHAR2) RETURN VARCHAR2;
    FUNCTION getIdType (pnNumberr VARCHAR2) RETURN NUMBER;
    FUNCTION getIdVeredict (pnNumberr VARCHAR2) RETURN NUMBER;
    FUNCTION getIdPerson (pnNumberr VARCHAR2) RETURN NUMBER;
    FUNCTION getIdDistrict (pnNumberr VARCHAR2) RETURN NUMBER;
    FUNCTION getUsernameCreator (pnNumberr VARCHAR2) RETURN VARCHAR2;
    PROCEDURE approve_record(pnNumberr VARCHAR2);
    FUNCTION getPictures (pnNumberr VARCHAR2) RETURN sys_refcursor;
    FUNCTION getAll RETURN SYS_REFCURSOR;
    FUNCTION getRecord(numberr VARCHAR2) RETURN SYS_REFCURSOR;
END admin_record;
/

CREATE OR REPLACE PACKAGE BODY admin_record AS
    PROCEDURE insert_record(pnNumberr VARCHAR2, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER,pnIdDistrict NUMBER, pnUsernameCreator VARCHAR2) IS
        BEGIN
            INSERT INTO record(numberr, description_crime, date_crime, resolution, crime_expiration_date, id_type, id_veredict, id_person, id_district, approved, username_creator)
            VALUES (pnNumberr, pnDescriptionCrime, pnDateCrime, pnResolution, pnCrimeExpirationDate, pnIdType, pnIdVeredict, pnIdPerson, pnIdDistrict, 'N', pnUsernameCreator);
        END;

    PROCEDURE update_record(pnNumberr VARCHAR2, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER, pnIdDistrict NUMBER, pnUsernameCreator VARCHAR2) IS
        BEGIN
            UPDATE record
            SET description_crime = pnDescriptionCrime,
                date_crime = pnDateCrime,
                resolution = pnResolution,
                crime_expiration_date = pnCrimeExpirationDate,
                id_type = pnIdType,
                id_veredict = pnIdVeredict,
                id_person = pnIdPerson,
                id_district = pnIdDistrict,
                username_creator = pnUsernameCreator
            WHERE numberr = pnNumberr;
        END;

    PROCEDURE remove_record(pnNumberr VARCHAR2) IS
        BEGIN
            DELETE FROM record
            WHERE numberr = pnNumberr;
        END;

    FUNCTION getDescriptionCrime (pnNumberr VARCHAR2) RETURN VARCHAR2 
    IS rDescriptionCrime VARCHAR2(30);
        BEGIN
            SELECT description_crime
            INTO rDescriptionCrime
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rDescriptionCrime;
        END;

    FUNCTION getDateCrime (pnNumberr VARCHAR2) RETURN DATE 
    IS rDateCrime DATE;
        BEGIN
            SELECT date_crime
            INTO rDateCrime
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rDateCrime;
        END;

    FUNCTION getResolution (pnNumberr VARCHAR2) RETURN VARCHAR2 
    IS rResolution VARCHAR2(30);
        BEGIN
            SELECT resolution
            INTO rResolution
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rResolution;
        END;

    FUNCTION getCrimeExpirationDate (pnNumberr VARCHAR2) RETURN DATE 
    IS rCrimeExpirationDate DATE;
        BEGIN
            SELECT crime_expiration_date
            INTO rCrimeExpirationDate
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rCrimeExpirationDate;
        END;
        
    FUNCTION getApproved (pnNumberr VARCHAR2) RETURN VARCHAR2 
    IS rApproved VARCHAR2(1);
        BEGIN
            SELECT approved
            INTO rApproved
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rApproved;
        END;

    FUNCTION getIdType (pnNumberr VARCHAR2) RETURN NUMBER
    IS rIdType NUMBER(3);
        BEGIN
            SELECT id_type
            INTO rIdType
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdType;
        END;    

    FUNCTION getIdVeredict (pnNumberr VARCHAR2) RETURN NUMBER 
    IS rIdVeredict NUMBER(4);
        BEGIN
            SELECT id_veredict
            INTO rIdVeredict
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdVeredict;
        END;  

    FUNCTION getIdPerson (pnNumberr VARCHAR2) RETURN NUMBER 
    IS rIdPerson NUMBER(9);
        BEGIN
            SELECT id_person
            INTO rIdPerson
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdPerson;
        END;  

    FUNCTION getIdDistrict (pnNumberr VARCHAR2) RETURN NUMBER 
    IS rIdDistricr NUMBER(9);
        BEGIN
            SELECT id_district
            INTO rIdDistricr
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdDistricr;
        END;  

    FUNCTION getUsernameCreator (pnNumberr VARCHAR2) RETURN VARCHAR2
    IS rUsernameCreator VARCHAR2(20);
        BEGIN
            SELECT username_creator
            INTO rUsernameCreator
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rUsernameCreator;
        END;
        
    PROCEDURE approve_record(pnNumberr VARCHAR2) IS
        BEGIN
            UPDATE record
            SET approved = 'Y'
            WHERE numberr = pnNumberr;
        END;
        
    FUNCTION getPictures (pnNumberr VARCHAR2) RETURN sys_refcursor
    AS
        cpictures sys_refcursor;
        BEGIN
            OPEN cpictures FOR
                SELECT pic_str
                FROM picture
                WHERE numberr = pnNumberr;
            RETURN cpictures;
        END;
        
    FUNCTION getAll RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
        OPEN rAll FOR    
            SELECT numberr, description_crime, date_crime, resolution, crime_expiration_date, id_type, id_veredict, id_person, approved, username_creator, id_district
            FROM record;
        RETURN rAll;
    END;

    FUNCTION getRecord(pnNumberr VARCHAR2) RETURN SYS_REFCURSOR
    AS rRecord  sys_refcursor;
    BEGIN
        OPEN rCrimeExpirationDate FOR
            SELECT numberr, description_crime, date_crime, resolution, crime_expiration_date, id_type, id_veredict, id_person, approved, username_creator, id_district
            FROM record
            WHERE numberr = pnNumberr;
        return rRecord;
END admin_record;
/