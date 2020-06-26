-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020
CREATE OR REPLACE PACKAGE admin_record IS
    PROCEDURE insert_record(pnNumberr NUMBER, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnPicture VARCHAR2 DEFAULT ' ', pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER);
    PROCEDURE update_record(pnNumberr NUMBER, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnPicture VARCHAR2 DEFAULT ' ', pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER);
    PROCEDURE remove_record(pnNumberr NUMBER);
    FUNCTION getDescriptionCrime (pnNumberr NUMBER) RETURN VARCHAR2;
    FUNCTION getDateCrime (pnNumberr NUMBER) RETURN DATE;
    FUNCTION getResolution (pnNumberr NUMBER) RETURN VARCHAR2;
    FUNCTION getCrimeExpirationDate (pnNumberr NUMBER) RETURN DATE;
    FUNCTION getPicture (pnNumberr NUMBER) RETURN VARCHAR2;
    FUNCTION getAproved (pnNumberr NUMBER) RETURN VARCHAR2;
    FUNCTION getIdType (pnNumberr NUMBER) RETURN NUMBER;
    FUNCTION getIdVeredict (pnNumberr NUMBER) RETURN NUMBER;
    FUNCTION getIdPerson (pnNumberr NUMBER) RETURN NUMBER;
    PROCEDURE approve_record(pnNumberr NUMBER);
END admin_record;
/

CREATE OR REPLACE PACKAGE BODY admin_record AS
    PROCEDURE insert_record(pnNumberr NUMBER, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnPicture VARCHAR2 DEFAULT ' ', pnApproved VARCHAR2,pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER) IS
        BEGIN
            INSERT INTO record(numberr, description_crime, date_crime, resolution, crime_expiration_date, picture, approved, id_type, id_veredict, id_person, approved)
            VALUES (pnNumberr, pnDescriptionCrime, pnDateCrime, pnResolution, pnCrimeExpirationDate, pnPicture, pnApproved, pnIdType, pnIdVeredict, pnIdPerson, 'N');
        END;

    PROCEDURE update_record(pnNumberr NUMBER, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnPicture VARCHAR2 DEFAULT ' ', pnApproved VARCHAR2, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER) IS
        BEGIN
            UPDATE record
            SET numberr = pnNumberr,
            SET description_crime = pnDescriptionCrime,
            SET date_crime = pnDateCrime,
            SET resolution = pnResolution,
            SET crime_expiration_date = pnCrimeExpirationDate,
            SET picture = pnPicture,
            SET approved = pnApproved,
            SET id_type = pnIdType,
            SET id_veredict = pnIdVeredict,
            SET id_person = pnIdPerson
            WHERE id = pnId;
        END;

    PROCEDURE remove_record(pnNumberr NUMBER) IS
        BEGIN
            DELETE FROM record
            WHERE numberr = pnNumberr;
        END;

    FUNCTION getDescriptionCrime (pnNumberr NUMBER) RETURN VARCHAR2 
    IS rDescriptionCrime VARCHAR2(30);
        BEGIN
            SELECT description_crime
            INTO rDescriptionCrime
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rDescriptionCrime;
        END;

    FUNCTION getDateCrime (pnNumberr NUMBER) RETURN DATE 
    IS rDateCrime DATE;
        BEGIN
            SELECT date_crime
            INTO rDateCrime
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rDateCrime;
        END;

    FUNCTION getResolution (pnNumberr NUMBER) RETURN VARCHAR2 
    IS rResolution VARCHAR2(30);
        BEGIN
            SELECT resolution
            INTO rResolution
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rResolution;
        END;

    FUNCTION getCrimeExpirationDate (pnNumberr NUMBER) RETURN DATE 
    IS rCrimeExpirationDate DATE;
        BEGIN
            SELECT crime_expiration_date
            INTO rCrimeExpirationDate
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rCrimeExpirationDate;
        END;

    FUNCTION getPicture (pnNumberr NUMBER) RETURN VARCHAR2 
    IS rPicture VARCHAR2(50);
        BEGIN
            SELECT picture
            INTO rPicture
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rPicture;
        END; 

    FUNCTION getAproved (pnNumberr NUMBER) RETURN VARCHAR2 
    IS rApproved VARCHAR2(1);
        BEGIN
            SELECT approved
            INTO rApproved
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rApproved;
        END;

    FUNCTION getIdType (pnNumberr NUMBER) RETURN NUMBER
    IS rIdType NUMBER(3);
        BEGIN
            SELECT id_type
            INTO rIdType
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdType;
        END;    

    FUNCTION getIdVeredict (pnNumberr NUMBER) RETURN NUMBER 
    IS rIdVeredict NUMBER(4);
        BEGIN
            SELECT id_veredict
            INTO rIdVeredict
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdVeredict;
        END;  

    FUNCTION getIdPerson (pnNumberr NUMBER) RETURN NUMBER 
    IS rIdPerson NUMBER(9);
        BEGIN
            SELECT id_person
            INTO rIdPerson
            FROM record
            WHERE numberr = pnNumberr;
            RETURN rIdPerson;
        END;  

    PROCEDURE approve_record(pnNumberr NUMBER) IS
        BEGIN
            UPDATE record
            SET approved = 'Y'
            WHERE numberr = pnNumberr;
        END;
        
END admin_record;
/