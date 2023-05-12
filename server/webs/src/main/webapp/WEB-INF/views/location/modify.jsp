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
		
	}

	.main1{
		text-align: center; margin: 0 auto;
		container: text-center;
	}	


</style>



<body>
<div class="main">
	<h3>전국산정보수정</h3>
</div>
	<form method="post" action='update.lo' enctype="multipart/form-data">
	<table class='w-px600'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>산이름</th>
		<td><input type='text' name='locname' value='${vo.locname }'></td>
	</tr>
<tr><th>산 이미지</th>
	<td>
<%-- 	<img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.profile}"
	 alt="산이미지파일">
 --%>
	<div class='align'>

		<span class='preview'><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepath}" alt="사진파일"></span>
		<label>

			<input type='file' name='file' accept="image/*" class="d-none">
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>

		</div>
	</td>
</tr>
<tr><th>위험정보이미지</th>
	<td>
<%-- 	<img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.profile}"
	 alt="산이미지파일">
 --%>
	<div class='align'>

		<span class='preview'><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepathd}" alt="사진파일"></span>
		<label>

			<input type='file' name='file' accept="image/*" class="d-none">
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>

		</div>
	</td>
</tr>
<tr><th>안내도이미지</th>
	<td>
<%-- 	<img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.profile}"
	 alt="산이미지파일">
 --%>
	<div class='align'>

		<span class='preview'><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepatht}" alt="사진파일"></span>
		<label>

			<input type='file' name='file' accept="image/*" class="d-none">
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a class='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>

		</div>
	</td>
</tr>



	
	<tr><th>추가설명</th>
	
           <td><input type='text' name='name_desc' value='${vo.name_desc }'></td>
	
	</tr>
	<tr><th>위도</th>
		<td><input type='text' name='latitude' value='${vo.latitude }'></td>
	</tr>
	<tr><th>경도</th>
		<td><input type='text' name='longitude' value='${vo.longitude }'></td>
	</tr>
	<tr><th>주소</th>
		<td><a class='btn-fill btn-post'>우편번호찾기</a>
			<input type='text' name='post' value='${vo.post }' class='w-px60' >
			<input type='text' name='address' value='${vo.address }' class='full' >
			<input type='text' name='address' class='full'>
		</td>
	</tr>
	</table>
	<input type='hidden' name='id' value='${vo.id}'>
	</form>
	
<div class="main1">
	<div class='btnSet'>
		<a class='btn-fill' onclick="$('form').submit()">저장</a>
		<a class='btn-empty' href='info.lo?id=${vo.id}'>취소</a>
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
$('.btn-fill').click(function(){
	if( $('[name=locname]').val()=='' ){
		alert('이름을 입력하세요!');
		$('[name=locname]').focus();
	}
	if( $('[name=post]').val()=='' ){
		alert('주소를 입력하세요!');
		$('[name=address]').focus();
	}
});
function fn_delete(){
	if( confirm('[ ${vo.locname} ] 정말 삭제?') ){
	 	location.href='delete.cu?id=${vo.id}'
	}
}

</script>

</body>
</html>