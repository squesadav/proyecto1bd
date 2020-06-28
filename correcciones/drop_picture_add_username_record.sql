-- Author: Sebastián Quesada Velluti
-- Date: 26/06/2020

-- Connected from APP

ALTER TABLE record DROP COLUMN picture;

ALTER TABLE record ADD username_creator VARCHAR2(20);

ALTER TABLE record
    ADD CONSTRAINT fk_record_username FOREIGN KEY(username_creator) 
    references adm.appuser(username);



