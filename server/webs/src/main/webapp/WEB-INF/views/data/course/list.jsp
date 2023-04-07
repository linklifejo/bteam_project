<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test='${empty list.item}'>
<table class='tb-list course'>
<tr><th>해당 산이 없습니다</th>
</tr>
</table>
</c:if>
<c:forEach items="${list.item}" var="vo">
<table class='tb-list course'>
<colgroup>
	<col width='120px'>
	<col width='70px'><col width='100px'>
	<col width='70px'><col width='80px'>
	<col width='200px'><col width='300px'>
	<col width='100px'><col width='300px'>
	<col width='100px'><col width='300px'>
</colgroup>
<%-- <tr><td rowspan='3'><img src="${vo.mntnattchimageseq}"></td>
	<th>산명</th><td>${vo.mntnnm}</td>
	<th>높이</th><td>${vo.mntninfohght}</td>
	<th>설명</th><td>${vo.mntninfodtlinfocont}</td>
	<th>추천코스</th><td><img src="${vo.rcmmncoursimageseq}"></td>
	<th>교통정보이미지</th><td><img src="${vo.mntninfotrnspinfoimageseq}"></td>
</tr>
<tr><th>주변관광정보이미지</th><td colspan='9' class='txt-left'><img src="${vo.crcmrsghtngetcimageseq}"></td>	
</tr>
<tr><th>주변관광정보설명</th><td colspan='8' class='txt-left'>${vo.crcmrsghtnginfodscrt}</td>
	<td>${vo.processState}</td>
</tr>
<tr><td colspan='2'>${vo.mntninfomapdnldfilenm}</td>
	<td colspan='7' class='txt-left'>${vo.mntninfopoflc}</td>
	<td colspan='2'>${vo.hkngpntdscrt}</td>
</tr> --%>
<tr><td rowspan='3'><img src="${vo.mntnfile}"></td>
	<th>산명</th><td>${vo.mntnimg}</td>
	<th>높이</th><td>${vo.mntninfourl}</td>
	
	<th>주변관광정보이미지</th><td><img src="${vo.mntnnm}"></td>
	<th>추천코스</th><td><img src="${vo.rcmmncoursimageseq}"></td>
	<th>교통정보이미지</th><td><img src="${vo.mntninfotrnspinfoimageseq}"></td>
</tr>
<tr>
	<th>주소</th><td rowspan='3' colspan='9' class='txt-left'>${vo.mntninfopoflc}</td>
</tr>	
	
</table>
<table class='tb-list location'>
<colgroup>
	<col width='120px'>
	<col width='80px'><col width='80px'>
	<col width='80px'><col width='100px'>
	<col width='200px'><col width='300px'>
	<col width='100px'><col width='300px'>
	<col width='100px'><col width='300px'>
</colgroup>
<tr><th>설명</th><td colspan='10' class='txt-left'>${vo.mntninfodtlinfocont}</td>
	
</tr>

</table>
</c:forEach>

<script>
$('.course img').on('click', function(){
	$('#popup, #popup-background').css('display', 'block');
	$('#popup').html( $(this).clone() )
});
makePage( ${list.count}, ${page} );
</script>
</body>
</html>