-- Connected from APP
-- Autor: Sebastián Quesada Calderón
CREATE OR REPLACE TRIGGER app.beforeInsertVeredict
BEFORE INSERT
ON app.veredict
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertVeredict;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateVeredict
BEFORE UPDATE
ON app.veredict
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateVeredict;
/