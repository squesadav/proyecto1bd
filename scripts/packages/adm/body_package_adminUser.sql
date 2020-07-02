-- Conected from ADM
-- Author: Diana Sofía Reyes Soto
-- Creation date: 20/06/2020
CREATE OR REPLACE PACKAGE BODY adminUser AS

PROCEDURE createUser (pnUsername VARCHAR2, pnPassword VARCHAR2, pnUsertype NUMBER, pnIdPerson NUMBER) IS
BEGIN
	INSERT INTO adm.appuser(username, password, id_usertype, id_person)
	VALUES(pnUsername,  encrypt_decrypt.encrypt(pnPassword), pnUsertype, pnIdPerson);
	COMMIT;
END;

PROCEDURE createBanned (pnIspermanent VARCHAR2, pnDateStart DATE, pnDateFinish DATE, pnUsername VARCHAR2, pnIdBannedReason NUMBER) IS
BEGIN
    IF pnIsPermanent = 'Y' THEN
        INSERT INTO adm.banned(id_banned, ispermanent, date_start, username, id_bannedreason)
        VALUES (adm.seq_banned.nextval, pnIspermanent, pnDateStart, pnUsername, pnIdBannedReason);
    ELSE
        INSERT INTO adm.banned(id_banned, ispermanent, date_start, date_finish, username, id_bannedreason)
        VALUES (adm.seq_banned.nextval, pnIspermanent, pnDateStart, pnDateFinish, pnUsername, pnIdBannedReason);
    END IF;
	COMMIT;
END;

PROCEDURE createBannedReason (pnDescription VARCHAR2) IS
BEGIN
	INSERT INTO adm.bannedreason(id_bannedreason, description)
	VALUES(seq_bannedreason.nextval,  pnDescription);
	COMMIT;
END;

PROCEDURE createUsertype (pnDescription VARCHAR2) IS
BEGIN
	INSERT INTO adm.usertype(id_usertype, description)
	VALUES(seq_usertype.nextval,  pnDescription);
	COMMIT;
END;

PROCEDURE editUserPassword (pnUsername VARCHAR2, pnOldPassword VARCHAR2, pnNewPassword VARCHAR2) IS
BEGIN
	UPDATE adm.appuser
	SET password = encrypt_decrypt.encrypt(pnNewPassword)
	WHERE username = pnUsername;
	COMMIT;
END;

PROCEDURE editUsertype (pnUsername VARCHAR2, pnUsertype NUMBER) IS
BEGIN
	UPDATE adm.appuser
	SET id_usertype = pnUsertype
	WHERE username = pnUsername;
	COMMIT;
END;

PROCEDURE editUsername (pnUsername VARCHAR2, pnNewUsername VARCHAR2) IS
BEGIN
	UPDATE adm.appuser
	SET username = pnNewUsername
	WHERE username = pnUsername;
	COMMIT;
END;

PROCEDURE editBannedPermanency (pnIdBanned NUMBER, pnIspermanent VARCHAR2) IS
BEGIN
	UPDATE adm.banned
	SET ispermanent = pnIspermanent
	WHERE id_banned = pnIdBanned;
	COMMIT;
END;

PROCEDURE editBannedReason (pnIdBanned NUMBER, pnIdBannedReason NUMBER) IS
BEGIN
	UPDATE adm.banned
	SET id_bannedreason = pnIdBannedReason
	WHERE id_banned = pnIdBanned;
	COMMIT;
END;

PROCEDURE editBannedReasonDescription (pnIdBannedReason NUMBER, pnNewDescription VARCHAR2) IS
BEGIN
	UPDATE adm.bannedreason
	SET description = pnNewDescription
	WHERE id_bannedReason = pnIdBannedReason;
	COMMIT;
END;

PROCEDURE editUserTypeDescription (pnIdUsertype NUMBER, pnNewDescription VARCHAR2) IS
BEGIN
	UPDATE adm.usertype
	SET description = pnNewDescription
	WHERE id_usertype = pnIdUsertype;
	COMMIT;
END;

PROCEDURE removeUser (pnUsername VARCHAR2) IS
BEGIN
	DELETE FROM adm.appuser
	WHERE username = pnUsername;
	COMMIT;
END;

PROCEDURE removeBanned (pnIdBanned NUMBER) IS
BEGIN
	DELETE FROM adm.banned
	WHERE id_banned = pnIdBanned;
	COMMIT;
END;

PROCEDURE removeBannedReason (pnIdBannedReason NUMBER) IS
BEGIN
	DELETE FROM adm.bannedreason
	WHERE id_bannedreason = pnIdBannedReason;
	COMMIT;
END;

PROCEDURE removeUsertype (pnIdUsertype NUMBER) IS
BEGIN
	DELETE FROM adm.usertype
	WHERE id_usertype = pnIdUsertype;
	COMMIT;
END;

PROCEDURE removePassword (pnUsername VARCHAR2) IS
BEGIN
	UPDATE adm.appuser
    SET password = ''
	WHERE username = pnUsername;
	COMMIT;
END;

