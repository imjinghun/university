<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

</head>
<body>
	<div style="text-align:center;">
		<form>
			<table width="100%">
                <tr style="font-weight:bold;background-color:#969696;">
                    <td width="20%" align="center">权限名称</td>
                    <td width="" align="center">权限说明</td>
                    <td width="10%" align="center">是否赋予</td>
                </tr>
                <tr>
                    <td> 需求征集</td>
                    <td>可以填报需求</td>
                    <td>
                    <input type="checkbox" name="xqzj" id="xqzj"/>
                    </td>
                </tr>
                <tr>
                    <td> 需求管理</td>
                    <td>对需求进行查看、删除、修改等</td>
                    <td>
                    <input type="checkbox" name="xqgl" id="xqgl"/>
                    </td>
                </tr>
                <tr>
                    <td>用户信息</td>
                    <td>查看修改个人信息等</td>
                    <td>
                    <input type="checkbox" name="yhxx" id="yhxx"/>
                    </td>
                </tr>
                <tr>
                    <td>修改密码</td>
                    <td>修改个人密码</td>
                    <td>
                    <input type="checkbox" name="xgmm" id="xgmm"/>
                    </td>
                </tr>
                <tr>
                    <td>分类检索</td>
                    <td>可以分类进行检索</td>
                    <td>
                    <input type="checkbox" name="fljs" id="fljs"/>
                    </td>
                </tr>
                <tr>
                    <td>综合检索</td>
                    <td>可以进行综合检索</td>
                    <td>
                    <input type="checkbox" name="zhjs" id="zhjs"/>
                    </td>
                </tr>
                <tr>
                    <td>统计图表</td>
                    <td>可以按类别进行图表统计</td>
                    <td>
                    <input type="checkbox" name="tjtb" id="tjtb"/>
                    </td>
                </tr>
                <tr>
                    <td>系统介绍</td>
                    <td>可以查看系统介绍</td>
                    <td>
                    <input type="checkbox" name="xtjs" id="xtjs"/>
                    </td>
                </tr>
                <tr>
                    <td>用户密码重置</td>
                    <td>将需求填报员密码重置为123456</td>
                    <td>
                    <input type="checkbox" name="mmcz" id="mmcz"/>
                    </td>
                </tr>
                <tr>
                    <td>形式审核</td>
                    <td>可以进行形式审核</td>
                    <td>
                    <input type="checkbox" name="xssh" id="xssh"/>
                    </td>
                </tr>
                <tr>
                    <td>部门审核</td>
                    <td>可以进行部门审核</td>
                    <td>
                    <input type="checkbox" name="bmsh" id="bmsh"/>
                    </td>
                </tr>
            </table>
        </form>
	</div>
</body>
</html>