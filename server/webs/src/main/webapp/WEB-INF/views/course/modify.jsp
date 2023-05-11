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
	<h3>코스정보수정</h3>
</div>
	<form method="post" action='update.co' enctype='multipart/form-data'>
	<table class='w-px600'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>코스명</th>
		<td><input type='text' name='couname' value='${vo.couname }'></td>
	</tr>
<tr><th>안내도</th>
	<td>
<%-- 	<img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.profile}"
	 alt="사진파일">
 --%>
	<div class='align'>

		<span id='preview'><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepath}" alt="사진파일"></span>
		<label>
			<input type='file' name='file' accept="image/*" id='attach-file'>
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a id='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>
		</div>
	</td>
</tr>
	<tr><th>구분</th>
		<td>
			<label><input type='radio' name='type' value='1'>위험</label>
			<label><input type='radio' checked name='type' value='2'>A코스</label>
			<label><input type='radio' name='type' value='3'>B코스</label>
			<label><input type='radio' checked name='type' value='4'>C코스</label>
		</td>
	</tr>

	<tr><th>산이름</th>
		<td><input type='text' name='locname' value='${vo.locname }'></td>
	</tr>
	</table>
	<input type='hidden' name='id' value='${vo.id}'>
	</form>


<div class="main1">
	<div class='btnSet'>
		<a class='btn-fill' onclick="$('form').submit()">저장</a>
		<a class='btn-empty' href='info.co?id=${vo.id}'>취소</a>
	</div>
</div>	


<script>
function fn_delete(){
	if( confirm('[ ${vo.couname} ] 정말 삭제?') ){
	 	location.href='delete.co?id=${vo.id}'
	}
}
</script>

</body>
</html>