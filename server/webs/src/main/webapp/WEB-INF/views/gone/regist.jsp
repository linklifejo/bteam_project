<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	.align{
		position: relative;
	}

	.delete-file{
		position: absolute;
		left: 10ox;
		bottom: 0px;
		right: 10px;
	}



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
<h3>탐방 글쓰기</h3>
</div>
<form method='post' enctype='multipart/form-data' action='insert.go'>
<!-- <input type='hidden' name='course_id' class="co2" >  --><!-- 코스선택 -->
<!-- <input type='hidden' name='location_id' class="loc2" >  --><!-- 산선택 -->
<input type='hidden' name='member_id' value='${loginInfo.id}'>

<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' name='title' title='제목' class='chk full'></td>
</tr>

<!-- .align { display: flex; align-items: center; }
.align * { margin-right: 5px; } -->


<tr><th>첨부파일</th>
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



<!-- <input type='hidden' name='ptype' value='3'> -->
<script>
	$('#btn1').click(function(){
		var checked = $('#ck1').is(':checked');
		$('#ck1').prop('checked',!checked);
	});
</script>

<tr style="display:none"><th>가본산/찜한산</th>
		<td>
			<label><input type='radio'id="btn1" checked name='type' value='1'>가본산</label>
		</td>
</tr>
<tr><th>산 선택</th>
	<td><select name='location_id' class='w-px300 loc'>
		<c:forEach items='${location}' var='l'>		
		<option value='${l.id}'>${l.locname }</option>
		
		
		</c:forEach>		
		</select>
	</td>
</tr>


<tr><th>코스 선택</th>
	<td><select name='course_id' class='w-px300 cou'>
		<c:forEach items='${course}' var='c'>		
		<option value='${c.id}'>${c.couname }</option>
		
		
		</c:forEach>		
		</select>
	</td>
</tr>
<tr><th>내용</th>
	<td><textarea name='content' title='내용' class='chk full'></textarea> </td>
</tr>
</table>
</form>
<div class="main1">

<div class='btnSet'>
<a class='btn-fill btn-save'>저장</a>
<a class='btn-empty' href='list.go'>취소</a>


</div>
</div>





</body>

<script>
$('.btn-save').on('click', function(){
	if( emptyCheck() ) {
// 		$(".loc2").val( $( ".loc option:selected" ).val() );
// 		$(".co2").val(  $( ".cou option:selected" ).val() );
// // 		console.log('loc2:', $(".loc2").val(), ' co2:', $(".co2").val() );
		$('form').submit();
	}
});
</script>
</body>

<script>
$(function(){
	/*  
	*/
	$( ".loc" ).change(function() {
		var v =$(this).val();
		$(".loc2").val(v);
		});
	$( ".cou" ).change(function() {
		var v =$(this).val();
		$(".co2").val(v);
		});
})
</script>




</html>