<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>캐러셀(=슬라이드 이미지, 슬라이드 쇼)</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="style.css">
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
	
	
  .slide-container {
    width: 300vw; /* 전체 이미지들의 크기를 정해줘야 한다. */
    transition: all 0.3s; /* 이 단계에서 애니메이션 효과 ON, 애니속도 == 0.3초 */

  }
  .slide-box {
    width: 100vw;
    float: left; /* 각 이미지들(.slide-box)을 순서대로 좌측 정렬*/
  }
  .slide-box img{
    width: 100%; /* 이미지 사이즈 예쁘게 조절*/
  }


	
	.homeimg{
		text-align: center; margin: 0 auto;
		container: text-center;		
	}
	
	
	
	
	
	
	
	
	
	.slide-container {
 width: 300vw;
 transition: all 1s;
}
.slide-box {
 width: 100vw;
 float: left;
}
.slide-box img {
 width: 100%;
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



<div style="overflow: hidden">
<c:forEach items='${gone_myname}' var='vo'>

		<span style="display:inline-block; height:450px; width:350px;">
	
		<div  style= "height:450px; width:350px;" class="card"><a href='info.go?id=${vo.id}' ><img style= "height:450px; width:350px;" class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
    		 alt="사진파일"></a>
    		 <div>
    		 ${vo.title}'
    		 </div>
		</div>
	
		</span>
</c:forEach>
</div> 


   <div class="slide-container">
     <div class="slide-box">
       <img src="imgs/heart1.png">
     </div>
     <div class="slide-box">
       <img src="imgs/heart2.png">
     </div>
     <div class="slide-box">
       <img src="imgs/main1.png">
     </div>
   </div>




<button class="next">다음</button>
<script>

  var 지금사진 = 1;

  $('.next').on('click', function(){
      $('.slide-container').css('transform', 'translateX(-' + 지금사진 + '00vw)');
      지금사진 += 1;
  })
</script>






<button class="slide-1">1</button>
<button class="slide-2">2</button>
<button class="slide-3">3</button>

















<!-- 자동 테스트 이동 -->
<!-- <body>
    <h2 align = "center">아래의 텍스트가 움직여요!!</h2>
    <p>
	<MARQUEE>이 텍스트가 움직인답니다.</MARQUEE>
	움직이는 텍스트
    </p>
    <p>
	<MARQUEE><img src= "aaa.jpg" width="200" height="150"></MARQUEE>
	움직이는 사진
    </p>
    <p>
	<MARQUEE bgColor="blue">배경 색상은 파란색입니다.</MARQUEE>
	배경 색상 조정
    </p>
    <p>
	<MARQUEE width="100" height="50">가로와 세로는 100/50입니다.</MARQUEE>
	크기 조절
    </p>
    <p>
	<MARQUEE direction="up">스크롤 방향이 위쪽이됩니다.</MARQUEE>
	스크롤 방향 설정
    </p>
    <p>
	<MARQUEE behavior="scroll">스크롤의 무한반복</MARQUEE>
	스크롤의 속성
    </p>
    <p>
	<MARQUEE loop="5">스크롤을 5회반복합니다.</MARQUEE>
	스크롤의 속성
    </p>
    <p>
	<MARQUEE  scrollamount="2">한번에 2픽셀씩 이동합니다.</MARQUEE>
	스크롤의 속도
    </p>
    <p>
	<MARQUEE scrolldelay="200">0.2초마다 스크롤을 이동시킵니다.</MARQUEE>
	스크롤의 속도
    </p>
    <p>
	<MARQUEE hspace="50" vspace="50" >스크롤의 위/아래 여백을 줍니다.</MARQUEE>
	스크롤의 여백
    </p>
</body> -->



<div class='btnSet'>
	<a href='' class='btn-fill'>산 등록</a>
</div>
	<h1 class="mainfont_1">인기산</h1>
</div>
<table class='w-px600 tb-list'>

<tbody>
<div class="homeimg">
<%-- <c:forEach items='${gone_myname}' var='vo'>

		<span style="display:inline-block; height:450px; width:350px;">
	
		<div  style= "height:450px; width:350px;" class="card"><a href='info.go?id=${vo.id}' ><img style= "height:450px; width:350px;" class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
    		 alt="사진파일"></a>
    		 <div>
    		 ${vo.title}'
    		 </div>
		</div>
	
		</span>
</c:forEach> --%>
    <div style="overflow: hidden;"> <!-- 밑에 가로bar 사라지게 하는 코드 -->
<c:forEach items='${gone_myname}' var='vo'>
      <div class="slide-container" style="">
        <div class="slide-box" style="height: 450px; width: 350px;">

		<span style="display:inline-block; height:450px; width:350px;">
		<div class="slide-box" style="height: 450px;width: 350px;">
          <img src="${vo.filepath}" alt="" style="height: 450px;width: 350px;">
        </div>
	
		</span>
        </div>
      </div>
</c:forEach>
    </div>
</div>
</tbody>
</table>
    <button id="btn1">1</button>
    <button id="btn2">2</button>
    <button id="btn3">3</button>
    <button id="btn4">앞으로</button>
    <button id="btn5">뒤으로</button>
</body>


<script type="text/javascript">
//1. 버튼 눌렀을 때 아래와 같은 효과를 스타일에 적용
$('#btn1').on('click', function() {  
   $('.slide-container').css('transform','translateX(0vw)' )
 })
 $('#btn2').on('click', function() {
   $('.slide-container').css('transform','translateX(-100vw)' )
 })
 $('#btn3').on('click', function() {
   $('.slide-container').css('transform','translateX(-200vw)' )
 })
 
 
 
 // translateX 수치를 담을 변수를 생성.
var front = 100;

//클릭시 한칸씩(100vw) (.slide-container)클래스의 위치가 이동되야함.
$('#btn4').on('click', function() {
  if(front > 200) { // 일정 수치이상 되면 수치를 초기화 시켜 줘야함.
    front = 0;
  }
  $('.slide-container').css('transform','translateX(-'+front+'vw)' )
  front += 100;
})
    

//처음 뒤로가기 누르면 맨 뒤로 가야함. (-200vw)
// translateX의 수치가 +100씩 되야 함.
//(-200 -> -100 -> 0 -> -200 -> -100 .... )

    var back = -200; // 일단 맨 뒤로 가야 하기 때문에 수치의 초기값은 -200.
    $('#btn5').on('click', function() { 
      if(back > 0) { // 일정 수치가 되면 다시 초기값 -200으로 변경. 
        back = -200;
      }
      $('.slide-container').css('transform','translateX('+back+'vw)' )
      back += 100; // 클릭시 -200에서 +100씩 함.
    })
</script>
</html>