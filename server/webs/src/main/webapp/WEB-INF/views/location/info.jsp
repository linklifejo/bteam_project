<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css">

	.main{
		text-align: center; margin: 0 auto;
		container: text-center;
	}


	.main1{
		text-align: center; margin: 0 auto;
		container: text-center;	
	}


</style>

<body>
<div class="main">
	<h3>전국산 정보</h3>
</div>
	<table width="900px"'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>산이름</th>
		<td>${vo.locname }</td>
	</tr>
	<tr><th>산이미지</th>
		<td><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepath}"
    		 alt="사진파일"></td>
	</tr>
		<tr><th>위험정보이미지</th>
		<td><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepathd}"
    		 alt="사진파일"></td>
	</tr>
		<tr><th>안내도이미지</th>
		<td><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepatht}"
    		 alt="사진파일"></td>
	</tr>
	
	<tr><th>추가설명</th>
		<td>${vo.name_desc }</td>
	</tr>
	<tr><th>위도</th>
		<td>${vo.latitude }</td>
	</tr>
	<tr><th>경도</th>
		<td>${vo.longitude }</td>
	</tr>
	<tr><th>주소</th>
		<td>${vo.address }</td>
	</tr>
	</table>


<div class="main1">
	<div class='btnSet'>
		<a class='btn-fill' href='list.lo'>전국산목록</a>
		<a class='btn-fill' href='modify.lo?id=${vo.id}'>정보수정</a>
		<a class='btn-empty' onclick='fn_delete()'>정보삭제</a>
	</div>
</div>	


<script>
function fn_delete(){
	if( confirm('[ ${vo.locname} ] 정말 삭제?') ){
	 	location.href='delete.lo?id=${vo.id}'
	}
}
</script>

</body>
</html>