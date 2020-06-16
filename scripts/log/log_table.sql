-- Conectado desde LOG

CREATE TABLE log
(
    id                NUMBER(6),
    scheme_name       VARCHAR2(10) NOT NULL,
    table_name        VARCHAR2(30) NOT NULL,
    field_name        VARCHAR2(30) NOT NULL,
    prev_value        VARCHAR2(100),
    current_value     VARCHAR2(100),
    creation_date     DATE,
    creation_user     VARCHAR2(15),
    last_change_date  DATE,
    last_change_user  VARCHAR2(15)
);

ALTER TABLE log
    ADD CONSTRAINT pk_log PRIMARY KEY (id)
    USING INDEX
    TABLESPACE log_ind PCTFREE 20
    STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 20);
    
CREATE SEQUENCE seq_log
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 10000000
NOCACHE
NOCYCLE;