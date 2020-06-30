-- Conected from APP
-- Author: Sebastián Quesada Velluti 
-- Creation date: 20/06/2020

CREATE OR REPLACE PACKAGE record_publishing IS
    /* Returns a cursor of rows from Record with the given values, if given, in ascending creation date order.
       For example, if no values are given all rows are returned in the cursor */
    FUNCTION with_numberr(vnumberr INTEGER) RETURN sys_refcursor;
    FUNCTION filter_records_by(vnumberr NUMBER DEFAULT NULL,
                               vdate_crime DATE DEFAULT NULL,
                               vid_type INTEGER DEFAULT NULL,
                               vid_person INTEGER DEFAULT NULL,
                               vid_district INTEGER DEFAULT NULL,
                               vid_city INTEGER DEFAULT NULL,
                               vid_state INTEGER DEFAULT NULL,
                               vid_country INTEGER DEFAULT NULL) RETURN sys_refcursor;
END record_publishing;
/

CREATE OR REPLACE PACKAGE BODY record_publishing IS
    FUNCTION with_numberr(vnumberr INTEGER) RETURN sys_refcursor
    AS 
        crecord sys_refcursor;
        BEGIN
            OPEN crecord FOR
                SELECT r.numberr record_number,
                       r.description_crime crime_description,
                       t.name,
                       r.date_crime date_crime,
                       dr.name district_crime,
                       cir.name city_crime,
                       sr.name state_crime,
                       cor.name country_crime,
                       r.crime_expiration_date crime_expiration_date,
                       p.id id_accused,
                       p.name first_name_accused,
                       p.middle_name middle_name_accused,
                       p.last_name last_name_accused,
                       p.age age_accused,
                       g.name gender_accused,
                       i.name workplace_accused,
                       dp.name district_accused,
                       cip.name city_accused,
                       sp.name state_accused,
                       cop.name country_accused,
                       r.resolution resolution,
                       v.years years_sentence,
                       v.date_start sentence_start,
                       v.date_end sentence_end,
                       pl.name custody_location
                FROM record r
                INNER JOIN type t ON r.id_type = t.id
                INNER JOIN person p ON r.id_person = p.id
                INNER JOIN gender g ON p.id_gender = g.id
                INNER JOIN district dp ON p.id_district = dp.id
                INNER JOIN city cip ON dp.id_city = cip.id
                INNER JOIN state sp ON cip.id_state = sp.id
                INNER JOIN country cop ON sp.id_country = cop.id
                INNER JOIN district dr ON r.id_district = dr.id
                INNER JOIN city cir ON dr.id_city = cir.id
                INNER JOIN state sr ON cir.id_state = sr.id
                INNER JOIN country cor ON sr.id_country = cor.id
                LEFT JOIN institution i ON p.id_institution = i.id
                LEFT JOIN veredict v ON r.id_veredict = v.id
                LEFT JOIN place pl ON v.id_place = pl.id
                WHERE numberr = vnumberr;
            RETURN crecord;
        END with_numberr;
    FUNCTION filter_records_by(vnumberr NUMBER DEFAULT NULL,
                               vdate_crime DATE DEFAULT NULL,
                               vid_type INTEGER DEFAULT NULL,
                               vid_person INTEGER DEFAULT NULL,
                               vid_district INTEGER DEFAULT NULL,
                               vid_city INTEGER DEFAULT NULL,
                               vid_state INTEGER DEFAULT NULL,
                               vid_country INTEGER DEFAULT NULL) RETURN sys_refcursor
    AS
        crecord sys_refcursor;
        BEGIN
            OPEN crecord FOR
                SELECT r.numberr
                FROM record r
                inner join district d on r.id_district = d.id
                inner join city ci on d.id_city = ci.id
                inner join state s on ci.id_state = s.id
                inner join country co on s.id_country = co.id
                WHERE approved = 'Y' AND
                      r.numberr = NVL(vnumberr, r.numberr) AND
                      (r.date_crime = NVL(vdate_crime, r.date_crime) OR r.date_crime IS NULL) AND
                      (r.id_type = NVL(vid_type, r.id_type) OR r.id_type IS NULL) AND
                      d.id = NVL(vid_district, d.id) AND
                      ci.id = NVL(vid_city, ci.id) AND
                      s.id = NVL(vid_state, s.id) AND
                      co.id = NVL(vid_country, co.id)
                ORDER BY r.creation_date ASC;
            RETURN crecord;
        END filter_records_by;
END record_publishing;
/