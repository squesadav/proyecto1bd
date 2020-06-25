-- Conected from ADM
-- Author: Sebastián Quesada Velluti
-- Creation date: 18/06/2020

CREATE OR REPLACE TRIGGER adm.beforeUpdatePassword
BEFORE UPDATE OF password
ON appuser
FOR EACH ROW
BEGIN
    UPDATE logs.logpasswords l
    SET prev_password = :old.password, current_password = :new.password, pass_change_date = SYSDATE
    WHERE l.username = username;
END beforeUpdatePassword;
/

create or replace TRIGGER adm.beforeDeleteUser
BEFORE DELETE
ON adm.appuser
FOR EACH ROW
BEGIN
    DELETE FROM logs.logPasswords l
    WHERE l.username = username;
END beforeDeleteUser;
/

create or replace TRIGGER adm.beforeUpdateUsername
BEFORE UPDATE
ON adm.appuser
FOR EACH ROW
BEGIN
    UPDATE logs.logPasswords l
    SET l.username = :new.username
    WHERE l.username = :old.username;
END beforeUpdateUsername;
/

create or replace TRIGGER adm.afterInsertUser
AFTER INSERT
ON adm.appuser
FOR EACH ROW
BEGIN
    INSERT INTO logs.logPasswords(id, username, current_password, pass_change_date)
    VALUES (logs.seq_logPasswords.nextval, :new.username, :new.password, SYSDATE);
END afterInsertUser;
/
