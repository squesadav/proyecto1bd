--Author: Sebastián Quesada Velluti
--Date: 24/06/2020

--From SYSTEM
grant create any view to app;

--From APP
-- Create view that stores records created a day ago
CREATE OR REPLACE VIEW new_records AS
SELECT *
FROM record
WHERE creation_date > trunc(admin_queries.get_current_date_new_records-1);

--Job updates current_date_new_records
BEGIN
  DBMS_SCHEDULER.create_job (
    job_name => 'new_records_job',
    job_type  => 'PLSQL_BLOCK',
    job_action => 'BEGIN admin_queries.current_date_new_records := SYSDATE; END;' ,
    start_date      => to_date('2020/06/25 11:00:00PM', 'yyyy/mm/dd hh:mi:sspm'),
    repeat_interval => 'freq=daily',
    end_date        => NULL,
    enabled         => TRUE,
    comments        => 'Updates');
END;