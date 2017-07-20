--作业表
create table homework
(
hid			nvarchar(20) primary key, --作业号
hcid		nvarchar(20),	--课程号
htid		nvarchar(20),	--老师账号
hname		nvarchar(20),	--作业名称
hinfo		text,	--作业内容
hbegintime	varchar(20),	--作业创建日期
hendtime	varchar(20),	--作业截止日期
hsubmit		int,			--已提交人数
hnosubmit	int				--未提交人数
)
--老师课程表
create table tcourse
(
	tcid		nvarchar(20) primary key,--课程号
	tctid		nvarchar(20),	--老师账号
	tcname		nvarchar(20),	--课程名称
	tcnumber	int ,			--课程人数
	tctime		varchar(20),	--创建时间
)
--留言表
create table message
(
	mid		nvarchar(20) primary key,--留言号
	mhid	nvarchar(20),	--作业号
	mcid	nvarchar(20),	--课程号
	msid	nvarchar(20),	--学生账号
	mtid	nvarchar(20),	--老师账号
	msg		text			--留言内容
)