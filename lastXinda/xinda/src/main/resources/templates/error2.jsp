<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error!</title>
<style>
   body{
   	background-color: #f6f6f6;
   }
	.main{
		 position: fixed;
	    top: 20%;
	    left: 0px;
	    right: 0px;
	    z-index: 999;
	    width: max-content;
	    margin: 0 auto 0;
	}
	.rabbit{
	 	width: 300px;
        height: 300px;
	}
	.text{
		font-size: 22px;
	}
</style>
</head>
<body>
	<div class="main">
		<img class="rabbit" src="./images/ai.jpg" />
	   ${message}
		<span class="text"><a href="javascript:history.go(-1)">返回</a></span>
	</div>
</body>
</html>