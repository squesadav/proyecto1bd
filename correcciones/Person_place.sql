-- Author: Sebastián Quesada Calderón
-- Date: 26/06/2020

-- Connected from APP



ALTER TABLE person DROP CONSTRAINT fk_person_community;

ALTER TABLE person DROP COLUMN id_community;

ALTER TABLE person ADD COLUMN id_district;

ALTER TABLE person
    ADD CONSTRAINT fk_person_district FOREIGN KEY(id_district) 
    references district(id);



ALTER TABLE place DROP CONSTRAINT fk_place_community;

ALTER TABLE place DROP COLUMN id_community;

ALTER TABLE place ADD COLUMN id_district;

ALTER TABLE place
    ADD CONSTRAINT fk_person_district FOREIGN KEY(id_district) 
    references district(id);


ALTER TABLE person DROP CONSTRAINT pk_community;


ALTER TABLE person DROP CONSTRAINT fk_community_district;

DROP TABLE community;


ALTER TABLE record ADD COLUMN id_district;

ALTER TABLE record
    ADD CONSTRAINT fk_record_district FOREIGN KEY(id_district) 
    references district(id);