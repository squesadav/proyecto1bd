-- Connected from adm
-- Permitir que en banned la fecha final sea nula, ya que si el ban es permanente no hay fecha final

ALTER TABLE banned DROP CONSTRAINT date_finish_nn;