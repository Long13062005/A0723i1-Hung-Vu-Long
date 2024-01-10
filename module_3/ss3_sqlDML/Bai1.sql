select * from class;
select * from mark;
#1
Select * from student 
where studentName like 'h%';
#2
Select * from class
where month(StartDate) = 12;
#3
select * from `subject`
where credit between 3 and 5;
#4
Update student set ClassId = 2 where studentName = 'Hung' ;
#5
Select StudentName,SubName,Mark 
from student s inner join mark m on s.studentID = m.studentid 
				inner join `subject` sub on s.status = sub.status
ORDER BY 
    m.Mark DESC,
    s.StudentName ASC;