$(".code1").on("click", function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})

// 自运行
$(function() {
	var img = document.getElementsByClassName("code1")[0];
	var time = new Date().getTime();
	img.src = "images?t=" + time;
})

$(".login-btn").on("click", function() {
	var id = $(".id").val();
	var cellphone = $(".cellphone").val();
	var password = $(".password").val();
	var imgcode = $(".code").val();
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "/register",
		// 请求参数
		data : {
			id : id,
			cellphone : cellphone,
			password : password,
			imgcode : imgcode,
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("注册成功后返回数据", data);
			alert("code=:" + data.code);
			if (data.code == 1) {
				location.href = "service_login.html"
			} else {
				alert("注册失败!");
				location.href = "service_register.html"
			}

		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
})