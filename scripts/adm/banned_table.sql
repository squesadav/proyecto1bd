CREATE TABLE banned
(
    id_banned NUMBER(20),
    ispermanent VARCHAR2(4),
    date_start DATE,
    date_finish DATE,
    username VARCHAR2(10),
    id_bannedreason NUMBER(10)
);

ALTER TABLE banned
ADD CONSTRAINT PK_banned PRIMARY KEY (id_banned);

ALTER TABLE banned
MODIFY id_banned CONSTRAINT id_banned_nn NOT NULL;

ALTER TABLE banned
MODIFY ispermanent CONSTRAINT ispermanent_nn NOT NULL;

ALTER TABLE banned
MODIFY date_start CONSTRAINT date_start_nn NOT NULL;

ALTER TABLE banned
MODIFY date_finish CONSTRAINT date_finish_nn NOT NULL;

ALTER TABLE banned
ADD CONSTRAINT FK_banned_reason FOREIGN KEY (id_bannedreason) REFERENCES bannedreason(id_bannedreason);

ALTER TABLE banned
ADD CONSTRAINT FK_banned_user FOREIGN KEY (username) REFERENCES appuser(username);

ALTER TABLE banned
MODIFY username CONSTRAINT userbanned_nn NOT NULL;

ALTER TABLE banned
MODIFY id_bannedreason CONSTRAINT idbannedreason_nn NOT NULL;

CREATE SEQUENCE seq_banned
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;