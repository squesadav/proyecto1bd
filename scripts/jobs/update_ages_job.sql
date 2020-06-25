--Author: Sebastián Quesada Velluti
--Date: 24/06/2020

--From SYSTEM
GRANT CREATE ANY job TO app;


--From APP
--Creation of the job
BEGIN
  DBMS_SCHEDULER.create_job (
    job_name => 'update_ages_job',
    job_type        => 'PLSQL_BLOCK',
    job_action => 'BEGIN admin_person.updateAllAges; END;' ,
    start_date      => to_date('2020/06/29 12:00:01AM', 'yyyy/mm/dd hh:mi:ssam'),
    repeat_interval => 'freq=daily',
    end_date        => NULL,
    enabled         => TRUE,
    comments        => 'Updates all person ages every day');
END;