--设置权限 powers 依次为admin assessor mgt users  对应 管理员 形式审核员 部门审核员 用户

--用户表
Create table userInfo
(
    Username     varchar(50) primary key,
    Password     varchar(50) ,
    Organcode    varchar(50) ,  --机构代码
    Organname    nvarchar(100),  --机构名称
    parentmgt    nvarchar(50) , --归口管理部门 
    Contactaddr  nvarchar(100),  --通讯地址
    Unitweb      varchar(255) ,  --单位网址
    Email        varchar(50) ,  --电子信箱
    Legalperson  nvarchar(20),  --法人代表
    Postcode     varchar(10) ,  --邮政编码
    Contacts     nvarchar(20),  --联系人
    Tel          varchar(15) ,  --固话
    Phone        varchar(15) ,  --手机
    Fax          varchar(15),   --传真
    Glbm         nvarchar(50) ,  --管理处室 部门审核员需要有
    Powers       nvarchar(20)  --角色
)
--管理部门
<option value="001办公室">001办公室</option>
						        	<option value="002人事处">002人事处</option>
						        	<option value="003机关党委">003机关党委</option>
						        	<option value="004政策法规处">004政策法规处</option>
						        	<option value="005计划财务处">005计划财务处</option>
						        	<option value="006平台与基础处">006平台与基础处</option>
						        	<option value="007国际合作处">007国际合作处</option>
						        	<option value="008高新技术处">008高新技术处</option>
						        	<option value="009农村科技处">009农村科技处</option>
						        	<option value="010社会发展处">010社会发展处</option>
						        	<option value="011成果与市场处">011成果与市场处</option>
						        	<option value="012监察室">012监察室</option>
						        	<option value="013离退休干部处">013离退休干部处</option>
						        	<option value="014知识产权局">014知识产权局</option>
						        	<option value="015半干旱中心">015半干旱中心</option>
						        	<option value="016山办">016山办</option>
						        	<option value="017机关服务中心">017机关服务中心</option>
						        	<option value="020科技研发中心">020科技研发中心</option>
						        	<option value="021科技情报研究院">021科技情报研究院</option>
						        	<option value="022器材公司">022器材公司</option>
						        	<option value="023基金办">023基金办</option>
						        	<option value="024档案馆">024档案馆</option>
						        	<option value="025科技管理信息中心">025科技管理信息中心</option>
						        	<option value="026科技投资中心">026科技投资中心</option>
						        	<option value="027成果转换中心">027成果转换中心</option>
						        	<option value="028中小企业创新资金管理中心">028中小企业创新资金管理中心</option>
						        	<option value="029对外交流中心">029对外交流中心</option>

































--需求保存提交审核表
Create table needTable
(
    id  int identity(1,1) primary key , --编号
    Organname    nvarchar(100),  --机构名称
    parentmgt    nvarchar(50) , --归口管理部门  
    Contactaddr  nvarchar(100),  --通讯地址
    LocationArea nvarchar(20),   --所在地域
    Unitweb      varchar(255) ,  --单位网址
    Email        varchar(50) ,  --电子信箱
    Legalperson  nvarchar(20),  --法人代表
    Postcode     varchar(10) ,  --邮政编码
    Contacts     nvarchar(20),  --联系人
    Tel          varchar(15) ,  --固话
    Phone        varchar(15) ,  --手机
    Fax          varchar(15) ,  --传真
    organattr    nvarchar(20) , --机构属性
    organInfo    nvarchar(510) , --机构简介
    needname     nvarchar(100) , --需求名称
    needsyear    varchar(10)   , --需求开始年份
    needeyear    varchar(10)   , --需求结束年份
    needoverview1 nvarchar(510)  , --重大科技需求概述1
    needoverview2 nvarchar(510)  , --重大科技需求概述2
    needoverview3 nvarchar(510)  , --重大科技需求概述3
    needkey      nvarchar(100) , --关键字
    totalmoney   float ,        --资金总额
    needmodel    nvarchar(100) , --技术需求解决方式
    coopunit     nvarchar(100), --合作意向单位
    restype      nvarchar(50) , --科技活动类型
    subtype      nvarchar(100) , --学科分类
    needfield    nvarchar(200) , --需求技术所属领域
    needindustry nvarchar(100) , --需求技术应用行业
    states       nvarchar(20)    , --形式审核未通过   形式审核通过  部门审核未通过 审核通过 未审核 未提交
    xsshyj       nvarchar(210) ,  --形式审核意见
    glbm         nvarchar(50) ,  --管理部门
    bmshyj       nvarchar(210)  --部门审核意见
      
)