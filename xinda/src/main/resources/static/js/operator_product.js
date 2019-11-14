$(".search-btn").on("click", function(){
	//var no=$('#BUSINESS_NO').val();//取值      val函数没加（）点击搜索一直出现400错误
    location.href="operator_orderform.html"
  /*  console.log($('#name').val());*/
})


$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})  