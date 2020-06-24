-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 23/06/2020

CREATE OR REPLACE PACKAGE admin_publishing IS
	FUNCTION no_longer_change_password (vnumberDays INTEGER) return rcursor;
	FUNCTION YetToBeApproved() return rcursor;

END;
/


CREATE OR REPLACE PACKAGE BODY admin_publishing IS
    FUNCTION no_longer_change_password (vnumberDays INTEGER) RETURN rcursor
    AS 
        cpassword rcursor;
        BEGIN
            OPEN cpassword FOR
                SELECT *
                FROM appuser
                 inner join logs.logPasswords on username = logPasswords.username
                WHERE (sysdate - logs.logPasswords.last_change_date)< vnumberDays;
            RETURN cpassword;
        END no_longer_change_password;

    FUNCTION YetToBeApproved() RETURN rcursor
    AS 
        capproved rcursor;
        BEGIN
            OPEN capproved FOR
                SELECT *
                FROM record
                WHERE record.approved = NULL;
            RETURN capproved;
        END YetToBeApproved;
END;
/