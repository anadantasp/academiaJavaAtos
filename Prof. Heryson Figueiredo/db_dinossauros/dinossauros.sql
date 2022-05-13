/*CRIE O COMANDO SQL PARA A CRIAÇÃO DO BANCO DE DADOS DINOSSAUROS */
create database db_dinossauros;

use db_dinossauros;

/*CRIE O COMANDO SQL PARA A CRIAÇÃO DAS TABELAS SOLICITADAS */
CREATE TABLE `tb_descobridor` (
  `id` bigint not null auto_increment,
  `nome` varchar(100) not null,
  PRIMARY KEY (`id`)
);

select * from tb_descobridor;

CREATE TABLE `tb_grupo` (
  `id` bigint not null auto_increment,
  `nome`  varchar(100) not null,
  PRIMARY KEY (`id`)
);

select * from tb_grupo;

CREATE TABLE `tb_eras` (
  `id` bigint not null auto_increment,
  `era` varchar(100) not null,
  `ano_inicio_milhoes` bigint not null,
  `ano_fim_milhoes` bigint not null,
  PRIMARY KEY (`id`)
);

select * from tb_eras;

CREATE TABLE `tb_dinossauro` (
  `id` bigint not null auto_increment,
  `nome` varchar(100) not null,
  `toneladas` bigint ,
  `ano_descoberta` bigint not null,
  `pais` varchar(100) not null,
  `fk_grupo` bigint not null,
  `fk_era` bigint not null,
  `fk_descobridor` bigint not null,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_grupo`) REFERENCES `tb_grupo`(`id`),
  FOREIGN KEY (`fk_era`) REFERENCES `tb_eras`(`id`),
  FOREIGN KEY (`fk_descobridor`) REFERENCES `tb_descobridor`(`id`)
);

select * from tb_dinossauro;

/*CRIE O COMANDO SQL PARA INSERÇÃO DE PELO MENOS 3 REGISTROS ACIMA, EM TODAS AS TABELAS NECESSÁRIAS */

insert into tb_descobridor (nome) values ("Maryanska");
insert into tb_descobridor (nome) values ("John Bell Hatcher");
insert into tb_descobridor (nome) values ("Cientistas Alemães");
insert into tb_descobridor (nome) values ("Museu Americano de História Natural");
insert into tb_descobridor (nome) values ("Othniel Charles Marsh");
insert into tb_descobridor (nome) values ("Barnum Brown");

insert into tb_grupo (nome) values ("Anquilossauros");
insert into tb_grupo (nome) values ("Ceratopsídeos");
insert into tb_grupo (nome) values ("Estegossauros");
insert into tb_grupo (nome) values ("Terápodes");

insert into tb_eras (era, ano_inicio_milhoes, ano_fim_milhoes) values ("Cretácio", 145, 66);
insert into tb_eras (era, ano_inicio_milhoes, ano_fim_milhoes) values ("Jurássico", 201, 145);

insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Saichania", 4, 1977, "Mongólia", 1, 1, 1);
insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Tricerátops", 6, 1887, "Canadá", 2, 1, 2);
insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Kentrossauro", 2, 1909, "Tanzânia", 3, 2, 3);
insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Pinacossauro", 6, 1999, "China", 1, 1, 4);
insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Alossauro", 3, 1877, "América do Norte", 4, 2, 5);
insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Torossauro", 8, 1891, "USA", 2, 1, 2);
insert into tb_dinossauro (nome, toneladas, ano_descoberta, pais, fk_grupo, fk_era, fk_descobridor) values ("Anquilossauro", 8, 1906, "América do Norte", 1, 1, 6);

/*CRIE UMA CONSULTA PARA RELACIONAR TODOS OS DADOS DISPONÍVEIS DE TODOS OS DINOSSAUROS EXISTENTES  NO CATÁLOGO EM ORDEM ALFABÉTICA DE NOME*/
select * from tb_dinossauro order by nome asc;

/*CRIE UMA CONSULTA PARA RELACIONAR TODOS OS DADOS DISPONÍVEIS DE TODOS OS DINOSSAUROS EXISTENTES EM ORDEM ALFABÉTICA DE DESCOBRIDOR*/
select tb_dinossauro.nome, tb_dinossauro.toneladas, tb_dinossauro.ano_descoberta, tb_dinossauro.pais, tb_descobridor.nome, tb_dinossauro.fk_grupo, tb_dinossauro.fk_era
from tb_descobridor
inner join tb_dinossauro on tb_descobridor.id = tb_dinossauro.fk_descobridor
where tb_dinossauro.id order by tb_descobridor.nome asc;

/*CRIE UMA CONSULTA PARA RELACIONAR TODOS OS DADOS DISPONÍVEIS DOS DINOSSAUROS DO GRUPO ANQUILOSSARUROS EM ORDEM DE ANO DE DESCOBERTA*/
select tb_grupo.nome, tb_dinossauro.nome, tb_dinossauro.toneladas, tb_dinossauro.ano_descoberta, tb_dinossauro.pais, tb_dinossauro.fk_era, tb_dinossauro.fk_descobridor
from tb_grupo
inner join tb_dinossauro on tb_grupo.id = tb_dinossauro.fk_grupo
where tb_grupo.nome = "Anquilossauros" order by tb_dinossauro.ano_descoberta asc;

/*CRIE UMA CONSULTA PARA RELACIONAR TODOS OS DADOS DISPONÍVEIS DOS DINOSSAUROS CERATOPSÍDEOS OU ANQUILOSSARUROS COM ANO DE DESCOBERTA ENTRE 1900 E 1999*/
select tb_grupo.nome, tb_dinossauro.nome, tb_dinossauro.toneladas, tb_dinossauro.ano_descoberta, tb_dinossauro.pais, tb_dinossauro.fk_era, tb_dinossauro.fk_descobridor
from tb_grupo
inner join tb_dinossauro on tb_grupo.id = tb_dinossauro.fk_grupo
where tb_grupo.nome in ("Anquilossauros", "Ceratopsídeos") and tb_dinossauro.ano_descoberta between 1900 and 1999  order by tb_dinossauro.ano_descoberta asc;




