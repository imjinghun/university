<?php
$con=  mysqli_connect('localhost',"root","");//连接服务器
mysqli_select_db($con,"my_db");//选数据库my_db
mysqli_query($con,"set name GB2312");//设置连接编码为简体中文
$sql="select * from namer";//查询所有内容
$result=mysqli_query($con,$sql);//执行查询
$num=  mysqli_num_rows($result);//获取结果数（行数）
echo '表namer中共有 '.$num.' 条数据'."<br>".'修改前内容';
echo "<table border=\"1\">";//输出表头
echo"<tr>
    <td>序号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>性别</td>
</tr>";
while( $row=mysqli_fetch_array($result)){
    echo "<tr>";
    echo "<td>".$row["id"]."</td>";
    echo "<td>".$row['name']."</td>";
    echo "<td>".$row['age']."</td>";
    echo "<td>".$row['sex']."</td>";
    echo "</tr>";
}
echo "</table>";

$sql2="update namer set name='侠' where id=10";
$re=mysqli_query($con, $sql2);
if($re)
    echo "更新成功";
else 
    echo '更新失败';
$result=mysqli_query($con,$sql);//执行查询
$num=  mysqli_num_rows($result);//获取结果数（行数）
echo '表namer中共有 '.$num.' 条数据'."<br>".'修改后内容';
echo "<table border=\"1\">";//输出表头
echo"<tr>
    <td>序号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>性别</td>
</tr>";
while( $row=mysqli_fetch_array($result)){
    echo "<tr>";
    echo "<td>".$row["id"]."</td>";
    echo "<td>".$row['name']."</td>";
    echo "<td>".$row['age']."</td>";
    echo "<td>".$row['sex']."</td>";
    echo "</tr>";
}
echo "</table>";