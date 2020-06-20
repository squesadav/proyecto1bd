-- Conectado desde APP

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
END admin_record;
/