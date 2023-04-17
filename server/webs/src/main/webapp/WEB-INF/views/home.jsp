<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
  </head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<style type="text/css">


/* 		position: relative;
		position: absolute; */
	.smdd{
		/* width: 800px; */
		container: text-center;
		text-align: center; margin: 0 auto;
	}
	
	.img{
		container: text-center;
		text-align: center; margin: 0 auto;
		width:100%;
		height:600px;
		position: relative;
		z-index: -1;
	}
	

	.mainimg {
		width: 250px;
		height: 300px;
		object-fit: contain;
	}


	.homeimg{
		width: 1100px;
		text-align: center; margin: 0 auto;
	}
	
	.mainfont{
		padding-bottom: 100px;
		font-size: 100px;
		font-weight: bold;
		position: absolute;
		left: 10px;
		top:250px;
		right: 10px;
		color: white;
	}
	
	.mainfont_1{
		padding-top: 200px;
	}
	
	
	.bd-example-cssgrid{
		container: text-center;
		text-align: center; margin: 0 auto;	
	}
	
	
	
</style>
<body onload="showImage()">
<div class="img">
 <img id="introimg" border="0" style= height:800px;width:1800px;>
</div>



<!-- <img src='imgs/mainm.png' style='width:100%'> -->
<!-- <img class="mainimg object-fit-cover border rounded" src='imgs/mainm.png' style='width:100%'> -->
<div class="mainsm">


<div class='smdd'>
<div class='btnSet'>
<div>
	<h1 class="mainfont">등산 가이드</h1>
</div>

	<h2 class="mainfont_1">인기산</h2>
</div>
<table class='w-px600 tb-list'>

<tbody>
<div class="homeimg">
<c:forEach items='${local_list}' var='vo'>
	<a href='info.go?id=${vo.id}'></a>
		<span style="display:inline-block; height:400px; width:350px;">
	
		<div class="card"><a href='info.go?id=${vo.gone_id}'><img class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
    		 alt="사진파일"></a>
		</div>
	
		</span>
</c:forEach>
</div>
</tbody>
</table>


<div class='btnSet'>
	<a href='list.go' class='btn-fill'>게시판</a>
</div>


<table class='w-px600 tb-list'>

<tbody>
<div class="homeimg" style="padding-bottom:30px">
<c:forEach items='${list}' var='vo'>
	
		<span style="display:inline-block; height:450px; width:350px;">
	
		<div style= "height:450px; width:350px;" class="card"><a style= "height:450px; width:350px;" href='info.go?id=${vo.gone_id}'><img style= "height:450px; width:350px;" class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
    		 alt="사진파일"></a>
		</div>
	
		</span>

</c:forEach>
</div>


</tbody>
</table>


</div>

</div>


  <body class="bd-example-cssgrid">

    <!-- Example Code -->
    
    <div class="grid text-center" style="--bs-columns: 1;" >
      <div><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
        두 번째 자동 열
        </font></font><div class="grid" style="--bs-columns: 3;">
          <div class="g-col-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">6/12</font></font></div>
          <div class="g-col-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">4/12</font></font></div>
          <div class="g-col-1"><font inherit;"><font style="vertical-align: inherit;"><a style="font-size: 20px; font-weight:bold;" href="https://map.forest.go.kr/forest/?systype=mapSearch&searchOption=trail#/">산 정보 찾아보기</a></font></font></div>
        </div>
      </div>
    </div>
    
    <!-- End Example Code -->  
    
    
<!--     
    <img alt="" src="src='imgs/mainm.png' style='width:100%;height:400px;">
    <img alt="" src="imgs/juwang.jpg">
    <img alt="" src="imgs/nam.jpg">
    <img alt="" src="imgs/tabak.jpg"> -->
  </body>
</html>


<!-- 
<script type="text/javascript">
$.ajax({
    url:'https://dapi.kakao.com/v2/local/search/address.json?query='+encodeURIComponent('숭의동'),
    type:'GET',
    headers: {'Authorization' : 'KakaoAK 481d31f68d1e3ee3ef028e3423236be5'},
success:function(data){
console.log(data);
},
error : function(e){
console.log(e);
}
});

</script> -->

<script type="text/javascript">
var imgArray=new Array();
imgArray[0]='imgs/mainm.png'
imgArray[1]='imgs/juwang.png'
imgArray[2]='imgs/dobog.png'
imgArray[3]='imgs/tebak.png'

function showImage(){
 var imgNum=Math.round(Math.random()*3);
 var objImg=document.getElementById("introimg");
 objImg.src=imgArray[imgNum];
 setTimeout(showImage,10000);
}
</script>


</body>
</html>
