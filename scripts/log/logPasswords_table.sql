-- Conectado desde LOGS
-- Ejecutar primero logPrivileges.sql

CREATE TABLE logPasswords
(
    id                NUMBER(10),
    username          VARCHAR2(10) NOT NULL,
    prev_password     VARCHAR2(8),
    current_password  VARCHAR2(8) NOT NULL,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE logPasswords
    ADD CONSTRAINT pk_logPasswords PRIMARY KEY (id)
    USING INDEX
    TABLESPACE log_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);

-- Si el siguiente alter da error debe ejecutar el script logPrivileges.sql desde SYSTEM
ALTER TABLE logPasswords
   ADD CONSTRAINT fk_username FOREIGN KEY (username)
   REFERENCES adm.appuser (username) 
   ENABLE;

CREATE SEQUENCE seq_logPasswords
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;
