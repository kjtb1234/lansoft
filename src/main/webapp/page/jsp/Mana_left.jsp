<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无标题文档</title>
<link href="../css/leftstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/iconfont.css">
</head>
<body style="background:#f3f9fe;" onload="loads()">
	<ul id="accordion" class="accordion">
		<li>
			<div class="link">
				<a href="Mana_systemNotification.jsp" target="rightFrame"></a><i
					class="iconfont icon-home_fill_light"></i>欢迎首页
			</div></li>
		<li class="base">
			<div class="link">
				<i class="iconfont icon-cascades"></i>首页<i
					class="iconfont icon-right"></i>
			</div>
			<ul class="submenu">
				<li class="pet"><a href="Mana_sowingmapList.jsp"
					target="rightFrame">轮播图</a></li>
				<li class="pet"><a href="Mana_sloganList.jsp"
					target="rightFrame">口号</a></li>
				<li class="dep"><a href="Mana_maindirectionList.jsp"
					target="rightFrame">主要方向</a></li>
				<li class="cus"><a href="Mana_coreproductList.jsp"
					target="rightFrame">核心产品</a></li>
			</ul></li>
		  <li id="chartTableManage" >
			<div class="link">	
				<img src="../imgs/chartTable.png" style="width:16%;float:left;margin:0 10px 0 -30px">新闻动态
				<i class="iconfont icon-right"></i>			
			</div>
			<ul class="submenu">
				<li><a href="Mana_aboutusList.jsp" target="rightFrame">关于我们</a>
				</li>
				<li><a href="Mana_joinusList.jsp" target="rightFrame">加入我们</a>
				</li>
				<li><a href="Mana_attentionusList.jsp" target="rightFrame">关注我们</a>
				</li>
				<li><a href="Mana_callusList.jsp" target="rightFrame">联系我们</a>
				</li>
			</ul>
		</li>
		<li class="pet">
			<div class="link">
				<i class="iconfont icon-file"></i>公司简介<i
					class="iconfont icon-right"></i>
			</div>
			<ul class="submenu" style="display:block">
				<li><a href="Mana_briefaboutusList.jsp" target="rightFrame">关于我们 </a>
				</li>
				<li><a href="Mana_coreteamList.jsp"
					target="rightFrame">核心团队
				</a>
				</li>
				<li><a href="Mana_cooperateList.jsp" target="rightFrame">合作伙伴 </a>
				</li>
			</ul></li>	
		<li class="Checkwork">
			<div class="link">
				<img src="../imgs/template.png" style="width:14%;float:left;margin:0 10px 0 -30px">最新新闻
				<i class="iconfont icon-right"></i>	
			</div>
			<ul class="submenu" style="display:block">
				<li><a href="Mana_newsList.jsp" target="rightFrame">新闻</a>
				</li>
			</ul></li>		
		<li>
			<div class="link">
				<i class="iconfont icon-settings"></i>联系我们<i
					class="iconfont icon-right"></i>
			</div>
			<ul class="submenu">
				<li class="man"><a href="Mana_callusList.jsp"
					target="rightFrame">联系我们</a></li>
				<li><a href="Mana_worktimeList.jsp" target="rightFrame">工作时间</a>
				</li>
			</ul></li>
		<li>
			<div class="link">
				<i class="iconfont icon-creative"></i>人员管理<i
					class="iconfont icon-right"></i>
			</div>
			<ul class="submenu">
				<li><a href="Mana_userinfoList.jsp" target="rightFrame">用户管理</a>
				</li>
			</ul></li>
	</ul>
</body>
<script src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/BaseUrl.js"></script>
<script type="text/javascript">
/**
 * 左侧菜单栏加载
 */
function loads() {
	// 列表栏目的展示和收缩
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {
			el : this.el,
			multiple : this.multiple
		}, this.dropdown);
	};

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
		$this = $(this), $next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass(
					'open');
		}
	};
	var accordion = new Accordion($('#accordion'), false);
}



</script>
</html>
