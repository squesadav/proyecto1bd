-- Connected from APP
-- Autor: Sebastián Quesada Calderón
CREATE TABLE district(
    id                NUMBER(4),
    name              VARCHAR2(20) NOT NULL,
    id_city           NUMBER(4) NOT NULL,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE district
    ADD CONSTRAINT pk_district PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
ALTER TABLE district
    ADD CONSTRAINT fk_district_city FOREIGN KEY(id_city) 
    references city(id);

CREATE SEQUENCE seq_district
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;