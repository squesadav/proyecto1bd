-- Connected from ADM

CREATE OR REPLACE TRIGGER adm.beforeInsertBannedReason
BEFORE INSERT
ON adm.bannedreason
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertUser;
/

CREATE OR REPLACE TRIGGER adm.beforeUpdateBannedReason
BEFORE UPDATE
ON adm.bannedreason
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateUser;
/