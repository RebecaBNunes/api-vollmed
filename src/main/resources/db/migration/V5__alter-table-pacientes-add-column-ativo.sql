alter table pacientes drop column ativo;
alter table pacientes add ativo tinyint;
update pacientes set ativo = 1;
alter table pacientes modify column ativo tinyint not null;