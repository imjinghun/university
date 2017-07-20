create table UserInfo
(
username nvarchar(20) primary key,
password nvarchar(20)
)

create table BookInfo
(
id nvarchar(20) primary key,
name nvarchar(20),
isbn nvarchar(20)
)