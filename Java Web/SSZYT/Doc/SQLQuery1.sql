--SQL Server 2008 R2
--ʦ����ҵͨ���ݿ�

--����Ա��Ϣ��
create table administrator
(
	adminid	  nvarchar(20) primary key,--����Ա�˺�
	password  nvarchar(20), --����
	adminname nvarchar(20), --����
)
--��ʦ��Ϣ��
create table teacher
(
	tid	    nvarchar(20) primary key,	--�˺�
	password	nvarchar(20),	--����
	tname	nvarchar(20),	--����
	tschool	nvarchar(50),	--ѧУ����
)
--ѧ����Ϣ��
create table student
(
	sid	    nvarchar(20) primary key,	--�˺�
	password	nvarchar(20),		--����
	sno	    nvarchar(20),		--ѧ��
	sname	nvarchar(20),		--����
	sschool	nvarchar(50)		--ѧУ����
)
--��ʦ�γ���Ϣ
create table tcourse
(
	tcid	 nvarchar(20) primary key,	--�γ̺�
	tctid	 nvarchar(20) ,		--��ʦ�˺�
	tcname	 nvarchar(50) ,		--�γ���
	tcnumber int default 0 ,	--�γ�����//��ʼֵΪ0
	tctime	 nvarchar(20)		--�γ̴���ʱ��
)
--ѧ���γ���Ϣ
create table scourse
(
	scid	nvarchar(20) not null,		--�γ̺�
	scsid	nvarchar(20) not null,		--ѧ���˺�
	scname	nvarchar(50) ,		--�γ���
	sctime	nvarchar(20)  ,		--����γ�ʱ��
	foreign key(scid) references tcourse(tcid),
	foreign key(scsid) references student(sid),
	primary key(scid,scsid)
)
--��ҵ��
create table homework
(
	hid			nvarchar(20) primary key, --��ҵ��
	hcid		nvarchar(20),	--�γ̺�
	htid		nvarchar(20),	--��ʦ�˺�
	hname		nvarchar(20),	--��ҵ����
	hinfo		ntext,	--��ҵ����
	hbegintime	nvarchar(20),	--��ҵ��������
	hendtime	nvarchar(20),	--��ҵ��ֹ����
	hsubmit		int,			--���ύ����
	hnosubmit	int				--δ�ύ����
)
--��ʦ���ϱ�
create table tmaterial
(
	tmid	nvarchar(20) primary key,	--��ʦ���Ϻ�
	tmname  ntext,          --������
	tmcid	nvarchar(20),	--�γ̺�
	tmtid	nvarchar(20),	--��ʦ�˺�
	tminfo	ntext,		    --���ϴ洢·��
	tmtime	nvarchar(20)	--�����ϴ�ʱ��
)
--ѧ�����ϱ�(��Ҫ���ύ��ҵ)
create table smaterial
(
	smid	nvarchar(20) primary key,	--ѧ�����Ϻ�
	smname  ntext,          --������
	smcid	nvarchar(20),	--�γ̺�
	smsid	nvarchar(20),	--ѧ���˺�
	sminfo	ntext,		    --���ϴ洢·��
	smtime	nvarchar(20),	--�����ϴ�ʱ��
	smhid	nvarchar(20)	--��ҵ��  
)
--���Ա�
create table message
(
	mid		nvarchar(20) primary key,--���Ժ�
	mhid	nvarchar(20),	--��ҵ��
	mcid	nvarchar(20),	--�γ̺�
	msid	nvarchar(20),	--ѧ���˺�
	mtid	nvarchar(20),	--��ʦ�˺�
	msg		ntext			--��������
)

