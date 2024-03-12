Create database Hospital;
use Hospital;
create table benh_an (
	id_sick int auto_increment primary key,
    code_sick varchar(40) not null
);


create table benh_nhan(
	id int auto_increment primary key,
    id_sick int not null,
	code_victim varchar(40) not null,
    name_victim varchar(255) not null  ,
    date_start date not null,
    date_end date not null,
    reason varchar(255) not null,
    foreign key(id_sick) references benh_an(id_sick)
    );


DELIMITER $$
create  procedure SHOW_ALL_HOSPITAL( )
begin
SELECT BN.ID,CODE_SICK AS MA_BENH_AN,CODE_VICTIM AS MA_BENH_NHAN,NAME_VICTIM AS TEN_BENH_NHAN,DATE_START AS NGAY_NHAP_VIEN,DATE_END AS NGAY_XUAT_VIEN,REASON AS LY_DO_NHAP_VIEN FROM BENH_NHAN BN
JOIN BENH_AN BA ON BA.ID_SICK = BN.ID_SICK
order by BN.id asc;
end $$
DELIMITER ;

CALL SHOW_ALL_HOSPITAL();
DELIMITER $$
create  procedure ADD_VICTIM(id_sick_add int,code_victim_add varchar(40), name_victim_add varchar(255), date_start_add date, date_end_add date, reason_add varchar(255))
begin 
INSERT INTO BENH_VIEN(id_sick,code_victim,name_victim,date_start,date_end,reason) VALUE (id_sick_add,code_victim,name_victim,date_start_add,date_end_add,reason_add);
end $$
DELIMITER ;
call ADD_VICTIM(?,?,?,?,?,?);
Insert into benh_an(code_sick) value ("BA-223");
INSERT INTO BENH_NHAN(id_sick,code_victim,name_victim,date_start,date_end,reason) VALUE(3,"BN-984","Tôn Nữ D","2020-01-11","2018-08-08","Suy thận");

DELIMITER $$
create  procedure DELETE_VICTIM(input_id int)
begin 
Delete from benh_nhan where id = input_id;
end $$
DELIMITER ;

DELIMITER $$
create  procedure search_by_id_victim( id_search int)
begin
SELECT BN.ID,CODE_SICK AS MA_BENH_AN,CODE_VICTIM AS MA_BENH_NHAN,NAME_VICTIM AS TEN_BENH_NHAN,DATE_START AS NGAY_NHAP_VIEN,DATE_END AS NGAY_XUAT_VIEN,REASON AS LY_DO_NHAP_VIEN FROM BENH_NHAN BN
JOIN BENH_AN BA ON BA.ID_SICK = BN.ID_SICK
where BN.id = id_search
order by BN.id asc;
end $$
DELIMITER ;

DELIMITER $$
create  procedure search_by_name_victim(in input_name varchar(255))
begin
SELECT BN.ID,CODE_SICK AS MA_BENH_AN,CODE_VICTIM AS MA_BENH_NHAN,NAME_VICTIM AS TEN_BENH_NHAN,DATE_START AS NGAY_NHAP_VIEN,DATE_END AS NGAY_XUAT_VIEN,REASON AS LY_DO_NHAP_VIEN FROM BENH_NHAN BN
JOIN BENH_AN BA ON BA.ID_SICK = BN.ID_SICK
where BN.Name_Victim like concat('%',input_name,'%') 
order by BN.id asc;
end $$
DELIMITER ;

call search_by_name_victim("A");

DELIMITER $$
create  procedure update_victim(name_victim_update varchar(255),date_start_update date,date_end_update date,reason_update varchar(255),input_id int)
begin 
update benh_nhan set name_victim = name_victim_update , date_start = date_start_update , date_end = date_end_update , reason = reason_update where id = input_id;
end $$
DELIMITER ;
call update_victim(?,?,?,?);
select * from benh_nhan;
select * from benh_an;
call update_victim("Nguyen Van A","2020-01-11","2018-08-08","Suy thận",1);

