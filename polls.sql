DROP TABLE if EXISTS creators cascade;
DROP TABLE if EXISTS polls cascade;
DROP TABLE if EXISTS options cascade;
DROP TABLE if EXISTS responses cascade;

CREATE TABLE polls(
   poll_id varchar(100) primary key not null,
    question text not null,
    creator_email varchar(50) not null,
    recipient_email varchar(255) not null
);

CREATE TABLE options(
    option_id varchar(100) primary key not null,
    poll_id varchar(100) references polls(poll_id) ON DELETE CASCADE ON UPDATE CASCADE,
    content text
);

CREATE TABLE responses(
    response_id varchar(100) primary key not null,
    poll_id varchar(100) references polls(poll_id) ON UPDATE CASCADE ON DELETE CASCADE,
    option_id varchar(100) references options(option_id) ON UPDATE CASCADE ON DELETE CASCADE

);


INSERT INTO polls("poll_id", "question", "creator_email", "recipient_email") VALUES('201', 'Did you enjoy the call?', 'sam@turntabl.io', 'sam@turntabl.io' );
INSERT INTO polls("poll_id","question", "creator_email", "recipient_email") VALUES('202','Will you like to do this again?', 'sam@turntabl.io', 'yaa.fordjour@turntabl.io');

INSERT INTO options("option_id", "poll_id", "content") VALUES('301', '201', 'Yes');
INSERT INTO options("option_id", "poll_id", "content") VALUES('302', '201', 'No');
INSERT INTO options("option_id", "poll_id", "content") VALUES('303', '201', 'Maybe');
INSERT INTO options("option_id", "poll_id", "content") VALUES('304', '202', 'Yes');
INSERT INTO options("option_id", "poll_id", "content") VALUES('305', '202', 'No');
INSERT INTO options("option_id", "poll_id", "content") VALUES('306', '202', 'Maybe');

INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('401', '201', '301');
INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('402', '201', '301');
INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('403', '201', '302');
INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('404', '201', '301');
INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('405', '201', '303');
INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('406', '201', '301');
INSERT INTO responses("response_id", "poll_id", "option_id") VALUES('407', '201', '301');