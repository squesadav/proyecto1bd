CREATE TABLE usertype
(
    id_usertype NUMBER(8),
    description VARCHAR2(30),
    creation_user VARCHAR2(12),
    creation_date DATE,
    last_change_user VARCHAR2(12),
    last_change_date DATE
);

ALTER TABLE usertype
ADD CONSTRAINT PK_usertype PRIMARY KEY (id_usertype)
USING INDEX TABLESPACE ADM_IND
PCTFREE 20
STORAGE(INITIAL 10K NEXT 10K PCTINCREASE 20);

ALTER TABLE usertype
MODIFY id_usertype CONSTRAINT id_usertype_nn NOT NULL;

ALTER TABLE usertype
MODIFY description CONSTRAINT description_nn NOT NULL;

CREATE SEQUENCE seq_usertype
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;

alter table usertype
add last_change_date DATE;
