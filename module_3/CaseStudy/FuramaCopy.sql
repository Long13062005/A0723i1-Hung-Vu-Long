create database Furama;
use Furama;

create table ViTri
(
	MaViTri int primary key,
    TenViTri varchar(45)
);
create table VaiTro
(
	MaVaiTro int primary key,
    TenVaiTro varchar(50)
);

create table NguoiSuDung
(
	UserName varchar(50) primary key,
    MatKhau varchar(50)
);
create table VaiTro_NguoiSuDung
(
	MaVaiTro int,
    UserName varchar(50)
);
create table TrinhDo
(
	MaTrinhDo int primary key,
    TenTrinhDo varchar(45)
);

create table BoPhan
(
	MaBoPhan int primary key,
    TenBoPhan varchar(45)
);

create table DichVuDiKem
(
	MaDichVuDiKem int primary key,
    TenDichVuDiKem varchar(45),
    Gia double,
    DonVi varchar(10),
    TrangThai varchar(45)
);

create table KieuThue
(
	MaKieuThue int primary key,
    TenKieuThue varchar(45)
);

create table LoaiKhach
(
	MaLoaiKhach int primary key,
    TenLoaiKhach varchar(45)
);

create table LoaiDichVu
(
	MaLoaiDichVu int primary key,
    TenLoaiDichVu varchar(45)
);

create table KhachHang
(
	MaKhachHang int primary key,
    MaLoaiKhach int,
    HoTen varchar(45),
    NgaySinh date,
    GioiTinh bit,
    CMND varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    foreign key(MaLoaiKhach) references LoaiKhach(MaLoaiKhach)
);

create table DichVu
(
	MaDichVu int primary key,
    TenDichVu varchar(45),
    DienTich int,
    ChiPhiThue double,
    SoNguoiToiDat int,
    MaKieuThue int,
    MaLoaiDichVu int,
    TieuChuanPhong varchar(45),
    MoTaTienNghiKhac varchar(45),
    DienTichHoBoi double,
	SoTang int,
    DichVuMienPhiDiKem text,
    foreign key (MaKieuThue) references KieuThue(MaKieuThue),
    foreign key (MaLoaiDichVu) references LoaiDichVu(MaLoaiDichVu),
    -- thêm ràng buộc cho bảng dịch vụ 
    constraint check_Dientich check (DienTich >= 0),
    constraint check_ChiPhiThue check (DienTich >= 0),
    constraint check_SoTang check (DienTich >= 0),
    constraint check_HoBoi check (DienTichHoBoi >= 0)
);



    



