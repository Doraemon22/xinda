$(".search-btn").on("click", function(){
	var name=$('#name').val();//取值      val函数没加（）点击搜索一直出现400错误
    location.href="/findOperByusername?name="+name;
})

$(function(){
	var pcount=$('#count').val();
	var psize=$('#pageSize').val();
	var pstart=$('#pageStart').val();
	var name=$('#name').val();
	var nowpage=Math.floor(pstart/psize)+1;
	//alert(nowpage);
	var cpage=Math.ceil(pcount/psize);
	var strhtml="";
	if(cpage<=10){
		for(var i=1;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
		//alert("111111===" + nowpage);
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				//strhtml+='<a href=/findProByname?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
			}else{
				strhtml+='<span> <a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		//alert("222222===" + nowpage);
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		//alert("333333===" + nowpage);
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findOperByusername?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
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
$(".business-order").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("注册用户");
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务商用户");
})