create table if not exists products (
    id serial,
    name varchar not null,
    vendor_code varchar unique not null,
    quantity integer DEFAULT 1.0,
    price numeric not null,
    description varchar,
    primary key (id)
);

create table if not exists categories (
    id serial,
    name varchar not null,
    description varchar not null,
    primary key (id)
);

create table if not exists products_categories (
    category_id serial not null,
    product_id serial not null,
    primary key (category_id, product_id),
    foreign key(category_id) references categories(id),
    foreign key(product_id) references products(id)
);

CREATE INDEX products_categories_category_idx ON products_categories (category_id);
CREATE INDEX products_categories_product_idx ON products_categories (product_id);

create table if not exists documents (
   id serial,
   tax_id bigint unique not null,
   passport varchar not null,
   additional_info varchar,
   primary key (id)
);

create table if not exists clients (
    id serial,
    first_name varchar not null,
    last_name varchar not null,
    phone varchar not null,

--  timestamp means that date will be converted to milliseconds
--  it store milliseconds count from January 1, 1970 to given data
    birth_date timestamp with time zone,

    login varchar not null,
    email varchar not null,
    password varchar not null,
    document_id serial,
    primary key (id),
    foreign key(document_id) references documents(id)
);

CREATE INDEX clients_document_idx ON clients (document_id);

create table if not exists orders (
    client_id serial,
    product_id serial,
    quantity integer DEFAULT 1,
    order_date timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    primary key (client_id, product_id, order_date),
    foreign key(client_id) references clients(id),
    foreign key(product_id) references products(id)
);

CREATE INDEX orders_client_idx ON orders (client_id);
CREATE INDEX orders_product_idx ON orders (product_id);

