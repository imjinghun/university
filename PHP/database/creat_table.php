<?php
$con=  mysqli_connect('localhost',"root","");//连接服务器
if($con){
    $select = mysqli_select_db($con,"my_db");//选数据库
    if($select)
        echo '选择数据库成功'."<br>";
    else 
        echo '选择数据库失败'."<br>";
    $sql="create table namer
    (
    id int(5) not null auto_increment primary key,
    name varchar(10) not null, 
    age int(5) not null, 
    sex varchar(10) not null
    )";//定义表有四列，列名分别为id name age sex
    $do=mysqli_query($con,$sql);//创建表sql
    if($do)
        echo '在my_db数据库中成功创建表namer'."<br>";
    else
        echo '创建表失败'."<br>";
}
else
    echo '连接服务器失败'."<br>";
 