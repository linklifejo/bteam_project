<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<style type="text/css">

	.main{
		text-align: center; margin: 0 auto;
		container: text-center;
		margin:50px;
		}

	.main1{
		text-align: center; margin: 0 auto;
		container: text-center;
	}	
	

</style>

<body>

<div class="main">
	<h3>전국산 등록</h3>
</div>
<form id='new' method='post' enctype='multipart/form-data' action='insert.lo'>
	<table class='w-px600'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>산이름</th>
		<td><input type='text' name='locname' class="w-100" ></td>
	</tr>
	
	<tr><th>산이미지</th>
	<td class='txt-left'>
		<div class="align">
		<label>
			<input type='file' name='file' class="d-none">
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>		
		<div class='file-name'></div>
		<div class='preview'></div>
		</div>
	</td>
	</tr>
	
		<tr><th>산위험정보이미지</th>
	<td class='txt-left'>
		<div class="align">
		<label>
			<input type='file' name='file' class="d-none">
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>		
		<div class='file-name'></div>
		<div class='preview'></div>
		</div>
	</td>
	</tr>
	
		<tr><th>산안내도이미지</th>
	<td class='txt-left'>
		<div class="align">
		<label>
			<input type='file' name='file' class="d-none">
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>		
		<div class='file-name'></div>
		<div class='preview'></div>
		</div>
	</td>
	</tr>
	
	<tr><th>추가설명</th>
		<td><textarea class="w-100" name='name_desc' ></textarea></td>
	</tr>

		<input type='hidden' value=1 name='latitude' ></td>
		<input  type='hidden' value=1 name='longitude' ></td>
	</tr>
	<tr><th>주소</th>
		<td><a class='btn-fill btn-post'>우편번호찾기</a>
			<input type='text' name='post' class='w-px60' readonly>
			<input type='text' name='address' class='full' readonly>
			<input type='text' name='address' class='full'>
		</td>
	</tr>
	</table>
	</form>

<div class="main1">
	<div class='btnSet'>
		<a class='btn-fill btn-save' onclick="if(losave())$('form#new').submit()">저장</a>
		<a class='btn-empty' href='list.lo'>취소</a>
	</div>
</div>

<script>

$('.btn-post').on('click', function(){
	new daum.Postcode({
        oncomplete: function(data) {
        	console.log(data);
        	$('[name=post]').val( data.zonecode );
        	
        	var address
        		= data.userSelectedType=='R' 
        		? data.roadAddress : data.jibunAddress;
        	if( data.buildingName!='' )
        		address += ' ('+data.buildingName + ')';
        	
			$('[name=address]:eq(0)').val( address );
			//$('[name=address]').eq(0).val( address );
        	
        }
    }).open();
});
function losave(){
	if( $('[name=locname]').val()=='' ){
		alert('이름을 입력하세요!');
		$('[name=locname]').focus();
		return false;
	}
	if( $('[name=post]').val()=='' ){
		alert('주소를 입력하세요!');
		$('[name=address]').focus();
		return false;
	}
	return true;

}



</script>
</body>
</html>