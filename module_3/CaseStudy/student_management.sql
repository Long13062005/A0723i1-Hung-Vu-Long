CREATE DATABASE student_management;
USE student_management;
create table class (
classId int(3) not null auto_increment,
className varchar(120) not null,
primary key (classId)
);
create table gv (
gvId int(3) not null auto_increment,
gvName varchar(120) not null,
primary key (gvId)
);
create table student (
      id int(3) NOT NULL AUTO_INCREMENT,
      name varchar(120) NOT NULL,
      classId int(3) NOT NULL,
      gvId int(3) not null,
      PRIMARY KEY (id),
      foreign key (classId) references class(classId),
      foreign key (gvId) references gv (gvId)
);
insert into gv(gvName) value ('Chanh');
insert into gv(gvName) value ('Cong');
insert into gv(gvName) value ('Phuong');
insert into class(className) value ('C0723');
insert into class(className) value ('C0523');
insert into class(className) value ('C0923');
insert into student(name,classId,gvId) value ('Tuan',1,1);
insert into student(name,classId,gvId) value ('Long',1,2);
insert into student(name,classId,gvId) value ('Thien',2,3);

DELIMITER $$
create  procedure get_all_student()
begin
select s.id,s.name,c.className,g.gvName from student s 
join class c on s.classId = c.classId 
join gv g on s.gvId = g.gvId
 
order by s.id asc;
end $$
DELIMITER ;
call get_all_student();
select * from student;

select s.id,s.name,c.className,g.gvName from student s 
join class c on s.classId = c.classId 
join gv g on s.gvId = g.gvId
where s.name like "Long"
order by s.id asc;

DELIMITER $$
create  procedure search_by_name_student(in input_name varchar(255))
begin
select s.id,s.name,c.className,g.gvName from student s 
join class c on s.classId = c.classId 
join gv g on s.gvId = g.gvId
where s.name like concat('%',input_name,'%') 
order by s.id asc;
end $$
DELIMITER ;
call search_by_name_student("L");

DELIMITER $$
create  procedure search_by_id_student( id_search int)
begin
select s.id,s.name,c.className,g.gvName from student s 
join class c on s.classId = c.classId 
join gv g on s.gvId = g.gvId
where s.id = id_search
order by s.id asc;
end $$
DELIMITER ;
call search_by_id_student(2);

DELIMITER $$
create  procedure add_student(input_name varchar(255),classID int(3),gvID int(3))
begin 
INSERT INTO STUDENT(NAME,CLASSID,GVID) VALUE (INPUT_NAME,CLASSID,GVID);
end $$
DELIMITER ;
INSERT INTO STUDENT(NAME,CLASSID,GVID) VALUE ("hải",1,2);
select * from student;

call add_student("Triều",1,2);

DELIMITER $$
create  procedure delete_student(id_delete int)
begin 
delete from student where id = id_delete;
end $$
DELIMITER ;

call delete_student(1);

DELIMITER $$
create  procedure update_student(input_name varchar(255),classID_input int(3),gvID_input int(3),id_update int)
begin 
update student set `name` = input_name,classID = classID_input,gvID = gvID_input  where id = id_update;
end $$
DELIMITER ;

select * from student;
call update_student("Quỳnh",1,2,2);

DELIMITER $$
create  procedure get_all_class()
begin
select s.id,s.name,c.className,g.gvName from student s 
join class c on s.classId = c.classId 
join gv g on s.gvId = g.gvId
 
order by s.id asc;
end $$
DELIMITER ;
select * from class;

 

