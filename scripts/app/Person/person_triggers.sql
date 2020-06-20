-- Connected from APP

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