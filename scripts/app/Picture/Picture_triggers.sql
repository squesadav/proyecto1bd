-- Conected from APP
-- Author: Sebastián Quesada Velluti
-- Creation date: 26/06/2020

CREATE OR REPLACE TRIGGER app.beforeInsertPicture
BEFORE INSERT
ON app.picture
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertPicture;
/

CREATE OR REPLACE TRIGGER app.beforeUpdatePicture
BEFORE UPDATE
ON app.picture
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdatePicture;
/