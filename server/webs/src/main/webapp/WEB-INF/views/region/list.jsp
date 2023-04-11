<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
table tr:hover { cursor: pointer;  background-color: #f6f6f6 }


	.mainsm{
		display:flex;
		padding-top: 20px;
		
	}

	.smdd{
		width: auto;
		text-align: center;
		margin: 0 auto;
	}

	.top{
		display: flex; 
		position: relative;
	}


	.hrbtn{
		position: absolute;
		left: 10ox;
		bottom: 16px;
		right: 10px;
	}
	
</style>
<body>

<div class="mainsm">


<div class='smdd'>

<tbody>

<body>
<h3>지역별산</h3>

<form method='post' action='list.location'>
<div id='list-top' class='w-px1000 top' >
<ul style="padding-left: 0">
	<li>서울-경기</li>
	<li><select name='local_list' class='w-px180'
		 onchange="$('form').submit()">
			<option value='-1'>전체</option>
			<c:forEach items='${location}' var='l'>
			<option ${id eq l.id ? 'selected' : ''} value='${l.id }'>${l.name }</option>
			</c:forEach>
		</select>	
	</li>
</ul>
</div>
</form>


<table class='w-px1000 tb-list'>
<colgroup>
	<col width='100px'>
	<col width='200px'>
	<col width='220px'>
	<col>
	<col width='140px'>
</colgroup>
<tr><th>번호</th>
	<th>파일네임</th>
	<th>사진</th>
	<th>이름</th>
	<th>주소</th>
</tr>


<%-- <c:forEach items='${list}' var='vo'>
	<a href='info.go?id=${vo.id}'></a> --%>
<c:forEach items='${local_list }' var='vo'>
<tr><td><a href='info.re?id=${vo.id}'>${vo.locname }</a></td>
	<td>${vo.filename }</td>
	<td><img alt="서울산 사진" src="${vo.filepath }" style="width: 300px" height="300px;"></td>
	<td>${vo.name_desc }</td>
	<td>${vo.address }</td>
</tr>
</c:forEach>
</table>
	
</tbody>

</div>

</body>
</html>






