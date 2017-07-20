<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>试验</title>
    </head>
    <body>
        
        <?php
       $s= scandir('D:\xampp');
       foreach ($s as $v) {
            echo "{$v}<br/>";
        }
        ?>
    </body>
</html>
