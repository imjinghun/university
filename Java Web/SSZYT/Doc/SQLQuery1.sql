--SQL Server 2008 R2
--师生作业通数据库

--管理员信息表
create table administrator
(
	adminid	  nvarchar(20) primary key,--管理员账号
	password  nvarchar(20), --密码
	adminname nvarchar(20), --姓名
)
--老师信息表
create table teacher
(
	tid	    nvarchar(20) primary key,	--账号
	password	nvarchar(20),	--密码
	tname	nvarchar(20),	--姓名
	tschool	nvarchar(50),	--学校名称
)
--学生信息表
create table student
(
	sid	    nvarchar(20) primary key,	--账号
	password	nvarchar(20),		--密码
	sno	    nvarchar(20),		--学号
	sname	nvarchar(20),		--姓名
	sschool	nvarchar(50)		--学校名称
)
--老师课程信息
create table tcourse
(
	tcid	 nvarchar(20) primary key,	--课程号
	tctid	 nvarchar(20) ,		--老师账号
	tcname	 nvarchar(50) ,		--课程名
	tcnumber int default 0 ,	--课程人数//初始值为0
	tctime	 nvarchar(20)		--课程创建时间
)
--学生课程信息
create table scourse
(
	scid	nvarchar(20) not null,		--课程号
	scsid	nvarchar(20) not null,		--学生账号
	scname	nvarchar(50) ,		--课程名
	sctime	nvarchar(20)  ,		--加入课程时间
	foreign key(scid) references tcourse(tcid),
	foreign key(scsid) references student(sid),
	primary key(scid,scsid)
)
--作业表
create table homework
(
	hid			nvarchar(20) primary key, --作业号
	hcid		nvarchar(20),	--课程号
	htid		nvarchar(20),	--老师账号
	hname		nvarchar(20),	--作业名称
	hinfo		ntext,	--作业内容
	hbegintime	nvarchar(20),	--作业创建日期
	hendtime	nvarchar(20),	--作业截止日期
	hsubmit		int,			--已提交人数
	hnosubmit	int				--未提交人数
)
--老师资料表
create table tmaterial
(
	tmid	nvarchar(20) primary key,	--老师资料号
	tmname  ntext,          --资料名
	tmcid	nvarchar(20),	--课程号
	tmtid	nvarchar(20),	--老师账号
	tminfo	ntext,		    --资料存储路径
	tmtime	nvarchar(20)	--资料上传时间
)
--学生资料表(主要是提交作业)
create table smaterial
(
	smid	nvarchar(20) primary key,	--学生资料号
	smname  ntext,          --资料名
	smcid	nvarchar(20),	--课程号
	smsid	nvarchar(20),	--学生账号
	sminfo	ntext,		    --资料存储路径
	smtime	nvarchar(20),	--资料上传时间
	smhid	nvarchar(20)	--作业号  
)
--留言表
create table message
(
	mid		nvarchar(20) primary key,--留言号
	mhid	nvarchar(20),	--作业号
	mcid	nvarchar(20),	--课程号
	msid	nvarchar(20),	--学生账号
	mtid	nvarchar(20),	--老师账号
	msg		ntext			--留言内容
)

