alter table medicos drop column ativo;
alter table medicos add ativo tinyint;
update medicos set ativo = 1;
alter table medicos modify column ativo tinyint not null;