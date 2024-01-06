create database if not exists nhacungcap;
use nhacungcap;
create table nhacc(
mancc nvarchar(10) primary key,
tenncc nvarchar(255) not null ,
address nvarchar(255) not null,
sdt nvarchar(10) not null
);
create table phoneNumber(
	mancc nvarchar(10) ,
    sdt nvarchar(10),
    primary key (mancc,sdt),
    foreign key (mancc) references nhacc(mancc)
);
create table dondh(
	sodh int primary key,
    ngaydh date not null,
    mancc nvarchar(10) not null,
    foreign key (mancc) references nhacc(mancc)
);
create table vattu(
	maVTU nvarchar(10) primary key,
    tenvtu nvarchar(255) not null,
    sodh int not null,
    foreign key (sodh) references dondh(sodh)
    
);

create table phieuxuat(
	soPX int primary key,
    ngayxuat date not null
    
     );
     
    create table phieuNhap(
	soPN int primary key,
    ngayNhap date not null
     );
     
    create table detailIn(
    maVTU nvarchar(10) not null,
    soPN int not null,
    primary key (maVTU,soPN),
	foreign key (maVTU) references vattu(maVTU),
    foreign key (soPN) references phieunhap(soPN)
);
    create table detailOut(
    maVTU nvarchar(10) not null,
    soPX int not null,
    primary key (maVTU,soPX),
	foreign key (maVTU) references vattu(maVTU),
    foreign key (soPX) references phieuxuat(soPX)
);
    
    
    
    