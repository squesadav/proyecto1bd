-- Connected from APP
-- Autor: Sebastián Quesada Calderón
CREATE OR REPLACE TRIGGER app.beforeInsertCommunity
BEFORE INSERT
ON app.community
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertCommunity;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateCommunity
BEFORE UPDATE
ON app.community
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateCommunity;
/