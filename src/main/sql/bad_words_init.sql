CREATE TABLE chat.badwords
(
    id SERIAL,
    word character varying(100)
);

insert into chat.badwords(word) values ('bad');
insert into chat.badwords(word) values ('bad1');
insert into chat.badwords(word) values ('bad2');
