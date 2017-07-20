<?php
$con=  mysqli_connect('localhost',"root","");//连接服务器
mysqli_select_db($con,"my_db");//选数据库my_db
mysqli_query($con,"set name UTF-8");//设置连接编码为简体中文
$insert="insert into namer(name,age,sex)values('奇侠',20,'男'),";//插入数据 一条
$insert .="('奇',20,'男'),";//插入数据   多条时写法
$insert .="('奇门',22,'男')";//插入数据
//$re=mysqli_query($con, $insert); 插入一条执行方法
$re=mysqli_multi_query($con, $insert);//插入多条执行方法
if($re)
    echo '成功插入数据';
else
    echo '插入数据失败';


