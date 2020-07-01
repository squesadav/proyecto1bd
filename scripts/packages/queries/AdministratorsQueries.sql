-- Author: Sebastián Quesada Velluti
-- Creation date: 23/06/2020

-- From SYSTEM
grant all on logs.logPasswords to app;
grant select on adm.appuser to adm;

--From APP
CREATE OR REPLACE PACKAGE admin_queries IS
    FUNCTION passwords_not_changed (vnumberDays INTEGER, 
                                    vfirst_name VARCHAR2 DEFAULT NULL, 
                                    vlast_name VARCHAR2 DEFAULT NULL,
                                    vid_person NUMBER DEFAULT NULL,
                                    vusername VARCHAR2 DEFAULT NULL) RETURN sys_refcursor;
	FUNCTION not_approved return sys_refcursor;
    FUNCTION records_by_user(vusername VARCHAR2) return sys_refcursor;
    FUNCTION get_new_records return sys_refcursor;
    FUNCTION get_current_date_new_records return DATE;
    current_date_new_records DATE;
END admin_queries;
/

CREATE OR REPLACE PACKAGE BODY admin_queries IS
    FUNCTION passwords_not_changed (vnumberDays INTEGER, 
                                    vfirst_name VARCHAR2 DEFAULT NULL, 
                                    vlast_name VARCHAR2 DEFAULT NULL,
                                    vid_person NUMBER DEFAULT NULL,
                                    vusername VARCHAR2 DEFAULT NULL) RETURN sys_refcursor
    AS 
        cpassword sys_refcursor;
        BEGIN
            OPEN cpassword FOR
                SELECT l.username, trunc(sysdate) - l.pass_change_date days_since_pass_change, p.name, p.last_name, p.id
                FROM logs.logpasswords l
                INNER JOIN adm.appuser u ON l.username = u.username
                INNER JOIN app.person p ON p.id = u.id_person
                WHERE l.pass_change_date <= trunc(sysdate-vnumberDays) AND 
                      p.name = NVL(vfirst_name, p.name) AND
                      p.last_name = NVL(vlast_name, p.last_name) AND
                      p.id = NVL(vid_person, p.id) AND
                      u.username = NVL(vusername, u.username);
            RETURN cpassword;
        END passwords_not_changed;

    FUNCTION not_approved RETURN sys_refcursor
    AS 
        capproved sys_refcursor;
        BEGIN
            OPEN capproved FOR
                SELECT numberr
                FROM record
                WHERE record.approved = 'N';
            RETURN capproved;
        END not_approved;
        
    FUNCTION records_by_user(vusername VARCHAR2) return sys_refcursor
    AS
        crecords sys_refcursor;
        BEGIN
            OPEN crecords FOR
                SELECT numberr
                FROM record
                WHERE username_creator = vusername;
            RETURN crecords;
        END records_by_user;
        
    FUNCTION get_new_records RETURN sys_refcursor
    AS
        cnrecords sys_refcursor;
        BEGIN
            OPEN cnrecords FOR
                SELECT numberr
                FROM new_records;
            RETURN cnrecords;
        END get_new_records;
        
    FUNCTION get_current_date_new_records return DATE
    AS
        rDate DATE := current_date_new_records;
        BEGIN 
            RETURN rDate; 
        END get_current_date_new_records;
END admin_queries;
/