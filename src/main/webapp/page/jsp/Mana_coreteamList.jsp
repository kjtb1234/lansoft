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
			<span style="color:#00a1ff;">公司简介</span><span style="margin:0 5px;">&gt;</span><span>核心团队</span>
		</div>
		<div style="margin-left:40px;height: 40px; ">
			<button onclick="window.location='Mana_addCoreteam.jsp'"
				style="background:#f0b319">
				<i class="iconfont icon-add"></i> 新增核心团队
			</button>
		</div>
		<div id="showReport" style="margin-left: 40px;"></div>
	</div>
	<div id="viewInfo" style="display:none">
		<div
			style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
			<span style="color:#00a1ff;">首页</span><span style="margin:0 5px;">&gt;</span><span>修改核心团队</span>
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
						<input type='hidden' id='uid' name="uid" />
						<table
							style="width:100%;border-collapse:separate;border-spacing:15px;">
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>内容:</td>
							<td><input placeholder="请输入内容" maxlength="100"  id="content1" style="width: 500px" ></input></td>
						</tr>
						<tr>
							<td><span style="color: red">*&nbsp;&nbsp;</span>图片:</td>
							<td> 
							<img id="addPicUrl" style="width: 468px; height: 300px;">
							<input type="file" name="spicUrl" id="picUrl"  />
							</td>
						</tr>
						</table>
						<div style="margin-top:20px;">
							<input type="button" value="提交" onclick="updateCoreteam();"
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
    /*原理是把本地图片路径："D(盘符):/image/..."转为"http://..."格式路径来进行显示图片*/  
    $("#picUrl").change(function() {  
        var $file = $(this);  
        var objUrl = $file[0].files[0];  
        //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome  
        var windowURL = window.URL || window.webkitURL;  
        //createObjectURL创建一个指向该参数对象(图片)的URL  
        var dataURL;  
        dataURL = windowURL.createObjectURL(objUrl);  
        $("#addPicUrl").attr("src",dataURL);  
    });  
	});

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
							title : '<font color=green>欢迎查看核心团队!</font>',
							columns : [
									{
										display : '序号',
										render : function(item, index) {
											return (index + 1);
										},
										width : "10%"
									},
									{
										display : '内容',
										name : 'content',
										width : "40%"
									},
									{
										display : '图片',
										name : 'picurl',
										width : "40%"
									},
									{
										display : '操作',
										isSort : false,
										width : "10%",
										render : function(item, index) {
											var h = "<label><img src='../imgs/delete.png' style='width:20px;vertical-align:middle;' onclick='deleteRow(\""
															+ item.id
															+ "\");'/> </label> ";
											return h;
									}}  ],
							url : baseUrl
									+ "/coreteamController/getCoreteamListByCondition.do",
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
													+ "/coreteamController/getCoreteamById.do?id="
													+ data.id,
											success : function(data) {
												var json = eval("(" + data
														+ ")");
												if (json.success) {
													setTimeout(
															function() {
																$('#content1').val(json.obj.content);
																$('#picUrl').val(json.obj.picUrl);
																$("#addPicUrl").attr("src",imgBasePath+json.obj.picurl);
															}, 100);
												} else {
													$.ligerDialog
															.warn(json.message);
													window.location.href = "Mana_coreteamList.jsp";
												}
											}
										});
							}
						});
	}

	//软删除人员
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
													+ "/coreteamController/deleteCoreteamById.do?id="
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
																		window.location.href = "Mana_coreteamList.jsp";//删除异常，跳转到用户信息列表
																	});
												}
											}
										});
							}
						});
	}
	function updateCoreteam() {
	    var id=$('#uid').val();
		var content = $('#content1').val();
		if($('#picUrl').val().length!=0){
           	if(!checkImg($('#picUrl').val())){
				$.ligerDialog.warn("请上传 正确的图片信息！");
				return;
			} 
		} else{
			$.ligerDialog.warn("请选择上传图片！");
		}
		if (content == "") {
			$.ligerDialog.warn("请填写内容！");
		} else {// 校验成功
		$("#form1").ajaxSubmit({
			url : baseUrl
					+ "/coreteamController/updateCoreteam.do",
			dataType : "json",
			data : {
				"content" : content,
				"id" : id
			},
			success : function(json) {
				if (json.success) {
					$.ligerDialog.success(json.message);
					setTimeout(
							function() {
								window.location.href = "Mana_coreteamList.jsp";
							}, 500);
				} else {
					$.ligerDialog
							.warn(
									json.message,
									function() {
										window.location.href = "Mana_coreteamList.jsp";
									});
				}

			}
		});
		}
	}
	//检查图片格式
	function checkImg(imgPath) {
		imgName = imgPath.substring(imgPath.lastIndexOf(".")).toUpperCase();
		if (imgName != ".BMP" && imgName != ".PNG" && imgName != ".GIF"
				&& imgName != ".JPG" && imgName != ".JPEG") {
			return false;
		} else {
			return true;
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
