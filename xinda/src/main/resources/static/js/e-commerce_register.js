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
	var cellphone = $(".cellphone").val();
	var password = $(".password").val();
	var imgcode = $(".code").val();
	var cmbProvince=$('#cmbProvince option:selected') .val();//选中的值
	var cmbCity=$('#cmbCity option:selected') .val();
	var cmbArea=$('#cmbArea option:selected') .val();
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "/euserRegister",
		// 请求参数
		data : {
			cellphone : cellphone,
			password : password,
			imgcode : imgcode,
			cmbProvince:cmbProvince,
			cmbCity:cmbCity,
			cmbArea:cmbArea,
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("注册成功后返回数据", data);
			alert("恭喜，注册成功！" );
			if (data.code == 1) {
				location.href = "e-commerce_login.html"
			} else {
				alert("注册失败!");
				location.href = "e-commerce_register.html"
			}

		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
})