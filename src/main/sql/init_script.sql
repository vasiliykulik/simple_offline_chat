-- Database: chat
CREATE DATABASE chat
    WITH
    OWNER = root
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA chat;

CREATE TABLE chat.users
(
    id integer NOT NULL DEFAULT nextval('chat.users_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default",
    password character varying(200) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE chat.messages
(
    id integer NOT NULL DEFAULT nextval('chat.messages_id_seq'::regclass),
    text character varying(500) COLLATE pg_catalog."default",
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
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (name)
);

CREATE TABLE chat.user_roles
(
    user_id bigint NOT NULL,
    role_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
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