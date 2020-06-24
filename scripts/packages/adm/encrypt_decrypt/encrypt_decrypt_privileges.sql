-- Author: Sebastián Quesada Velluti
-- Date: 23/06/2020

--From SYS (Se accede con USER: SYS as SYSDBA / PASSWORD: <contraseña igual a la de SYSTEM>)
--Para poder usar package dbms_crypto desde cualquier user
grant EXECUTE on "SYS"."DBMS_CRYPTO" to "PUBLIC" ;