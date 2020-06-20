-- Connected from SYSTEM

CREATE OR REPLACE PACKAGE adminUser IS

PROCEDURE createUser (pnUsername VARCHAR2, pnPassword VARCHAR2, pnUsertype NUMBER);
PROCEDURE createBanned (pnIspermanent VARCHAR2, pnDateStart DATE, pnDateFinish DATE, pnUsername VARCHAR2, pnBannedReason NUMBER);
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
PROCEDURE removeBannedReason (pnIdBannedReaon NUMBER);
PROCEDURE removeUsertype (pnIdUsertype NUMBER);
PROCEDURE removePassword (pnUsername VARCHAR2);

END adminUser;
