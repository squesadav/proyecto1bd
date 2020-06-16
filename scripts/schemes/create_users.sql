-- Conectado desde SYSTEM

CREATE USER ADM
   IDENTIFIED BY ADM
   DEFAULT TABLESPACE ADM_DATA
   QUOTA 10M ON ADM_DATA
   QUOTA UNLIMITED ON ADM_IND
   TEMPORARY TABLESPACE temp
   QUOTA 5M ON system;
   
grant connect to ADM;

grant create session to ADM;

grant create table to ADM;

grant create any trigger to ADM;

grant create any sequence to ADM;

---------------------------------------------------------

CREATE USER APP
   IDENTIFIED BY APP
   DEFAULT TABLESPACE APP_DATA
   QUOTA 10M ON APP_DATA
   QUOTA UNLIMITED ON APP_IND
   TEMPORARY TABLESPACE temp
   QUOTA 5M ON system;
   
grant connect to APP;

grant create session to APP;

grant create table to APP;

grant create any trigger to APP;

grant create any sequence to APP;

---------------------------------------------------------

CREATE USER LOG
   IDENTIFIED BY LOG
   DEFAULT TABLESPACE LOG_DATA
   QUOTA 10M ON LOG_DATA
   QUOTA UNLIMITED ON LOG_IND
   TEMPORARY TABLESPACE temp
   QUOTA 5M ON system;
   
grant connect to LOG;

grant create session to LOG;

grant create table to LOG;

grant create any trigger to LOG;

grant create any sequence to LOG;