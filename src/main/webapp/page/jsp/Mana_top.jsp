<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/media.css" />
<link href="../css/leftstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../css/jquery.gritter.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/CookieUtil.js"></script>
</head>
<style>
body {
	font-family: "微软雅黑";
}

.more {
	background: none !important;
}
</style>
</head>
<body>
	<div class="topleft">
		<img src="../imgs/logo1-default.png"  title="陕西蓝软信息科技有限公司后台管理系统" width="65px"  height="65px"; style="margin-left: 10px;"/>
		<span style="font-weight: bolder; font-size: 15px; float: right; margin-top: 30px; color:EA0000 ">陕西蓝软信息科技有限公司后台管理系统</span>
	</div>
	<div class="topright">
		 <div class="user">
			<span id="show" style="font-weight: bolder; font-size: 15px;margin-top: 15px;color:FF5809"></span>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#show").html(
			"欢迎系统管理员：" + getCookie("username") +"&nbsp登录系统");
</script>
</html>