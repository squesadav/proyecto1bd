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

grant create any procedure to ADM;

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

grant create any procedure to APP;

---------------------------------------------------------

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
