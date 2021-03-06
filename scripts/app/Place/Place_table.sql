-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 17/06/2020

CREATE TABLE place(
    id                NUMBER(4),
    name              VARCHAR2(30) NOT NULL,
    id_district       NUMBER(4),
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE place
    ADD CONSTRAINT pk_place PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);

ALTER TABLE place
    ADD CONSTRAINT fk_person_district FOREIGN KEY(id_district) 
    references district(id);
    
ALTER TABLE place
ADD CONSTRAINT PLACE_UK_NAME UNIQUE (NAME)
ENABLE;
    
CREATE SEQUENCE seq_place
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;