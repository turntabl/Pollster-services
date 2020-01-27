DROP TABLE if EXISTS creators cascade;
DROP TABLE if EXISTS polls cascade;
DROP TABLE if EXISTS options cascade;
DROP TABLE if EXISTS responses cascade;

CREATE TABLE

CREATE TABLE creators(
    creator_id varchar(100) primary key not null,
    creator_email varchar(50) not null,
    creator_name varchar(50) not null
);

CREATE TABLE polls(
   poll_id varchar(100) primary key not null,
    creator_id varchar(100) references creators(creator_id) ON DELETE CASCADE ON UPDATE CASCADE,
    question text not null
);

CREATE TABLE options(
    option_id varchar(100) primary key not null,
    poll_id varchar(100) references polls(poll_id) ON DELETE CASCADE ON UPDATE CASCADE,
    content text
);

CREATE TABLE responses(
    response_id varchar(100) primary key not null,
    poll_id varchar(100) references polls(poll_id) ON UPDATE CASCADE ON DELETE CASCADE,
    option_id varchar(100) references options(option_id) ON UPDATE CASCADE ON DELETE CASCADE,
    suggestions text
);

INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES('101', 'isaac@mail.com', 'Isaac Agyen');
INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES('102', 'yaa@mail.com', 'Yaa Nuamah');
INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES('103', 'shadrack@mail.com', 'Shadrack Amoakohene');
INSERT INTO creators("creator_id", "creator_email", "creator_name") VALUES('104', 'sam@mail.com', 'Sam Bartels');

INSERT INTO polls("poll_id","creator_id", "question") VALUES('201', '101', 'Did you enjoy the call?');
INSERT INTO polls("poll_id","creator_id", "question") VALUES('202', '102','Will you like to do this again?');

INSERT INTO options("option_id", "poll_id", "content") VALUES('301', '201', 'Yes');
INSERT INTO options("option_id", "poll_id", "content") VALUES('302', '201', 'No');
INSERT INTO options("option_id", "poll_id", "content") VALUES('303', '201', 'Maybe');
INSERT INTO options("option_id", "poll_id", "content") VALUES('304', '202', 'Yes');
INSERT INTO options("option_id", "poll_id", "content") VALUES('305', '202', 'No');
INSERT INTO options("option_id", "poll_id", "content") VALUES('306', '202', 'Maybe');

INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('401', '201', '301', 'cool');
INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('402', '201', '301', 'cool');
INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('403', '201', '302', 'cool');
INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('404', '201', '301', 'cool');
INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('405', '201', '303', 'cool');
INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('406', '201', '301', 'cool');
INSERT INTO responses("response_id", "poll_id", "option_id", "suggestions") VALUES('407', '201', '301', 'cool');