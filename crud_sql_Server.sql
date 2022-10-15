CREATE DATABASE crud;
CREATE TABLE ceps (
    id INT IDENTITY(1,1) CONSTRAINT pk_id PRIMARY KEY,
    cep varchar(9) not null,
    bairro varchar(250) default 'Sem bairro',
    rua varchar(250) default 'Sem rua',
    cidade varchar(250) not null,
    uf varchar(2) not null,
);
CREATE TABLE produtos (
    id int identity(1,1) constraint pk_id_produtos primary key,
    description varchar(100) default null,
    qtd int not null default '0',
);
CREATE TABLE usuario (
    id int identity(1,1) constraint pk_id_user primary key,
    name varchar(50) not null,
    email varchar(250) not null,
    password varchar(250) not null,
    cep varchar(8) not null,
    bairro varchar(100) default 'Sem bairro',
    rua varchar(50) default 'Sem rua',
    cidade varchar(100) not null,
    estado varchar(2) not null,
    constraint uk_name unique(name),
    constraint uk_email unique(email),
);
