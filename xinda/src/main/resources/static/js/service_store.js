$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
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
$(function(){
	var id = sessionStorage.getItem("pid");
$(".imgshow").attr("src","/headImg3?id="+id);
})


function defaultImg(img){
	img.src = "/images/default_user.png";
	}

//显示原来的name数据,pjsname在html页面

$(function(){
	var qq = sessionStorage.getItem("pqq");
$(".pjsqq").attr("value",qq);
})
$(function(){
	var cellphone = sessionStorage.getItem("pcellphone");
$(".pjscellphone").attr("value",cellphone);
})
$(function(){
	var providerInfo = sessionStorage.getItem("pproviderInfo");
$(".pjsproviderInfo").attr("value",providerInfo);
})
$(function(){
	var sname = sessionStorage.getItem("pname");
$(".pjsname").attr("value",sname);
})