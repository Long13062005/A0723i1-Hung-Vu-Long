use quanlysinhvien;
#1
select * from subject where credit = (select max(credit) from subject);
#2
select * from subject s 
 join mark m on s.subid = m.subid
 where m.mark = (select max(mark) from mark);
 #3
SELECT s.*, AVG(m.mark) AS tbm
FROM student s
JOIN mark m ON s.studentid = m.studentid
GROUP BY s.studentid, s.studentname
ORDER BY tbm DESC;


