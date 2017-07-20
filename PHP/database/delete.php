<?php
$con=  mysqli_connect('localhost',"root","");//连接服务器
mysqli_select_db($con,"my_db");//选数据库my_db
/*mysqli_query($con,"set name UTF-8");//设置连接编码为简体中文
$sql="select * from namer";//查询所有内容
$result=mysqli_query($con,$sql);//执行查询
$num=  mysqli_num_rows($result);//获取结果数（行数）
echo '表namer中共有 '.$num.' 条数据';
echo "<p>";
$sql2="delete from namer where id>=1";//删除id为1及以上的数据
$r=  mysqli_query($con, $sql2);

if($r)
    echo '删除成功'."<br>";
else 
    echo '删除失败'."<br>";

$result=  mysqli_query($con, $sql);
$num=  mysqli_num_rows($result);//获取结果数（行数）
echo '表namer中共有 '.$num.' 条数据';*/
$a="drop database my_db";
if($a)
    echo '1';
else
    echo '2';

