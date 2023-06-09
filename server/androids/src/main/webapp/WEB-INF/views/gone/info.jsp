<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table td { text-align: left; }
#comment-regist, #comment-list { width: 600px; margin: 0 auto; text-align: left }
#comment, textarea.modify { height: 60px; margin-top: 5px;}
#comment-regist div { display: flex;  justify-content: space-between;}
</style>
</head>
<body>
<h3>탐방기록 안내</h3>
<table class='w-px1200'>
<colgroup>
	<col width='140px'>
	<col>
	<col width='140px'>
	<col width='140px'>
	<col width='100px'>
	<col width='100px'>
</colgroup>
<tr><th>제목</th>
	<td colspan='5'>${vo.title}</td>
</tr>
<tr><th>작성자</th>
	<td>${vo.name}</td>
	<th>작성일자</th>
	<td>${vo.gone_date}</td>
	<th>조회수</th>
	<td>${vo.readcnt}</td>
</tr>
<tr><th>내용</th>
	<td colspan='5'>${fn: replace(vo.content, crlf, '<br>')}</td>
</tr>
<tr><th>첨부파일</th>
	<td colspan='5'>
	<c:forEach items='${vo.fileInfo}' var='f'>
	<div class='align'>
		<span>${f.filename}
<%-- 			<a href='download.go?id=${f.id}'><i class="font-img-b fa-solid fa-file-arrow-down"></i></a> --%>
			<a class='download' data-file='${f.id}'><i class="font-img-b fa-solid fa-file-arrow-down"></i></a>
		</span>
		<span class='preview'></span>
	</div>
	</c:forEach>
	</td>
</tr>
</table>
<div class='btnSet'>
	<a class='btn-fill' id='list'>목록으로</a>
	<!-- 방명록 글 작성자만 수정/삭제 가능 -->
	<c:if test="${vo.member_id eq loginInfo.id}">
	<a class='btn-fill' id='modify'>정보수정</a>
	<a class='btn-fill' id='delete'>정보삭제</a>
	</c:if>
</div>

<div id='comment-regist'>
	<div><span>댓글작성</span>
		<a class='btn-fill-s' id='regist'>댓글등록</a>
	</div>
	<textarea id='comment' class='full'></textarea>
</div>
<div id='comment-list'></div>

<form method='post' action='download.bo'>
<input type='hidden' name='file'>
<input type='hidden' name='id' value='${vo.id}'>
<input type='hidden' name='curPage' value='${page.curPage }'>
<input type='hidden' name='search' value='${page.search }'>
<input type='hidden' name='keyword' value='${page.keyword }'>
<input type='hidden' name='pageList' value='${page.pageList }'>
<input type='hidden' name='viewType' value='${page.viewType }'>
</form>

<script>
$('#regist').click(function(){
	if( $('#comment').val()=='' ){
		alert('댓글을 입력하세요!');
		$('#comment').focus();
	}else if( ${empty loginInfo} ) {
		alert('댓글을 등록하려면 로그인하세요!');
		location = 'login'
	}else{
		$.ajax({
			url: 'gone/comment/insert',
			data: { gone_id: ${vo.id}, content: $('#comment').val(), member_id: '${loginInfo.id}' },
			success: function( response ){
				console.log( response )
				if( response ){
					alert('댓글이 등록되었습니다!');
					$('#comment').val('');
					comment_list();
				}else{
					alert('댓글이 등록 실패ㅠㅠ');
				}
			},error: function(req, text){
				alert(text+':'+req.status);
			}
		});
	}
	
});

comment_list();

//댓글목록 조회
function comment_list(){
	$.ajax({
		url: 'gone/comment/list/${vo.id}',
		success: function( response ){
			$('#comment-list').html( response );
		},error: function(req,text){
			alert(text+':'+req.status)
		}
	});
}

$('#list, #delete, #modify').click(function(){	
	$('form').attr('action', $(this).attr('id') + '.go')
	if( $(this).attr('id')=='delete' ){
		if( confirm('정말 삭제?') ){
			$('form').submit();			
		}
	}else
		$('form').submit();
});

$('.download').click(function(){
	$('[name=file]').val( $(this).data('file') )
	$('form').submit();
});

<c:forEach items="${vo.fileInfo}" var='f' varStatus='state'>
if( isImage( '${f.filename}' ) ){
	$('.preview').eq( ${state.index}).html( '<img src="${f.filepath}">' )
}
</c:forEach>

</script>
</body>
</html>












