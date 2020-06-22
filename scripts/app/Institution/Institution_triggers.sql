-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE TRIGGER app.beforeInsertInstitution
BEFORE INSERT
ON app.institution
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertInstitution;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateInstitution
BEFORE UPDATE
ON app.institution
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateInstitution;
/