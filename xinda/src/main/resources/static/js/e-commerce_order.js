//顶端欢迎  
$(function(){
	var euser = sessionStorage.getItem("cellphone");
	var txt = "";
	txt += `<span >${euser}</span>`;
	$("#euser").append(txt);//顶端

	var txt2 =`
        <p>${euser}</p>`;
	$(".userinfo").append(txt2);//显示头像下面的电话号码
})
//显示头像
$(function(){
	var id = sessionStorage.getItem("eid");
$(".imgshow").attr("src","/imgshow?id="+id);
})
function defaultImg(img){
		img.src="/images/user-lg.png";
	}


//查询按钮
$(".searchByEorderid").on("click", function(){
	console.log("000000000000000");
	//var eorderid=$('#eorderid').val();//取值    
   // location.href="/findOrderByNumber?eorderid="+eorderid;
    myOrder();
   // location.href="redirect?page=e-commerce_order";
    
})	

//订单展示
/*$(function(){
	myOrder();
})*/
function myOrder(){//		<li>` +item.sname+` </li> 
	var eid = sessionStorage.getItem("eid");
	var eorderid=$('#eorderid').val();
	var startTime = $(".startTime").val();
	var endTime = $(".endTime").val();
	$.ajax({
		type : "get",
		url : "/findOrderByNumber",
		data:{
			eid:eid,
			eorderid:eorderid,
			startTime:startTime,
			endTime:endTime,
			},
		dataType : "json",
		success:function (data) {
        	console.log(data);
        	var str = "";
        	$.each(data.showMyOrder,function(index,item){
    			if(item.status == 1){
    				str += `
    				<ul class="order-details"> 
    				<li>
    					<img src="/commentProImgShow?pid=` +item.product_id + `"  alt="图片" />
    					<ul> 
					
							<li>` + item.name + `</li>
							</ul> 
    				<p><span>¥</span>` + item.mapket_price + ` </p>
					<p>` +item.buy_num + `</p>
				 </li>
				<li class="font-aqua">`+item.mapket_price*item.buy_num+ `</li>
					<li class="font-aqua">等待买家付款</li> 
					<li> 
						<p onclick="pay(` + item.business_no +`)">付款</p>
						<span onclick = "deleteorderline(`+ item.business_no +`)">删除订单</span> 
					</li>
				</ul>
				
				<hr color="#ededed" size="1">
    				`;
    			}else{
    				str += `
        				<ul class="order-details"> 
        				<li>
        					<img src="/commentProImgShow?pid=` +item.product_id + `"  alt="图片" />
        					<ul> 
    							<li>` +item.sname+` </li> 
    							<li>` + item.name + `</li>
    							</ul> 
        				<p><span>¥</span>` + item.mapket_price + ` </p>
    					<p>` +item.buy_num + `</p>
    				 </li>
    				<li class="font-aqua">`+item.mapket_price*item.buy_num+ `</li>
    					<li class="font-aqua">买家已付款</li> 
    					<li> 
    						<p onclick="pay(` + item.business_no +`)">已付款</p>
    						<span onclick = "deleteorderline(`+ item.business_no +`)">删除订单</span> 
    					</li>
    				</ul>
    				
    				<hr color="#ededed" size="1">
        				`;
    			}
    		});
    		$(".orderList").html(str);
        },
		error : function(data) {
			console.log("失败", data);
		}
	})
}
//付款
function pay(orderid){
	var id=orderid;
	console.log("订单号：",orderid);
	//var eid = sessionStorage.getItem("eid");
	$.ajax({
		type : "post",
		url : "/payOrder",   //payInfo
		data : {
			id : id,
			//eid:eid
		},
		// 返回数据类型
		// 请求成功后调用函数
		success : function(data) {
			console.log("订单付款成功后返回数据", data);
			if (data.code == 1) {
				location.href = "/payInfo?id=" + id;     //当前的订单号
			} 
//			else {
//				alert("信息输入错误!");
//			}
		},
		// 请求失败后调用函数
		error : function(data) {
			console.log("订单付款失败后返回数据", data);
		}
	})
}

//删除订单
function deleteMyOrder(orderid)
{
	var orderid= orderid;
	console.log("删除的订单号：",orderid);
	$.ajax({
		type : "post",
		url : "/deleteMyOrder",
		dataType : "json",
		data : {
			orderid : orderid,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.msg == "删除成功"){
				alert("嘻嘻，删除我的订单成功!");	
				location.href = "/showCart"
			}
			else if(data.msg == "删除失败"){
				alert("删除我的订单失败!");	
			}
			location.href="/OrderShow" ;
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}


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




