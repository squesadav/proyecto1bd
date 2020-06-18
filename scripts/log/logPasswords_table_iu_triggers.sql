-- Conectado desde LOGS

CREATE OR REPLACE TRIGGER logs.beforeInsertLogPasswords
BEFORE INSERT
ON logs.logPasswords
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertLogPasswords;
/

CREATE OR REPLACE TRIGGER logs.beforeUpdateLogPasswords
BEFORE UPDATE
ON logs.logPasswords
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateLog;
/