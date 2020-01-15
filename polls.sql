DROP TABLE if EXISTS creators cascade;
DROP TABLE if EXISTS polls cascade;
DROP TABLE if EXISTS options cascade;
DROP TABLE if EXISTS responses cascade;

CREATE TABLE creators(
    creator_id serial primary key not null,
    creator_email varchar(50) not null,
    creator_name varchar(50) not null
);

CREATE TABLE polls(
    poll_id serial primary key not null,
    creator_id integer references creators(creator_id) ON DELETE CASCADE ON UPDATE CASCADE,
    questions text not null
);

CREATE TABLE options(
    options_id serial primary key not null,
    poll_id integer references polls(poll_id) ON DELETE CASCADE ON UPDATE CASCADE,
    content text 
);

CREATE TABLE responses(
    response_id serial primary key not null,
    options_id integer references options(options_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO creators("creator_email", "creator_name") VALUES('isaac@mail.com', 'Isaac Agyen');
INSERT INTO creators("creator_email", "creator_name") VALUES('yaa@mail.com', 'Yaa Nuamah');
INSERT INTO creators("creator_email", "creator_name") VALUES('shadrack@mail.com', 'Shadrack Amoakohene');
INSERT INTO creators("creator_email", "creator_name") VALUES('sam@mail.com', 'Sam Bartels');

INSERT INTO polls("creator_id", "questions") VALUES(1, 'Did you enjoy the call?');
INSERT INTO polls("creator_id", "questions") VALUES(2,'Will you like to do this again?');

INSERT INTO options("poll_id", "content") VALUES(1, 'Yes');
INSERT INTO options("poll_id", "content") VALUES(1, 'No');
INSERT INTO options("poll_id", "content") VALUES(1, 'Maybe');
INSERT INTO options("poll_id", "content") VALUES(2, 'Yes');
INSERT INTO options("poll_id", "content") VALUES(2, 'No');
INSERT INTO options("poll_id", "content") VALUES(2, 'Maybe');

INSERT INTO responses("options_id") VALUES(1);
INSERT INTO responses("options_id") VALUES(2);
INSERT INTO responses("options_id") VALUES(1);
INSERT INTO responses("options_id") VALUES(1);
INSERT INTO responses("options_id") VALUES(2);
INSERT INTO responses("options_id") VALUES(3);
INSERT INTO responses("options_id") VALUES(5);




