-- Si ya hicieron lo que respecta al usuario log deben eliminarlo todo con el siguiente codigo y volverlo a hacer
-- Una vez que hacen todo esto ejecutan los nuevos scripts en la carpeta log

-- Conectado desde SYSTEM

DROP USER log CASCADE;

CREATE USER LOGS
   IDENTIFIED BY LOGS
   DEFAULT TABLESPACE LOG_DATA
   QUOTA 10M ON LOG_DATA
   QUOTA UNLIMITED ON LOG_IND
   TEMPORARY TABLESPACE temp
   QUOTA 5M ON system;
   
grant connect to LOGS;

grant create session to LOGS;

grant create table to LOGS;

grant create any trigger to LOGS;

grant create any sequence to LOGS;

grant create any procedure to LOGS;