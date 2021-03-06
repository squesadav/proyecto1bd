-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 20/06/2020

CREATE OR REPLACE TRIGGER app.beforeInsertDistrict
BEFORE INSERT
ON app.district
FOR EACH ROW
BEGIN
    :NEW.creation_user := USER;
    :NEW.creation_date := SYSDATE;
END beforeInsertDistrict;
/

CREATE OR REPLACE TRIGGER app.beforeUpdateDistrict
BEFORE UPDATE
ON app.district
FOR EACH ROW
BEGIN
    :NEW.last_change_user := USER;
    :NEW.last_change_date := SYSDATE;
END beforeUpdateDistrict;
/