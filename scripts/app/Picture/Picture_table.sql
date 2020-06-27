-- Conected from APP
-- Author: Sebastián Quesada Velluti
-- Creation date: 26/06/2020

CREATE TABLE picture(
    id			            NUMBER(9),
    pic_str                 VARCHAR2(50),
    numberr                 VARCHAR2(10),		
    creation_date           DATE,
    creation_user           VARCHAR2(15),
    last_change_date        DATE,
    last_change_user        VARCHAR2(15)
);

ALTER TABLE picture
    ADD CONSTRAINT pk_picture PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
    
ALTER TABLE picture
    ADD CONSTRAINT fk_picture_record FOREIGN KEY(numberr) 
    references record(numberr);

CREATE SEQUENCE seq_picture
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;