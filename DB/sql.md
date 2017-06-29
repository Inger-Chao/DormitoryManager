
Apartment

```mysql
use apartments;
create table Apartment(
ApartNo varchar(12) not null primary key,
ApartName varchar(10) not null unique,
ApartLocation varchar(30),
ApartFloor smallint,
ApartMax smallint,
ApartIn smallint);
```

```mysql
/*当公寓插入一条元组时，会自动向apartmanager表插入一条元组，公寓号等于这条公寓号，职工号赋值为空*/
CREATE DEFINER=`root`@`localhost` TRIGGER `apartments`.`apartment_AFTER_INSERT` 
AFTER INSERT ON `apartment` 
FOR EACH ROW
BEGIN
insert into apartmanager(ApartNo)
values(new.ApartNo);
END
```

Administrator
```mysql
create table Administartor(
AdminNo varchar(12) not null primary key,
AdminName varchar(10) not null unique,
AdminSex varchar(2) check(AdminSex in ('m','f')),
AdminAge smallint,
AdminTel varchar(11) not null,
ApartNo varchar(12),
AdminAddr varchar(50),
AdminWorkYead smallint,
password varchar(16) not null default '123456',
foreign key(ApartNo) references apartment(ApartNo));
```

Apartment-Administrator

```mysql
create table ApartManager(
ApartNo varchar(12) ,
AdminNo varchar(12) ,
foreign key(ApartNo) references Apartment(ApartNo));
```

```mysql
alter table apartmanager
add constraint foreign_Admin foreign key(AdminNo) references administartor(AdminNo);
```

Dorm
```mysql
create table Dorm(
DormNo varchar(12),
ApartNo varchar(12),
DormBed smallint,
DormIn smallint,
primary key(DormNo,ApartNo),
foreign key(ApartNo) references apartment(ApartNo));
/*当插入一个元组到寝室表时，会自动向live添加他最大床位数个床位*/
CREATE DEFINER=`root`@`localhost` TRIGGER `apartments`.`dorm_AFTER_INSERT` 
AFTER INSERT ON `dorm` 
FOR EACH ROW
BEGIN
set @i=0;
lp1 : loop
set @i=@i+1;
insert into live(apartNo,dormNo,bedNo) values(new.apartNo,new.dormNo,@i);
if @i>=new.DormBed
then
LEAVE lp1;
end if;
end loop;
insert into dormmanager(apartNo,DormNo) values(new.apartNo,new.dormNo);
END
```
Student
```mysql
create table Student(
SNo varchar(12) not null primary key,
SName varchar(10) not null unique,
SSex varchar(2) check ( SSex in ('m' and 'f')),
STel varchar(11) not null,
SAcademic varchar(20),
SDept varchar(20),
ApartNo varchar(12),
DormNo varchar(12),
BedNo smallint,
password varchar(16) not null default '000000',
Saddress varchar(50),
foreign key(ApartNo,DormNo) references Dorm(ApartNo,DormNo));
/*当插入一个学生时，更新live表，把对应的床位号传入这个学生的学号*/
CREATE DEFINER=`root`@`localhost` TRIGGER `apartments`.`student_AFTER_INSERT` AFTER INSERT ON `student` FOR EACH ROW
BEGIN
update live set sno=new.sno 
where apartNo=new.apartNo and dormno=new.dormNo and bedNo=new.bedNo;
END
/*当一个学生被删除时，把live表原先住的床学号设置为空*/
CREATE DEFINER=`root`@`localhost` TRIGGER `apartments`.`student_AFTER_DELETE` 
AFTER DELETE ON `student` 
FOR EACH ROW
BEGIN
update live set sno=''
where SNo=old.SNo;
END
```

Live
```mysql
create table live(
Apartno varchar(12),
DormNo varchar(12),
bedNo smallint check(bedNo >= 1 AND bedNo <= 10),
SNo varchar(12),
primary key(ApartNo,DormNo,bedNo),
foreign key(ApartNo,DormNo) references Dorm(ApartNo,DormNo),
foreign key(SNo) references Student(Sno));
```

DormManager
```mysql
create table DormManager(
ApartNo varchar(12),
DormNo varchar(12),
BedNo smallint,
primary key(ApartNo,DormNo),
foreign key(ApartNo, DormNo,BedNo) references live(ApartNo,DormNo,BedNo));
```

Advice
```mysql
create table Advice(
id int primary key,
apartNo varchar(12),
advice varchar(200),
date DATE,
foreign key(apartNo) references apartment(apartNo))
/*每次插入前找到id最大值，把新元组id赋值为最大值+1*/
CREATE DEFINER=`root`@`localhost` TRIGGER `apartments`.`advice_BEFORE_INSERT` 
BEFORE INSERT ON `advice` 
FOR EACH ROW
BEGIN
set @i=(SELECT max(id) from advice);
set new.id=@i+1;
END
```

```mysql
create table supervisor(
id varchar(12) primary key default 'nucnuc',
password varchar(16) not null default 'nucnuc');
```

数据库管理员在每次公寓新建时会 创建一个名为该公寓号的视图 来查看该公寓内的学生
```mysql
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `a01` AS
    SELECT 
        `dorm`.`DormNo` AS `dormNo`,
        `live`.`bedNo` AS `bedNo`,
        `live`.`SNo` AS `Sno`,
        `student`.`SName` AS `Sname`,
        `student`.`STel` AS `STel`
    FROM
        ((`dorm`
        JOIN `live`)
        JOIN `student`)
    WHERE
        ((`dorm`.`ApartNo` = `live`.`Apartno`)
            AND (`dorm`.`DormNo` = `live`.`DormNo`)
            AND (`live`.`SNo` = `student`.`SNo`)
            AND (`dorm`.`ApartNo` = 'A01'))
    ```
