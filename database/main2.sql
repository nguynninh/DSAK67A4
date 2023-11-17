CREATE DATABASE thuchanhtuan3;

USE thuchanhtuan3;

CREATE TABLE NHANVIEN
(
    HONV   VARCHAR(15) NOT NULL,
    TENLOT VARCHAR(15) NOT NULL,
    TENNV  VARCHAR(15) NOT NULL,
    MANV   VARCHAR(9)  NOT NULL PRIMARY KEY,
    NGSINH DATE        NOT NULL,
    DCHI   VARCHAR(30) NOT NULL,
    PHAI   VARCHAR(3)  NOT NULL,
    LUONG  DOUBLE      NOT NULL,
    MA_NQL VARCHAR(9)  NOT NULL,
    PHG    INT         NOT NULL
);

INSERT INTO NHANVIEN (HONV, TENLOT, TENNV, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG)
VALUES ('Đinh', 'Bá', 'Tiên', '009', '1960-02-11', '119 Cống Quỳnh, Tp HCM', 'Nam', 30000, '005', 5),
       ('Nguyễn', 'Thanh', 'Tùng', '005', '1962-08-20', '222 Nguyễn Văn Cừ, Tp HCM', 'Nam', 40000, '006', 5),
       ('Bùi', 'Ngọc', 'Hằng', '007', '1954-03-11', '332 Nguyễn Thái Học, Tp HCM', 'Nam', 25000, '001', 4),
       ('Lê', 'Quỳnh', 'Như', '001', '1967-02-01', '291 Hồ Văn Huê, Tp HCM', 'Nữ', 43000, '006', 4),
       ('Nguyễn', 'Mạnh', 'Hùng', '004', '1967-03-04', '95 Bà Rịa, Vũng Tàu', 'Nam', 38000, '005', 5),
       ('Trần', 'Thanh', 'Tâm', '003', '1957-05-04', '34 Mai Thị Lự, Tp HCM', 'Nam', 25000, '005', 5),
       ('Trần', 'Hồng', 'Quang', '008', '1967-09-01', '80 Lê Hồng Phong, Tp HCM', 'Nam', 25000, '001', 4),
       ('Phạm', 'Văn', 'Vinh', '006', '1965-01-01', '45 Trưng Vương, Hà Nội', 'Nữ', 55000, '006', 1);

CREATE TABLE PHONGBAN
(
    TENPHG      VARCHAR(15) NOT NULL,
    MAPHG       INT         NOT NULL PRIMARY KEY,
    TRPHG       VARCHAR(9)  NOT NULL,
    NG_NHANCHUC DATE        NOT NULL
);

INSERT INTO PHONGBAN (TENPHG, MAPHG, TRPHG, NG_NHANCHUC)
VALUES ('Nghiên cứu', 5, '005', '1978-05-22'),
       ('Điều hành', 4, '008', '1985-01-01'),
       ('Quản lý', 1, '006', '1971-06-19');

CREATE TABLE DIADIEM_PHG
(
    MAPHG   INT         NOT NULL,
    DIADIEM VARCHAR(15) NOT NULL,
    PRIMARY KEY (MAPHG, DIADIEM)
);

INSERT INTO DIADIEM_PHG (MAPHG, DIADIEM)
VALUES (1, 'TP HCM'),
       (4, 'Hà Nội'),
       (5, 'TAU'),
       (5, 'NHA TRANG'),
       (5, 'TP HCM');

CREATE TABLE DEAN
(
    TENDA    VARCHAR(15) NOT NULL,
    MADA     INT         NOT NULL PRIMARY KEY,
    DDIEM_DA VARCHAR(15) NOT NULL,
    PHONG    INT         NOT NULL
);

INSERT INTO DEAN (TENDA, MADA, DDIEM_DA, PHONG)
VALUES ('San pham X', 1, 'Vũng Tàu', 5),
       ('San pham Y', 2, 'Nha Trang', 5),
       ('San pham Z', 3, 'TP HCM', 5),
       ('Tin hoc hoa', 10, 'Hà Nội', 4),
       ('Cap quang', 20, 'TP HCM', 1),
       ('Dao tao', 30, 'Hà Nội', 4);

