-- Conected from ADM
-- Author: Diana Sofía Reyes Soto
-- Creation date: 17/06/2020

CREATE OR REPLACE TRIGGER adm.beforeInsertBanned
BEFORE INSERT
ON adm.banned
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertUser;
/

CREATE OR REPLACE TRIGGER adm.beforeUpdateBannned
BEFORE UPDATE
ON adm.banned
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateUser;
/
