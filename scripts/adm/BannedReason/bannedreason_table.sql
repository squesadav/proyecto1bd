-- Conected from ADM
-- Author: Diana Sofía Reyes Soto
-- Creation date: 17/06/2020
CREATE TABLE bannedreason
(
    id_bannedreason NUMBER(10),
    description VARCHAR2(50),
    creation_user VARCHAR2(12),
    creation_date DATE,
    last_change_user VARCHAR2(12),
    last_change_date DATE
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
