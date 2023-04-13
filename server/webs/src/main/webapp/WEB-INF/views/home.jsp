<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
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


	.mainimg {
		width: 250px;
		height: 300px;
		object-fit: contain;
	}


	.homeimg{
		width: 1100px;
		text-align: center; margin: 0 auto;
	}
	
	
</style>



<!-- <img src='imgs/mainm.png' style='width:100%'> -->
<!-- <img class="mainimg object-fit-cover border rounded" src='imgs/mainm.png' style='width:100%'> -->
<div class="mainsm">


<div class='smdd'>
<div class='btnSet'>
	<h2 >인기산</h2>
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

</body>
</html>
