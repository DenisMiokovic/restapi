create table if not exists Product (
  id int auto_increment primary key,
  code varchar(15) unique not null,
  name varchar(255) not null,
  price_eur decimal(10, 2) not null,
  price_usd decimal(10, 2) not null,
  description text
);

create table if not exists Review (
  id int auto_increment primary key,
  product_id int not null,
  reviewer varchar(255) not null,
  text text,
  rating int check (rating between 1 and 5),
  foreign key (product_id) references product(id)
);