--SQL Server2008 R2
--班级管理系统

--班级表
create table classes
(
	cid nvarchar(20) primary key,--编号
	cname nvarchar(20)	--名称
)
--课程表
create table course
(
	crid nvarchar(20) primary key,--编号
	crname nvarchar(20),	--名称
	crnature nvarchar(20), --课程性质（必修 选修 学位）
	crcredit float --学分
)
--学生表
create table student
(
	sid nvarchar(20) primary key,--学号
	spwd nvarchar(20) ,--密码
	scid nvarchar(20) references classes(cid),--班级编号
	sname nvarchar(20),	--姓名
	ssex nvarchar(20), --性别 男 女
	sbirth nvarchar(20), --出生日期
	stel nvarchar(20),--联系电话
	saddress nvarchar(20)--家庭住址
)
--成绩表
create table grade
(
	sid nvarchar(20),--学号
	crid nvarchar(20),--课程编号
	ggrade float, --成绩
	foreign key (sid) references student(sid),
	foreign key (crid) references course(crid),
	primary key(sid,crid)
)