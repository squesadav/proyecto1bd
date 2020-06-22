-- Connected from APP
-- Autor: Sebastián Quesada Calderón
CREATE TABLE community(
    id                NUMBER(4),
    name              VARCHAR2(20) NOT NULL,
    id_district       NUMBER(4) NOT NULL,
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE community
    ADD CONSTRAINT pk_community PRIMARY KEY (id)
    USING INDEX
    TABLESPACE app_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
ALTER TABLE community
    ADD CONSTRAINT fk_community_district FOREIGN KEY(id_district) 
    references district(id);

CREATE SEQUENCE seq_community
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;