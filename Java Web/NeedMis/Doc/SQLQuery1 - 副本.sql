--����Ȩ�� powers ����Ϊadmin assessor mgt users  ��Ӧ ����Ա ��ʽ���Ա �������Ա �û�

--�û���
Create table userInfo
(
    Username     varchar(50) primary key,
    Password     varchar(50) ,
    Organcode    varchar(50) ,  --��������
    Organname    nvarchar(100),  --��������
    parentmgt    nvarchar(50) , --��ڹ����� 
    Contactaddr  nvarchar(100),  --ͨѶ��ַ
    Unitweb      varchar(255) ,  --��λ��ַ
    Email        varchar(50) ,  --��������
    Legalperson  nvarchar(20),  --���˴���
    Postcode     varchar(10) ,  --��������
    Contacts     nvarchar(20),  --��ϵ��
    Tel          varchar(15) ,  --�̻�
    Phone        varchar(15) ,  --�ֻ�
    Fax          varchar(15),   --����
    Glbm         nvarchar(50) ,  --������ �������Ա��Ҫ��
    Powers       nvarchar(20)  --��ɫ
)
--������
<option value="001�칫��">001�칫��</option>
						        	<option value="002���´�">002���´�</option>
						        	<option value="003���ص�ί">003���ص�ί</option>
						        	<option value="004���߷��洦">004���߷��洦</option>
						        	<option value="005�ƻ�����">005�ƻ�����</option>
						        	<option value="006ƽ̨�������">006ƽ̨�������</option>
						        	<option value="007���ʺ�����">007���ʺ�����</option>
						        	<option value="008���¼�����">008���¼�����</option>
						        	<option value="009ũ��Ƽ���">009ũ��Ƽ���</option>
						        	<option value="010��ᷢչ��">010��ᷢչ��</option>
						        	<option value="011�ɹ����г���">011�ɹ����г���</option>
						        	<option value="012�����">012�����</option>
						        	<option value="013�����ݸɲ���">013�����ݸɲ���</option>
						        	<option value="014֪ʶ��Ȩ��">014֪ʶ��Ȩ��</option>
						        	<option value="015��ɺ�����">015��ɺ�����</option>
						        	<option value="016ɽ��">016ɽ��</option>
						        	<option value="017���ط�������">017���ط�������</option>
						        	<option value="020�Ƽ��з�����">020�Ƽ��з�����</option>
						        	<option value="021�Ƽ��鱨�о�Ժ">021�Ƽ��鱨�о�Ժ</option>
						        	<option value="022���Ĺ�˾">022���Ĺ�˾</option>
						        	<option value="023�����">023�����</option>
						        	<option value="024������">024������</option>
						        	<option value="025�Ƽ�������Ϣ����">025�Ƽ�������Ϣ����</option>
						        	<option value="026�Ƽ�Ͷ������">026�Ƽ�Ͷ������</option>
						        	<option value="027�ɹ�ת������">027�ɹ�ת������</option>
						        	<option value="028��С��ҵ�����ʽ��������">028��С��ҵ�����ʽ��������</option>
						        	<option value="029���⽻������">029���⽻������</option>

































--���󱣴��ύ��˱�
Create table needTable
(
    id  int identity(1,1) primary key , --���
    Organname    nvarchar(100),  --��������
    parentmgt    nvarchar(50) , --��ڹ�����  
    Contactaddr  nvarchar(100),  --ͨѶ��ַ
    LocationArea nvarchar(20),   --���ڵ���
    Unitweb      varchar(255) ,  --��λ��ַ
    Email        varchar(50) ,  --��������
    Legalperson  nvarchar(20),  --���˴���
    Postcode     varchar(10) ,  --��������
    Contacts     nvarchar(20),  --��ϵ��
    Tel          varchar(15) ,  --�̻�
    Phone        varchar(15) ,  --�ֻ�
    Fax          varchar(15) ,  --����
    organattr    nvarchar(20) , --��������
    organInfo    nvarchar(510) , --�������
    needname     nvarchar(100) , --��������
    needsyear    varchar(10)   , --����ʼ���
    needeyear    varchar(10)   , --����������
    needoverview1 nvarchar(510)  , --�ش�Ƽ��������1
    needoverview2 nvarchar(510)  , --�ش�Ƽ��������2
    needoverview3 nvarchar(510)  , --�ش�Ƽ��������3
    needkey      nvarchar(100) , --�ؼ���
    totalmoney   float ,        --�ʽ��ܶ�
    needmodel    nvarchar(100) , --������������ʽ
    coopunit     nvarchar(100), --��������λ
    restype      nvarchar(50) , --�Ƽ������
    subtype      nvarchar(100) , --ѧ�Ʒ���
    needfield    nvarchar(200) , --��������������
    needindustry nvarchar(100) , --������Ӧ����ҵ
    states       nvarchar(20)    , --��ʽ���δͨ��   ��ʽ���ͨ��  �������δͨ�� ���ͨ�� δ��� δ�ύ
    xsshyj       nvarchar(210) ,  --��ʽ������
    glbm         nvarchar(50) ,  --������
    bmshyj       nvarchar(210)  --����������
      
)