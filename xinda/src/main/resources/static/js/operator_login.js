$(".code1").on("click", function(){
    /* location.href="redirect?page=operator_product*/   
	/* 开始*/
    var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
    /*结束*/
})

/* 开始*/
// 自运行
$(function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})



$(".login-btn").on("click", function() {
	var cellphone = $(".o_cellphone").val();
	var password = $(".o_password").val();
	var imgcode = $(".code").val();
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "/login",
		// 请求参数
		data : {
			cellphone : cellphone,
			password : password,
			imgcode : imgcode,
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("登录成功后返回数据", data);
			//alert("code=:"+data.code);
			if (data.code == 1) {
				location.href = "/findOperByname"
			} else {
				alert("信息输入错误!");
				location.href = "operator_login.html"
			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("登录失败后返回数据", data);
		}
	})
})
/*结束*/