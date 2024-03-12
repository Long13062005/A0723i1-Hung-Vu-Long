create database if not exists product;
use product;
create table product_type(
id int auto_increment primary key,
name varchar(50)
);
create table product (
id int auto_increment primary key,
code varchar(10),
name varchar(50),
unit varchar(10),
price float,
type_id int,
foreign key ( type_id) references product_type(id)
);