CREATE TABLE CONGVIEC
(
    MADA          INT         NOT NULL,
    STT           INT         NOT NULL,
    TEN_CONG_VIEC varchar(50) NOT NULL,
    PRIMARY KEY (MADA, STT)
);

INSERT INTO CONGVIEC (MADA, STT, TEN_CONG_VIEC)
VALUES (1, 1, 'Thiet ke san pham X'),
       (1, 2, 'Thu nghiem san pham X'),
       (2, 1, 'San xuat san pham Y'),
       (2, 2, 'Quang cao san pham Y'),
       (3, 1, 'Khuyen mai san pham Z'),
       (10, 1, 'Tin hoc hoa nhan su tien luong'),
       (10, 2, 'Tin hoc hoa phong Kinh doanh'),
       (20, 1, 'Lap dat cap quang'),
       (30, 1, 'Dao tao nhan vien Marketing'),
       (30, 2, 'dao tao chuyen vien thiet ke');

CREATE TABLE PHANCONG
(
    MA_NVIEN VARCHAR(9)   NOT NULL,
    MADA     INT          NOT NULL,
    STT      INT          NOT NULL,
    THOIGIAN DOUBLE(5, 1) NOT NULL,
    PRIMARY KEY (MA_NVIEN, MADA, STT)
);

INSERT INTO PHANCONG (MA_NVIEN, MADA, STT, THOIGIAN)
VALUES ('009', 1, 1, 32.0),
       ('009', 2, 2, 8.0),
       ('004', 3, 1, 40.0),
       ('003', 1, 2, 20.0),
       ('003', 2, 1, 20.0),
       ('008', 10, 1, 35.0),
       ('008', 30, 2, 5.0),
       ('001', 30, 1, 20.0),
       ('001', 20, 1, 15.0),
       ('006', 20, 1, 30.0),
       ('005', 3, 1, 10.0),
       ('005', 10, 2, 10.0),
       ('005', 20, 1, 10.0),
       ('007', 30, 2, 30.0),
       ('007', 10, 2, 10.0);

CREATE TABLE THANNHAN
(
    MA_NVIEN VARCHAR(9)  NOT NULL,
    TENTN    VARCHAR(15) NOT NULL,
    PHAI     VARCHAR(3)  NOT NULL,
    NGSINH   DATE        NOT NULL,
    QUANHE   VARCHAR(15) NOT NULL,
    PRIMARY KEY (MA_NVIEN, TENTN)
);

INSERT INTO THANNHAN (MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE)
VALUES ('001', 'Minh ', 'Nam', '1932-02-29', 'Vợ chồng'),
       ('005', 'Khang ', 'Nam', '1973-10-25', 'Con trai'),
       ('005', 'Phương ', 'Nữ', '1948-05-03', 'Vợ chồng'),
       ('005', 'Trinh ', 'Nữ', '1976-04-05', 'Con gái'),
       ('009', 'Châu ', 'Nữ', '1978-12-30', 'Con gái'),
       ('009', 'Phương ', 'Nữ', '1957-05-05', 'Vợ chồng'),
       ('009', 'Tiến ', 'Nam', '1978-01-01', 'Con trai');

ALTER TABLE NHANVIEN
    ADD FOREIGN KEY (MA_NQL) REFERENCES NHANVIEN (MANV);

ALTER TABLE NHANVIEN
    ADD FOREIGN KEY (PHG) REFERENCES PHONGBAN (MAPHG);

ALTER TABLE PHONGBAN
    ADD FOREIGN KEY (TRPHG) REFERENCES NHANVIEN (MANV);

ALTER TABLE DIADIEM_PHG
    ADD FOREIGN KEY (MAPHG) REFERENCES PHONGBAN (MAPHG);

