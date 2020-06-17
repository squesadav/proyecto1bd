----En el esquema APP-----
CREATE TABLE Institution(
    id                NUMBER(4),
    name              VARCHAR2(50) NOT NULL,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE Institution
    ADD CONSTRAINT pk_institution PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);

CREATE SEQUENCE seq_institution
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;
NOCYCLE;