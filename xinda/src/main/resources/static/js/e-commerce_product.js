$(function(){
	var user = sessionStorage.getItem("cellphone");
	var txt = "";
	txt += `${euser}`;
	$("#euser").append(txt);
})
$(function(){
	var user = sessionStorage.getItem("cusphone");
	var txt = "";
	txt += `${user}`;
	$("#user").append(txt);
})

function epro(data)
{
	var epro = data.epro;
	var  txt = "";
	$(".eproduct").append().html("");
	for(var i = 0;i < epro.length;i++){
		txt +=`
		
		 <div class="article"  > 
            <img src=""  alt="图片" />
            <ul class="article-info"  value = "${epro[i].id}">
					<li>${epro[i].name}</li>
					<li>${epro[i].info}</li>
					<li>${epro[i].sname}</li>
			</ul>
            <ul class="article-price"  >
            	<li > ${epro[i].mapket_price}</li>
                <li>
                    <a href="redirect?page=e-commerce_pay" >立即购买</a>
                      <a href="redirect?page=e-commerce_shoping-car" >加入购物车</a>
                </li>
            </ul> `
	}
	$(".eproduct").append(txt);
}

$(function(){
	var a = 0;
	$("#jiage").click(
			function(){
				a++;
				if(a%2 != 0){
					// 升序
					$.ajax({
						type : "post",
						url : "priceAsc",
						dataType : "json",
						success : function(data) {
							console.log("升序成功",data);
							epro(data);
						},
						error : function(data) {
							console.log("升序失败",data);
						}
					})		
				}
				else{
					// 降序
					$.ajax({
						type : "post",
						url : "/priceDesc",
						dataType : "json",
						success : function(data) {
							console.log("降序成功",data);
							epro(data);
						},
						error : function(data) {
							console.log("降序失败",data);
						}
					})
				}		
			})
})


$(function(){
	var pcount=$('#count').val();
	var psize=$('#pageSize').val();
	var pstart=$('#pageStart').val();
	var nowpage=Math.floor(pstart/psize)+1;
	var cpage=Math.ceil(pcount/psize);
	var strhtml="";
	if(cpage<=10){
		for(var i=1;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/priceAsc?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/priceAsc?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){	
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/priceAsc?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/priceAsc?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/priceAsc?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/priceAsc?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/priceAsc?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/priceAsc?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else{
		console.error(00000000);
	}
	$("#mydiv").html(strhtml);
	
});















$(".search-btn").on("click", function(){
	var name=$('#name').val();//取值      val函数没加（）点击搜索一直出现400错误
    location.href="/findProByname?name="+name;
  /*  console.log($('#name').val());*/
})
//根据服务商查
$(".search-btn2").on("click", function(){
	var name=$('#name').val();//取值      val函数没加（）点击搜索一直出现400错误
    location.href="/findProByProviderName?name="+name;
  /*  console.log($('#name').val());*/
})

$(".search-btn22").on("click", function(){
	var name=$('#name').val();//取值      val函数没加（）点击搜索一直出现400错误
    location.href="/findProByProviderName"
  /*  console.log($('#name').val());*/
})
//
//$(".search-service2").on("click", function(){
//    $(".search-service").removeClass("font-aqua");
//    $(".search-product").addClass("font-aqua");
//})
//==============

$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

//   分页展示电商页面所有产品    ePageProlist
$(function(){
	var pcount=$('#count').val();
	var psize=$('#pageSize').val();
	var pstart=$('#pageStart').val();
	var name=$('#name').val();
	var nowpage=Math.floor(pstart/psize)+1;
	var cpage=Math.ceil(pcount/psize);
	var strhtml="";
	if(cpage<=10){
		for(var i=1;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findProByname?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else{
		console.error(00000000);
	}
	$("#mydiv").html(strhtml);
});







$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
