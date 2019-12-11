//支付
$(".payment li").eq(1).on("click", function(){
	var payWay = $('input[name="pay"]:checked').val();
    var id = $(".orderId").text();
    console.log(id);
    $.ajax({
    	url:"/pay",
    	type:"post",
    	data:{
    		"id":id,
    		"payWay":payWay
    		},
    	success:function(data){
    		if(data.code==1){
    			alert("支付成功");
    			//location.href="/ePageProlist";
    			location.href="/OrderShow" ;
    		}else {
    			alert("支付失败");
    		}
    	},
    	error:function(){
    		alert("error");
    	}
    })
})
