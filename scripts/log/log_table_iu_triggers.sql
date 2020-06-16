-- Conectado desde LOG

CREATE OR REPLACE TRIGGER log.beforeInsertLog
BEFORE INSERT
ON log.log
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertLog;
/

CREATE OR REPLACE TRIGGER log.beforeUpdateLog
BEFORE UPDATE
ON log.log
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateLog;
/