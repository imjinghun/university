<?php
$host="localhost";
$user="root";
$password="";
$con=  mysqli_connect($host,$user,$password);
if($con)
    echo '成功连接到服务器 '.$host;
else 
    echo '连接失败';
