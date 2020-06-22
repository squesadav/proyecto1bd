-- Conected from APP
-- Author: Sebastián Quesada Calderón
-- Creation date: 17/06/2020
CREATE TABLE veredict(
    id                NUMBER(4),
    years             NUMBER(3) NOT NULL,
    id_place          NUMBER(4),
    date_start        DATE NOT NULL,
    date_end          DATE,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE veredict
    ADD CONSTRAINT pk_veredict PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
ALTER TABLE veredict
    ADD CONSTRAINT fk_veredict_place FOREIGN KEY(id_place) 
    references place(id);


CREATE SEQUENCE seq_veredict
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;