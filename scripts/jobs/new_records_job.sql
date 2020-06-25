--Author: Sebastián Quesada Velluti
--Date: 24/06/2020

--From SYSTEM
grant create any view to app;

--From APP
BEGIN
  DBMS_SCHEDULER.create_job (
    job_name => 'new_records_job',
    job_type        => 'PLSQL_BLOCK',
    job_action => 'BEGIN
                       CREATE OR REPLACE VIEW new_records AS
                       SELECT *
                       FROM record
                       WHERE creation_date > trunc(sysdate-1); 
                   END;' ,
    start_date      => to_date('2020/06/29 12:00:01AM', 'yyyy/mm/dd hh:mi:ssam'),
    repeat_interval => 'freq=daily',
    end_date        => NULL,
    enabled         => TRUE,
    comments        => 'Updates');
END;