create database student_management;
use student_management;
create table class (
	id int auto_increment primary key,
    `name` nvarchar(255) not null
);
create table teacher(
	id int auto_increment primary key,
    `name` nvarchar(255) not null,
    age int(2) not null,
    country nvarchar(255) not null
);