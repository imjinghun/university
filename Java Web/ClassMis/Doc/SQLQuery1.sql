--SQL Server2008 R2
--�༶����ϵͳ

--�༶��
create table classes
(
	cid nvarchar(20) primary key,--���
	cname nvarchar(20)	--����
)
--�γ̱�
create table course
(
	crid nvarchar(20) primary key,--���
	crname nvarchar(20),	--����
	crnature nvarchar(20), --�γ����ʣ����� ѡ�� ѧλ��
	crcredit float --ѧ��
)
--ѧ����
create table student
(
	sid nvarchar(20) primary key,--ѧ��
	spwd nvarchar(20) ,--����
	scid nvarchar(20) references classes(cid),--�༶���
	sname nvarchar(20),	--����
	ssex nvarchar(20), --�Ա� �� Ů
	sbirth nvarchar(20), --��������
	stel nvarchar(20),--��ϵ�绰
	saddress nvarchar(20)--��ͥסַ
)
--�ɼ���
create table grade
(
	sid nvarchar(20),--ѧ��
	crid nvarchar(20),--�γ̱��
	ggrade float, --�ɼ�
	foreign key (sid) references student(sid),
	foreign key (crid) references course(crid),
	primary key(sid,crid)
)