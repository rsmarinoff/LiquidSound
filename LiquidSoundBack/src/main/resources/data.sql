insert into song(id, filename, type,name,artist,genre) values(1,'something.mp3','audio/mpeg','First Song','First Artist','Genre');
insert into song(id, filename, type,name,artist,genre) values(2,'something.mp3','audio/mpeg','Second Song','Second Artist','Genre');
insert into song(id, filename, type,name,artist,genre) values(3,'something.mp3','audio/mpeg','Third Song','Third Artist','Genre');
insert into song(id, filename, type,name,artist,genre) values(4,'something.mp3','audio/mpeg','Fourth Song','Fourth Artist','Genre');
insert into song(id, filename, type,name,artist,genre) values(5,'something.mp3','audio/mpeg','Fifth Song','Fifth Artist','Genre');
insert into song(id, filename, type,name,artist,genre) values(6,'something.mp3','audio/mpeg','Sixth Song','Sixth Artist','Genre');
insert into playlist(id, name) values (1,'Generic playlist');
insert into playlist_songs(playlist_id,songs_id) values (1,1);
insert into playlist_songs(playlist_id,songs_id) values (1,2);
insert into playlist_songs(playlist_id,songs_id) values (1,3);
insert into playlist_songs(playlist_id,songs_id) values (1,4);
insert into playlist_songs(playlist_id,songs_id) values (1,5);
insert into playlist_songs(playlist_id,songs_id) values (1,6);