FUNCTION getPassword (vUsername VARCHAR2) RETURN VARCHAR2
    IS rPassword VARCHAR2(8);
BEGIN
    SELECT password
    INTO rPassword
    FROM appuser
    WHERE username = vUsername;
    RETURN rPassword;
END;

FUNCTION getUserType (vUsername VARCHAR2) RETURN NUMBER
    IS rUserType NUMBER(4);
BEGIN
    SELECT id_usertype
    INTO rUserType
    FROM appuser
    WHERE username = vUsername;
    RETURN rUserType;
END;

FUNCTION getIsPermanentBan (vIdBanned NUMBER) RETURN VARCHAR2
    IS rIsPermanent VARCHAR2(4);
BEGIN
    SELECT isPermanent
    INTO rIsPermanent
    FROM banned
    WHERE id_banned = vIdBanned;
    RETURN rIsPermanent;
END;

FUNCTION getDateStartBan (vIdBanned NUMBER) RETURN DATE
    IS rDateStart DATE;
BEGIN
    SELECT date_start
    INTO rDateStart
    FROM banned
    WHERE id_banned = vIdBanned;
    RETURN rDateStart;
END;

FUNCTION getDateFinishBan (vIdBanned NUMBER) RETURN DATE
    IS rDateFinish DATE;
BEGIN
    SELECT date_finish
    INTO rDateFinish
    FROM banned
    WHERE id_banned = vIdBanned;
    RETURN rDateFinish;
END;

FUNCTION getUserBanned (vIdBanned NUMBER) RETURN VARCHAR2
    IS rUserBanned VARCHAR2(10);
BEGIN
    SELECT username
    INTO rUserBanned
    FROM banned
    WHERE id_banned = vIdBanned;
    RETURN rUserBanned;
END;

FUNCTION getBannedReasonId (vIdBanned NUMBER) RETURN NUMBER
    IS rBannedReason NUMBER(10);
BEGIN
    SELECT id_bannedReason
    INTO rBannedReason
    FROM banned
    WHERE id_banned = vIdBanned;
    RETURN rBannedReason;
END;

FUNCTION getBannedReasonDesc (vIdBannedReason NUMBER) RETURN VARCHAR2
    IS rBannedReasonDesc VARCHAR2(50);
BEGIN
    SELECT description
    INTO rBannedReasonDesc
    FROM bannedReason
    WHERE id_bannedReason = vIdBannedReason;
    RETURN rBannedReasonDesc;
END;

FUNCTION getUserTypeDesc (vIdUserType NUMBER) RETURN VARCHAR2
    IS rUserTypeDesc VARCHAR2(30);
BEGIN
    SELECT description
    INTO rUserTypeDesc
    FROM userType
    WHERE id_userType = vIdUserType;
    RETURN rUserTypeDesc;
END;

FUNCTION getPersonId (vUsername VARCHAR2) RETURN NUMBER
    IS rPersonId NUMBER(9);
BEGIN
    SELECT id_person
    INTO rPersonId
    FROM appuser
    WHERE username = vUsername;
    RETURN rPersonId;
END;

FUNCTION getAllUserType RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT id_usertype, description
            FROM usertype;
        RETURN rAll;
    END;

FUNCTION getAllBannedReason RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT id_bannedreason, description
            FROM bannedreason;
        RETURN rAll;
    END;

FUNCTION isBanned (vUsername VARCHAR2) RETURN VARCHAR2
    IS rBanned VARCHAR2(1);
BEGIN
    declare
        rows_found number;
    begin
        select count(*)
        into   rows_found
        from   banned
        where  username = vUsername AND (ispermanent = 'Y' OR NVL(date_finish, SYSDATE) > SYSDATE);
    
        if rows_found > 0 then
            rBanned := 'Y';
        else
            rBanned := 'N';
        end if;
    END;
    RETURN rBanned;
END isBanned;

FUNCTION checkLogin (vUsername VARCHAR2, vPassword VARCHAR2) RETURN NUMBER
    IS rUserType NUMBER(8);
    /*Returns the usertype id or 0 if the user or password is incorrect or -1 if the user is banned*/
BEGIN
    BEGIN
        SELECT id_usertype
        INTO rUserType
        FROM appuser au
        WHERE au.username = vUsername AND au.password = encrypt_decrypt.encrypt(vPassword);
        
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
            rUserType := 0;
            RETURN rUserType;
        END;
        
        IF isBanned(vUsername) = 'Y' THEN
            rUserType := -1;
        END IF;
        RETURN rUserType;
    END checkLogin;

FUNCTION getAllUsernames RETURN sys_refcursor
        AS rAll sys_refcursor;
    BEGIN
    OPEN rALL FOR
            SELECT username
            FROM appuser;
        RETURN rAll;
    END;
    
FUNCTION getIdUsertype(vName VARCHAR2) RETURN NUMBER
AS
    rid NUMBER(8);
    BEGIN
        SELECT id_usertype
        INTO rid
        FROM usertype
        WHERE description = vName;
    RETURN rid;
    END;
    
END adminUser;
/



