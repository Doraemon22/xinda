//顶端欢迎  
$(function(){
	var euser = sessionStorage.getItem("cellphone");
	var txt = "";
	txt += `${euser}`;
	$("#euser").append(txt);
})

//头像显示
$(function(){
	var id = sessionStorage.getItem("eid");
$(".imgshow").attr("src","/imgshow?id="+id);
})
function defaultImg(img){
		img.src="/images/user-lg.png";
	}
//******************                 *************************


function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}

//立即购买
function toPay(id){//产品id
	console.log("产品号：",id);
	var eid = sessionStorage.getItem("eid");
	$.ajax({
		type : "post",
		url : "/toPay",   
		data : {
			id : id,
			eid:eid
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("toPay成功后返回数据", data);
			if (data.code == 1) {
				location.href = "/payInfo?id=" + data.id;     //动态新增的订单号，控制层：toPay
			} else {
				alert("信息输入错误!");
				location.href = "/findProByname"
			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("toPay失败后返回数据", data);
		}
	})
}
//-------添加产品到购物车
function addCar(id){  //产品id
	console.log(id);
	var eid = sessionStorage.getItem("eid");
	$.ajax({
		// 请求类型
		type : "post",
		// 请求路径
		url : "/addCart",
		// 请求参数
		data : {
			id : id,
			eid:eid,
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("成功后返回数据", data);
			if (data.code == 1) {
				alert("添加购物车成功！");
				location.href = "/findProByname"
			} else {
				alert("添加购物车  失败！");
				location.href = "/findProByname"
			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("失败后返回数据", data);
		}
	})
}

//---------------------------------------------------------------------

//排序
function price(){
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
							AscDescList(data);
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
							AscDescList(data);
						},
						error : function(data) {
							console.log("降序失败",data);
						}
					})
				}		
			})
}
//
function AscDescList(data)
{
	var epro = data.epro;
	var txt = "";
	$(".list").append().html("");
	if(epro!=null){
		for(var i = 0;i<epro.length;i++)//  <li>${eOderPro[i].sname}</li>

		{
		txt+=`
		<div class = "article">
	<img src="/proImgShow?id=${epro[i].id}"  alt="图片" />
            <ul class="article-info">
            <li>${epro[i].name}</li>
            <li>${epro[i].info}</li>
          <li> ${epro[i].sname}</li>
        </ul>
        <ul class="article-price"  >
                <li th:text="${epro.mapket_price}"  ></li>
                <li>
                     <a th:data-id="${epro.id}" th:onclick="toPay(this.getAttribute('data-id'))">立即购买</a>
                     <a th:data-id="${epro.id}" th:onclick="addCar(this.getAttribute('data-id'))">加入购物车</a>
                </li>
            </ul>
        </div>
        
        `
		}
	$(".list").append(txt);}
	else{
		alert(data.msg);
	}
}

$(".search-btn").on("click", function(){
	var name=$('#name').val();//取值    
    location.href="/findProByname?name="+name;
    
    var branch = sessionStorage.getItem("branch");
	var likename = $(".likename").val();
	console.log(branch,likename);
	$.ajax({
		type : "post",
		url : "/findProByname",
		data:{
			branch:branch,
			likename:likename,
		},
		dataType : "json",
		success : function(data) {
			console.log("成功",data);
			if(data.status==1)
			{
				alert(data.state);
			}else{
				productlist(data);
			}
		},
		error : function(data) {
			console.log("失败",data);
		}
})
})


$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

//模糊查询分页  分页展示电商页面所有产品    ePageProlist
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
