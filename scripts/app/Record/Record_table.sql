-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 17/06/2020

CREATE TABLE record(
    numberr                 VARCHAR2(10),
    description_crime       VARCHAR2(30) NOT NULL,
    date_crime              DATE NOT NULL,
    resolution              VARCHAR2(30) NOT NULL,
    crime_expiration_date   DATE NOT NULL,
    picture                 VARCHAR2(50),
    approved                VARCHAR2(1),
    id_type                 NUMBER(3),
    id_veredict             NUMBER(4),
    id_person               NUMBER(9),
    creation_date           DATE,
    creation_user           VARCHAR2(15),
    last_change_date        DATE,
    last_change_user        VARCHAR2(15)
);

ALTER TABLE record
    ADD CONSTRAINT pk_record PRIMARY KEY (numberr)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
ALTER TABLE record
    ADD CONSTRAINT fk_record_type FOREIGN KEY(id_type) 
    references type(id);
ALTER TABLE record
    ADD CONSTRAINT fk_record_veredict FOREIGN KEY(id_veredict) 
    references veredict(id);
ALTER TABLE record
    ADD CONSTRAINT fk_record_person FOREIGN KEY(id_person) 
    references person(id);