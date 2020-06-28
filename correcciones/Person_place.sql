-- Author: Sebastián Quesada Calderón
-- Date: 26/06/2020

-- Connected from APP



ALTER TABLE person DROP CONSTRAINT fk_person_community;

ALTER TABLE person DROP COLUMN id_community;

ALTER TABLE person ADD id_district NUMBER(4) NOT NULL;

ALTER TABLE person
    ADD CONSTRAINT fk_person_district FOREIGN KEY(id_district) 
    references district(id);


ALTER TABLE place DROP CONSTRAINT fk_place_community;

ALTER TABLE place DROP COLUMN id_community;

ALTER TABLE place ADD id_district NUMBER(4) NOT NULL;

ALTER TABLE place
    ADD CONSTRAINT fk_place_district FOREIGN KEY(id_district) 
    references district(id);


ALTER TABLE community DROP CONSTRAINT pk_community;


ALTER TABLE community DROP CONSTRAINT fk_community_district;

DROP TABLE community;


ALTER TABLE record ADD id_district NUMBER(4) NOT NULL;

ALTER TABLE record
    ADD CONSTRAINT fk_record_district FOREIGN KEY(id_district) 
    references district(id);