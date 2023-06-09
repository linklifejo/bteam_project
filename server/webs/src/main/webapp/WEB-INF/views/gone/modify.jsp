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

</style>

<body>

<div class="main">
<h3>탐방록 안내수정</h3>
<form method='post' enctype='multipart/form-data' action='info.go'>
<input type='hidden'id="btn1" checked name='ptype' value='1'>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' name='title' value='${vo.title}' title='제목' class='chk full'></td>
</tr>
<tr><th>첨부파일</th>
	<td class='txt-left'>
		<c:forEach items="${vo.fileInfo}" var="f">
		<div class='align' data-file='${f.id}'>
		<label>
			<input type='file' name='file' id='attach-file'>
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<span id='file-name'>${f.filename}</span>
		<span id='preview'></span>
		<a id='delete-file' style='display:inline'><i class="font-img-r fa-regular fa-trash-can"></i></a>
		</div>
		</c:forEach>
		<c:if test="${empty vo.fileInfo}">
		
		<div class='align'>
		<label>
			<input type='file' name='file' id='attach-file'>
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<span id='file-name'></span>
		<span id='preview'></span>
		<a id='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>
		</div>		
		</c:if>
	</td>
</tr>
<tr><th>내용</th>
	<td><textarea name='content' title='내용' 
				class='chk full'>${vo.content}</textarea> </td>
</tr>
</table>
<input type='hidden' name='removed'>
<input type='hidden' name='id' value='${vo.id}'>
<input type='hidden' name='curPage' value='${page.curPage }'>
<input type='hidden' name='search' value='${page.search }'>
<input type='hidden' name='keyword' value='${page.keyword }'>
<input type='hidden' name='pageList' value='${page.pageList }'>
<input type='hidden' name='viewType' value='${page.viewType }'>
</form>


<div class='btnSet'>

<a class='btn-fill' id='save'>저장</a>
<a class='btn-empty' href='javascript:history.go(-1)'>취소</a>


<!-- <a class='btn-fill btn-save'>저장</a> -->
<!-- <a class='btn-empty' id='cancel'>취소</a> -->
</div>

</div>



<script>
<c:forEach items="${vo.fileInfo}" var="f" varStatus="s">
if( isImage( '${f.filename}' ) ){
	$('#preview').eq( ${s.index} )
			.html( '<img src="${f.filepath}">' );
}
</c:forEach>

$('#cancel').click(function(){
	$('form').submit();	
});

$('#save').on('click', function(){
	$('[name=removed]').val( $('#file-name').text() )
	if( emptyCheck() ) $('form').attr('action', 'update.go').submit();
});
</script>
</body>
</html>