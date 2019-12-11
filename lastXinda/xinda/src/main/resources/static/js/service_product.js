$(function(){
	var provider=sessionStorage.getItem("cellphone");
	var id=sessionStorage.getItem("pid");
	
	var txt = "";
	txt += `<span >${provider}</span>`;
	$("#provider").append(txt);//顶端

})

//显示头像
$(function() {
	var id = sessionStorage.getItem("pid");
	$(".imgshow").attr("src", "/headImg2?id="+id);
})
function defaultImg(img) {
	img.src = "/images/default_user.png";
}



$(".search-btn").on("click", function(){
	var name=$('#name').val();
    location.href="/findSproByName?name="+name;
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
				strhtml+='<a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
		//alert("111111===" + nowpage);
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
				//strhtml+='<a href=/ePageProlist?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
			}else{
				strhtml+='<span> <a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		//alert("222222===" + nowpage);
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		//alert("333333===" + nowpage);
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/findSproByName?pageStart='+psize*(i-1)+'&name='+name+'>'+i+'</a></span>';
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
$(".add-product-action").on("click", function(event){
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