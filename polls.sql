DROP TABLE if EXISTS creators cascade;
DROP TABLE if EXISTS polls cascade;
DROP TABLE if EXISTS options cascade;
DROP TABLE if EXISTS responses cascade;

CREATE TABLE creators(
    creator_id integer primary key not null,
    creator_email varchar(50) not null,
    creator_name varchar(50) not null
);

CREATE TABLE polls(
    poll_id integer primary key not null,
    creator_id integer references creators(creator_id) ON DELETE CASCADE ON UPDATE CASCADE,
    questions text not null
);

CREATE TABLE options(
    options_id integer primary key not null,
    poll_id integer references polls(poll_id) ON DELETE CASCADE ON UPDATE CASCADE,
    content text 
);

CREATE TABLE responses(
    response_id integer primary key not null,
    options_id integer references options(options_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES(101, 'isaac@mail.com', 'Isaac Agyen');
INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES(102, 'yaa@mail.com', 'Yaa Nuamah');
INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES(103, 'shadrack@mail.com', 'Shadrack Amoakohene');
INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES(104, 'sam@mail.com', 'Sam Bartels');

INSERT INTO polls("poll_id","creator_id", "questions") VALUES(201, 101, 'Did you enjoy the call?');
INSERT INTO polls("poll_id","creator_id", "questions") VALUES(202, 102,'Will you like to do this again?');

INSERT INTO options("options_id", "poll_id", "content") VALUES(301, 201, 'Yes');
INSERT INTO options("options_id", "poll_id", "content") VALUES(302, 201, 'No');
INSERT INTO options("options_id", "poll_id", "content") VALUES(303, 201, 'Maybe');
INSERT INTO options("options_id", "poll_id", "content") VALUES(304, 202, 'Yes');
INSERT INTO options("options_id", "poll_id", "content") VALUES(305, 202, 'No');
INSERT INTO options("options_id", "poll_id", "content") VALUES(306, 202, 'Maybe');

INSERT INTO responses("response_id", "options_id") VALUES(401, 301);
INSERT INTO responses("response_id", "options_id") VALUES(402, 301);
INSERT INTO responses("response_id", "options_id") VALUES(403, 302);
INSERT INTO responses("response_id", "options_id") VALUES(404, 301);
INSERT INTO responses("response_id", "options_id") VALUES(405, 303);
INSERT INTO responses("response_id", "options_id") VALUES(406, 301);
INSERT INTO responses("response_id", "options_id") VALUES(407, 301);




