create database Furama_casestudy;
use Furama_Casestudy;

-- 1st
CREATE TABLE AttachService (
    attach_service_id INT PRIMARY KEY,
    attach_service_name NVARCHAR(255) not null,
    attach_service_unit NVARCHAR(255) not null,
    attach_service_cost DOUBLE not null,
    attach_service_status varchar(45)
    
);
create table Service_type(
	Service_type_id int primary key,
    Service_type_name varchar(45)
);
Create Table rentType(
	rent_type_id int primary key,
    rent_type_name nvarchar(255) ,
    rent_type_cost double
);
create table `posItIon`(
	posItIon_Id Int prImary key,
    posItIon_name varchar(45) 
);
create table educatIon_degree(
	educatIon_degree_Id Int primary key,
    educatIon_degree_name varchar(50) 
);
create table dIvIsIon(
	dIvIsIon_Id Int primary key,
    dIvIsIon_name varchar(45) 
);
create table `role`(
	role_Id Int primary key,
    role_name varchar(255) 
   
);
create table `user`(
	username varchar(255) primary key,
   `password` varchar(255) 
     
);
create table user_role(
	role_Id Int not null,
    username varchar(255) not null,
    foreign key(username) references `user`(username),
    foreign key(role_id) references `role`(role_id)
);
create table customer_type(
	customer_type_Id Int primary key,
    customer_type_name varchar(45) 
);
-- second

create table customer(
	customer_Id Int primary key,
    customer_type_Id Int not null,
    customer_name varchar(45) not null,
    customer_bIrthday date not null,
    customer_gender bIt(1) not null,
    customer_Id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_emaIl varchar(45) ,
    customer_address varchar(45) ,
    foreign key(customer_type_Id) references customer_type(customer_type_Id)
);
create table Service(
	service_id int auto_increment primary key,
    service_name nvarchar(255) not null,
    service_area double ,
    service_cost double not null,
    service_max_people int ,
    rent_type_id int  not null,
    service_type_id int not null,
    standard_room varchar(45) ,
    description_other_conveniece varchar(45) ,
    pool_area double ,
    number_of_floors int ,
    foreign key(rent_type_id) references rentType(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);
-- third
create table employee(
	employee_id int primary key,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) ,
    employee_address varchar(45) ,
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
    username varchar(255) ,
    foreign key(position_id) references `position`(position_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(division_id) references division(division_id),
    foreign key(username) references `user`(username)
);
create table contract(
	contract_id int primary key,
    contract_start_date datetime not null,
    contract_end_date datetime not null,
    contract_deposit double not null,
    contract_total_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id) references service(service_id)
);
create table contract_detaIl(
	contract_detaIl_Id Int primary key,
    contract_Id Int not null,
    attach_servIce_Id Int not null,
    quantIty Int not null,
    foreign key(attach_service_id)references attachservIce(attach_service_id),
    foreign key(contract_id) references contract(contract_id)
);

