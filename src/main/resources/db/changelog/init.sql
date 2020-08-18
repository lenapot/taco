--liquibase formatted sql
--changeset gorshkova:init



create table if not exists public.ingredient
(
    id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    type character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT ingredient_pkey PRIMARY KEY (id)
);

create table if not exists public.roles
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);

create table if not exists public.taco
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    createdat timestamp without time zone NOT NULL,
    CONSTRAINT taco_pkey PRIMARY KEY (id)
);

create table if not exists public.taco_ingredients
(
    taco_id bigint NOT NULL,
    ingredients_id character varying(4) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT taco_ingredients_ingredient_fkey FOREIGN KEY (ingredients_id)
        REFERENCES public.ingredient (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT taco_ingredients_taco_fkey FOREIGN KEY (taco_id)
        REFERENCES public.taco (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE if not exists public.taco_order
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    street character varying(50) COLLATE pg_catalog."default" NOT NULL,
    city character varying(50) COLLATE pg_catalog."default" NOT NULL,
    state character varying(50) COLLATE pg_catalog."default" NOT NULL,
    zip character varying(10) COLLATE pg_catalog."default" NOT NULL,
    cc_number character varying(16) COLLATE pg_catalog."default" NOT NULL,
    cc_expiration character varying(5) COLLATE pg_catalog."default" NOT NULL,
    cccvv character varying(3) COLLATE pg_catalog."default" NOT NULL,
    placed_at timestamp without time zone NOT NULL,
    user_id bigint NOT NULL,
    status character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT taco_order_pkey PRIMARY KEY (id)
);

CREATE TABLE if not exists public.taco_order_tacos
(
    order_id bigint NOT NULL,
    tacos_id bigint NOT NULL,
    CONSTRAINT taco_order_tacos_taco_fkey FOREIGN KEY (tacos_id)
        REFERENCES public.taco (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT taco_order_tacos_tacoorder_fkey FOREIGN KEY (order_id)
        REFERENCES public.taco_order (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(350) COLLATE pg_catalog."default" NOT NULL,
    fullname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    street character varying(50) COLLATE pg_catalog."default" NOT NULL,
    city character varying(50) COLLATE pg_catalog."default" NOT NULL,
    state character varying(50) COLLATE pg_catalog."default" NOT NULL,
    zip character varying(10) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(12) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE public.users_roles
(
    user_id integer NOT NULL,
    roles_id integer NOT NULL,
    CONSTRAINT user_role_roleid_fkey FOREIGN KEY (roles_id)
        REFERENCES public.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_role_userid_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



delete from Ingredient;
insert into Ingredient (id, name, type)
                values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
                values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
                values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
                values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
                values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
                values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
                values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
                values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
                values ('SRCR', 'Sour Cream', 'SAUCE');


insert into roles (id, name) OVERRIDING SYSTEM VALUE
                values (1, 'USER');
insert into roles (id, name) OVERRIDING SYSTEM VALUE
                values (2, 'ADMIN');

insert into public.users(id, username, password, fullname, street, city, state, zip, phone_number) OVERRIDING SYSTEM VALUE
	VALUES (1, 'admin', '74a23edd62d76fb5b6d40cf3d5bb67933aa36b09743763242f0b822297ea5c147856a72cb80c5a62', 'Главный админ',  'Novo-Sadovaya 1', 'Samara', 'Samara', '443100', '8800111111');

insert into public.users_roles(user_id, roles_id) OVERRIDING SYSTEM VALUE
	VALUES (1, 2);

