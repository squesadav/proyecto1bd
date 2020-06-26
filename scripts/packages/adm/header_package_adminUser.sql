-- Conected from ADM
-- Author: Diana Sofía Reyes Soto
-- Creation date: 20/06/2020
CREATE OR REPLACE PACKAGE adminUser IS

PROCEDURE createUser (pnUsername VARCHAR2, pnPassword VARCHAR2, pnUsertype NUMBER);
PROCEDURE createBanned (pnIspermanent VARCHAR2, pnDateStart DATE, pnDateFinish DATE, pnUsername VARCHAR2, pnIdBannedReason NUMBER);
PROCEDURE createBannedReason (pnDescription VARCHAR2);
PROCEDURE createUsertype (pnDescription VARCHAR2);
PROCEDURE editUserPassword (pnUsername VARCHAR2, pnOldPassword VARCHAR2, pnNewPassword VARCHAR2);
PROCEDURE editUsertype (pnUsername VARCHAR2, pnUsertype NUMBER);
PROCEDURE editUsername (pnUsername VARCHAR2, pnNewUsername VARCHAR2);
PROCEDURE editBannedPermanency (pnIdBanned NUMBER, pnIspermanent VARCHAR2);
PROCEDURE editBannedReason (pnIdBanned NUMBER, pnIdBannedReason NUMBER);
PROCEDURE editBannedReasonDescription (pnIdBannedReason NUMBER, pnNewDescription VARCHAR2);
PROCEDURE editUserTypeDescription (pnIdUserType NUMBER, pnNewDescription VARCHAR2);
PROCEDURE removeUser (pnUsername VARCHAR2);
PROCEDURE removeBanned (pnIdBanned NUMBER);
PROCEDURE removeBannedReason (pnIdBannedReason NUMBER);
PROCEDURE removeUsertype (pnIdUsertype NUMBER);
PROCEDURE removePassword (pnUsername VARCHAR2);
FUNCTION getPassword (vUsername VARCHAR2) RETURN VARCHAR2;
FUNCTION getUserType (vUsername VARCHAR2) RETURN NUMBER;
FUNCTION getIsPermanentBan (vIdBanned NUMBER) RETURN VARCHAR2;
FUNCTION getDateStartBan (vIdBanned NUMBER) RETURN DATE;
FUNCTION getDateFinishBan (vIdBanned NUMBER) RETURN DATE;
FUNCTION getUserBanned (vIdBanned NUMBER) RETURN VARCHAR2;
FUNCTION getBannedReasonId (vIdBanned NUMBER) RETURN NUMBER;
FUNCTION getBannedReasonDesc (vIdBannedReason NUMBER) RETURN VARCHAR2;
FUNCTION getUserTypeDesc (vIdUserType NUMBER) RETURN VARCHAR2;
FUNCTION getPersonId (vUsername VARCHAR2) RETURN NUMBER;
FUNCTION isBanned (vUsername VARCHAR2) RETURN VARCHAR2;
FUNCTION checkLogin (vUsername VARCHAR2, vPassword VARCHAR2) RETURN NUMBER;

END adminUser;
