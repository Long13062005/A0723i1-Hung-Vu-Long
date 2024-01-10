
insert into Customer
 values (1,'Minh Quan',10),
		(2,'Ngoc Oanh',20),
        (3,'Hong Ha',50);
        
insert into `Order`
values (1, 1, '2006-03-21', null),
    (2, 2, '2006-03-23', null),
    (3, 1, '2006-03-16', null);

insert into Product
values (1,'May Giat',3),
		(2,'Tu Lanh',5),
        (3,'Dieu Hoa',7),
        (4,'Quat',1),
        (5,'Bep Dien',2);
        
insert into OrderDetail
values (1,1,3),
		(1,3,7),
        (1,4,2),
        (2,1,1),
        (3,1,8),
        (2,5,4),
        (2,3,3);
        
#baitap
#1 
select  oID, oDate, oTotalPrice  from `order`;
#2
select * from OrderDetail od
	right join `order` o on od.oID = o.oID 
    right join product p on p.pid = od.pid
    right join customer c on c.cid = o.cid;
#3
select * from customer c 
	left join `order` o on c.cID = o.cID
    left join orderdetail od on o.oID = od.oID
    where o.oID is null;
#4
SELECT o.oid, o.odate, SUM(od.odqty * p.pPrice) AS total_price
FROM `order` o
JOIN orderdetail od ON o.oid = od.oid
JOIN product p ON od.pid = p.pid
GROUP BY o.oid, o.oDate;

