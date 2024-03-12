use furama;
#2
select * from nhan_vien
where (ho_ten   like 'K%' or ho_ten  like 'H%' or ho_ten   like 'L%') and length(ho_ten) <= 15;
#3
select * ,year(curdate()) - year(ngay_sinh)  as so_tuoi from khach_hang
where year(curdate()) - year(ngay_sinh)  between 18 and 50 and (dia_chi like('%Đà Nẵng') or dia_chi like ('%Quảng Trị'));
#4
select k.ma_khach_hang,k.ho_ten,count(h.ma_hop_dong) as so_lan_dat_phong from khach_hang k
 join hop_dong h on k.ma_khach_hang = h.ma_khach_hang
 join loai_khach l on l.ma_loai_khach = k.ma_loai_khach
where k.ma_loai_khach = (select ma_loai_khach from loai_khach  where ten_loai_khach = 'Diamond')
group by k.ma_khach_hang,k.ho_ten
order by so_lan_dat_phong asc;
#5
select k.ma_khach_hang, k.ho_ten, l.ten_loai_khach, h.ma_hop_dong, d.ten_dich_vu, h.ngay_lam_hop_dong, h.ngay_ket_thuc, (d.chi_phi_thue + dv.gia * hd.so_luong)   as tong_tien from khach_hang k
left join loai_khach l on l.ma_loai_khach = k.ma_loai_khach
left join hop_dong h on h.ma_khach_hang = k.ma_khach_hang
left join dich_vu d on d.ma_dich_vu = h.ma_dich_vu
left join hop_dong_chi_tiet hd on hd.ma_hop_dong = h.ma_hop_dong
left join dich_vu_di_kem dv on dv.ma_dich_vu_di_kem = hd.ma_dich_vu_di_kem
group by k.ma_khach_hang,l.ten_loai_khach, h.ma_hop_dong, d.ten_dich_vu, h.ngay_lam_hop_dong, h.ngay_ket_thuc,tong_tien;
#6
select dv.ma_dich_vu,dv.ten_dich_vu,  dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu from dich_vu dv
left join loai_dich_vu ldv on ldv.ma_loai_dich_vu=dv.ma_loai_dich_vu
where  dv.ma_dich_vu not in ( 
	select ma_dich_vu from  hop_dong 
    where year(ngay_lam_hop_dong) > 2020 and month(ngay_lam_hop_dong) <= 3
    ) ;
#7
select d.ma_dich_vu, d.ten_dich_vu, d.dien_tich, d.so_nguoi_toi_da, d.chi_phi_thue, dv.ten_loai_dich_vu  from dich_vu d
join loai_dich_vu dv on dv.ma_loai_dich_vu = d.ma_loai_dich_vu
where  d.ma_dich_vu in ( 
	select ma_dich_vu from  hop_dong 
    where year(ngay_lam_hop_dong) < 2021 
    ) and d.ma_dich_vu not in ( 
	select ma_dich_vu from  hop_dong 
    where year(ngay_lam_hop_dong) >2020 
    );
#8
-- c1 : distinct
select distinct ho_ten from khach_hang k;
-- c2 : group by
select ho_ten from khach_hang k 
group by ho_ten;
-- c3 : having
select ho_ten from khach_hang k
group by ho_ten
having count(ho_ten) = 1 ;
#9
select month(ngay_lam_hop_dong) as thang,count(ma_khach_hang) as so_lan from hop_dong h
where year(ngay_lam_hop_dong) = 2021
group by thang
order by thang asc;
#10
SELECT h.ma_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc, SUM(IFNULL(hd.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM hop_dong h
LEFT JOIN hop_dong_chi_tiet hd ON hd.ma_hop_dong = h.ma_hop_dong
GROUP BY h.ma_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc;
#11
select dv.ma_dich_vu_di_kem,dv.ten_dich_vu_di_kem from dich_vu_di_kem dv
 join hop_dong_chi_tiet hd on hd.ma_dich_vu_di_kem = dv.ma_dich_vu_di_kem
 join hop_dong h on h.ma_hop_dong = hd.ma_hop_dong
 join khach_hang k on k.ma_khach_hang = h.ma_khach_hang
join loai_khach lk on k.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' and (dia_chi like('%Đà Nẵng') or dia_chi like ('%Quảng Trị'))
#12




    


