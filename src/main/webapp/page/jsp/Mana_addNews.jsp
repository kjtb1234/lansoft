<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加核心产品</title>
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
<!-- 引入富文本文件 -->
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div
		style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
		<span style="color:#00a1ff;">最新新闻</span><span style="margin:0 5px;">&gt;</span><span>添加新闻</span>
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
				<form id="form1" enctype="multipart/form-data" method='post' >
					<table style="border-collapse:separate;  border-spacing:20px; margin-left: 30px;" >
						<tr>      
							<td ><span style="color: red;">*&nbsp;&nbsp;</span>标题:</td>
							<td><input placeholder="请输入标题" maxlength="100"  id="title" style="width: 500px"></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>日期:</td>
							<td>
							<input type="text" placeholder="请选择日期" class="Wdate" id="ndate"  onfocus="WdatePicker()" style="width:300px" />
							</input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>详情:</td>
							<td><script id="content1" type="text/plain"
							style="width:800px;height:500px;"></script></td>
						</tr>
					</table>
					<div style="margin-top:25px;">
						<input type="button" value="提交" onclick="save();"
							class="item1" /> <input type="button" value="取消"
							onclick="window.location='Mana_newsList.jsp'"
							style="margin-left: 50px;" class="item1" />
					</div>
				</form>
			</div>

		</div>
		<div class="sys4"></div>
	</div>
	<script type="text/javascript">
		//实例化编辑器
	   	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('addNewsBody')就能拿到相关的实例
	  		var  addUe = UE.getEditor('content1');
	  		addUe.addListener("ready", function () { 
			
		}); 
	</script>
</body>
<script type="text/javascript">
	$(function() {
		$("td:odd").addClass("odd");//odd为偶数列
		$("td:even").addClass("even");//even奇数列
	});

	function save() {
		var title = $('#title').val();
		var ndate = $('#ndate').val();
		var content= getPlainTxt();;
		if (title == "") {
			$.ligerDialog.warn("请填写标题！");
		} else if (ndate == "") {
			$.ligerDialog.warn("请选择时间！");
		}else if(!content&&content==""){
			$.ligerDialog.alert("请填写内容！");
		}else {// 校验成功
		$("#form1").ajaxSubmit({
			url : baseUrl
					+ "/newsController/addNews.do",
			dataType : "json",
			data : {
				"title" : title,
				"content" : content,
				"ndate" : ndate
			},
			success : function(json) {
				if (json.success) {
					$.ligerDialog.success(json.message);
					setTimeout(
							function() {
								window.location.href = "Mana_newsList.jsp";
							}, 500);
				} else {
					$.ligerDialog
							.warn(
									json.message,
									function() {
										window.location.href = "Mana_newsList.jsp";
									});
				}

			}
		});
		}
	}
	 function getPlainTxt() {
        var arr = [];
        arr.push(UE.getEditor('content1').getContent());
        return arr.join('\n');
    }
</script>
</html>
