create database if not exists product_management;
use product_management;
create table country(
id int primary key auto_increment,
name varchar(45) unique not null);
create table products(
id int primary key auto_increment,
name varchar(45) not null,
price double not null,
description varchar(125),
isActive bit default 1,
id_country int not null,
foreign key(id_country) references country(id)
);
DELIMITER $$
create  procedure get_all_product()
begin
select p.id,p.name,p.price,c.name as country,p.description from products p 
join country c on p.id_country = c.id
where p.isActive  = 1
order by p.id asc;
end $$
DELIMITER ;
call get_all_product();
DELIMITER $$
create  procedure search_by_name(input_name varchar(45))
begin
select p.id,p.name,p.price,c.name as country,p.description from products p 
join country c on p.id_country = c.id
where p.isActive  = 1 and p.name like input_name
order by p.id asc
;
end $$
DELIMITER ;
select * from country order by id asc;
create table user(
user_name varchar(45) primary key,
password varchar(45) not null,
email varchar(45) not null unique);
SELECT * FROM user WHERE user_name =  "admin" and password = "admin";