-- Connected from APP
-- Autor: Sebastián Quesada Calderón

CREATE OR REPLACE TRIGGER app.beforeInsertRecord
BEFORE INSERT
ON app.record
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertRecord;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateRecord
BEFORE UPDATE
ON app.record
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateRecord;
/