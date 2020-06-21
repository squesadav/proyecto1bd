-- Conected from APP
-- Author: Sebasti�n Quesada Velluti 
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE record_publishing IS
    /* Returns a cursor of rows from Record with the given values, if given, in ascending creation date order.
       For example, if no values are given all rows are returned in the cursor */
    FUNCTION filter_records_by(vdate_crime DATE DEFAULT NULL,
                               vdate_expiration DATE DEFAULT NULL,
                               vid_type INTEGER DEFAULT NULL,
                               vid_veredict INTEGER DEFAULT NULL,
                               vid_person INTEGER DEFAULT NULL,
                               vid_community INTEGER DEFAULT NULL,
                               vid_district INTEGER DEFAULT NULL) RETURN sys_refcursor;
END record_publishing;
/

CREATE OR REPLACE PACKAGE BODY record_publishing IS
    FUNCTION filter_records_by(vdate_crime DATE DEFAULT NULL,
                               vdate_expiration DATE DEFAULT NULL,
                               vid_type INTEGER DEFAULT NULL,
                               vid_veredict INTEGER DEFAULT NULL,
                               vid_person INTEGER DEFAULT NULL,
                               vid_community INTEGER DEFAULT NULL,
                               vid_district INTEGER DEFAULT NULL) RETURN sys_refcursor
    AS
        crecord sys_refcursor;
        BEGIN
            OPEN crecord FOR
                SELECT numberr
                FROM record
                WHERE (date_crime = NVL(vdate_crime, date_crime) OR date_crime IS NULL) AND
                      (crime_expiration_date = NVL(vdate_expiration, crime_expiration_date) OR crime_expiration_date IS NULL) AND
                      (id_type = NVL(vid_type, id_type) OR id_type IS NULL) AND
                      (id_veredict = NVL(vid_veredict, id_veredict) OR id_veredict IS NULL) AND
                      (id_person = NVL(vid_person, id_person) OR id_person IS NULL) AND
                      (id_person = 
                        (SELECT id FROM person WHERE id_community = NVL(vid_community, id_community) OR id_community IS NULL)
                       OR id_person IS NULL) AND
                      (id_person = 
                        (SELECT id FROM person WHERE id_community = 
                            (SELECT id FROM community WHERE id_district = NVL(vid_district, id_district) OR id_district IS NULL) 
                        OR id_community IS NULL) 
                       OR id_person IS NULL)
                ORDER BY creation_date ASC;
            RETURN crecord;
        END filter_records_by;
END record_publishing;
/

-- C�digo s�lo para probar la funci�n filter_records_by. Borrar despu�s
declare
    mycursor SYS_REFCURSOR;
    l_numberr record.numberr%type;

begin
    mycursor := record_publishing.filter_records_by;

    loop
        fetch mycursor into l_numberr;
        exit when mycursor%notfound;
        dbms_output.put_line(l_numberr);
    end loop;
    close mycursor;
end;