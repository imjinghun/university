
--SQL Server 2008 R2
--设置权限 power 依次为 1 2 3 4

--管理员表
create table managerInfo
(
        username varchar(50) primary key,
	password varchar(50)
)
--形式审核员表
create table assessorInfo
(
        username varchar(50) primary key,
	password varchar(50)
)
--部门审核员表
create table mgtInfo
(
        username varchar(50) primary key,
	password varchar(50),
        glbm     nvarchar(50)   --管理部门 
)
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
    Fax          varchar(15)   --传真
)

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
    states       varchar(5)    , --形式审核未通过为0  形式审核通过、部门未审核为1 部门审核未通过为10 通过为11 未审核为 2  保存为 3
    xsshyj       nvarchar(210) ,  --形式审核意见
    glbm         nvarchar(50) ,  --管理部门
    bmshyj       nvarchar(210)  --部门审核意见
      
)