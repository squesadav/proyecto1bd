-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

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