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
	var cellphone = $(".e_cellphone").val();
	var password = $(".e_password").val();
	var imgcode = $(".code").val();
//	console.log(cellphone,password,imgcode)；
	$.ajax({
		type : "post",
		// 请求路径
		url : "/elogin",
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
		//	alert(data.msg);
			if (data.code == 1) {   
				console.log(data.cellphone,data.id,data.name);//对应控制层 map里的id。。。
				sessionStorage.setItem("cellphone", data.cellphone);
				sessionStorage.setItem("eid", data.id);
				sessionStorage.setItem("ename", data.name);
				sessionStorage.setItem("esex", data.sex);
				sessionStorage.setItem("eemail", data.email);
				location.href = "/ePageProlist";
					
			} else {
				alert("信息输入错误!");
				location.href = "e-commerce_login.html"
			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
})
