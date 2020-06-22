-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020
CREATE OR REPLACE PACKAGE admin_record IS
    PROCEDURE insert_record(pnNumberr NUMBER, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnPicture VARCHAR2, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER);
    PROCEDURE remove_record(pnIdRecord NUMBER);
END admin_record;
/

CREATE OR REPLACE PACKAGE BODY admin_record AS
    PROCEDURE insert_record(pnNumberr NUMBER, pnDescriptionCrime VARCHAR2, pnDateCrime DATE, pnResolution VARCHAR2, pnCrimeExpirationDate DATE, pnPicture VARCHAR2, pnIdType NUMBER, pnIdVeredict NUMBER, pnIdPerson NUMBER) IS
        BEGIN
            INSERT INTO record(numberr, description_crime, date_crime, resolution, crime_expiration_date, picture, id_type, id_veredict, id_person)
            VALUES (pnNumberr, pnDescriptionCrime, pnDateCrime, pnResolution, pnCrimeExpirationDate, pnPicture, pnIdType, pnIdVeredict, pnIdPerson);
        END;
    PROCEDURE remove_record(pnIdRecord NUMBER) IS
        BEGIN
            DELETE FROM record
            WHERE numberr = pnIdRecord;
        END;

    FUNCTION getDescriptionCrime (vId VARCHAR2) RETURN VARCHAR2 IS rDescriptionCrime VARCHAR2(30);
        BEGIN
            SELECT description_crime
            INTO rDescriptionCrime
            FROM record
            WHERE id = vId;
            RETURN rDescriptionCrime;
        END;

    FUNCTION getDateCrime (vId VARCHAR2) RETURN DATE IS rDateCrime DATE;
        BEGIN
            SELECT date_crime
            INTO rDateCrime
            FROM record
            WHERE id = vId;
            RETURN rDateCrime;
        END;

    FUNCTION getResolution (vId VARCHAR2) RETURN VARCHAR2 IS rResolution VARCHAR2(30);
        BEGIN
            SELECT resolution
            INTO rResolution
            FROM record
            WHERE id = vId;
            RETURN rResolution;
        END;

    FUNCTION getCrimeExpirationDate (vId VARCHAR2) RETURN DATE IS rCrimeExpirationDate DATE;
        BEGIN
            SELECT crime_expiration_date
            INTO rCrimeExpirationDate
            FROM record
            WHERE id = vId;
            RETURN rCrimeExpirationDate;
        END;

    FUNCTION getPicture (vId VARCHAR2) RETURN VARCHAR2 IS rPicture VARCHAR2(50);
        BEGIN
            SELECT picture
            INTO rPicture
            FROM record
            WHERE id = vId;
            RETURN rPicture;
        END; 

    FUNCTION getIdType (vId VARCHAR2) RETURN NUMBER IS rIdType NUMBER(3);
        BEGIN
            SELECT id_type
            INTO rIdType
            FROM record
            WHERE id = vId;
            RETURN rIdType;
        END;    

    FUNCTION getIdVeredict (vId VARCHAR2) RETURN NUMBER IS rIdVeredict NUMBER(4);
        BEGIN
            SELECT id_veredict
            INTO rIdVeredict
            FROM record
            WHERE id = vId;
            RETURN rIdVeredict;
        END;  

    FUNCTION getIdPerson (vId VARCHAR2) RETURN NUMBER IS rIdPerson NUMBER(9);
        BEGIN
            SELECT id_person
            INTO rIdPerson
            FROM record
            WHERE id = vId;
            RETURN rIdPerson;
        END;  

END admin_record;
/