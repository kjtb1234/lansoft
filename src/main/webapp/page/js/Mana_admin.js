var manageId;
var OpenWindow = 0;
/**
 * 登录
 */
function admin() {
	
	var telphone = $("#telphone").val();
	var password = $("#pwd").val();
	if (telphone == "请输入手机号码" || telphone == "") {
		alert("请输入手机号码！");
	} else if (password == "密码" || password == "") {
		alert("请输入密码！");
	} else {
		$
				.ajax({
					type : "POST",
					url : baseUrl + "/userinfoController/login.do",
					data : "telphone=" + telphone + "&password=" + password,
					dataType : 'JSON',
					success : function(json) {
						// 登录失败
						if (!json.success) {
							alert(json.message);
						} else {
							setCookie("username", json.obj.username, "h12");
							window.location.href ="Mana_index.jsp";
						}
					}
				});
	}
}

/**
 * 回车登录
 */
function KeyDown() {
	if (event.keyCode == 13) {
		event.returnValue = false;
		event.cancel = true;
		admin();
	}
}


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

	var url = parent.location;

	// 查询菜单权限
	$(".base").css("display", "");
	$(".pet").css("display", "");
	$(".dep").css("display", "");
	$(".man").css("display", "");
	$(".cus").css("display", "");
	$(".wor").css("display", "");
	$(".rec").css("display", "");
}

