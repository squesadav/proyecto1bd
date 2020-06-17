CREATE TABLE bannedreason
(
    id_bannedreason NUMBER(10),
    description VARCHAR2(50)
);

ALTER TABLE bannedreason
ADD CONSTRAINT PK_bannedreason PRIMARY KEY (id_bannedreason);

ALTER TABLE bannedreason
MODIFY id_bannedreason CONSTRAINT id_bannedreason_nn NOT NULL;

ALTER TABLE bannedreason
MODIFY description CONSTRAINT descriptionbanned_reason_nn NOT NULL;

CREATE SEQUENCE seq_bannedreason
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;