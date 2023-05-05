<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr:hover {
	cursor: pointer;
	background-color: #f6f6f6
}

.mainsm {
	display: flex;
	padding-top: 20px;
}

.smdd {
	width: auto;
	text-align: center;
	margin: 0 auto;
}

.top {
	display: flex;
	position: relative;
}

.hrbtn {
	position: absolute;
	left: 10ox;
	bottom: 16px;
	right: 10px;
}
</style>



<script>					

$(function(){
var g = ['서울-경기','강원도','전라도','경상도','충청도','제주도']
g = g[ Number('${param.loccode}'.substr(1)) - 1 ]	
	console.log('${param.loccode}')
	console.log('${param.loccode}'.substr(1))
	console.log( Number('${param.loccode}'.substr(1)) - 1)
$('h3.g').text(g)
})
</script>

</head>


<body>

	<div class="mainsm">


		<div class='smdd'>

			<tbody>

				<body>
					<h3 class="g"></h3>
					
					



	
					<%-- <form method='post' action='list.location'>
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
</form> --%>

					<%-- 
<table class='w-px1000 tb-list'>
<colgroup>
	<col width='100px'>

	<col width='220px'>
	<col>
	<col width='140px'>
</colgroup>


<c:forEach items='${local_list}' var='vo'>
<tr>
	<td>${vo.id }</td>
	<td>${vo.locname}</td>
	<td><a href='info.re?id=${vo.id}'><img alt="서울산 사진" src="${vo.filepath }" style="width: 300px" height="300px;"></a></td>
	<td>${vo.address }</td>
</tr>
</c:forEach>

</table> --%>

<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach items='${local_list}' var='vo'>
			<div class="col mb-5"><a href='info.re?id=${vo.id}'>
				<div class="card h-100">
					<!-- Product image-->
				<img class="card-img-top h-100"
					src="${vo.filepath }"
					alt="사진">
				<!-- Product details-->
				<div class="card-body p-4 h-200">
					<div class="text-center">
						<!-- 산이름 -->
						<h5 class="fw-bolder">${vo.locname}</h5>
						<!-- 주소 -->
						${vo.address}
					</div>
				</div>
				
			</div>
			</a>
			</div>
			</c:forEach>
	</div>
</div>

					<%-- <table class='w-px1000 tb-list'>
<tbody>
<div class="homeimg">
<c:forEach items='${local_list}' var='vo'>
<a href='info.re?loccode=${vo.loccode}'></a>
<span style="width: 350px;">
<div style="display: flex; width: 350px;">
	<div>
	<div><a href='info.re?id=${vo.id}'><img alt="서울산 사진" src="${vo.filepath }" style="width: 300px" height="300px;"></a></div>
	<div>${vo.locname}</div>
	
	</div>
</div>
</span>
</c:forEach>
</div>
</tbody>
</table> --%>


					<%-- 	<table class='w-px600 tb-list'>

	<tbody>
	<div class="homeimg">
	<c:forEach items='${list}' var='vo'>
		<a href='info.re?loccode=${vo.loccode}'></a>
			<span style="display:inline-block; height:300px; width:250px;">
		
			<div class="card"><a href='info.go?id=${vo.gone_id}'><img class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
	    		 alt="사진파일"></a>
			</div>
		
			</span>
	</c:forEach>
	</div>
	</tbody>
	</table>
		 --%>
			</tbody>

		</div>
</body>
</html>






