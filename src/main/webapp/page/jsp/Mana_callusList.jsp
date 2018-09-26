<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/BaseUrl.js"></script>
<!-- 表格查询  -->
<script type="text/javascript" src="../libs/ligerUI/js/ligerui.all.js"></script>
<script src="../libs/ligerUI/js/plugins/ligerGrid.js"
	type="text/javascript"></script>
<script type="text/javascript" src="../js/jquery-form.js"></script>
<link rel="stylesheet" type="text/css"
	href="../libs/ligerUI/skins/Aqua/css/ligerui-all.css" />
<link rel="stylesheet" type="text/css" href="../css/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../css/contentstyle.css" />
</head>
<body>
	<div id="content">
		<div
			style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
			<span style="color:#00a1ff;">新闻动态</span><span style="margin:0 5px;">&gt;</span><span>联系我们</span>
		</div>
		<div style="margin-left:40px;height: 40px; ">
			<button onclick="window.location='Mana_addCallus.jsp'"
				style="background:#f0b319">
				<i class="iconfont icon-add"></i> 新增联系我们
			</button>
		</div>
		<div id="showReport" style="margin-left: 40px;"></div>
	</div>
	<div id="viewInfo" style="display:none">
		<div
			style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
			<span style="color:#00a1ff;">新闻动态</span><span style="margin:0 5px;">&gt;</span><span>修改联系我们</span>
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

					<form id="form1" method='post' >
						<input type='hidden' id='uid' name="uid" />
						<table
							style="width:100%;border-collapse:separate;border-spacing:15px;">
						<tr>      
							<td ><span style="color: red;">*&nbsp;&nbsp;</span>地址:</td>
							<td><input placeholder="请输入地址" maxlength="100"  id="address" style="width: 500px"></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>电话:</td>
							<td><input placeholder="请输入电话" maxlength="100"  id="telphone" style="width: 500px" ></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>qq:</td>
							<td><input placeholder="请输入qq" maxlength="100"  id="qq" style="width: 500px" ></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>邮箱:</td>
							<td><input placeholder="请输入邮箱" maxlength="100"  id="email" style="width: 500px" ></input></td>
						</tr>
						</table>
						<div style="margin-top:20px;">
							<input type="button" value="提交" onclick="updateCallus();"
								class="item1"> <input type="button" value="取消"
								onclick="location.href='javascript:goBack();'"
								style="margin-left: 50px;" class="item1">
						</div>
					</form>
				</div>

			</div>
			<div class="sys4"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("td:odd").addClass("odd");//odd为偶数列
		$("td:even").addClass("even");//even奇数列
		f_initGrid();
	});
	function f_initGrid() {
		document.getElementById("showReport").style.display = "";
		document.getElementById("viewInfo").style.display = "none";
		grid = $("#showReport")
				.ligerGrid(
						{
							title : '<font color=green>欢迎查看联系我们!</font>',
							columns : [
									{
										display : '序号',
										render : function(item, index) {
											return (index + 1);
										},
										width : "10%"
									},
									{
										display : '地址',
										name : 'address',
										width : "20%"
									},
									{
										display : '电话',
										name : 'telphone',
										width : "15%"
									},
									{
										display : 'qq',
										name : 'qq',
										width : "15%"
									},
									{
										display : '邮箱',
										name : 'email',
										width : "20%"
									},
									{
										display : '操作',
										isSort : false,
										width : "20%",
										render : function(item, index) {
											var h = "<label><img src='../imgs/delete.png' style='width:20px;vertical-align:middle;' onclick='deleteRow(\""
															+ item.id
															+ "\");'/> </label> ";
											return h;
									}}  ],
							url : baseUrl
									+ "/callusController/getCallusListByCondition.do",
							resizable : true,
							pageParmName : "currentPage",
							pagesizeParmName : "rowSize",
							pageSizeOptions : [ 10, 20, 30, 40, 50 ],
							record : "total",
							root : "list",
							width : "90%",
							rowHeight : 'auto',
							// 设置行宽
							rowAttrRender : function(rowdata, rowid) {
								return "style='height:30px;'";
							},
							onSuccess : function() {

							},
							//双击后触发，查看详情
							onDblClickRow : function(data, rowindex, rowobj) {
								document.getElementById("content").style.display = "none";
								document.getElementById("viewInfo").style.display = "";
								$('#uid').val(data.id);//保存id
								//加载数据
								$
										.ajax({
											type : "POST",
											url : baseUrl
													+ "/callusController/getCallusById.do?id="
													+ data.id,
											success : function(data) {
												var json = eval("(" + data
														+ ")");
												if (json.success) {
													setTimeout(
															function() {
																$('#address').val(json.obj.address);
																$('#telphone').val(json.obj.telphone);
																$('#qq').val(json.obj.qq);
																$('#email').val(json.obj.email);
															}, 100);
												} else {
													$.ligerDialog
															.warn(json.message);
													window.location.href = "Mana_callusList.jsp";
												}
											}
										});
							}
						});
	}

	function deleteRow(id) {
		$.ligerDialog
				.confirm(
						'你确定删除?',
						function(yes) {
							if (yes) {
								$
										.ajax({
											type : "POST",
											url : baseUrl
													+ "/callusController/deleteCallusById.do?id="
													+ id,
											success : function(data) {
												var json = eval("(" + data
														+ ")");
												if (json.success) {
													$.ligerDialog
															.success(json.message);
													goBack();
												} else {
													$.ligerDialog
															.warn(
																	json.message,
																	function(
																			yes) {
																		window.location.href = "Mana_callusList.jsp";//删除异常，跳转到用户信息列表
																	});
												}
											}
										});
							}
						});
	}
	function updateCallus() {
	    var id=$('#uid').val();
		var address = $('#address').val();
		var telphone = $('#telphone').val();
		var qq = $('#qq').val();
		var email = $('#email').val();
		if (address == "") {
			$.ligerDialog.warn("请填写地址！");
		}else if (telphone == "") {
			$.ligerDialog.warn("请填写电话！");
		} else if (qq == "") {
			$.ligerDialog.warn("请填写qq！");
		}else if (email == "") {
			$.ligerDialog.warn("请填写邮箱！");
		}else {// 校验成功
		$("#form1").ajaxSubmit({
			url : baseUrl
					+ "/callusController/updateCallus.do",
			dataType : "json",
			data : {
				"address" : address,
				"telphone" : telphone,
				"qq" : qq,
				"email" : email,
				"id" : id
			},
			success : function(json) {
				if (json.success) {
					$.ligerDialog.success(json.message);
					setTimeout(
							function() {
								window.location.href = "Mana_callusList.jsp";
							}, 500);
				} else {
					$.ligerDialog
							.warn(
									json.message,
									function() {
										window.location.href = "Mana_callusList.jsp";
									});
				}

			}
		});
		}
	}
	//返回
	function goBack() {
		document.getElementById("content").style.display = "";
		document.getElementById("viewInfo").style.display = "none";
		grid.reload();
	}
</script>
</html>
