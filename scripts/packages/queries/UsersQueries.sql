-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020


CREATE OR REPLACE PACKAGE user_publishing IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN rcursor;
    FUNCTION recordInformation() RETURN rcursor;
    FUNCTION user_list RETURN rcursor;
    FUNCTION user_banned RETURN rcursor;
    FUNCTION user_banned RETURN rcursor;
    FUNCTION record_list(daterange DATE) RETURN rcursor;
END;
/


CREATE OR REPLACE PACKAGE BODY user_publishing IS
    FUNCTION dangerous_places(vquantity INTEGER) RETURN rcursor
    AS 
        cplaces rcursor;
        BEGIN
            OPEN cplaces FOR
                SELECT *
                FROM record
                inner join veredict on record.id_veredict = veredict.id
                where rownum <=vquantity
                order by veredict.id_place;
            RETURN cplaces;
        END;

    FUNCTION recordInformation RETURN rcursor
    AS 
        crecords rcursor;
        BEGIN
            OPEN crecords FOR
                SELECT *
                FROM record
                inner join type on record.id_type = type.id
                group by id_type;
            RETURN crecords;
        END;

    FUNCTION user_list RETURN rcursor
    AS
        cusers rcursor;
        BEGIN
            OPEN cusers FOR
                SELECT *
                FROM users;
            RETURN cusers;
        END;

    FUNCTION user_banned RETURN rcursor
    AS
        cusersBanned rcursor;
        BEGIN
            OPEN cusersBanned FOR
                SELECT *
                FROM banned
                inner join banned on banned.id_bannedreason = bannedreason.id_bannedreason;
            RETURN cusersBanned;
        END;

    FUNCTION record_list(daterange DATE) RETURN rcursor
    AS
        crecords rcursor;
        BEGIN
            OPEN crecords FOR
                SELECT *
                FROM record
                inner join person on record.id_person = person.id;
            RETURN crecords;
        END;
END;
/