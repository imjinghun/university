<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="../dist/css/bootstrap.min.css" />
        <script src="../dist/js/jquery-3.1.1.min.js"></script>
        <script src="../dist/js/bootstrap.min.js"></script>
        <style type="text/css">
            div {
                position: relative;
            }
            
            ul {
                display: block;
                width: 300px;
                margin: 0 auto;
                position: relative;
            }
        </style>
    </head>


    <body>
        <div style="width:95%;left:2.5%;">
            <div class="tabbable" style="top:10px;">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#yh" data-toggle="tab">用户管理</a>
                    </li>
                    <li>
                        <a href="#qx" data-toggle="tab">权限管理</a>
                    </li>
                     <li>
                        <a href="#js" data-toggle="tab">角色管理</a>
                    </li>
                </ul>
                <div class="tab-content" style="border:1px solid #3B3B3B; ">
                    <div class="tab-pane  active" id="yh">
                       <div style="text-align:center;"> <font style="font-weight:bold;font-size:25px;">用户管理</font> </div>
                    <jsp:include page="yhgl.jsp" flush="true"></jsp:include>
                    </div>
                    <div class="tab-pane" id="qx">
                        <p>
                           权限管理
                        </p>
                    </div>
                    <div class="tab-pane" id="js">
                        <p>
                            角色管理
                        </p>
                    </div>
                </div>
            </div>


        </div>
    </body>

    </html>