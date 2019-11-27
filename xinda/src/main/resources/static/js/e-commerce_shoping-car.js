//顶端欢迎  
$(function(){
	var euser = sessionStorage.getItem("cellphone");
	var txt = "";
	txt += `${euser}`;
	$("#euser").append(txt);
  
})

function deletes(id){
	console.log("购物车id----",id);
	$.ajax({
		type:"post",
		url:"/e_delete",
		//请求参数
		data:{
			id:id,
		},
		//返回数据类型
		//请求成功后调用函数
		success: function(data){
			console.log("成功后返回数据",data);
			if(data.msg == "success"){
				alert("删除成功!");	
				location.href = "/showCart"
			}
			else if(data.msg == "false"){
				alert("删除失败!");	
			}
		},
		error: function(data){
			console.log("失败后返回数据",data);
		}
	})
}
//===========价格动态变化系列================================

$(function(){
	//数量值
	 	$(".myAmount").each(
	 		function(){
	 			$(this).attr("alt",$(this).val());//attr() 方法设置或返回被选元素的属性值
	 		}
	 	)
	 	.on("change",function(){
	 		alert(this.value);
	 		if($(this).val().indexOf("-")>=0 || $(this).val().indexOf("e")>=0 || $(this).val()=="" 
	 			|| $(this).val().indexOf(".")>=0 || $(this).val()=="0"){
	 			alert("请输入正整数");
	 			$(this).val($(this).attr("alt"));
	 			return;
	 		}
			var minusBtn = $(this).parent().find("input[name='minus']");
			if($(this).val()==1){//将 - 按钮设置为 disabled   alert(minusBtn.attr("disabled"));
				minusBtn.attr("disabled","disabled");
			}else if($(this).val()>1){//解除禁制
				minusBtn.removeAttr("disabled");
			}
			//小计
			var price = parseInt($(this).parent().parent().find(".myPrice").html());		//获取myPrice值
			var prodNum = parseInt($(this).val());
			var myPrice = (price * prodNum).toFixed(2);
			$(this).parent().parent().find(".prodTotalPrice").html(myPrice)//myPrice给prodTotalPrice
			totalPrice();
			$(this).attr("alt",$(this).val());
	 	});	
	})
//th:text= "${list.id}"

	function modifyPrice(type,obj){
	//alert( $(obj).parent().parent().find(".cartid").html());
	//$(obj).parent().parent().find(".cartid").hide();
		var price = parseInt($(obj).parent().parent().find(".myPrice").html());
		var prodNum = parseInt($(obj).siblings(".myAmount").val());//获取数量值
		if(type=="minus"){
			prodNum -= 1;
		}else if(type=="add"){
			prodNum += 1;
		}
		$(obj).siblings(".myAmount").val(prodNum)
		var minusBtn = $(obj).parent().find("input[name='minus']");
		if($(obj).siblings(".myAmount").val()==1){
			minusBtn.attr("disabled","disabled");
		}else if($(obj).siblings(".myAmount").val()>1){
			minusBtn.removeAttr("disabled");
		}
		var myPrice = (price * prodNum);//单个记录的金额
		$(obj).parent().parent().find(".prodTotalPrice").html(myPrice)
		totalPrice();
		$(obj).siblings(".myAmount").attr("alt",$(obj).siblings(".myAmount").val());
		
//		console.log("count==:"+$(obj).siblings(".myAmount").val());
//		console.log("money==:"+	$(obj).parent().parent().find(".prodTotalPrice").html());
	}
	//商品总计
	function totalPrice(){
		var prodTotalPriceList = $(".prodTotalPrice");
		var sum = 0;
		for(var i=0;i<prodTotalPriceList.length;i++){
			sum += parseFloat(prodTotalPriceList[i].innerHTML);
		}
		$("#totalPrice").html(sum.toFixed(2));
	}
	//加号+++++
	function add(obj){
		console.log("count=add=:"+$(obj).siblings(".myAmount").val());
		console.log("money=add=:"+	$(obj).parent().parent().find(".prodTotalPrice").html());
		console.log("cartid=add=:"+ $(obj).parent().parent().find(".cartid").html());
		var pnum=$(obj).siblings(".myAmount").val();
		var money=$(obj).parent().parent().find(".prodTotalPrice").html();
		var cartid=$(obj).parent().parent().find(".cartid").html();
		$.ajax({
			url:"/addMinusProNumInCart",
			type:"post",
			data:{
				pnum:pnum,
				money:money,
				cartid:cartid,
			},
			dataType:"json",
			success:function(data){
				if(data.code == 1){
					alert("增加数量成功！");
				}else{
					alert("增加数量失败！");
				}
			},
			error:function(){
				alert("操作失败");
			}
		});
	}
	//减号---------
	function minus(obj){
		console.log("count=jian=:"+$(obj).siblings(".myAmount").val());
		console.log("money=jian=:"+	$(obj).parent().parent().find(".prodTotalPrice").html());
		console.log("cartid=jian=:"+ $(obj).parent().parent().find(".cartid").html());
		var pnum=$(obj).siblings(".myAmount").val();
		var money=$(obj).parent().parent().find(".prodTotalPrice").html();
		var cartid=$(obj).parent().parent().find(".cartid").html();
		$.ajax({
			url:"/addMinusProNumInCart",
			type:"post",
			data:{
				//proid:proid,
				pnum:pnum,
				money:money,
				cartid:cartid,
			},
			dataType:"json",
			success:function(data){
				if(data.code == 1){
					alert("减少数量成功！");
				}else{
					alert("减少数量失败！");
				}
			},
			error:function(){
				alert("操作失败");
			}
		});
	}
//===============================================
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
				strhtml+='<a href=/showCart?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/showCart?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && 1<=nowpage && nowpage<=6){		//pagestart=20 nowpage=11 cpage=15
		for(var i=1;i<=10;i++){
			if(i==nowpage){
				strhtml+='<a href=/showCart?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/showCart?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && nowpage<=cpage-4){
		for(var i=nowpage-5;i<=nowpage+4;i++){//6--15
			if(i==nowpage){
				strhtml+='<a href=/showCart?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span><a href=/showCart?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else if(cpage>10 && cpage-4<nowpage && nowpage<=cpage){
		for(var i=cpage-9;i<=cpage;i++){
			if(i==nowpage){
				strhtml+='<a href=/showCart?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa;font-weight:700">'+i+'</a>';
			}else{
				strhtml+='<span> <a href=/showCart?pageStart='+psize*(i-1)+'>'+i+'</a></span>';
			}
		}
	}else{
		console.error(00000000);
	}
	$("#mydiv").html(strhtml);
});