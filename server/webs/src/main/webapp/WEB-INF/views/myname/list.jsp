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
<h3>내정보</h3>


<!-- 내정보 -->
<%-- <table>
<colgroup>
	<col width='200px'>
	<col width='200px'>
	<col width='400px'>
</colgroup>

<tr>
			<c:if test='${not empty loginInfo}'>
	<td>
			<c:choose>
				<c:when test='${empty loginInfo.profile}'>
					<i class="font-profile fa-regular fa-circle-user"></i>
				</c:when>
				<c:otherwise>
					<img class='profile' src='${loginInfo.profile}'>
				</c:otherwise>
			</c:choose>
		
	</td>
	<td>
		<li><strong>${loginInfo.name}</strong>님 안녕하세요</li>
		<li>ID :   <strong>${loginInfo.name}</strong></li>
		<div>가입일자</div>
	</td>
		</c:if>
	<td>
	
		<div class='btnSet'>
			<a class='btn-fill' href='logout'>로그아웃</a>
		</div>


		<div class='btnSet'>
			<a href='new.lo' class='btn-fill'>내정보 수정</a>
		</div>
		
	
		<div class='btnSet'>
			<a class='btn-empty' href='changepw'>비밀번호변경</a>
		</div>
		
	</td>								 
</tr>


</table> --%>


<div class='btnSet'>
	<a href='' class='btn-fill'>산 등록</a>
</div>
<table class='w-px600 tb-list'>
<thead>
	<tr><th class='w-px140'>산이름</th>

	</tr>
</thead>
<tbody>
<c:forEach items='${gone_myname}' var='vo'>
	<tr><td><a href='info.lo?id=${vo.member_id}'>${vo.filepath }</a></td>

	</tr>
</c:forEach>
	
</tbody>
</table>

</body>
</html>