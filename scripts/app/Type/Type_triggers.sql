-- Connected from APP
-- Autor: Sebastián Quesada Calderón

CREATE OR REPLACE TRIGGER app.beforeInsertType
BEFORE INSERT
ON app.type
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertType;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateType
BEFORE UPDATE
ON app.type
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateType;
/