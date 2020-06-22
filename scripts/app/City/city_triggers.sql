-- Connected from APP
-- Autor: Sebastián Quesada Calderón

CREATE OR REPLACE TRIGGER app.beforeInsertCity
BEFORE INSERT
ON app.city
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCity;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateCity
BEFORE UPDATE
ON app.city
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateCity;
/