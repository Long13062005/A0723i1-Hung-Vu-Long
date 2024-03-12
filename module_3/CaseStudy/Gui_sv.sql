create database student_management;
use student_management;
create table SV (
	StuID nvarchar(4) primary key,
	Name nvarchar(255),
	Address nvarchar(255)
);
SELECT * FROM SV;
INSERT INTO SV(STUID,NAME,ADDRESS) value ("1","2","3");
DELETE FROM SV WHERE STUID = "?";
SELECT * FROM SV WHERE NAME LIKE "A";
UPDATE SV set STUID = ?,NAME = ?,ADDRESS = ? WHERE STUID = ?;
UPDATE SV set STUID = 2,NAME = 2,ADDRESS = 2 WHERE STUID = 1;

