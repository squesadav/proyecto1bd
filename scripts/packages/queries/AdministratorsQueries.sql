-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020

CREATE OR REPLACE PACKAGE admin_queries IS
	--FUNCTION no_longer_change_password (vnumberDays INTEGER) return sys_refcursor;
	FUNCTION not_approved return sys_refcursor;
    FUNCTION get_new_records return sys_refcursor;
END admin_queries;
/


CREATE OR REPLACE PACKAGE BODY admin_queries IS
    /*FUNCTION no_longer_change_password (vnumberDays INTEGER) RETURN sys_refcursor
    AS 
        cpassword sys_refcursor;
        BEGIN
            OPEN cpassword FOR
                SELECT *
                FROM appuser
                 inner join logs.logPasswords on appuser.username = logPasswords.username
                WHERE (sysdate - logs.logPasswords.last_change_date)< vnumberDays;
            RETURN cpassword;
        END no_longer_change_password;*/

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