<html>
    <head>
        <meta charset="UTF-8">
        <title>音乐</title>
    </head>
    <body>
        <center>
            <h2>上传音乐</h2>
            
                <form action="upload.php" method="post" ENCTYPE="multipart/form-data">
                    <table border=1>
                    <td>选择音乐</td>
                    <td><input type="file" name="up_file"></td>
                    <td colspan="2"><center><input type="submit" value="上传"></center></td>
                    </table>
                </form>
            <h2>已有音乐</h2>
        </center>
        <?php
        $dir = opendir('music');
        while(($file = readdir($dir))!=false){
        if ($file!="." && $file!="..") { 
        $ns = explode('.', $file);
        echo $ns[0];
            } 
        }
        closedir($dir);
        ?>
    </body>
</html>



