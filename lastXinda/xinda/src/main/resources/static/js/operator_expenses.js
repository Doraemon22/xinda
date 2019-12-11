
$(".user-arrow-down").on("click", function () {
    if ($(".dropdown").is(":hidden")) {
        $(".dropdown").show();
    } else {
        $(".dropdown").hide();
    }
})
$(".business-order").on("click", function () {
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("支付中心");
})
$(".service-order").on("click", function () {
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("结算中心");
})
$(".search li").eq(0).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".search li").eq(1).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".search li").eq(2).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".search li").eq(3).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".qitian-btn").on("click", function(){
    location.href="/qitian";
})
$(".feiyong-btn").on("click", function(){
    location.href="/feiyong"
})
$(".yiyue-btn").on("click", function(){
    location.href="/yiyue"
})
$(".jintian-btn").on("click", function(){
    location.href="/jintian"
})

$(
		function() {
			var pcount = $('#pageCount').val();
			var psize = $('#pageSize').val();
			var pstart = $('#pageStart').val();
			var buy_time = $('#buy_time').val();
			var price = $('#price').val();
			var nowpage = pstart / psize + 1;
			//alert(pstart);
			var cpage = Math.ceil(pcount / psize);
			var strhtml = "";
			if (cpage <= 10) {
				for (var i = 1; i <= cpage; i++) {
					if (i == nowpage) {
						strhtml += '<a href=/feiyong?pageStart=' + psize
								* (i - 1) + '&buy_name=' + buy_name
								+ ' style="background-color:#aaaaaa">' + i
								+ '</a>';
					} else {
						strhtml += '<span> <a href=/feiyong?pageStart='
								+ psize * (i - 1) + '&buy_name=' + buy_name
								+ '>' + i + '</a></span>';
					}
				}
			} else if (cpage > 10 && 1 <= nowpage && nowpage <= 6) { //pagestart=20 nowpage=11 cpage=15
				//alert("111111===" + nowpage);
				for (var i = 1; i <= 10; i++) {
					if (i == nowpage) {
						strhtml += '<a href=/feiyong?pageStart='
								+ psize
								* (i - 1)
								+ '&buy_name='
								+ buy_name
								+ ' style="background-color:#aaaaaa;font-weight:700">'
								+ i + '</a>';
						//strhtml+='<a href=/userAll?pageStart='+psize*(i-1)+' style="background-color:#aaaaaa"><div class="nowpage">'+i+'</div></a>';
					} else {
						strhtml += '<span> <a href=/feiyong?pageStart='
								+ psize * (i - 1) + '&buy_name=' + buy_name
								+ '>' + i + '</a></span>';
					}
				}
			} else if (cpage > 10 && nowpage <= cpage - 4) {
				//alert("222222===" + nowpage);
				for (var i = nowpage - 5; i <= nowpage + 4; i++) {//6--15
					if (i == nowpage) {
						strhtml += '<a href=/feiyong?pageStart='
								+ psize
								* (i - 1)
								+ '&buy_name'
								+ buy_name
								+ ' style="background-color:#aaaaaa;font-weight:700">'
								+ i + '</a>';
					} else {
						strhtml += '<span><a href=/feiyong?pageStart='
								+ psize * (i - 1) + '&buy_name' + buy_name
								+ '>' + i + '</a></span>';
					}
				}
			} else if (cpage > 10 && cpage - 4 < nowpage
					&& nowpage <= cpage) {
				//alert("333333===" + nowpage);
				for (var i = cpage - 9; i <= cpage; i++) {
					if (i == nowpage) {
						strhtml += '<a href=/feiyong?pageStart='
								+ psize
								* (i - 1)
								+ '&buy_name='
								+ buy_name
								+ ' style="background-color:#aaaaaa;font-weight:700">'
								+ i + '</a>';
					} else {
						strhtml += '<span> <a href=/feiyong?pageStart='
								+ psize * (i - 1) + '&buy_name=' + buy_name
								+ '>' + i + '</a></span>';
					}
				}
			} else {
				console.error(00000000);
			}
			$("#mydiv").html(strhtml);

		});

	