-- Conectado desde SYSTEM
-- En todos modificar la instrucción DATAFILE para que funcione con la ubicación de la base de datos en su sistema

CREATE TABLESPACE ADM_DATA
   DATAFILE 'C:\app\sebas\oradata\PROYECTO1\admdata01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;

CREATE TABLESPACE ADM_IND
   DATAFILE 'C:\app\sebas\oradata\PROYECTO1\admind01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;
   
-----------------------------------------------------------------------

CREATE TABLESPACE APP_DATA
   DATAFILE 'C:\app\sebas\oradata\PROYECTO1\appdata01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;

CREATE TABLESPACE APP_IND
   DATAFILE 'C:\app\sebas\oradata\PROYECTO1\appind01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;

-----------------------------------------------------------------------

CREATE TABLESPACE LOG_DATA
   DATAFILE 'C:\app\sebas\oradata\PROYECTO1\logdata01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;

CREATE TABLESPACE LOG_IND
   DATAFILE 'C:\app\sebas\oradata\PROYECTO1\logind01.dbf'
   SIZE 10M
   REUSE
   AUTOEXTEND ON
   NEXT 512k
   MAXSIZE 200M;