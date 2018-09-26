<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加用户</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/BaseUrl.js"></script>
<script type="text/javascript" src="../js/jquery-form.js"></script>
<style>
.sys4 {
	margin-top: 15px;
	width: 1000px;
	height: 40px;
	font-size: 14px;
	color: #666;
	text-align: center;
}

.item {
	margin-top: 30px;
	height: 35px;
	width: 100px !important;
	background-color: #1f93ee;
	color: #fff;
	font-size: 16px;
}

input {
	font-family: 微软雅黑;
}

select {
	width: 200px;
	font-family: 微软雅黑;
}
</style>
<script type="text/javascript" src="../libs/ligerUI/js/ligerui.all.js"></script>
<script type="text/javascript" src="../libs/jquery.cookie.js"></script>
<link rel="stylesheet" type="text/css"
	href="../libs/ligerUI/skins/Aqua/css/ligerui-all.css" />
<link rel="stylesheet" type="text/css" href="../css/contentstyle.css" />
</head>
<body>
	<div
		style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
		<span style="color:#00a1ff;">人员管理</span><span style="margin:0 5px;">&gt;</span><span>新增用户</span>
	</div>
	<div style="margin:20px auto;width:90%;">
		<div align="center" style="margin-top: 30px;margin-bottom: 60px;">
			<div class="boxmodule">
				<div class="boxtop">
					<p style="color:#666;font-size:12px;">
						<strong style="color:#00a1ff;font-weight:400;"><i
							class="iconfont icon-emoji"></i> 温馨提示：</strong> 带<i style="color:red;">
							* </i> 的为必填项！
					</p>
				</div>
				<form id="form1" method="post">
					<table style="border-collapse:separate;  border-spacing:20px; margin-left: 30px;" >
						<tr>      
							<td ><span style="color: red;">*&nbsp;&nbsp;</span>姓名:</td>
							<td><input placeholder="请输入姓名" maxlength="100"  id="username" style="width: 500px"></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>电话:</td>
							<td><input placeholder="请输入电话" maxlength="100"  id="telphone" style="width: 500px" ></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>密码:</td>
							<td><input placeholder="请输入密码" maxlength="100"  id="password" style="width: 500px" ></input></td>
						</tr>
					</table>
					<div style="margin-top:25px;">
						<input type="button" value="提交" onclick="save();"
							class="item1" /> <input type="button" value="取消"
							onclick="window.location='Mana_userinfoList.jsp'"
							style="margin-left: 50px;" class="item1" />
					</div>
				</form>
			</div>

		</div>
		<div class="sys4"></div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("td:odd").addClass("odd");//odd为偶数列
		$("td:even").addClass("even");//even奇数列
	});

	function save() {
		var username = $('#username').val();
		var telphone = $('#telphone').val();
		var password = $('#password').val();
		if (username == "") {
			$.ligerDialog.warn("请填写姓名！");
		} else if (telphone == "") {
			$.ligerDialog.warn("请填写电话！");
		}  else if (password == "") {
			$.ligerDialog.warn("请填写密码！");
		}else {// 校验成功
		$("#form1").ajaxSubmit({
			url : baseUrl
					+ "/userinfoController/addUserinfo.do",
			dataType : "json",
			data : {
				"username" : username,
				"telphone" : telphone,
				"password" : password
			},
			success : function(json) {
				if (json.success) {
					$.ligerDialog.success(json.message);
					setTimeout(
							function() {
								window.location.href = "Mana_userinfoList.jsp";
							}, 500);
				} else {
					$.ligerDialog
							.warn(
									json.message,
									function() {
										window.location.href = "Mana_userinfoList.jsp";
									});
				}

			}
		});
		}
	}
</script>
</html>
