create table usuario(
codigo int auto_increment not null,
usuario varchar(60) not null,
senha varchar(45) not null,
primary key (codigo)
);


create table pontuacao(
	codigo int auto_increment not null,
    pontos int,
    datacadastro datetime default now(),
    codusuario int,
	qtd_perguntas bigint(20),
    assunto varchar(100),
    primary key (codigo),
    foreign key(codusuario) references usuario(codigo)
);

create table perguntas(
	codigo int auto_increment not null,
    assunto varchar(100) not null,
    pergunta1 varchar(500) not null,
    dica1perg1 varchar(200) not null,
    dica2perg1 varchar(200) not null,
    dica3perg1 varchar(200) not null,
    respperg1 varchar(60) not null,
    pergunta2 varchar(500) not null,
    dica1perg2 varchar(200) not null,
    dica2perg2 varchar(200) not null,
    dica3perg2 varchar(200) not null,
    respperg2 varchar(60) not null,
    pergunta3 varchar(500) not null,
    dica1perg3 varchar(200) not null,
    dica2perg3 varchar(200) not null,
    dica3perg3 varchar(200) not null,
    respperg3 varchar(60) not null,
    pergunta4 varchar(500) not null,
    dica1perg4 varchar(200) not null,
    dica2perg4 varchar(200) not null,
    dica3perg4 varchar(200) not null,
    respperg4 varchar(60) not null,
    pergunta5 varchar(500) not null,
    dica1perg5 varchar(200) not null,
    dica2perg5 varchar(200) not null,
    dica3perg5 varchar(200) not null,
    respperg5 varchar(60) not null,
    primary key (codigo)
);


create table cod_user_atual(
	codigo int auto_increment not null,
    cod_user_atual int,
    primary key(codigo)
);
 
create table info_perguntas(
	id int primary key,
    nome varchar(200),
    datacadastro datetime default now(),
    assunto_atual varchar(100),
    codperguntas int,
    foreign key (codperguntas) references perguntas(codigo)
);


create table backup_sistema (
	id int auto_increment primary key,
	usuario varchar(100),
    senha varchar(100),
    assunto varchar(100),
    pergunta1 varchar(500),
    dica1perg1 varchar(200),
    dica2perg1 varchar(200),
    dica3perg1 varchar(200),
    respperg1 varchar(60),
    pergunta2 varchar(500),
    dica1perg2 varchar(200),
    dica2perg2 varchar(200),
    dica3perg2 varchar(200),
    respperg2 varchar(60),
    pergunta3 varchar(500),
    dica1perg3 varchar(200),
    dica2perg3 varchar(200),
    dica3perg3 varchar(200),
    respperg3 varchar(60),
    pergunta4 varchar(500),
    dica1perg4 varchar(200),
    dica2perg4 varchar(200),
    dica3perg4 varchar(200),
    respperg4 varchar(60),
    pergunta5 varchar(500),
    dica1perg5 varchar(200),
    dica2perg5 varchar(200),
    dica3perg5 varchar(200),
    respperg5 varchar(60)
);


########################Trigger 1 ##################
-- data de registro das perguntas
delimiter $$
create trigger trg_data_perguntas
after
insert
on perguntas
for each row
begin
insert into pontuacao(id, nome)
values(NEW.codigo, NEW.assunto);
end$$
delimiter ;

select * from info_perguntas;

######################Trigger 2 ####################
delimiter $$
create trigger trg_backup_perguntas
after
insert
on perguntas
for each row
begin
insert into backup_sistema(assunto,pergunta1,dica1perg1,dica2perg1,
dica3perg1,respperg1,pergunta2,dica1perg2,dica2perg2,dica3perg2,respperg2,
pergunta3,dica1perg3,dica2perg3,dica3perg3,respperg3,pergunta4,dica1perg4,
dica2perg4,dica3perg4,respperg4,pergunta5,dica1perg5,dica2perg5,dica3perg5,
respperg5)
values(NEW.assunto,NEW.pergunta1,NEW.dica1perg1,NEW.dica2perg1,
NEW.dica3perg1,NEW.respperg1,NEW.pergunta2,NEW.dica1perg2,NEW.dica2perg2,
NEW.dica3perg2,NEW.respperg2,NEW.pergunta3,NEW.dica1perg3,NEW.dica2perg3,
NEW.dica3perg3,NEW.respperg3,NEW.pergunta4,NEW.dica1perg4,NEW.dica2perg4,
NEW.dica3perg4,NEW.respperg4,NEW.pergunta5,NEW.dica1perg5,NEW.dica2perg5,
NEW.dica3perg5,NEW.respperg5);
end$$
delimiter ;

######################Trigger 3 ####################
delimiter $$
create trigger trg_qtd_perguntas
after
insert
on perguntas
for each row
begin
	declare _contar bigint(20);
    
    select count(codigo)
    into _contar
    from perguntas;
    
	update pontuacao set qtd_perguntas=_contar where codigo=1;
end$$
delimiter ;

select * from perguntas;
select * from backup_sistema;
######################Function ####################
delimiter $$
create function assunto_extenso(assunto varchar(100))
returns varchar(120)
begin
return concat('Este questionário é do assunto;', assunto);
end$$
delimiter ;

select assunto_extenso(assunto) from perguntas;

######################Procedure####################
delimiter $$
create procedure importarassunto(_idassunto bigint(20))
begin
	declare _assunto varchar(100);
    
select
assunto
into _assunto
from perguntas where codigo=_idassunto;

update info_perguntas set assunto_atual=_assunto where id=_idassunto;
end$$
delimiter ;

call importarassunto(1);
select * from info_perguntas;
######################View 1####################

create view view_agrupar_assunto as
select assunto,pergunta1,dica1perg1,dica2perg1,dica3perg1,respperg1,
pergunta2,dica1perg2,dica2perg2,dica3perg2,respperg2,pergunta3,
dica1perg3,dica2perg3,dica3perg3,respperg3,pergunta4,dica1perg4,
dica2perg4,dica3perg4,respperg4,pergunta5,dica1perg5,dica2perg5,
dica3perg5,respperg5
from perguntas
order by assunto desc;

select * from view_agrupar_assunto;

######################View 2####################

create view view_pesquisar_assunto as
select assunto
from view_agrupar_assunto
where assunto like '%tec%';

select * from view_pesquisar_assunto;
select * from perguntas;
insert into perguntas(assunto,pergunta1,dica1perg1,dica2perg1,
dica3perg1,respperg1,pergunta2,dica1perg2,dica2perg2,dica3perg2,respperg2,
pergunta3,dica1perg3,dica2perg3,dica3perg3,respperg3,pergunta4,dica1perg4,
dica2perg4,dica3perg4,respperg4,pergunta5,dica1perg5,dica2perg5,dica3perg5,
respperg5)
values('Tecnologia','01101001 01101110 01110100 01100101 01110010 01101110 01100101 01110100',
'programação','internet','computador','a',
'Qual é o API para acesso a SGBD?','BJDC','CDJB','JDBC','a',
'Nome da Classe para fazer a conexão com o Banco de dados?',
'Conexão','ConexãoUtil','Conectar','a',
'Serve para executar algo sempre que algum evento é disparado?',
'trigger','function','view','a',
'Qual o nome deste programa?','Quiz','Descobrir a Palavra',
'Responder Perguntas','a');
