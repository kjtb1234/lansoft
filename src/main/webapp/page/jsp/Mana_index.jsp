<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>陕西蓝软信息科技有限公司</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/CookieUtil.js"></script>
<script type="text/javascript">
var username = getCookie("username");
	$(function() {
		if (username == null) {
			//跳转至登录
			window.location.href = "Mana_admin.jsp";
			return;
		}
		})
</script>
</head>
<frameset rows="85,*,31" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="Mana_top.jsp" name="topFrame" scrolling="no"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="Mana_left.jsp" name="leftFrame" 
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="Mana_systemNotification.jsp" name="rightFrame"
			id="rightFrame" title="rightFrame" />
	</frameset>
	<frame src="Mana_bottom.jsp" name="bottomframe"
		border="0px" scrolling="no" target="_self" id="bottomFrame" />
</frameset>
</html>

