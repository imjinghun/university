<?php
$con=  mysqli_connect('localhost',"root","");//连接服务器
mysqli_select_db($con,"my_db");//选数据库my_db
mysqli_query($con,"set name UTF-8");//设置连接编码为简体中文
$sql="select * from namer";//查询所有内容
$result=mysqli_query($con,$sql);//执行查询
$num=  mysqli_num_rows($result);//获取结果数（行数）
echo '表namer中共有 '.$num.' 条数据';
echo "<table border=\"1\">";//输出表头
echo"<tr>
    <td>序号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>性别</td>
</tr>";
//$row=  mysqli_fetch_array($result);//结果集类型 数组

while( $row=mysqli_fetch_array($result)){
    echo "<tr>";
    echo "<td>".$row["id"]."</td>";
    echo "<td>".$row['name']."</td>";
    echo "<td>".$row['age']."</td>";
    echo "<td>".$row['sex']."</td>";
    echo "</tr>";
}

echo "</table>";
