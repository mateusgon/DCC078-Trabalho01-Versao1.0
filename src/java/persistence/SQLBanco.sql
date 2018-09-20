create table aluno (
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




