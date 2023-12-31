CREATE DATABASE thuchanhtuan3
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

use thuchanhtuan3;

CREATE TABLE NHANVIEN
(
    Hodem    VARCHAR(50)  NOT NULL,
    Ten      VARCHAR(50)  NOT NULL,
    MaSoNV   INT          NOT NULL PRIMARY KEY,
    NgaySinh DATE         NOT NULL,
    Diachi   VARCHAR(100) NOT NULL,
    Gioitinh BOOLEAN      NOT NULL,
    Luong    DOUBLE       NOT NULL,
    MaSoNGS  INT          NOT NULL,
    MaSoDV   INT          NOT NULL
);

CREATE TABLE DONVI
(
    TenĐV      VARCHAR(50) NOT NULL,
    MasoĐV     INT         NOT NULL PRIMARY KEY,
    MasoNQL    INT         NOT NULL,
    Ngaybatdau DATE        NOT NULL
);

CREATE TABLE DONVI_DIADIEM
(
    MasoDV    INT         NOT NULL,
    DiadiemDV VARCHAR(50) NOT NULL,
    PRIMARY KEY (MasoDV, DiadiemDV)
);

CREATE TABLE DUAN
(
    TanDA     VARCHAR(50) NOT NULL,
    MasoDA    INT         NOT NULL PRIMARY KEY,
    DiadiemDA VARCHAR(50) NOT NULL,
    MasoĐV    INT         NOT NULL
);

CREATE TABLE THAMGIA
(
    MasoNV INT NOT NULL,
    MasoDA INT NOT NULL,
    Sogio  INT NOT NULL,
    PRIMARY KEY (MasoNV, MasoDA)
);

CREATE TABLE PHUTHUOC
(
    MasoNV   INT         NOT NULL,
    TenCon   VARCHAR(50) NOT NULL,
    Gioitinh BOOLEAN     NOT NULL,
    Ngaysinh DATE        NOT NULL,
    PRIMARY KEY (MasoNV, TenCon)
);

ALTER TABLE NHANVIEN
    ADD FOREIGN KEY (MaSoNGS) REFERENCES NHANVIEN (MaSoNV);

ALTER TABLE NHANVIEN
    ADD FOREIGN KEY (MaSoDV) REFERENCES DONVI (MasoĐV);

ALTER TABLE NHANVIEN
    ADD FOREIGN KEY (MaSoDV) REFERENCES DONVI_DIADIEM (MasoDV);

ALTER TABLE DUAN
    ADD FOREIGN KEY (MasoĐV) REFERENCES DONVI (MasoĐV);

ALTER TABLE THAMGIA
    ADD FOREIGN KEY (MasoNV) REFERENCES NHANVIEN (MaSoNV);

ALTER TABLE THAMGIA
    ADD FOREIGN KEY (MasoDA) REFERENCES DUAN (MasoDA);

ALTER TABLE PHUTHUOC
    ADD FOREIGN KEY (MasoNV) REFERENCES NHANVIEN (MaSoNV);

ALTER TABLE DONVI
    ADD FOREIGN KEY (MasoNQL) REFERENCES NHANVIEN (MaSoNV);

ALTER TABLE DONVI_DIADIEM
    ADD FOREIGN KEY (MasoDV) REFERENCES DONVI (MasoĐV);