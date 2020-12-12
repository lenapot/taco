--liquibase formatted sql
--changeset gorshkova:data-for-diagrams

INSERT INTO public.users (id, username, password, fullname, street, city, state, zip, phone_number) OVERRIDING SYSTEM VALUE VALUES
    (3, 'ivanov', '1dc2a9834ac0c8d333449c65e0d086af5e2da61d0d8016b72c1f75295f4e1d54afc6b037614d68f3', 'Ivanov Ivan', 'Novo-Sadovaya 42-27', 'Samara', 'Russia', '443110', '89171189174');
INSERT INTO public.users (id, username, password, fullname, street, city, state, zip, phone_number) OVERRIDING SYSTEM VALUE VALUES
    (6, 'johnson', '17bdd93960c84cc0a3ec8bd685f113d8f248d12d234de2ad747b19819d2398d713508acec22a1569', 'Johnson Sara', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '89171189174');
INSERT INTO public.users (id, username, password, fullname, street, city, state, zip, phone_number) OVERRIDING SYSTEM VALUE VALUES
    (4, 'smith', '0dbe17df4be8edc8599263012763445172fb44c90ea503a9526f0002af340f0535b0662192b30407', 'John Smith', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '89171189174');
INSERT INTO public.users (id, username, password, fullname, street, city, state, zip, phone_number) OVERRIDING SYSTEM VALUE VALUES
    (5, 'martin', '6b7fcbe5405b26aa36762ea48004945c5a78c6f7fa438164d909e038a45c15413743d4bfa78c9457', 'Martin Lora', 'Novo-Sadovaya 42-27', 'Paris', 'Russia', '443110', '89171189174');

INSERT INTO public.users_roles (user_id, roles_id) VALUES (6, 1);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (3, 1);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (4, 1);
INSERT INTO public.users_roles (user_id, roles_id) VALUES (5, 1);


INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (1, 'beaf with cheddar', '2020-08-14 16:35:06.928');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (2, 'fresh', '2020-08-14 16:36:48.463');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (3, 'tomato taco', '2020-08-14 23:22:50.453');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (4, 'corn taco', '2020-08-14 23:23:42.223');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (5, 'salsa taco', '2020-08-14 23:24:23.412');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (6, 'funny taco', '2020-08-14 23:25:20.877');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (7, 'sunday taco', '2020-08-14 23:26:00.43');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (8, 'Monterrey Jack taco', '2020-08-14 23:28:33.189');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (9, 'lettuce taco', '2020-08-14 23:29:28.775');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (10, 'favorite taco', '2020-08-14 23:30:30.723');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (11, 'cream taco', '2020-08-14 23:31:34.005');
INSERT INTO public.taco_type (id, name, createdat) OVERRIDING SYSTEM VALUE VALUES (12, 'johnson taco', '2020-08-14 23:38:01.02');
SELECT setval('taco_type_id_seq', (SELECT MAX(id) from "taco_type"));


INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (1, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (1, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (1, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (1, 'LETC');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (1, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (2, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (2, 'CARN');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (2, 'JACK');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (2, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (2, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (3, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (3, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (3, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (3, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (3, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (4, 'COTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (4, 'CARN');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (4, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (4, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (4, 'SRCR');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (5, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (5, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (5, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (5, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (5, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (6, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (6, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (6, 'JACK');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (6, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (6, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (7, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (7, 'CARN');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (7, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (7, 'LETC');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (7, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (8, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (8, 'CARN');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (8, 'JACK');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (8, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (8, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (9, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (9, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (9, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (9, 'LETC');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (9, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (10, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (10, 'CARN');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (10, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (10, 'TMTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (10, 'SLSA');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (11, 'COTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (11, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (11, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (11, 'LETC');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (11, 'SRCR');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (12, 'FLTO');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (12, 'GRBF');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (12, 'CHED');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (12, 'LETC');
INSERT INTO public.taco_type_ingredients (taco_type_id, ingredients_id) VALUES (12, 'SLSA');


INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (10, 'Martin Lora', 'Novo-Sadovaya 42-27', 'Paris', 'Russia', '443110', '123', '12/20', '123', '2020-08-14 23:30:48.611', 5, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (11, 'John Smith', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '123', '12/20', '123', '2020-08-14 23:31:51.659', 4, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (1, 'Ivanov Ivan', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '111', '12/20', '009', '2020-03-12 16:36:01.589', 3, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (2, 'Ivanov Ivan', 'Novo-Sadovaya 42-27', 'Samara', 'Russia', '443110', '1232123', '12/20', '666', '2020-04-12 16:36:01.589', 3, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (3, 'Martin Lora', 'Novo-Sadovaya 42-27', 'Paris', 'Russia', '443110', '123', '12/20', '122', '2020-05-18 16:36:01.589', 5, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (4, 'Martin Lora', 'Novo-Sadovaya 42-27', 'Paris', 'Russia', '443110', '123', '12/20', '123', '2020-05-20 16:36:01.589', 5, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (5, 'Martin Lora', 'Novo-Sadovaya 42-27', 'Paris', 'Russia', '443110', '1233', '12/20', '123', '2020-05-22 16:36:01.589', 5, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (6, 'John Smith', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '123', '12/20', '122', '2020-06-22 16:36:01.589', 4, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (7, 'John Smith', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '234', '12/20', '122', '2020-06-24 16:36:01.589', 4, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (8, 'Ivanov Ivan', 'Novo-Sadovaya 42-27', 'Samara', 'Russia', '443110', '1233', '12/20', '123', '2020-07-12 16:36:01.589', 3, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (9, 'Johnson Sara', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '123', '12/20', '123', '2020-07-17 16:36:01.589', 6, 'PROCCESSING');
INSERT INTO public.taco_order (id, name, street, city, state, zip, cc_number, cc_expiration, cccvv, placed_at, user_id, status) OVERRIDING SYSTEM VALUE VALUES (12, 'Johnson Sara', 'Novo-Sadovaya 42-27', 'Moscow', 'Russia', '443110', '123', '12/20', '123', '2020-08-14 23:38:16.932', 6, 'PROCCESSING');
SELECT setval('taco_order_id_seq', (SELECT MAX(id) from "taco_order"));

INSERT INTO public.taco (order_id, tacotype_id) VALUES (1, 1);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (2, 2);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (2, 1);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (2, 1);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (3, 3);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (4, 4);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (5, 5);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (5, 4);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (6, 6);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (7, 7);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (7, 6);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (8, 8);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (8, 2);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (9, 9);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (10, 10);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (10, 5);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (11, 11);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (12, 12);
INSERT INTO public.taco (order_id, tacotype_id) VALUES (12, 9);
