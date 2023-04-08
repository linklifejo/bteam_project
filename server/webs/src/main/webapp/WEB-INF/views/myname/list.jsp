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



<table>
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


</table>


<h3>방문기록</h3>

<table class='w-px600 tb-list'>
<thead>
	<tr><th class='w-px140'>산이름</th>
		<th>추가설명</th>
		<th class='w-px160'>위도</th>
		<th class='w-px160'>경도</th>
	</tr>
</thead>
<tbody>
<c:forEach items='${list}' var='vo'>
	<tr><td><a href='info.lo?id=${vo.id}'>${vo.locname }</a></td>
		<td>${vo.name_desc }</td>
		<td>${vo.latitude }</td>
		<td>${vo.longitude }</td>
	</tr>
</c:forEach>
	
</tbody>
</table>





<h3>방문기록</h3>
<c:if test='${page.viewType eq "list"}'>
<table class='w-px1200 tb-list'>
<colgroup>
	<col width='100px'>
	<col>
	<col width='140px'>
	<col width='140px'>
</colgroup>
<tr><th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
</tr>
<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.no }</td>
	<td class='txt-left'><a onclick="fn_info( ${vo.id} )">${vo.title }</a>
	<c:if test='${vo.filecnt > 0}'>
	<span><i class="font-img-b fa-solid fa-paperclip"></i></span>
	</c:if>
<%-- 	<span>${vo.filecnt eq 0 ? '' : '<i class="font-img-b fa-solid fa-paperclip"></i>'}</span> --%>
	</td>
	<td>${vo.name }</td>
	<td>${vo.gone_date }</td>
</tr>
</c:forEach>
</table>
</c:if>





<div class="mainsm">


<div class='smdd'>
<div class='btnSet'>
	<a href='new.cu' class='btn-fill'>인기산</a>
</div>
<table class='w-px600 tb-list'>

<tbody>
<div class="homeimg">
<c:forEach items='${list}' var='vo'>
	<a href='info.go?id=${vo.id}'></a>
		<span style="display:inline-block; height:300px; width:250px;">
	
		<div class="card"><a href='info.go?id=${vo.id}'><img class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
    		 alt="사진파일"></a>
		</div>
		<div>${vo.filename}</div>
	
		</span>
</c:forEach>
</div>
</tbody>
</table>

</div>

</div>









<h3>탐방 후기</h3>
<c:if test='${page.viewType eq "list"}'>
<table class='w-px1200 tb-list'>
<colgroup>
	<col width='100px'>
	<col width='250px'>
	<col width='140px'>
	<col width='140px'>
</colgroup>
<div>
<tr><th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
</tr>
</div>
<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.no }</td>
	<td class='txt-left'><a onclick="fn_info( ${vo.id} )">${vo.title }</a>
	<c:if test='${vo.filecnt > 0}'>
	<span><i class="font-img-b fa-solid fa-paperclip"></i></span>
	</c:if>
<%-- 	<span>${vo.filecnt eq 0 ? '' : '<i class="font-img-b fa-solid fa-paperclip"></i>'}</span> --%>
	</td>
	<td>${vo.name }</td>
	<td>${vo.gone_date }</td>
</tr>
</c:forEach>
</table>
</c:if>







<h3>찜한산</h3>

<table class='w-px600 tb-list'>
<thead>
	<tr><th class='w-px140'>산이름</th>
		<th class='w-px160'>사진</th>
		<th class='w-px160'>작성자</th>
		<th class='w-px160'>경도</th>
	</tr>
</thead>
<tbody>
<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.location_id}</td>
	<td class='txt-left'><a onclick="fn_info( ${vo.id} )">${vo.title }</a>
	<c:if test='${vo.filecnt > 0}'>
	<span><i class="font-img-b fa-solid fa-paperclip"></i></span>
	</c:if>
<%-- 	<span>${vo.filecnt eq 0 ? '' : '<i class="font-img-b fa-solid fa-paperclip"></i>'}</span> --%>
	</td>
	<td>${vo.name }</td>
	<td>${vo.gone_date }</td>
</tr>
</c:forEach>
	
</tbody>
</table>







</div>

</body>
</html>