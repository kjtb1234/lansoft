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
<!-- 引入富文本文件 -->
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"></script>
</head>
<body>
	<div id="content">
		<div
			style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
			<span style="color:#00a1ff;">首页</span><span style="margin:0 5px;">&gt;</span><span>核心产品</span>
		</div>
		<div style="margin-left:40px;height: 40px; ">
			<button onclick="window.location='Mana_addCoreproduct.jsp'"
				style="background:#f0b319">
				<i class="iconfont icon-add"></i> 新增核心产品
			</button>
		</div>
		<div id="showReport" style="margin-left: 40px;"></div>
	</div>
	<div id="viewInfo" style="display:none">
		<div
			style="margin-top :15px;font-size:15px;color:#666;background:#f5f5f5;padding:10px;margin:10px;border-radius:6px;">
			<span style="color:#00a1ff;">首页</span><span style="margin:0 5px;">&gt;</span><span>修改核心产品</span>
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
							<td ><span style="color: red;">*&nbsp;&nbsp;</span>标题:</td>
							<td><input placeholder="请输入标题" maxlength="100"  id="title" style="width: 500px"></input></td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>简介:</td>
							<td><input placeholder="请输入内容" maxlength="100"  id="content1" style="width: 500px" ></input></td>
						</tr>
						<tr>
							<td><span style="color: red">*&nbsp;&nbsp;</span>图片:</td>
							<td> 
							<img id="addPicUrl" style="width: 468px; height: 300px;">
							<input type="file" name="spicUrl" id="picUrl"  />
							</td>
						</tr>
						<tr>      
							<td><span style="color: red">*&nbsp;&nbsp;</span>详情:</td>
							<td><script id="detail" type="text/plain"
							style="width:800px;height:500px;"></script></td>
						</tr>
						</table>
						<div style="margin-top:20px;">
							<input type="button" value="提交" onclick="updateCoreproduct();"
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
		//实例化编辑器
	   	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('addNewsBody')就能拿到相关的实例
	  		var  addUe = UE.getEditor('detail');
	  		addUe.addListener("ready", function () { 
			
		}); 
		grid = $("#showReport")
				.ligerGrid(
						{
							title : '<font color=green>欢迎查看核心产品!</font>',
							columns : [
									{
										display : '序号',
										render : function(item, index) {
											return (index + 1);
										},
										width : "5%"
									},
									{
										display : '标题',
										name : 'title',
										width : "10%"
									},
									{
										display : '内容',
										name : 'content',
										width : "25%"
									},
									{
										display : '图片',
										name : 'picurl',
										width : "30%"
									},{
										display : '详情',
										width : "20%",
										name:'retail',
										render : function(item) {
											var	show = item.retail.replace(/<[^>]+>/g,"").replace(/&nbsp;/gi,'').substring(0,35);
											return show;
										}	
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
									+ "/coreproductController/getCoreproductListByCondition.do",
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
													+ "/coreproductController/getCoreproductById.do?id="
													+ data.id,
											success : function(data) {
												var json = eval("(" + data
														+ ")");
												if (json.success) {
													setTimeout(
															function() {
																$('#title').val(json.obj.title);
																$('#content1').val(json.obj.content);
																$('#picUrl').val(json.obj.picUrl);
																$("#addPicUrl").attr("src",imgBasePath+json.obj.picurl);
																insertHtml(json);
																
															}, 100);
												} else {
													$.ligerDialog
															.warn(json.message);
													window.location.href = "Mana_coreproductList.jsp";
												}
											}
										});
							}
						});
	}
	function insertHtml(data,isAppendTo) {
	     var value = data.obj.retail;
		 UE.getEditor('detail').setContent('', isAppendTo);//清空
		 UE.getEditor('detail').execCommand('insertHtml', value);
	     return value;
    }
	 function setContent(data) {
	    var arr = [];
	    arr.push(data.retail);
	    UE.getEditor('detail').setContent('data', data);
	    return arr.join("\n");
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
													+ "/coreproductController/deleteCoreproductById.do?id="
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
																		window.location.href = "Mana_coreproductList.jsp";//删除异常，跳转到用户信息列表
																	});
												}
											}
										});
							}
						});
	}
	function updateCoreproduct() {
	    var id=$('#uid').val();
		var title = $('#title').val();
		var content = $('#content1').val();
		var detial= getPlainTxt();
		if($('#picUrl').val().length!=0){
           	if(!checkImg($('#picUrl').val())){
				$.ligerDialog.warn("请上传 正确的图片信息！");
				return;
			} 
		} else{
			$.ligerDialog.warn("请选择上传图片！");
		}
		if (title == "") {
			$.ligerDialog.warn("请填写标题！");
		} else if (content == "") {
			$.ligerDialog.warn("请填写内容！");
		}else if(!detial&&detial==""){
			$.ligerDialog.alert("请填写详情！");
		} else {// 校验成功
		$("#form1").ajaxSubmit({
			url : baseUrl
					+ "/coreproductController/updateCoreproduct.do",
			dataType : "json",
			data : {
				"title" : title,
				"content" : content,
				"detial" : detial,
				"id" : id
			},
			success : function(json) {
				if (json.success) {
					$.ligerDialog.success(json.message);
					setTimeout(
							function() {
								window.location.href = "Mana_coreproductList.jsp";
							}, 500);
				} else {
					$.ligerDialog
							.warn(
									json.message,
									function() {
										window.location.href = "Mana_coreproductList.jsp";
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
	function getPlainTxt() {
        var arr = [];
        arr.push(UE.getEditor('detail').getContent());
        return arr.join('\n');
    }
	//返回
	function goBack() {
		document.getElementById("content").style.display = "";
		document.getElementById("viewInfo").style.display = "none";
		grid.reload();
	}
</script>
</html>
