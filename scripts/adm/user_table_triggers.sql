-- Connected from ADM

CREATE OR REPLACE TRIGGER adm.beforeInsertUser
BEFORE INSERT
ON adm.appuser
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertUser;
/

CREATE OR REPLACE TRIGGER adm.beforeUpdateUser
BEFORE UPDATE
ON adm.appuser
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateUser;
/