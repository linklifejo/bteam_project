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
	<h3>코스정보등록</h3>
	
</div>
	<form method="post" action='insert.co' class="myform" enctype='multipart/form-data'>

		<%-- <input type='hidden' name='location_id' class='loc2' value='${vo.id}'></input> --%>
	<table class='w-px600'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>코스이름</th>
		<td><input type='text' name='couname' ></td>
	</tr>
	<tr><th>안내도</th>
	<td class='txt-left'>
		<div class="align">
		<label>
			<input type='file' name='file' class='attach-file'>
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>		
		<div class='file-name'></div>
		<div class='preview'></div>
		</div>
	</td>
</tr>
	<!--1: 위험 2: A코스 3: B코스 4: C코스 -->
	<tr><th>구분</th>
		<td>
			<label><input type='radio' name='type' value='1'>위험</label>
			<label><input type='radio' checked name='type' value='2'>A코스</label>
			<label><input type='radio' name='type' value='3'>B코스</label>
			<label><input type='radio' checked name='type' value='4'>C코스</label>
			
		</td>
	</tr>
	<tr><th>산 선택</th>
		<td><select name='location_id' class='w-px120' name='viewType'>
		<c:forEach items="${list}" var="vo">
		<option value='${vo.id}'>${vo.locname}</option>
		</c:forEach>
		</select>
	</td>
	</tr>
	</table>
	</form>

<div class="main">
	<div class='btnSet'>
		<a class='btn-fill' onclick="$('form').submit()">저장</a>
		<a class='btn-empty' href='list.co'>취소</a>
	</div>
</div>	


</body>

<script>
/* $(function(){
	$( ".w-px120" ).change(function() {
		var v =$(this).val();
		$(".loc2").val(v);
		});
}) */
</script>



</html>