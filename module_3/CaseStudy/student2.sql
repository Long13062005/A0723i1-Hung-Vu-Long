Create database student_man;
use student_man;
create table SV(
	ID int auto_increment primary key,
    stuID nvarchar(4) not null,
    `name` nvarchar(255) not null,
    classID int not null,
    foreign key(classID) references Khoa(classID)
);
create table Khoa(
	classID int primary key,
    name_classID nvarchar(255) not null
);
select id,stuID,`name`,name_classID as "Khoa" from SV
inner join Khoa ON sv.classID = Khoa.classID;
insert into khoa values (1,"Khoa Học máy tinh "),(2,"Mạng máy tinh"),(3,"Điện tử"),(4,"Kinh tế")
