/*$(".a-shopping-cart").on("click", function(){
    location.href="ecar"
})*/

//想法：计算得到金额和金额合计，然后放到对应位置显示
$(function(){
	var num=$('#num').val;
	var price=$('#price').val;
	var money=eval(num*price);
//	var allmoney = [[${allmoney}]];  //controller model取值
	var pro=[];
	pro=$("ecar").val;
	for(var i=0;i<pro.length;i++){
		var allmoney=pro[i].money+allmoney;
	}
	console.log("money:"+money);
	console.log("allmoney:"+allmoney);
	$("#allmoney").html(allmoney);
	$("#money").html(money);
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

$(".content-nav li").on("click", function(event){
    $(".content-nav a").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
