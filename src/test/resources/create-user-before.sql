delete from users_roles;
delete from users;

INSERT INTO public.users (id, username, password, fullname, street, city, state, zip, phone_number) OVERRIDING SYSTEM VALUE VALUES
    (7, 'test', '6b7fcbe5405b26aa36762ea48004945c5a78c6f7fa438164d909e038a45c15413743d4bfa78c9457', 'Test Test', 'Novo-Sadovaya 42-27', 'Paris', 'Russia', '443110', '89171189174');

INSERT INTO public.users_roles (user_id, roles_id) VALUES (7, 2);
