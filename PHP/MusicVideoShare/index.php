<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>MuViShare</title>
    </head>
    <body> 
        <!--<center>-->
        <form action="index.php" method="get">
            <p>用户登录</p>
            <p>帐号：<input type="text" name="name"></p>
            <p>密码：<input type="password" name="pass"></p>
            <p>
                <input type="submit" value="登录">
                <!--<input type="reset" value="取消">-->
            </p>
        </form>
        <h2>
        <a href="music.php" target="_blank">音乐</a><br/><br/><a href="video.php" target="_blank">视频</a>
        <?php
        ?>
        </h2>   
        <!--</center>-->
    </body>
</html>
