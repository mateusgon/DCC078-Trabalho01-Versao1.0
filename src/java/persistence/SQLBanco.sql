create table restaurante (
restaurantecod integer primary key generated always as identity,
nome varchar(100),
nomeFantasia varchar(100),
telefone varchar(100),
endereco varchar(100),
sigla varchar(100)
);

/*create table aluno (
codigoAluno integer primary key generated always as identity,
nome varchar(100),
estado varchar(100)
);

create table alunoMemento (
codigoAlunoMemento integer primary key generated always as identity,
estado varchar(100),
data timestamp,
fkcodigoAluno integer not null,
foreign key (fkcodigoAluno) references aluno (codigoAluno)
);


*/