
create table restaurante (
restaurantecod integer primary key generated always as identity,
nome varchar(100),
nomeFantasia varchar(100),
telefone varchar(100),
endereco varchar(100),
sigla varchar(100)
);



create table pessoa (
pessoacod integer primary key generated always as identity,
nome varchar(100),
endereco varchar(100),
telefone varchar(100),
email varchar(100),
senha varchar(100),
restaurantecod integer,
tipoPessoa integer,
foreign key (restaurantecod) references restaurante (restaurantecod)

);

insert into pessoa (nome, email, senha, tipoPessoa) values ('adminGeral', 'adminGeral', 'adminGeral', 8);
-- tipoPessoa = 1 (Cliente), 2 (Atendente), 3 (Chefe 01), 4 (Chefe 02), 5 (Chefe 03), 6 (Motoboy), 7 (SuperUsuarioRestaurante), 8 (SuperUsuarioSistema)

create table produto (
produtocod integer primary key generated always as identity,
nome varchar(100),
valor double,
dificuldade integer,
tipoProduto integer,
restaurantecod integer,
foreign key (restaurantecod) references restaurante (restaurantecod)
)
-- tipoProduto = 1 (Entrada), 2 (Prato Principal), 3 (Bebida), 4 (Sobremesa)
-- dificuldade = 1 (Fácil), 2 (Médio, 3 (Difícil)
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

--delete from restaurante where restaurantecod=1