BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION

begin transaction;

drop table if exists artists, event_artist, event, venue, venue_event, venue;
create table venue (
    venue_name varchar(50) not null primary key,
    city varchar(50) not null,
    state_abv varchar(4) not null ,
    venue_img varchar(250)

);
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
    date varchar(10) ,
    min_age varchar(10),
    event_img varchar(250),
    venue_name varchar(50) not null,
    constraint FK_venue_name foreign key (venue_name) references venue(venue_name)
);
--pickMe--


--pickme--
create table event_artist(
    event_id integer not null,
    artist_id integer not null,
    constraint PK_event_artist primary key(event_id,artist_id),
    constraint FK_event_id foreign key(event_id) references event(event_id),
    constraint FK_artist_id foreign key(artist_id) references artists(artist_id)
);
commit transaction;