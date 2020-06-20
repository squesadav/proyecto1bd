-- Connected from APP

CREATE OR REPLACE TRIGGER app.beforeInsertPlace
BEFORE INSERT
ON app.place
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertPlace;
/

CREATE OR REPLACE TRIGGER app.beforeUpdatePlace
BEFORE UPDATE
ON app.place
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdatePlace;
/