create table NhanVien
(
	MaNhanVien int primary key,
    HoTen varchar(45),
    NgaySinh date,
    CMND varchar(45),
    Luong double,
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    MaViTri int,
    MaTrinhDo int,
    MaBoPhan int,
    UserName varchar(50),
    foreign key (MaViTri) references ViTri(MaViTri),
    foreign key (MaTrinhDo) references TrinhDo(MaTrinhDo),
    foreign key (MaBoPhan) references BoPhan(MaBoPhan),
    -- tạo thêm ràng buộc cho bảng nhân viên
    constraint Check_Email check (Email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'),
    constraint Check_Luong check (Luong >= 0),
    constraint check_SDT check (SDT REGEXP '0[0-9]{9}$')
);

create table HopDong 
(
	MaHopDong int primary key,
    NgayLamHopDong datetime not null,
    NgayKetThuc dateTime not null,
    TienDatCoc double,
    MaNhanVien int,
    MaKhachHang int,
    MaDichVu int,
    foreign key (MaNhanVien) references NhanVien(MaNhanVien),
    foreign key (MaKhachHang) references KhachHang(MaKhachHang),
foreign key(MaDichVu) references DichVu(MaDichVu)
);
create table HopDongChiTiet
(
	MaHopDongChiTiet int primary key,
    MaHopDong int,
    MaDichVuDiKem int,
    SoLuong int,
    foreign key (MaHopDong) references HopDong(MaHopDong),
    foreign key(MaDichVuDiKem) references DichVuDiKem(MaDichVuDiKem)
);
-- Bảng ViTri
INSERT INTO ViTri (MaViTri, TenViTri) VALUES
(1, 'VIP'),
(2, 'Standard'),
(3, 'Deluxe'),
(4, 'Superior'),
(5, 'Family'),
(6, 'Suite'),
(7, 'Executive'),
(8, 'Penthouse'),
(9, 'Ocean View'),
(10, 'Garden View');
INSERT INTO VaiTro (MaVaiTro, TenVaiTro) VALUES
(1, 'Vai Tro 1'),
(2, 'Vai Tro 2'),
(3, 'Vai Tro 3'),
(4, 'Vai Tro 4'),
(5, 'Vai Tro 5'),
(6, 'Vai Tro 6'),
(7, 'Vai Tro 7'),
(8, 'Vai Tro 8'),
(9, 'Vai Tro 9'),
(10, 'Vai Tro 10');

-- Inserting data into the NguoiSuDung table
INSERT INTO NguoiSuDung (UserName, MatKhau) VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3'),
('user4', 'password4'),
('user5', 'password5'),
('user6', 'password6'),
('user7', 'password7'),
('user8', 'password8'),
('user9', 'password9'),
('user10', 'password10');



-- Inserting data into the VaiTro_NguoiSuDung table
-- Assuming you want random assignments of VaiTro to NguoiSuDung for demonstration purposes
INSERT INTO VaiTro_NguoiSuDung (MaVaiTro, UserName) VALUES
(1, 'user1'),
(2, 'user2'),
(3, 'user3'),
(4, 'user4'),
(5, 'user5'),
(6, 'user6'),
(7, 'user7'),
(8, 'user8'),
(9, 'user9'),
(10, 'user10');
-- Bảng TrinhDo
INSERT INTO TrinhDo (MaTrinhDo, TenTrinhDo) VALUES
(1, 'Bachelor'),
(2, 'Master'),
(3, 'PhD'),
(4, 'Associate'),
(5, 'Diploma'),
(6, 'Certificate'),
(7, 'Specialist'),
(8, 'Professional'),
(9, 'Technical'),
(10, 'Vocational');

-- Bảng BoPhan
INSERT INTO BoPhan (MaBoPhan, TenBoPhan) VALUES
(1, 'Administration'),
(2, 'Finance'),
(3, 'Human Resources'),
(4, 'Marketing'),
(5, 'IT'),
(6, 'Customer Service'),
(7, 'Operations'),
(8, 'Sales'),
(9, 'Engineering'),
(10, 'Security');

-- Bảng DichVuDiKem
INSERT INTO DichVuDiKem (MaDichVuDiKem, TenDichVuDiKem, Gia, DonVi, TrangThai) VALUES
(1, 'WiFi', 10, 'Hour', 'Active'),
(2, 'Breakfast', 15, 'Person', 'Active'),
(3, 'Airport Transfer', 20, 'Service', 'Inactive'),
(4, 'Spa Package', 30, 'Package', 'Active'),
(5, 'Laundry Service', 8, 'Piece', 'Active'),
(6, 'Gym Access', 12, 'Day', 'Inactive'),
(7, 'Room Upgrade', 25, 'Service', 'Active'),
(8, 'Car Rental', 50, 'Day', 'Active'),
(9, 'Late Checkout', 18, 'Hour', 'Active'),
(10, 'Pool Access', 15, 'Day', 'Inactive');

-- Bảng KieuThue
INSERT INTO KieuThue (MaKieuThue, TenKieuThue) VALUES
(1, 'Hourly'),
(2, 'Daily'),
(3, 'Weekly'),
(4, 'Monthly'),
(5, 'Yearly'),
(6, 'Event');

-- Bảng LoaiKhach
INSERT INTO LoaiKhach (MaLoaiKhach, TenLoaiKhach) VALUES
(1, 'Regular'),
(2, 'VIP'),
(3, 'Corporate'),
(4, 'Government'),
(5, 'Senior'),
(6, 'Group'),
(7, 'Family'),
(8, 'Student'),
(9, 'Military'),
(10, 'Wedding');

-- Bảng LoaiDichVu
INSERT INTO LoaiDichVu (MaLoaiDichVu, TenLoaiDichVu) VALUES
(1, 'Hotel'),
(2, 'Resort'),
(3, 'Motel'),
(4, 'Inn'),
(5, 'Guesthouse'),
(6, 'Cottage'),
(7, 'B&B'),
(8, 'Hostel'),
(9, 'Villa'),
(10, 'Apartment');

-- Bảng KhachHang
INSERT INTO KhachHang (MaKhachHang, MaLoaiKhach, HoTen, NgaySinh, GioiTinh, CMND, SDT, Email, DiaChi) VALUES
(1, 2, 'John Doe', '1990-05-15', 1, '123456789', '0123456789', 'john.doe@example.com', '123 Main St'),
(2, 1, 'Jane Smith', '1985-08-22', 0, '987654321', '0987654321', 'jane.smith@example.com', '456 Oak St'),
(3, 3, 'Bob Johnson', '1978-11-10', 1, '456789123', '0123456789', 'bob.johnson@example.com', '789 Pine St'),
(4, 4, 'Alice Williams', '1995-03-25', 0, '789123456', '0987654321', 'alice.williams@example.com', '101 Maple St'),
(5, 1, 'Charlie Brown', '1980-12-05', 1, '321654987', '0123456789', 'charlie.brown@example.com', '202 Cedar St'),
(6, 3, 'Eva Davis', '1992-07-18', 0, '654789321', '0987654321', 'eva.davis@example.com', '303 Birch St'),
(7, 2, 'Mike Miller', '1987-09-30', 1, '987321654', '0123456789', 'mike.miller@example.com', '404 Elm St'),
(8, 1, 'Lisa Taylor', '1998-01-12', 0, '147258369', '0987654321', 'lisa.taylor@example.com', '505 Walnut St'),
(9, 5, 'David Wilson', '1983-06-08', 1, '369852147', '0123456789', 'david.wilson@example.com', '606 Oak St'),
(10, 4, 'Sarah Moore', '1990-04-20', 0, '258369147', '0987654321', 'sarah.moore@example.com', '707 Pine St');

-- Bảng DichVu
INSERT INTO DichVu (MaDichVu, TenDichVu, DienTich, ChiPhiThue, SoNguoiToiDat, MaKieuThue, MaLoaiDichVu, TieuChuanPhong, MoTaTienNghiKhac, DienTichHoBoi, SoTang, DichVuMienPhiDiKem) VALUES
(1, 'Luxury Suite', 60, 250, 2, 2, 1, '5-star', 'Ocean view, Jacuzzi', 10, 5, 'WiFi, Breakfast'),
(2, 'Beachfront Villa', 120, 450, 4, 3, 9, '5-star', 'Private beach access, Pool', 20, 2, 'WiFi, Late Checkout'),
(3, 'Standard Room', 30, 100, 1, 1, 1, '3-star', 'City view, Basic amenities', 0, 3, 'WiFi'),
(4, 'Family Cabin', 40, 150, 3, 2, 6, '4-star', 'Forest view, Fireplace', 5, 2, 'WiFi, Breakfast, Pool Access'),
(5, 'Executive Suite', 50, 200, 2, 3, 1, '4-star', 'Mountain view, Workstation', 0, 4, 'WiFi, Late Checkout'),
(6, 'Garden Cottage', 35, 120, 2, 1, 6, '3-star', 'Garden view, Kitchenette', 0, 1, 'WiFi'),
(7, 'Poolside Bungalow', 45, 180, 3, 2, 5, '4-star', 'Pool view, Terrace', 15, 2, 'WiFi, Pool Access'),
(8, 'Apartment Suite', 55, 220, 2, 3, 10, '4-star', 'City view, Living area', 0, 5, 'WiFi, Late Checkout'),
(9, 'Mountain Chalet', 65, 280, 3, 1, 6, '5-star', 'Mountain view, Fireplace', 10, 3, 'WiFi'),
(10, 'Ocean View Room', 35, 150, 2, 2, 1, '4-star', 'Ocean view, Balcony', 0, 4, 'WiFi, Breakfast');

-- Bảng NhanVien
INSERT INTO NhanVien (MaNhanVien, HoTen, NgaySinh, CMND, Luong, SDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan,UserName) VALUES
(1, 'Alex Johnson', '1980-02-14', '456123789', 3000, '0123456789', 'alex.johnson@example.com', '123 Main St', 2, 2, 1,'username1'),
(2, 'Emily Davis', '1992-09-25', '789456123', 2500, '0987654321', 'emily.davis@example.com', '456 Oak St', 3, 3, 2,'username1'),
(3, 'Michael Smith', '1985-06-12', '321789654', 3500, '0123456789', 'michael.smith@example.com', '789 Pine St', 1, 4, 3,'username1'),
(4, 'Sophia Brown', '1998-04-30', '987654321', 2000, '0987654321', 'sophia.brown@example.com', '101 Maple St', 4, 5, 4,'username1'),
(5, 'Christopher Wilson', '1995-11-08', '654321987', 2800, '0123456789', 'christopher.wilson@example.com', '202 Cedar St', 5, 6, 5,'username1'),
(6, 'Olivia Moore', '1982-08-17', '789321654', 3200, '0987654321', 'olivia.moore@example.com', '303 Birch St', 2, 7, 6,'username5'),
(7, 'William Taylor', '1990-03-22', '123789456', 2600, '0123456789', 'william.taylor@example.com', '404 Elm St', 3, 8, 7,'username4'),
(8, 'Emma Miller', '1987-12-05', '456987321', 3800, '0987654321', 'emma.miller@example.com', '505 Walnut St', 1, 9, 8,'username4'),
(9, 'Liam Johnson', '1994-05-18', '789147258', 2100, '0123456789', 'liam.johnson@example.com', '606 Oak St', 4, 10, 9,'username3'),
(10, 'Ava Davis', '1989-01-30', '258369147', 2900, '0987654321', 'ava.davis@example.com', '707 Pine St', 5, 6, 10,'username2');

-- Bảng HopDong
INSERT INTO HopDong (MaHopDong, NgayLamHopDong, NgayKetThuc, TienDatCoc, MaNhanVien, MaKhachHang, MaDichVu) VALUES
(1, '2023-01-10 08:00:00', '2023-02-10 18:00:00', 500, 1, 1, 3),
(2, '2023-02-15 10:30:00', '2023-03-15 20:30:00', 700, 2, 2, 6),
(3, '2023-03-20 12:45:00', '2023-04-20 22:45:00', 1000, 3, 3, 9),
(4, '2023-04-25 14:15:00', '2023-05-25 00:15:00', 800, 4, 4, 2),
(5, '2023-05-30 16:30:00', '2023-06-30 02:30:00', 1200, 5, 5, 5),
(6, '2023-06-05 18:45:00', '2023-07-05 04:45:00', 900, 6, 6, 8),
(7, '2023-07-10 20:00:00', '2023-08-10 06:00:00', 600, 7, 7, 10),
(8, '2023-08-15 22:15:00', '2023-09-15 10:15:00', 1100, 8, 8, 1),
(9, '2023-09-20 00:30:00', '2023-10-20 12:30:00', 950, 9, 9, 4),
(10, '2023-10-25 02:45:00', '2023-11-25 14:45:00', 850, 10, 9, 7);