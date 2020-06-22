-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020
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