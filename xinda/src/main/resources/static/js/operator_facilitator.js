$(".search-btn").on("click", function(){
	var serviceName=$('#serviceName').val();//取值      val函数没加（）点击搜索一直出现400错误
    location.href="/findByServicename?serviceName="+serviceName;
})
$(function(){
	var pcount=$('#count').val();
	var psize=$('#pageSize').val();
	var pstart=$('#pageStart').val();
	var serviceName=$('#serviceName').val();
	var nowpage=Math.floor(pstart/psize)+1;
	//alert(nowpage);
	var cpage=Math.ceil(pcount/psize);
	var strhtml="";
	if(cpage<=10){
		for(var i=1;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
		//alert("111111===" + nowpage);
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				//strhtml+='<a href=/findProByname?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
			}else{
				strhtml+='<span> <a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		//alert("222222===" + nowpage);
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		//alert("333333===" + nowpage);
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findByServicename?pageStart='+psize*(i-1)+'&serviceName='+serviceName+'>'+i+'</a></span>';
			}
		}
	}else{
		console.error(00000000);
	}
	$("#mydiv").html(strhtml);
	
});
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
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