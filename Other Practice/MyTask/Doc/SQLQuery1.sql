--��ҵ��
create table homework
(
hid			nvarchar(20) primary key, --��ҵ��
hcid		nvarchar(20),	--�γ̺�
htid		nvarchar(20),	--��ʦ�˺�
hname		nvarchar(20),	--��ҵ����
hinfo		text,	--��ҵ����
hbegintime	varchar(20),	--��ҵ��������
hendtime	varchar(20),	--��ҵ��ֹ����
hsubmit		int,			--���ύ����
hnosubmit	int				--δ�ύ����
)
--��ʦ�γ̱�
create table tcourse
(
	tcid		nvarchar(20) primary key,--�γ̺�
	tctid		nvarchar(20),	--��ʦ�˺�
	tcname		nvarchar(20),	--�γ�����
	tcnumber	int ,			--�γ�����
	tctime		varchar(20),	--����ʱ��
)
--���Ա�
create table message
(
	mid		nvarchar(20) primary key,--���Ժ�
	mhid	nvarchar(20),	--��ҵ��
	mcid	nvarchar(20),	--�γ̺�
	msid	nvarchar(20),	--ѧ���˺�
	mtid	nvarchar(20),	--��ʦ�˺�
	msg		text			--��������
)