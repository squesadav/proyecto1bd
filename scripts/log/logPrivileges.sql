-- Conectado desde SYSTEM

-- Ejecutar antes de crear la tabla y secuencia de logPasswords en LOGS

grant all on ADM.APPUSER to LOGS ;

-- Ejecutar luego de crear la tabla y secuencia de logPasswords en LOGS

grant all on LOGS.LOGPASSWORDS to ADM ;

grant all on logs.seq_logPasswords to adm;
