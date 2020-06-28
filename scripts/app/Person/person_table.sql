-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 17/06/2020

CREATE TABLE Person(
    id                NUMBER(9),
    name              VARCHAR2(30) NOT NULL,
    middle_name       VARCHAR2(30),
    last_name         VARCHAR2(30) NOT NULL,
    birthday          DATE NOT NULL,
    age               NUMBER(2),
    id_gender         NUMBER(2),
    id_institution    NUMBER(4),
    id_district       NUMBER(4),
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE person
    ADD CONSTRAINT pk_person PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
ALTER TABLE person
    ADD CONSTRAINT fk_person_institution FOREIGN KEY(id_institution) 
    references institution(id);
ALTER TABLE person
    ADD CONSTRAINT fk_person_gender FOREIGN KEY(id_gender) 
    references gender(id);
ALTER TABLE person
    ADD CONSTRAINT fk_person_district FOREIGN KEY(id_district) 
    references district(id);
