create database db_biblioteca;

use db_biblioteca;

CREATE TABLE `tb_categoria` (
  `id` bigint not null auto_increment,
  `descricao` varchar (50),
  PRIMARY KEY (`id`)
);

select * from tb_categoria;

CREATE TABLE `tb_editora` (
  `id` bigint not null auto_increment,
  `nome` varchar(50),
  PRIMARY KEY (`id`)
);

select * from tb_editora;

CREATE TABLE `tb_autor` (
  `id` bigint not null auto_increment,
  `nome` varchar(100) not null,
  `nacionalidade` varchar(100),
  PRIMARY KEY (`id`)
);

select * from tb_autor;

CREATE TABLE `tb_livro` (
  `isbn` bigint not null,
  `titulo` varchar(100) not null,
  `ano` bigint not null,
  `fk_categoria` bigint not null,
  `fk_editora` bigint not null,
  PRIMARY KEY (`isbn`),
  FOREIGN KEY (`fk_categoria`) REFERENCES `tb_categoria`(`id`),
  FOREIGN KEY (`fk_editora`) REFERENCES `tb_editora`(`id`)
);

select * from tb_livro;

CREATE TABLE `tb_livro_autor` (
  `id` bigint not null auto_increment,
  `fk_livro` bigint not null,
  `fk_autor` bigint not null,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_livro`) REFERENCES `tb_livro`(`isbn`),
  FOREIGN KEY (`fk_autor`) REFERENCES `tb_autor`(`id`)
);

select * from tb_livro_autor;

insert into tb_categoria (descricao) values ("Literatura Juvenil");
insert into tb_categoria (descricao) values ("Ficção Científica");
insert into tb_categoria (descricao) values ("Humor");

insert into tb_editora (nome) values ("Rocco");
insert into tb_editora (nome) values ("WMF Martins Fontes");
insert into tb_editora (nome) values ("Casa da Palavra");
insert into tb_editora (nome) values ("Belas Letras");
insert into tb_editora (nome) values ("Matrix");

insert into tb_autor (nome, nacionalidade) values ("J. K. Rowling", "Inglaterra");
insert into tb_autor (nome, nacionalidade) values ("Clive Staples Lewis", "Inglaterra");
insert into tb_autor (nome, nacionalidade) values ("Affonso Solano", "Brasil");
insert into tb_autor (nome, nacionalidade) values ("Marcos Piangers", "Brasil");
insert into tb_autor (nome, nacionalidade) values ("Ciro Botelho", "Brasil");
insert into tb_autor (nome, nacionalidade) values ("Bianca Mól", "Brasil");

insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (8532511015, "Harry Potter e A Pedra Filosofal", 2000, 1, 1);
insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (9788578270698, "As Crônicas de Nárnia", 2009, 1, 2);
insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (9788577343348, "O Espadachim de Carvão", 2013, 2, 3);
insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (9788581742458, "O Papai é Pop", 2015, 3, 4);
insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (9788582302026, "Pior Que Tá Não Fica", 2015, 3, 5);
insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (9788577345670, "Garota Desdobrável", 2015, 1, 3);
insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (8532512062, "Harry Potter e o Prisioneiro de Azkaban", 2000, 1, 1);

insert into tb_livro_autor (fk_livro, fk_autor) values (8532511015, 1);
insert into tb_livro_autor (fk_livro, fk_autor) values (8532512062, 1);
insert into tb_livro_autor (fk_livro, fk_autor) values (9788577343348, 3);
insert into tb_livro_autor (fk_livro, fk_autor) values (9788577345670, 6);
insert into tb_livro_autor (fk_livro, fk_autor) values (9788578270698, 2);
insert into tb_livro_autor (fk_livro, fk_autor) values (9788581742458, 4);
insert into tb_livro_autor (fk_livro, fk_autor) values (9788582302026, 5);


/*
Crie uma consulta para relacionar todos os dados disponíveis de todos os livros existentes na biblioteca em ordem alfabética de título
*/
select * from tb_livro order by titulo asc;

/*
select * from tb_livro_autor 
inner join tb_livro on tb_livro.isbn = tb_livro_autor.fk_livro
inner join tb_autor on tb_autor.id = tb_livro_autor.fk_autor;
*/

/*
Crie uma consulta para relacionar todos os dados disponíveis de todos os livros existentes na biblioteca por ordem Alfabética de autor
*/
select tb_autor.nome, tb_livro.isbn, tb_livro.titulo, tb_livro.ano, tb_livro.fk_categoria, tb_livro.fk_editora 
from tb_livro_autor 
inner join tb_livro on tb_livro.isbn = tb_livro_autor.fk_livro
inner join tb_autor on tb_autor.id = tb_livro_autor.fk_autor
where tb_livro.isbn order by tb_autor.nome asc;

/*
Crie uma consulta para relacionar todos os dados disponíveis dos livros da categoria de literatura Juvenil em ordem de ano
*/
select tb_categoria.descricao, tb_livro.ano, tb_livro.isbn, tb_livro.titulo, tb_livro.fk_categoria, tb_livro.fk_editora
from tb_livro
inner join tb_categoria on tb_livro.fk_categoria = tb_categoria.id
where tb_categoria.descricao = "Literatura Juvenil" order by tb_livro.ano asc;

/*
Crie uma consulta para relacionar todos os dados disponíveis dos livros de humor e ficção científica com ano entre 2000 e 2010
*/
select tb_categoria.descricao, tb_livro.ano, tb_livro.isbn, tb_livro.titulo, tb_livro.fk_categoria, tb_livro.fk_editora
from tb_livro
inner join tb_categoria on tb_livro.fk_categoria = tb_categoria.id
where tb_categoria.descricao in ("Ficção Científica", "Humor") order by tb_livro.ano between 2000 and 2010 asc;













