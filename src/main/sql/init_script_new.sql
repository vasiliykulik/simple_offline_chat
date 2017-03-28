
CREATE SCHEMA chat;

CREATE TABLE chat.users
(
    id SERIAL,
    name character varying(100),
    password character varying(200),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE chat.messages
(
    id SERIAL,
    text character varying(500),
    create_time timestamp with time zone,
    user_id bigint,
    CONSTRAINT messages_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_MSG_USER_ID" FOREIGN KEY (user_id)
        REFERENCES chat.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE chat.roles
(
    name character varying(100),
    CONSTRAINT roles_pkey PRIMARY KEY (name)
);

CREATE TABLE chat.user_roles
(
    user_id bigint NOT NULL,
    role_name character varying(100),
    CONSTRAINT user_roles_pkey PRIMARY KEY (role_name, user_id),
    CONSTRAINT "FKR_ROLE_NAME" FOREIGN KEY (role_name)
        REFERENCES chat.roles (name) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FKR_USER_ID" FOREIGN KEY (user_id)
        REFERENCES chat.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


insert into chat.users(name, password) values ('test-user', '0bfdcaa92b7396c93f6feba7eeb3f2b5');
insert into chat.roles(name) values ('WRITER');
insert into chat.roles(name) values ('READER');
insert into chat.users(name, password) values ('test-user1', '0bfdcaa92b7396c93f6feba7eeb3f2b5');-- test-user   test
insert into chat.user_roles(user_id, role_name) VALUES (1,'WRITER');