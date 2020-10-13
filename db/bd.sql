-- borra la bd si existe
DROP DATABASE IF EXISTS ciberfarma;
-- creamos la bd
CREATE DATABASE ciberfarma;
-- activamos la bd
USE ciberfarma;

create table tb_tipo(
id_tipo	 int not null primary key,
des_tipo varchar(20)
);

CREATE TABLE tb_usuarios(
codigo  int auto_increment,
nombre varchar(15),
apellido varchar(25),
usuario  char(4) NOT NULL,
clave    char(5),
fnacim  date  null,
id_tipo  int DEFAULT 2,
estado  int(1) DEFAULT 1,
primary key (codigo),
foreign key (id_tipo) references tb_tipo(id_tipo)
);

create table tb_categorias(
idtipo		int not null primary key,
descripcion varchar(45)
);

create table tb_productos(
idprod      char(5) not null,
descripcion varchar(45),
stock		int,
precio		decimal(8,2),
idtipo		int,
estado		boolean,
primary key (idprod), 
foreign key (idtipo) references tb_categorias(idtipo)
);

-- insert
insert into tb_tipo values (1, 'Administrador');
insert into tb_tipo values (2, 'Cliente');
insert into tb_tipo values (3, 'Cajero');

insert into tb_categorias values (1, 'Pastillas');
insert into tb_categorias values (2, 'Jarabe');
insert into tb_categorias values (3, 'Otros');

select * from tb_usuarios;
insert into tb_usuarios values (1, 'José', 'Robles', 'user', 'pass', '2020/10/06',1,1);
insert into tb_usuarios values (null, 'José', 'Atuncar', 'prof', 'prof', '1980/10/06',1,1);
insert into tb_usuarios values (null, 'Alvaro', 'Ramirez', 'prof', 'prof', '1985/08/10',default,default);