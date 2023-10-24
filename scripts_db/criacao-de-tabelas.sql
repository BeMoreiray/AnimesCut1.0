create database db_animescut;
use db_animescut;

create table tb_user(
	id int primary key auto_increment,
    user_name varchar(60) not null,
    email varchar(80) not null,
    pass varchar(80) not null
);

create table tb_types_Animes(
	id int primary key auto_increment,
	title varchar(50)
);

create table tb_animes(
	id int primary key auto_increment,
    title varchar(50) not null,
    link varchar(200) not null,
    release_year int,
	description_anime varchar(600),
    studio varchar(50),
    creator varchar(50)

);

create table tb_movies(
	id int primary key auto_increment,
    duration_min int
    
);

create table tb_series(
	id int primary key auto_increment,
    number_episodes int,
    number_seasons int
);



create table tb_favorites(
	id int primary key auto_increment
    
);

create table tb_animes_watched(
	id int primary key auto_increment
);
drop database db_animescut;