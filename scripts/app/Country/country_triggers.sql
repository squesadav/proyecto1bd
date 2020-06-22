-- Connected from APP
-- Autor: Sebastián Quesada Calderón

CREATE OR REPLACE TRIGGER app.beforeInsertCountry
BEFORE INSERT
ON app.country
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCountry;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateCountry
BEFORE UPDATE
ON app.country
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateCountry;
/