//顶端欢迎  
$(function(){
	var euser = sessionStorage.getItem("cellphone");
	var txt = "";
	txt += `<span >${euser}</span>`;
	$("#euser").append(txt);//顶端
	
	var id = sessionStorage.getItem("eid");
	var txt1 =`<input  name="id"   type="hidden" value = "${id}">`;
	$(".input2").append(txt1);//

	var txt2 =`
        <p>${euser}</p>`;
	$(".userinfo").append(txt2);//显示头像下面的电话号码
})

//显示头像
$(function(){
	var id = sessionStorage.getItem("eid");
$(".imgshow").attr("src","/imgshow?id="+id);
})


function defaultImg(img){
		img.src="/images/user-lg.png";
	}

//隐藏的显示用户id
$(function(){
	var id = sessionStorage.getItem("eid");
$(".hideEid").attr("value",id);
})

//账户设置
$(".password").on("click", function() {
	var oldpassword = $(".password_old").val();
	var new1password = $(".new").val();
	var new2password = $(".password_new2").val();
	var id = $(".id").val();       
	var cellphone = sessionStorage.getItem("cellphone");
	console.log(oldpassword, new1password, new2password, cellphone,id);
	$.ajax({
		type : "post",
		url : "/password",
		data : {
			oldpassword : oldpassword,
			new1password : new1password,
			new2password : new2password,
			cellphone : cellphone,
			id : id,
		},
		//dataType : "json",
		success : function(data) {
			alert(data.msg);
			console.log("成功", data);
		},
		error : function(data) {
			alert(data.msg);
			console.log("失败", data);
		}
	})
})

$(".information").on("click", function() {
	var sex = $('input[name="sex"]:checked').val();
	console.log(sex);
	var name = $(".name").val();
	var email = $(".email").val();
	var id = $(".id").val();             
	var cellphone = sessionStorage.getItem("cellphone");
	console.log( name, sex,email, cellphone,id);
	$.ajax({
		type : "post",
		url : "/info",
		data : {
			sex : sex,
			name : name,
			email : email,
			cellphone : cellphone,
			id : id,
		},
		dataType : "json",
		success : function(data) {
			alert(data.msg);
			console.log("成功", data);
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
})




//显示原来的name数据,ejsname在html页面
$(function(){
	var name = sessionStorage.getItem("ename");
$(".ejsname").attr("value",name);
})
//   ***根据获得的信息让页面选择男或者女
$(function(){
	var sex = sessionStorage.getItem("esex");
	$('input[name="sex"][value='+sex+']').get(0).checked = true;
})

$(function(){
	var email = sessionStorage.getItem("eemail");
$(".ejsemail").attr("value",email);
})






//---------------------------------------------------------------------
$(".search-product").on("click", function () {
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function () {
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function (event) {
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function (event) {
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function (event) {
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(".content-banner li").eq(0).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").hide();
    $(".account-info").show();
})
$(".content-banner li").eq(1).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").show();
    $(".account-info").hide();
})