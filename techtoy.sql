/*create database db_aluno;
use db_aluno;

create table alunos(
	id int auto_increment primary key,
    CA  	varchar(6)		,
	nome 	varchar(100)	,
	email 	varchar(100)	,
	dataNascimento  	date,
	endereco 	varchar(50)	,
	idade	 	CHAR(2) 			
);

drop database db_aluno;*/

drop database sisaluno;

create database sisaluno;
use sisaluno;

create table if not exists alunos (
	id int auto_increment not null,
    status bit not null,
	ca int not null,
	nome varchar(100) not null,
	email varchar(100) not null,
	dataNascimento date not null,
	endereco varchar(100) not null,
	idade int(2) not null,
	dataCadastro datetime not null,
 	dataAtualizacao datetime not null,   
	constraint PK_ID primary key(id)
)default charset = utf8;

describe alunos;

select * from alunos;

insert into alunos values (1, 1, 123, 'André', 'andre@email.com', '1993-03-07', 'rua Lauro de Freitas', 28, now(), now());




