$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})
$(".order3").on("click", function(){
    $(".main-top li").eq(3).text("未通过用户");
})
$(".change-info").on("click", function(event){
    $(".masking").show();
})
$(".save").on("click", function(event){
    $(".masking").hide();
    console.log("保存");
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})

$(function(){
	var provider=sessionStorage.getItem("cellphone");
	var id=sessionStorage.getItem("pid");
	
	var txt = "";
	txt += `<span >${provider}</span>`;
	$("#provider").append(txt);//顶端
	
	var id = sessionStorage.getItem("pid");
	
	var txt1 =`<input  name="id"   type="hidden" value = "${id}">`;
	$(".imgto").append(txt1);//

	var txt2 =`
        <p>${provider}</p>`;
	$(".proinfo").append(txt2);//显示头像下面的电话号码	
})

//隐藏的显示用户id
$(function(){
	var id = sessionStorage.getItem("pid");
$(".hidePid").attr("value",id);

})

//显示头像
$(function() {
	var id = sessionStorage.getItem("pid");
	$(".imgshow").attr("src", "/headImg2?id="+id);
})
function defaultImg(img) {
	img.src = "/images/default_user.png";
}



$(".save").on("click", function() {

	var sname = $(".sname").val();
	var cellphone = $(".cellphone").val();
	var weixin = $(".weixin").val();
	var qq = $(".qq").val();
	var emall = $(".emall").val();
	var cmbProvince=$('#cmbProvince option:selected').val();
	var cmbCity=$('#cmbCity option:selected').val();
	var cmbArea=$('#cmbArea option:selected').val();
	var id = sessionStorage.getItem("pid");	
//	var cellphone = sessionStorage.getItem("cellphone");

	console.log(sname, cellphone, weixin, qq, emall,id,cmbProvince,cmbCity,cmbArea);
	$.ajax({
		type : "post",
		url : "/updateinfo",
		dataType : "json",
		data : {
			sname : sname,
			cellphone : cellphone,
			weixin : weixin,
			qq : qq,
			emall : emall,
			id : id,
			cmbProvince:cmbProvince,
			cmbCity:cmbCity,
			cmbArea:cmbArea,

		},
		success : function(data) {
			console.log("成功", data);
			if (data.code == 1) {
				alert(data.status);
			} else {
				alert(data.status);
			}

		},
		error : function(data) {
			console.log("失败", data);
		}
	})

})



//显示原来的name数据,pjsname在html页面
$(function(){
	var sname = sessionStorage.getItem("pname");
$(".pjsname").attr("value",sname);
})
$(function(){
	var regionId = sessionStorage.getItem("pregionId");
$(".pjsregionId").attr("value",regionId);
})
$(function(){
	var weixin = sessionStorage.getItem("pweixin");
	
$(".pjsweixin").attr("value",weixin);
})
$(function(){
	var emall = sessionStorage.getItem("pemall");
$(".pjsemall").attr("value",emall);
})
$(function(){
	var qq = sessionStorage.getItem("pqq");
$(".pjsqq").attr("value",qq);
})
$(function(){
	var cellphone = sessionStorage.getItem("pcellphone");
$(".pjscellphone").attr("value",cellphone);
})