ALTER TABLE DEAN
    ADD FOREIGN KEY (PHONG) REFERENCES PHONGBAN (MAPHG);

ALTER TABLE CONGVIEC
    ADD FOREIGN KEY (MADA) REFERENCES DEAN (MADA);

ALTER TABLE PHANCONG
    ADD FOREIGN KEY (MA_NVIEN) REFERENCES NHANVIEN (MANV);

ALTER TABLE PHANCONG
    ADD FOREIGN KEY (MADA, STT) REFERENCES CONGVIEC (MADA, STT);


ALTER TABLE THANNHAN
    ADD FOREIGN KEY (MA_NVIEN) REFERENCES NHANVIEN (MANV);

#Bai 1
SELECT DISTINCT pc.MADA
FROM phancong pc
WHERE pc.MA_NVIEN IN (SELECT nv.MANV
                      FROM nhanvien nv,
                           phongban pb
                      WHERE nv.HONV LIKE 'Đinh%' AND nv.PHG = pb.MAPHG
                         OR nv.MANV = pb.TRPHG AND nv.HONV LIKE 'Đinh%');

#Bai 2
SELECT HONV, TENLOT, TENNV
FROM nhanvien
WHERE (SELECT COUNT(*)
       FROM thannhan
       WHERE MA_NVIEN = MANV) >= 2;

#Bai 3
SELECT HONV, TENLOT, TENNV
FROM nhanvien
WHERE (SELECT COUNT(*)
       FROM thannhan
       WHERE MA_NVIEN = MANV) = 0;

#Bai 4
SELECT HONV, TENLOT, TENNV
FROM nhanvien
WHERE (SELECT COUNT(*)
       FROM thannhan
       WHERE MA_NVIEN = MANV) >= 1;


#Bai 5
SELECT nv.HONV, nv.TENLOT, nv.TENNV
FROM nhanvien nv
         JOIN PHONGBAN pb ON pb.TRPHG = nv.MANV
WHERE (SELECT COUNT(*)
       FROM thannhan tn
       WHERE tn.MA_NVIEN = nv.MANV) = 0;

#Bai 6
SELECT HONV, TENLOT, TENNV
FROM nhanvien
WHERE LUONG > (SELECT AVG(LUONG)
               FROM PHONGBAN pb,
                    NHANVIEN nc
               WHERE pb.TENPHG = 'Nghiên cứu'
                 AND pb.MAPHG = nc.PHG);

#Bai 7
SELECT pb.TENPHG, nv.HONV, nv.TENLOT, nv.TENNV
FROM phongban pb
         JOIN nhanvien nv ON pb.TRPHG = nv.MANV
ORDER BY (SELECT COUNT(*) FROM nhanvien WHERE PHG = pb.MAPHG) DESC
LIMIT 1;

#Câu 8
SELECT DISTINCT cv.MADA
FROM congviec cv
WHERE MADA NOT IN (SELECT pc.MADA
                   FROM phancong pc
                   WHERE pc.MA_NVIEN = '009'
                   );

#Câu 9
SELECT cv.TEN_CONG_VIEC
FROM dean da
         JOIN CONGVIEC cv on da.MADA = cv.MADA
WHERE da.TENDA LIKE 'Sản phẩm X%'
  AND NOT EXISTS (SELECT *
                  FROM phancong pc
                  WHERE pc.MADA = da.MADA
                    AND pc.MA_NVIEN LIKE '009');

#Cau 11
SELECT DISTINCT CONCAT(nv.HONV, ' ', nv.TENLOT, ' ', nv.TENNV) AS "HO_TEN_NHAN_VIEN", nv.DCHI
FROM PHANCONG pc
         JOIN DEAN da ON da.MADA = pc.MADA
         JOIN NHANVIEN nv ON nv.MANV = pc.MA_NVIEN
WHERE NOT EXISTS(SELECT *
                 FROM DIADIEM_PHG ddp
                 WHERE da.DDIEM_DA = ddp.DIADIEM
                   AND nv.PHG = ddp.MAPHG);