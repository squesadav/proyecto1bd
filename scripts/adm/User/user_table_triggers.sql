-- Conected from ADM
-- Author: Diana Sofía Reyes Soto
-- Creation date: 17/06/2020
create or replace TRIGGER adm.beforeInsertUser
BEFORE INSERT
ON adm.appuser
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertUser;
/

CREATE OR REPLACE TRIGGER adm.beforeUpdateUser
BEFORE UPDATE
ON adm.appuser
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateUser;
/
