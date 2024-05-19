create table if not exists user_list (
    name varchar not null,
    pass varchar not null,
    role varchar unique not null,
    primary key(name)
);

insert into user_list (name, pass, role) values
('admin', crypt('admin', gen_salt('bf')), 'ROLE_ADMIN'),
('user', crypt('user', gen_salt('bf')), 'ROLE_USER');

create table if not exists client_role (
  role varchar not null,
  client_id bigserial not null,
  primary key(role, client_id),
  foreign key(role) references user_list(role),
  foreign key(client_id) references clients(id)
);

insert into client_role (role, client_id) values
((SELECT role from user_list where name='admin'), (SELECT * FROM get_id_from_table(1, 'clients'))),
((SELECT role from user_list where name='user'), (SELECT * FROM get_id_from_table(2, 'clients')));

CREATE INDEX client_role_role_idx ON client_role (role);
CREATE INDEX client_role_client_id_idx ON client_role (client_id);