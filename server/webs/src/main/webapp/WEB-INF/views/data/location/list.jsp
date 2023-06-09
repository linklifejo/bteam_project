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
<table class='tb-list location'>
<tr><th>해당 산이 없습니다</th>
</tr>
</table>
</c:if>
<c:forEach items="${list.item}" var="vo">
<table class='tb-list location'>
<colgroup>
	<col width='120px'>
	<col width='70px'><col width='100px'>
	<col width='70px'><col width='80px'>

</colgroup>

<tr><td rowspan='3'><img src="${vo.mntnattchimageseq}"></td>
	<th>산명</th><td>${vo.mntnnm}</td>
	<th>높이</th><td>${vo.mntninfohght}</td>
	<th>주소</th><td rowspan='3' colspan='9' class='txt-left'>${vo.mntninfopoflc}</td>	
</tr>

	
</table>
<table class='tb-list location desc'>

<tr><th>설명</th><td colspan='10' class='txt-left'>${vo.mntninfodtlinfocont}</td>
	
</tr>

</table>
</c:forEach>

<script>
$(function(){
	$('table.desc tr').each( function(idx){		
		$('table.desc tr:eq('+idx+ ') td').html( $('table.desc tr:eq('+idx+ ') td').text() );
	})
})
$('.location img').on('click', function(){
	$('#popup, #popup-background').css('display', 'block');
	$('#popup').html( $(this).clone() )
});
makePage( ${list.count}, ${page} );
</script>
</body>
</html>