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
   response_id serial primary key not null,
   poll_id varchar(100) references polls(poll_id) ON UPDATE CASCADE ON DELETE CASCADE,
   option_id varchar(100) references options(option_id) ON UPDATE CASCADE ON DELETE CASCADE
);
