$(".search-eorder-btn").on("click", function(){
	//var number=$('#number').val();
	  location.href="/findOrderByNumber";
  /*  location.href="/findOrderByNumber?number="+number;*/
})


$(function(){
	var pcount=$('#count').val();
	var psize=$('#pageSize').val();
	var pstart=$('#pageStart').val();
	var number=$('#number').val();
	var nowpage=Math.floor(pstart/psize)+1;
	var cpage=Math.ceil(pcount/psize);
	var strhtml="";
	if(cpage<=10){
		for(var i=1;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findOrderByNumber?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findOrderByNumber?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){	
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/findOrderByNumber?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findOrderByNumber?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/findOrderByNumber?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/findOrderByNumber?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findOrderByNumber?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findOrderByNumber?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else{
		console.error(00000000);
	}
	$("#mydiv").html(strhtml);
	
});



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
function pay(){
    location.href="redirect?page=e-commerce_pay" ;
}