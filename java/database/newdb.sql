begin transaction;

drop table if exists artists, event_artist, event, venue, venue_event, venue;

create table artists (
    artist_id serial primary key,
    artist_name varchar(50) not null,
    artist_img varchar(100)
);
--pickMe--
create table event (
    event_id serial primary key,
    event_name varchar(50) not null,
    genre varchar(40),
    start_time varchar(10),
    date date(20) ,
    min_age varchar(10),
    event_img varchar(100),
    venue_name varchar(50) not null,
    constraint FK_venue_name foreign key (venue_name) references venue(venue_name)
);
--pickMe--
create table venue (
    venue_name varchar(50) not null primary key,
    city varchar(50) not null,
    state_abv varchar(4) not null ,
    venue_img varchar(100)
    constraint UQ_venue_name unique(venue_name)
);

--pickme--
create table event_artist(
    event_id integer not null,
    artist_id integer not null,
    constraint PK_event_artist primary key(event_id,artist_id),
    constraint FK_event_id foreign key(event_id) references event(event_id),
    constraint FK_artist_id foreign key(artist_id) references artists(artist_id)
);
commit transaction;

begin transaction;
insert into artists (artist_name,artist_img) values
                    ('BSTANG', 'capstone/java/assests/artist_photos/djbstang.png');
insert into artists (artist_name,artist_img) values
                    ('PDOT' ,'capstone/java/assests/artist_photos/stock_img.jpg' );
insert into artists (artist_name,artist_img) values
                    ('RKLS', 'capstone/java/assests/artist_photos/RKLS.jpeg');
insert into artists (artist_name, artist_img) values
                    ('A_RON',  'capstone/java/assests/artist_photos/stock_img.jpg');
insert into artists (artist_name,artist_img) values
                    ('Pickle','capstone/java/assests/artist_photos/pickle.jpeg');
insert into artists (artist_name,artist_img) values
                    ('Will Clarke', 'capstone/java/assests/artist_photos/willclarke.jpeg' );
insert into artists (artist_name,artist_img) values
                    ('Radical West', 'capstone/java/assests/artist_photos/radicalwest.jpeg');
insert into artists (artist_name,artist_img) values
                    ('Esme Patterson',  'capstone/java/assests/artist_photos/esmepatterson.jpeg');
insert into artists (artist_name,artist_img) values
                    ('Destructo','capstone/java/assests/artist_photos/destructo.png');
insert into artists (artist_name,artist_img) values
                    ('Rebel Souljahz', 'capstone/java/assests/artist_photos/rebelsouljahz.png' );
commit transaction;

begin transaction;
insert into venue (venue_name,city,state_abv,venue_img) values
                  ('Commonwealth','Las Vegas', 'NV', 'capstone/java/assests/venue_photos/commonwealth.jpeg');
insert into venue (venue_name,city,state_abv,venue_img) values
                  ('Discopussy','Las Vegas', 'NV', 'capstone/java/assests/venue_photos/discopussy.jpeg');  
insert into venue (venue_name,city,state_abv,venue_img) values
                  ('The Usual Place', 'Las Vegas', 'NV', 'capstone/java/assests/venue_photos/theusualplace.jpeg') ;
insert into venue (venue_name,city,state_abv,venue_img) values
                  ('Freemont Country Club','Las Vegas', 'NV', 'capstone/java/assests/venue_photos/freemontcountryclub.jpeg');
insert into venue (venue_name,city,state_abv,venue_img) values
                  ('Lucky Day', 'Las Vegas', 'NV', 'capstone/java/assests/venue_photos/luckyday.jpeg');
                  commit transaction;

begin transaction;
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Snapback','Hip-Hop','10:00 PM', '2022-05-11', '21+','capstone/java/assests/event_photos/snapback.jpeg','Commonwealth');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Snapback','Hip-Hop','10:00 PM', '2022-05-18', '21+','capstone/java/assests/event_photos/snapback.jpeg','Commonwealth');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Holy House W/ Pickle', 'House','10:00 PM', '2022-05-13', '21+','capstone/java/assests/event_photos/pickleholyhouse.png','Discopussy');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Holy House W/ Will Clarke','House','10:00 PM', '2022-05-11', '21+', 'capstone/java/assests/event_photos/holyhousewillclarke.png', 'Discopussy');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Radical West', 'Funk', '9:00 PM','2022-05-06','21+','capstone/java/assests/event_photos/stock_img.jpg','The Usual Place'); 
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Holy House W/ Destructo', 'House', '10:00 PM', '2022-05-06', '21+', 'capstone/java/assests/event_photos/holyhousedestructo.jpg','Discopussy');  
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values
                  ('Rebel Souljahz', 'Reggae', '7:00 PM', '2022-05-08', '21+', 'capstone/java/assests/event_photos/rebelsouljahz.png' ,'Freemont Country Club');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values 
                  ('Esme Patterson', 'Alternative/Indie', '8:00 PM', '2022-05-08', '21+', 'capstone/java/assests/event_photos/stock_img.jpg','The Usual Place');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values 
                  ('Late Checkout', 'Hip-Hop', '10:00 PM', '2022-05-13', '21+', 'capstone/java/assests/event_photos/latecheckout.jpeg','Lucky Day');
insert into event (event_name,genre,start_time,date,min_age,event_img,venue_name) values 
                  ('Late Checkout', 'Hip-Hop', '10:00 PM', '2022-05-06', '21+', 'capstone/java/assests/event_photos/latecheckout.jpeg','Lucky Day');
commit transaction;


begin transaction;

insert into event_artist (event_id, artist_id) values
                          ('1','1');
insert into event_artist (event_id, artist_id) values
                          ('1','2');
insert into event_artist (event_id, artist_id) values
                          ('1','3');
insert into event_artist (event_id, artist_id) values
                          ('1','4');
insert into event_artist (event_id, artist_id) values
                         ('2','1');
insert into event_artist (event_id, artist_id) values
                         ('2','2');
insert into event_artist (event_id, artist_id) values
                         ('2','3');
insert into event_artist (event_id, artist_id) values
                         ('2','4');
insert into event_artist (event_id, artist_id) values
                         ('3','5');
insert into event_artist (event_id, artist_id) values
                         ('4','6');
insert into event_artist (event_id, artist_id) values
                         ('5','7');
insert into event_artist (event_id, artist_id) values
                         ('6','9');
insert into event_artist (event_id, artist_id) values
                         ('7','10');
insert into event_artist (event_id, artist_id) values
                         ('8','8');
insert into event_artist (event_id, artist_id) values
                         ('9','1');
insert into event_artist (event_id, artist_id) values
                         ('9','2');
insert into event_artist (event_id, artist_id) values
                        ('10','1');
insert into event_artist (event_id, artist_id) values
                        ('10','2');
commit transaction;
