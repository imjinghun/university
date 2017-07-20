<?php
if ($_FILES["up_file"]["name"] == "") {
    echo '没选择文件' . "<br>";
    echo "点<a href=\"upload.htm\">这里</a>返回";
}
 else {
     $filepath="upload/";
     $name=$filepath.$_FILES["up_file"]["name"];
     while(file_exists($name)){
         $temp=explode(".",$name);
         $name=$temp[0]."0".".".$temp[1];
     }
     if(move_uploaded_file($_FILES["up_file"]["tmp_name"], $name)){
         echo '名为 '.$_FILES["up_file"]["name"].' 的文件上传'."<br>";
         echo "点<a href=\"upload.htm\">这里</a>返回";
     }
     else{
         echo '文件上传发生错误！'."<br>";
         echo "点<a href=\"upload.htm\">这里</a>返回";
     }
}

