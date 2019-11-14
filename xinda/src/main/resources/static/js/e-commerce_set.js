//账户设置
function getUser(id){			
			 $.ajax({
	                type:"post",
	                url:"/esetShow",
	                data:$('#login_value').serialize(),
	       success:function(data){
	                var sysUser=data.sysUser;
	                console.log(data);
	                var txt="";
	                txt+=`<tr><th>性别</th><th>姓名</th><th>邮箱</th></tr>`;
	                txt +=`<tr>
                	<td><input type="text" name="id" value="${eUser.id}" /></td>
                	<td><input type="text" name= "username" value="${eUser.name}" /></td>
                	<td><input type="text" name="password" value="${eUser.email}" /></td>
                		</tr>`;
                	   var tbody=$("<tbody></tbody>").html(txt);
                	   $('#eUser').html(tbody);//动态添加，把东东添加到id对应的表格里
	                   	                },
	       error:function(data){
	                	alert("操作错误！"+data);
	                	console.log("失败返回的数据",data);
	                },
	                })}





//---------------------------------------------------------------------
$(".search-product").on("click", function () {
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function () {
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function (event) {
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function (event) {
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function (event) {
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(".content-banner li").eq(0).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").hide();
    $(".account-info").show();
})
$(".content-banner li").eq(1).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").show();
    $(".account-info").hide();
})