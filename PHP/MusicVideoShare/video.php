<html>
    <head>
        <meta charset="UTF-8">
        <title>视频</title>
    </head>
    <body>
        <center>
            <h2>上传视频</h2>
            
                <form action="upload.php" method="post" ENCTYPE="multipart/form-data">
                    <table border=1>
                    <td>选择视频</td>
                    <td><input type="file" name="up_file"></td>
                    <td colspan="2"><center><input type="submit" value="上传"></center></td>
                    </table>
                </form>
            <h2>已有视频</h2>
        </center>
        <?php
        // put your code here
        ?>
    </body>
</html>

