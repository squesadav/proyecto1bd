--Connected from SYSTEM

CREATE OR REPLACE PACKAGE BODY adminUser AS

-PROCEDURE createUser (pnUsername VARCHAR2, pnPassword VARCHAR2, pnUsertype NUMBER) IS
BEGIN
	INSERT INTO adm.appuser(username, password, id_usertype)
	VALUES(pnUsername,  pnPassword, 2);
	COMMIT;
END;

PROCEDURE createBanned (pnIspermanent VARCHAR2, pnDateStart DATE, pnDateFinish DATE, pnUsername VARCHAR2, pnBannedReason NUMBER) IS
BEGIN
    IF pnIsPermanent = 'Y' THEN
        INSERT INTO adm.banned(id_banned, ispermanent, date_start, date_finish, username, id_bannedreason)
        VALUES (sq_banned.nextval, pnIspermanent, NULL, NULL, pnUsername, pnIdBannedReason);
    ELSE
        INSERT INTO adm.banned(id_banned, ispermanent, date_start, date_finish, username, id_bannedreason)
        VALUES (sq_banned.nextval, pnIspermanent, pnDateStart, pnDateFinish, pnUsername, pnIdBannedReason);
    END IF;
	COMMIT;
END;

PROCEDURE createBannedReason (pnDescription VARCHAR2);
BEGIN
	INSERT INTO adm.bannedreason(id_bannedreason, description)
	VALUES(sq_bannedreason.nextval,  pnDescription);
	COMMIT;
END;

PROCEDURE createUsertype (pnDescription VARCHAR2) IS
BEGIN
	INSERT INTO adm.usertype(id_usertype, description)
	VALUES(sq_usertype.nextval,  pnDescription);
	COMMIT;
END;

-PROCEDURE editUserPassword (pnUsername VARCHAR2, pnOldPassword VARCHAR2, pnNewPassword VARCHAR2) IS
BEGIN
	UPDATE adm.appuser
	SET password = pnNewPassword
	WHERE username = pnUsername;
	COMMIT;
END;

PROCEDURE editUsertype (pnUsername VARCHAR2, pnUsertype NUMBER) IS
BEGIN
	UPDATE adm.appuser
	SET usertype = pnUsertype
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
	WHERE id_banned = pnIdBannedReason;
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

PROCEDURE removeBannedReason (pnIdBannedReaon NUMBER) IS
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

-PROCEDURE removePassword (pnUsername VARCHAR2) IS
BEGIN
	UPDATE adm.appuser
    SET password = temporaryPassword
	WHERE id_usertype = pnIdUsertype;
	COMMIT;
END;

END adminUser;




