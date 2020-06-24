-- Conected from ADM
-- Author: Diana Sofía Reyes Soto
-- Creation date: 17/06/2020
CREATE OR REPLACE TRIGGER adm.beforeInsertUserType
BEFORE INSERT
ON usertype
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertLog;
/

CREATE OR REPLACE TRIGGER adm.beforeUpdateUserType
BEFORE UPDATE
ON usertype
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateLog;
/
