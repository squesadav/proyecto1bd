-- Conectado desde ADM

CREATE OR REPLACE TRIGGER adm.beforeUpdatePassword
BEFORE UPDATE OF password
ON appuser
FOR EACH ROW
BEGIN
    INSERT INTO logs.logPasswords(id, username, prev_password, current_password)
    VALUES (logs.seq_logPasswords.nextval, :new.username, :old.password, :new.password);
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
    INSERT INTO logs.logPasswords(id, username, current_password)
    VALUES (logs.seq_logPasswords.nextval, :new.username, :new.password);
END afterInsertUser;
/