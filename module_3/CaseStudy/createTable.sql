
use Furama;

Create table vi_tri (
ma_vi_tri int primary key,
ten_vi_tri nvarchar(45)
);

create table trinh_do(
ma_trinh_do int primary key,
ten_trinh_do nvarchar(45)
);

create table bo_phan(
	ma_bo_phan int primary key,
    ten_bo_phan nvarchar(45)
);

create table nhan_vien(
	ma_nhan_vien INT primary key,
    ho_ten nvarchar(45) not null,
    ngay_sinh date not null,
    so_cmnd nvarchar(45) not null,
    luong double not null,
    so_dien_thoai nvarchar(45) not null,
    email nvarchar(45),
    dia_chi nvarchar(45),
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
    foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
    foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
    
);

create table dich_vu_di_kem(
	ma_dich_vu_di_kem int primary key,
    ten_dich_vu_di_kem nvarchar(45) not null,
    gia double not null,
    don_vi nvarchar(10) not null,
    trang_thai nvarchar(45)
);

create table hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet int primary key,
    ma_hop_dong int not null,
    ma_dich_vu_di_kem int not null,
    so_luong int not null,
    foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem),
    foreign key (ma_hop_dong) references hop_dong(ma_hop_dong)
);

create table kieu_thue(
	ma_kieu_thue int primary key,
    ten_kieu_thue nvarchar(45)
);

create table loai_dich_vu(
	ma_loai_dich_vu int primary key,
    ten_loai_dich_vu nvarchar(45)
);

create table loai_khach(
	ma_loai_khach int primary key,
    ten_loai_khach nvarchar(45)
);

create table khach_hang(
	ma_khach_hang int primary key,
    ma_loai_khach int not null,
    ho_ten nvarchar(45) not null,
    ngay_sinh date not null,
    gioi_tinh bit(1) not null,
    so_cmnd nvarchar(45) not null,
	so_dien_thoai nvarchar(45) not null,
    email nvarchar(45),
    dia_chi nvarchar(45),
    foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table dich_vu(
	ma_dich_vu int primary key,
    ten_dich_vu nvarchar(45) not null,
    dien_tich int ,
    chi_phi_thue double not null,
    so_nguoi_toi_da int not null,
    ma_kieu_thue int not null,
    ma_loai_dich_vu int not null,
    tieu_chuan_phong nvarchar(45),
    mo_ta_tien_nghi_khac nvarchar(45),
    dien_tich_ho_boi double,
    so_tang int,
    dich_vu_mien_phi_di_kem Text,
    foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
    foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong(
	ma_hop_dong int primary key,
    ngay_lam_hop_dong datetime not null,
    ngay_ket_thuc datetime not null,
    tien_dat_coc double not null,
    ma_nhan_vien int,
    ma_khach_hang int,
    ma_dich_vu int,
    foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
    foreign key(ma_dich_vu) references dich_vu(ma_dich_vu)
);