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
	var cellphone = $(".s_cellphone").val();
	var password = $(".s_password").val();
	var imgcode = $(".code").val();
	//console.log(123);
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "prologin",
		// 请求参数
		data : {
			cellphone : cellphone,
			password : password,
			imgcode : imgcode,
		},
		// 返回数据类型
		// 请求成功后调用函数
		dataType:"json",
		success : function(data) {
			console.log("成功后返回数据", data);
			if (data.code == 1) {
				console.log(data.cellphone,data.id,data.sname);
				sessionStorage.setItem("cellphone", data.cellphone);
				sessionStorage.setItem("pid", data.id);
				sessionStorage.setItem("pname", data.sname);
				sessionStorage.setItem("pregionId", data.regionId);
				sessionStorage.setItem("pcellphone",data.cellphone);
				sessionStorage.setItem("pweixin", data.weixin);
				sessionStorage.setItem("pqq", data.qq);
				sessionStorage.setItem("pemall", data.emall);
				sessionStorage.setItem("pproviderInfo", data.providerInfo);
		//		sessionStorage.setItem("pworkTime", data.workTime);
				location.href = "/findSproByName"
			} else {
				alert("信息输入错误!");
				location.href = "service_login.html"
			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
})

//$(".login-btn").on("click", function() {
//
//	//var phone = $("#ph").val();
//	var cellphone = $('.s_cellphone').val();
//	alert(cellphone);
//	var password = $('.s_password').val();
//	alert(password);
//	var imgcode = $('.code').val();
//	$.ajax({
//		// 请求类型
//		type : "post",
//		// 请求路径
//		url : "/servicelogin",
//		// 请求参数
//		data : {
//			cellphone : cellphone,
//			password : password,
//			imgcode : imgcode,
//		},
//		// 返回数据类型
//		// 请求成功后调用函数
//		success : function(data) {
//			console.log("成功后返回数据", data);
//			if (data.code == 1) {
//				console.log(data.cellphone,data.id,data.sname);
//				location.href = "/findSproByName"
//			} else {
//				alert("信息输入错误!");
//				location.href = "service_login.html"
//			}
//		},
//		// 请求失败后调用函数
//		error : function(data) {
//			console.log("失败后返回数据", data);
//		}
//	})
//})