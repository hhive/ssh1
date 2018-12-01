
-- # alter table xsb modify column xb enum('1','2');
-- # alter table cjb drop primary key ;
-- # alter table cjb add primary key (xh,kch);
-- # 开始周数 结束周数 周几 节数（1,2,3,4,5）开课专业
-- we don't know how to generate schema xscjgl (class Schema) :(
create table cjb
(
  xh char(6) not null,
  kch char(3) not null,
  cj int null,
  xf int null,
  primary key (xh, kch)
)
;

-- create table kcb
-- (
--   kch char(3) not null
--     primary key,
--   kcm char(12) null,
--   kxxq enum('1', '2', '3', '4', '5', '6', '7', '8') null,
--   xs int null,
--   xf int null
-- )
-- ;
create table kcb
(
  kch char(3) not null primary key,
  kcm char(12) not null,
  kxxq enum('1', '2', '3', '4', '5', '6', '7', '8') not null,
  xs int not null,
  xf int not null,
  weekBegin int not null ,
  weekEnd int not null,
  weekDay enum('1', '2', '3', '4', '5', '6', '7') not null,
  lesson enum('1', '2', '3', '4', '5') not null,
  zy_id int not null,
  destination varchar(255) not null,
  foreign key (zy_id) references Zyb (id)
)

create table xs_kcb
(
  xh varchar(6) not null,
  kch varchar(3) not null,
  primary key (xh, kch)
)
;

create table zyb
(
  id int auto_increment
    primary key,
  zym char(12) not null,
  rs int null,
  fdy char(8) null
)
;

create table xsb
(
  xh char(6) not null
    primary key,
  xm char(8) not null,
  xb enum('1', '2') null,
  cssj date null,
  zy_id int not null,
  zxf int null,
  bz varchar(500) null,
  zp blob null,
  constraint xsb_ibfk_1
  foreign key (zy_id) references Zyb (id)
)
;

create table dlb
(
  id int not null
    primary key,
  xh char(6) not null,
  kl char(20) null,
  constraint dlb_ibfk_1
  foreign key (xh) references Xsb (xh)
)
;

create index xh
  on dlb (xh)
;

create index zy_id
  on xsb (zy_id)
;

INSERT INTO `xscjgl`.`Zyb` (`id`, `zym`, `rs`, `fdy`) VALUES (6, '网络工程', 60, '万老师');
INSERT INTO `xscjgl`.Xsb (`xh`, `xm`, `xb`, `cssj`, `zy_id`, `zxf`, `bz`, `zp`)VALUES ('002', '陈明', '1', '1991-02-01', 5, 50, 'NULL', NULL);
INSERT INTO `xscjgl`.Xsb (`xh`, `xm`, `xb`, `cssj`, `zy_id`, `zxf`, `bz`, `zp`)VALUES ('003', '王燕', '1', '1992-03-01', 5, 50, '好人', NULL);
INSERT INTO `xscjgl`.Xsb (`xh`, `xm`, `xb`, `cssj`, `zy_id`, `zxf`, `bz`, `zp`)VALUES ('001', '王琳', '2', '1990-02-10', 5, 50, 'NULL', NULL);
INSERT INTO `xscjgl`.Dlb (`id`, `xh`, `kl`)VALUES (1, '001', '123456');
INSERT INTO `xscjgl`.Dlb (`id`, `xh`, `kl`)VALUES (2, '002', '123456');
INSERT INTO `xscjgl`.`kcb` (`kch`, `kcm`, `kxxq`, `xs`, `xf`, `weekBegin`, `weekEnd`, `weekDay`, `lesson`, `zy_id`) VALUES ('1001', 'web前端开发', '5', 56, 2, 1, 11, '1', '1', 5);
INSERT INTO `xscjgl`.`kcb` (`kch`, `kcm`, `kxxq`, `xs`, `xf`, `weekBegin`, `weekEnd`, `weekDay`, `lesson`, `zy_id`) VALUES ('101', 'web前端开发', '5', 56, 2, 1, 11, '1', '1', 5);
-- INSERT INTO `xscjgl`.Kcb (`kch`, `kcm`, `kxxq`, `xs`, `xf`)VALUES ('101', '计算机导论', '1', 80, 5);
-- INSERT INTO `xscjgl`.Kcb (`kch`, `kcm`, `kxxq`, `xs`, `xf`)VALUES ('102', '程序设计与语言', '2', 68, 4);
-- INSERT INTO `xscjgl`.Kcb (`kch`, `kcm`, `kxxq`, `xs`, `xf`)VALUES ('206', '离散数学', '3', 68, 4);