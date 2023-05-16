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
		margin:50px;
		}

	.main1{
		text-align: center; margin: 0 auto;
		container: text-center;
	}


</style>


<body>
<div class="main">
	<h3>코스정보</h3>
</div>
	<table class='w-px600'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>코스명</th>
		<td>${vo.couname }</td>
	</tr>
		<tr><th>사진</th>
		<td><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepath}"
    		 alt="사진파일"></td>
	</tr>
	<tr><th>구분</th>
	<td >${vo.grade }</td>
	</tr>
	
	<tr><th>산이름</th>
		<td>${vo.locname }</td>
	</tr>
	</table>

<div class="main1">
	<div class='btnSet'>
		<a class='btn-fill' href='list.co'>코스목록</a>
		<a class='btn-fill' href='modify.co?id=${vo.id}'>정보수정</a>
		<a class='btn-empty' onclick='fn_delete()'>정보삭제</a>
	</div>
</div>

<script>

$('#type-name').text(s);
function fn_delete(){
	if( confirm('[ ${vo.couname} ] 정말 삭제?') ){
	 	location.href='delete.co?id=${vo.id}'
	}
}
</script>

</body>
</html>