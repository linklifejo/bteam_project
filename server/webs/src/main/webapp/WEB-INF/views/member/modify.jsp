<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr td{ text-align: left }
[name=address] { margin-top: 3px }
th span, p span { color:#ff0000; margin-right: 5px; }
p { margin: 10px auto;  text-align: right;}




.main{
		container: text-center;
		text-align: center; margin: 0 auto;
		margin-top: 50px;
	}
.main1{
		container: text-center;
		text-align: center; margin: 0 auto;
		margin-top: 30px;
	}




</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>


<div class="main">
<h3>회원정보수정</h3>
</div>
<p class='w-px600'><span>*</span>는 필수입력항목입니다</p>
<!-- 
파일을 전송하는 경우 주의점
1. form태그 전송방식을  반드시 post 로 지정
2. 첨부파일전송형식지정: enctype="multipart/form-data"
 -->
<form method='post' action='memberUpdate' enctype="multipart/form-data">
<table class='w-px600'>
<tr><th class='w-px140'><span>*</span>이름</th>
	<td><input type='text' name='name' value='${vo.name }'> </td>
</tr>

<tr><th><span>*</span>성별</th>
	<td><label>
			<input type='radio' name='gender' <c:if test="${vo.gender eq '남' }">checked</c:if> value='남'>남
		</label>
		<label>
			<input type='radio' name='gender' <c:if test="${vo.gender eq '여' }">checked</c:if> value='여'>여
		</label>
	</td>
</tr>
<tr><th><span>*</span>이메일</th>
	<td><input type='text' class='chk' name='email' value='${vo.email }'>
		<div class='invalid'>이메일을 입력하세요</div>
	</td>
</tr>
<tr><th>프로필이미지</th>
	<td>
<%-- 	<img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.profile}"
	 alt="사진파일">
 --%>
	<div class='align'>

		<span id='preview'><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.profile}" alt="사진파일"></span>
		<label>

			<input type='file' name='file' accept="image/*" id='attach-file'>
			<a><i class="font-img-b fa-solid fa-file-circle-plus"></i></a>
		</label>
		<a id='delete-file'><i class="font-img-r fa-regular fa-trash-can"></i></a>
		</div>
	</td>
</tr>

<tr><th>생년월일</th>
	<td><input type='text' name='birth' class='date' value='${vo.birth }' readonly>
		<a id='btn-delete'><i class="font-img-r fa-regular fa-circle-xmark"></i></a>
	</td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone' maxlength="13" value='${vo.phone }'></td>
</tr>
<tr><th>주소</th>
	<td><a class='btn-fill btn-post'>우편번호찾기</a>
		<input type='text' name='post' class='w-px60' readonly value='${vo.post }'>
		<input type='text' name='address' class='full' readonly value='${vo.address }'>
		<input type='text' name='address' class='full'>
	</td>
</tr>
</table>
<input type='hidden' name='id' value='${vo.id}'>
</form>

<div class="main1">
	<div class='btnSet main1'>
		<a class='btn-fill' onclick="$('form').submit()">회원정보수정</a>
<<<<<<< HEAD
		<%-- <a class='btn-empty' href='myname/list.na?id=${vo.id}'>취소</a> --%>
=======
>>>>>>> 5e048b8fe94a639fd9426262e033bc4a94e2f48e
		<a class='btn-empty' href='javascript:history.go(-1)'>취소</a>
	</div>
</div>
<script src='js/member_check.js?<%=new java.util.Date() %>'></script>
<script>
$('.btn-id').click(function(){
	id_check();
});


$('.btn-join').click(function(){
	if( $('[name=name]').val()=='' ){
		alert('이름을 입력하세요!');
		$('[name=name]').focus();
	}
	

	
	if( tagIsInvalid( $('[name=pw]') ) ) return;
	if( tagIsInvalid( $('[name=pw_ck]') ) ) return;
	if( tagIsInvalid( $('[name=email]') ) ) return;
	
	$('form').submit();
});
//태그의 입력값이 유효하지 않는지 확인할 함수
function tagIsInvalid( tag ){
	var status = member.tag_status( tag );
	if( status.code=='invalid' ){
		alert( '회원가입 불가\n' +  status.desc );
		tag.focus();
		return true;
	}else
		return false;
}



/* 만13세이상 회원가입하도록 생년월일 선택 날짜를 제한  */
var today = new Date();
var endDay = new Date( today.getFullYear()-13, today.getMonth()
						, today.getDate()-1 );
var range = today.getFullYear() - 80 + ":" + endDay.getFullYear();						
$('.date').datepicker({
	maxDate: endDay,
	yearRange: range
});					
 
$('.date').change(function(){
	$(this).next().css('display', 'inline')
});
$('#btn-delete').click(function(){
	$('.date').val('');
	$(this).css('display', 'none')
});

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
</script>

</body>
</html>



