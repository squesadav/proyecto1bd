-- Connected from ADM

CREATE TABLE appuser
(
    username VARCHAR2(10),
    password VARCHAR2(8),
    id_userType NUMBER(4),
    creation_user VARCHAR2(15),
    creation_date DATE,
    last_change_user  VARCHAR2(15),
    last_change_date  DATE
);

ALTER TABLE appuser
ADD CONSTRAINT PK_appuser PRIMARY KEY (username);

ALTER TABLE appuser
MODIFY username CONSTRAINT username_nn NOT NULL;

ALTER TABLE appuser
MODIFY password CONSTRAINT password_nn NOT NULL;

ALTER TABLE appuser
ADD CONSTRAINT FK_appuser_usertype FOREIGN KEY (id_userType) REFERENCES usertype(id_userType);

CREATE SEQUENCE seq_appuser
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;