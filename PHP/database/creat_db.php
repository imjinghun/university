<?php
$con=  mysqli_connect('localhost',"root","");//连接服务器
$result=  mysqli_query($con,"create database my_db");//创建数据库
 if($result)
    echo '成功创建数据库my_db';
 else 
    echo '创建数据库失败';

