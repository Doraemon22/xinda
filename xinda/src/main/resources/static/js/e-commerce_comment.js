//1.顶端欢迎  
$(function(){
	var euser = sessionStorage.getItem("cellphone");
	var txt = "";
	txt += `<span >${euser}</span>`;
	$("#euser").append(txt);//顶端

	var txt2 =`
        <p>${euser}</p>`;
	$(".userinfo").append(txt2);//显示头像下面的电话号码
})
//2.显示头像
$(function(){
	var id = sessionStorage.getItem("eid");
$(".imgshow").attr("src","/imgshow?id="+id);
})
function defaultImg(img){
		img.src="/images/user-lg.png";
	}
$(function(){
	nocomment();
})
//3.没评价
function nocomment(){
	var id = sessionStorage.getItem("eid");
	$.ajax({
		type : "post",
		url : "/ecomment",
		data:{
			id:id
			},
		dataType : "json",
		success : function(data) {
			console.log("成功comment0", data);
			orderCommentList(data);//data里放了多表查询的数据
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}

//4.评价模块   订单显示	
function orderCommentList(data)
{
	var eOderPro = data.eOderPro;
	var txt = "";
	$(".list").append().html("");
	if(eOderPro!=null){
		for(var i = 0;i<eOderPro.length;i++)
		{
		txt+=`
		<div class = "article">
	<img src="/commentProImgShow?pid=${eOderPro[i].id}"  alt="图片" />
            <ul class="article-info">
            <li>${eOderPro[i].name}</li>
            <li>${eOderPro[i].info}</li>
            <li>${eOderPro[i].sname}</li>
            <li>
                   <input    type="hidden"   value = "${eOderPro[i].order_id}"   class="orderid"/>
            </li>
        </ul>
        <p>购买时间：${datetime(eOderPro[i].create_time)}</p>
        `
			  if(eOderPro[i].comment_status==0){
			        txt+=	`<p class="evaluate_btn" onclick = "goComment(${eOderPro[i].order_id})">去评价</p>
			          </div><hr color="#ccc" size="1">`
			        }else
			        {
			            txt+=	`<p class="evaluate_btn" >已评价</p>`
			        }
		}
	$(".list").append(txt);}
	else{
		alert(data.msg);
	}
}
//5.
function datetime(time) {//时间显示
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}

//评价
function goComment(orderid)//
{
	$(".masking").show();
	var orderid= $(".orderid").val();                //class="orderid"/>  隐藏显示了
	sessionStorage.setItem("orderid",orderid);
	console.log("orderid====", orderid);
	
}

//评价窗口页面
$(".save").on("click", function(event){
    $(".masking").hide();
    var id = sessionStorage.getItem("eid");
    var orderid = sessionStorage.getItem("orderid");
	var content = $("#content").val();
	console.log(content);
	console.log("saveComment==orderid", orderid);
	$.ajax({
		type : "post",
		url : "/saveComment",
		data:{
			id:id,
			orderid:orderid,
			content:content,//评价内容
		},
		dataType : "json",
		success : function(data) {
			console.log("评价成功", data);
			location.href = "redirect?page=e-commerce_comment";//评价成功后更新一下页面
			alert(data.msg);
		},
		error : function(data) {
			alert(data.msg);
			console.log("评价啊失败", data);
		}
	})
})

$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
    sessionStorage.removeItem("orderid");
})





$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
$(".evaluate_btn").on("click", function(event){
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