/*USER---------------------*/
insert into tb_user(email, pass, user_name) values ('biamoreira@gmail.com', '12345', 'Bia Moreira');
insert into tb_user(email, pass, user_name) values('gabriel@gmail.com', '123456', 'gabe');
insert into tb_user(email, pass, user_name) values('pessoa01@gmail.com', '1234', 'pessoa 01');

/*TYPES ANIMES----------------*/
insert into tb_types_animes(title) values ('Shounen');
insert into tb_types_animes(title) values ('Shoujo');
insert into tb_types_animes(title) values ('Seinen');
insert into tb_types_animes(title) values ('Josei');
insert into tb_types_animes(title) values ('Isekai');
insert into tb_types_animes(title) values ('Gore');
insert into tb_types_animes(title) values ('Slice of Life');

/*ANIMES -----------------*/
/*series*/
insert into tb_animes(title, link, release_year, description_anime, studio, creator, types_animes_id) values ('BOKU NO HERO', 'https://www.youtube.com/watch?v=L1FdEBTJXus', 2016, 'um anime de humanos mutantes que estudam em uma escola de heróis', 'Bones', 'Kōhei Horikoshi', 1);
insert into tb_animes(title, link, release_year, description_anime, studio, creator, types_animes_id) values ('Viland Saga', 'https://www.youtube.com/watch?v=f8JrZ7Q_p-8', 2019, 'anime de época que se passa na ocupação nórdica na Grã-Bretanha durante a Idade Média', 'Mappa', 'Makoto Yukimura', 3);
/*filmes*/
insert into tb_animes(title, link, release_year, description_anime, studio, creator, types_animes_id) values ('A Viagem de Chihiro', 'https://www.youtube.com/watch?v=ByXuk9QqQkk', 2003, 'uma garota entra em um mundo mágico desconhecido onde precisa lutar pela sua sobrevivência e resgatar seus pais das garras do vilão', 'Studio Ghibli', 'Hayao Miyazaki', 5);

/*SERIES -------------*/
insert into tb_series(number_episodes, number_seasons, animes_id) values(138, 6, 1);
insert into tb_series(number_episodes, number_seasons, animes_id) values(48, 2, 2);

/*MOVIES-----------*/
insert into tb_movies(duration_min, animes_id) values(420, 3);

/*FAVORITES--------------------------*/
INSERT INTO tb_favorites(animes_id, user_id) values (1,1);
INSERT INTO tb_favorites(animes_id, user_id) values (2,2);
INSERT INTO tb_favorites(animes_id, user_id) values (3,3);

/*ANIMES WATCHED--------------------*/
insert into tb_animes_watched(animes_id, user_id) values (1,1);
insert into tb_animes_watched(animes_id, user_id) values (2,2);
insert into tb_animes_watched(animes_id, user_id) values (3,3);

select * from tb_movies;
select * from tb_series;
select * from tb_types_animes;
select * from tb_animes;
select * from tb_user;
select * from tb_favorites;
select * from tb_animes_watched;