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