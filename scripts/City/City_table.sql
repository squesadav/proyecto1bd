----En el esquema APP-----
CREATE TABLE city(
    id                NUMBER(4),
    name              VARCHAR2(20) NOT NULL,
    id_state          NUMBER(4) NOT NULL,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE city
    ADD CONSTRAINT pk_city PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
ALTER TABLE city
    ADD CONSTRAINT fk_city_state FOREIGN KEY(id_state) 
    references state(id);

CREATE SEQUENCE seq_city
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;