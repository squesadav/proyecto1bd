-- Connected from APP

CREATE OR REPLACE TRIGGER app.beforeInsertState
BEFORE INSERT
ON app.state
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertState;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateState
BEFORE UPDATE
ON app.state
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateState;
/