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
		margin-top:50px;
		}

	
	.tb-list{
		text-align: center; margin: 0 auto;
		container: text-center;		
	}

</style>
<body>

<div class="main">
<h3>코스목록</h3>


<div class='btnSet'>
	<a href='new.co' class='btn-fill'>코스등록</a>
</div>
</div>
<table class='w-px1000 tb-list'>
<thead>
	<tr>
		<th class='w-px300'>산이름</th>
		<th>코스명</th>
	</tr>
</thead>
<tbody>
<c:forEach items='${list}' var='vo'>
	<tr>
		<td>${vo.locname }</td>
		<td><a href='info.co?id=${vo.id}'>${vo.couname }</a></td>
	</tr>
</c:forEach>
	
</tbody>
</table>

</body>
</html>