-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE TRIGGER app.beforeInsertPerson
BEFORE INSERT
ON app.person
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertPerson;
/

CREATE OR REPLACE TRIGGER app.beforeUpdatePerson
BEFORE UPDATE
ON app.person
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdatePerson;
/