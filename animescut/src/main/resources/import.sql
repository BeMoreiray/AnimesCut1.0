
/*ANIMES -----------------*/
/*series*/
insert into tb_animes(title, link, release_year, description, studio, creator) values ('BOKU NO HERO', 'https://www.youtube.com/watch?v=L1FdEBTJXus', 2016, 'um anime de humanos mutantes que estudam em uma escola de heróis', 'Bones', 'Kōhei Horikoshi');
insert into tb_animes(title, link, release_year, description, studio, creator) values ('VILAND SAGA', 'https://www.youtube.com/watch?v=f8JrZ7Q_p-8', 2019, 'anime de época que se passa na ocupação nórdica na Grã-Bretanha durante a Idade Média', 'Mappa', 'Makoto Yukimura');
/*filmes*/
insert into tb_animes(title, link, release_year, description , studio, creator) values ('A VIAGEM DE CHIHIRO', 'https://www.youtube.com/watch?v=ByXuk9QqQkk', 2003, 'uma garota entra em um mundo mágico desconhecido onde precisa lutar pela sua sobrevivência e resgatar seus pais das garras do vilão', 'Studio Ghibli', 'Hayao Miyazaki');

/*TYPES ANIMES----------------*/
insert into tb_types_Animes(title) values ('Shounen');
insert into tb_types_Animes(title) values ('Shoujo');
insert into tb_types_Animes(title) values ('Seinen');
insert into tb_types_Animes(title) values ('Josei');
insert into tb_types_Animes(title) values ('Isekai');
insert into tb_types_Animes(title) values ('Gore');
insert into tb_types_Animes(title) values ('Slice of Life');

/*SERIES-------------------*/
insert into tb_series(number_episodes, number_seasons, animes_id) values (138, 7, 1);
insert into tb_series(number_episodes, number_seasons, animes_id) values (48, 2, 2);

/*MOVIES----------------*/
insert into tb_movies(duration_min, animes_id) values (125, 3);

/*USER-----------------*/
insert into tb_user(user_name, email, pass) values ('bibia123', 'bia@email.com', '12345');
insert into tb_user(user_name, email, pass) values ('blastoise', 'blastoise@email.com', '1234');
insert into tb_user(user_name, email, pass) values ('jota', 'jota@email.com', 'char123');

/*AnimesWatched---------*/
insert into tb_animes_watched(user_id, animes_id) values (1, 1);
insert into tb_animes_watched(user_id, animes_id) values (2, 2);
insert into tb_animes_watched(user_id, animes_id) values (3, 3);

/*Favorites------------*/
insert into tb_favorites(user_id, animes_id) values (1,1);
insert into tb_favorites(user_id, animes_id) values (2, 2);
insert into tb_favorites(user_id, animes_id) values (3, 3);
