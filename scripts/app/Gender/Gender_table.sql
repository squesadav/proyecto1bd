-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 17/06/2020
CREATE TABLE gender(

    id      NUMBER(6),
    name    VARCHAR2(20) NOT NULL,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE gender
    ADD CONSTRAINT pk_gender PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
    
ALTER TABLE gender
ADD CONSTRAINT GENDER_UK_NAME UNIQUE (NAME)
ENABLE;

CREATE SEQUENCE seq_gender
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;
