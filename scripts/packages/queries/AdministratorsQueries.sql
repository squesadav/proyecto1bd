-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020

-- From SYSTEM
grant all on logs.logPasswords to app;

--From APP
CREATE OR REPLACE PACKAGE admin_queries IS
	FUNCTION passwords_not_changed (vnumberDays INTEGER) return sys_refcursor;
	FUNCTION not_approved return sys_refcursor;
    FUNCTION get_new_records return sys_refcursor;
END admin_queries;
/


CREATE OR REPLACE PACKAGE BODY admin_queries IS
    FUNCTION passwords_not_changed (vnumberDays INTEGER) RETURN sys_refcursor
    AS 
        cpassword sys_refcursor;
        BEGIN
            OPEN cpassword FOR
                SELECT username, trunc(sysdate) - pass_change_date days_since_pass_change
                FROM logs.logpasswords
                WHERE pass_change_date >= trunc(sysdate-vnumberDays);
            RETURN cpassword;
        END passwords_not_changed;

    FUNCTION not_approved RETURN sys_refcursor
    AS 
        capproved sys_refcursor;
        BEGIN
            OPEN capproved FOR
                SELECT *
                FROM record
                WHERE record.approved = 'N';
            RETURN capproved;
        END not_approved;
        
    FUNCTION get_new_records RETURN sys_refcursor
    AS
        cnrecords sys_refcursor;
        BEGIN
            OPEN cnrecords FOR
                SELECT *
                FROM new_records;
            RETURN cnrecords;
        END get_new_records;
END admin_queries;
/