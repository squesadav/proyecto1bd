-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE TRIGGER app.beforeInsertGender
BEFORE INSERT
ON app.gender
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertGender;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateGender
BEFORE UPDATE
ON app.gender
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateGender;
/