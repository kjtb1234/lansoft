<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>步长制药 - 文件签批流转管理平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/Mana_Admin.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/BaseUrl.js"></script>
<script type="text/javascript" src="../js/CookieUtil.js"></script>
<script type="text/javascript" src="../js/Mana_admin.js"></script>
</head>
<body
	style="background-color: #1c77ac; background-image:url(../imgs/background.jpg); background-repeat:no-repeat; background-position:center top; overflow:hidden; background-size: cover;
	  -webkit-background-size: cover;
	  -o-background-size: cover;">
	<div class="loginbody"
		style="width:700px;height: 470px;position: absolute;top: 0;left: 0;bottom: 0;right: 0; margin: auto;">
		<div class="loginbox"  align="center"
			style="padding-top: 82px;padding-bottom: 46px;">
			<ul>
				<li><input id="telphone" type="text" class="loginuser"
					placeholder="请输入手机号码"
					onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" />
				</li>
				</br>
				<li><input id="pwd" type="password" class="loginpwd"
					placeholder="密码" onkeydown="KeyDown()" />
				</li>
				<li></br><input
					type="button" class="loginbtn" value="登录" onclick="admin();" />
				</li>
			</ul>
		</div>
	</div>
	<div class="loginbm">
		Copyright &copy;2018 陕西蓝软信息科技有限公司</a>
	</div>
</body>
</html>

