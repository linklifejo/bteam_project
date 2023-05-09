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
	    <!-- step1. include bxslider files CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>    
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
	
	
	.homeimg{
		text-align: center; margin: 0 auto;
		container: text-center;		
	}
	
	
	
	
	
	
	
/* 	
	
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
	
	
	
	#mydiv {
  position: absolute;
  z-index: 9;
  background-color: #f1f1f1;
  border: 1px solid #d3d3d3;
  text-align: center;
}

#mydivheader {
  padding: 10px;
  cursor: move;
  z-index: 10;
  background-color: #2196F3;
  color: #fff;
}

	
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
#slider {
  position: relative;
  width: 1200px;
  height:450px;
  margin: 0 auto;
  visibility: hidden;
}
.btn {
  position: absolute;
  width: 3rem;
  height: 100%;
  top: 50%;
  transform: translateY(-50%);
  z-index: 1;
  border: 0;
  background: rgba(250, 250, 250, 0.3);
  transition: 0.2s;
  cursor: pointer;
  font-size: 2rem;
  background: #c3c3c3;
  opacity: 0.3;
  &:hover {
   background: rgba(250, 250, 250, 0.5);  
  }
  &.prev {
    left: 0;
  }
  &.next {
    right: 0;
  }
}


.wrapper {
  text-align: center; margin: 0 auto;
  container: text-center;	
  position: relative;
  width: 100%;
  height: 500px;
  overflow: hidden;
  padding: 3px 0;
  /* cursor: grab; */
  &.active {
   /*  cursor: grabbing; */
  }
}
.items {
  position: absolute;
  width: 500%;
  itemCount - 1;
  left: 0;
  top: 0;
  display: flex;
}
/* .items.active {
  transition: 0.3s; */
}
.item {
  width: 360px;
  pointer-events: none;
  position: relative;
  padding: 0 1rem;
}
  .content {
    width: 100%;
    height: 18rem;
    border: 1px solid #c8c8c8;
    box-shadow: 0 1rem 2.8rem rgba(0, 0, 0, 0.05);
    border-radius: 1rem;
    background-color: #fff;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: 700;
    font-size: 5rem;
    color: #fff;
  }

.content {
  &.pink {
    background: linear-gradient(315deg, #e899dc 0%, #d387ab 74%);
  }
  &.yellow {
    background: linear-gradient(315deg, #fce043 0%, #fb7ba2 74%);
  }
  &.skyblue {
    background-image: linear-gradient(315deg, #5de6de 0%, #b58ecc 74%);
  }
  &.orange {
    background-image: linear-gradient(315deg, #fc9842 0%, #fe5f75 74%);
  }
  
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


<%-- 
<div class="slides">
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



    <!-- step2. -->
    <script>
        $(document).ready(function(){
          $('.slides').bxSlider();
        });
      </script>
 --%>




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
<%--     <div style="overflow: hidden;"> <!-- 밑에 가로bar 사라지게 하는 코드 -->
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
    </div> --%>
</div>
</tbody>
</table>







<script type="text/javascript">
//Make the DIV element draggable:
dragElement(document.getElementById("mydiv"));

function dragElement(elmnt) {
  var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
  if (document.getElementById(elmnt.id + "header")) {
    // if present, the header is where you move the DIV from:
    document.getElementById(elmnt.id + "header").onmousedown = dragMouseDown;
  } else {
    // otherwise, move the DIV from anywhere inside the DIV:
    elmnt.onmousedown = dragMouseDown;
  }

  function dragMouseDown(e) {
    e = e || window.event;
    e.preventDefault();
    // get the mouse cursor position at startup:
    pos3 = e.clientX;
    pos4 = e.clientY;
    document.onmouseup = closeDragElement;
    // call a function whenever the cursor moves:
    document.onmousemove = elementDrag;
  }

  function elementDrag(e) {
    e = e || window.event;
    e.preventDefault();
    // calculate the new cursor position:
    pos1 = pos3 - e.clientX;
    pos2 = pos4 - e.clientY;
    pos3 = e.clientX;
    pos4 = e.clientY;
    // set the element's new position:
    elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
    elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
  }

  function closeDragElement() {
    // stop moving when mouse button is released:
    document.onmouseup = null;
    document.onmousemove = null;
  }
}
</script>










<div id="slider">
  <button class="btn prev"><</button>
  <div class="wrapper" style="width: 1200px;">
    <div class="items" style="left: 100;">
    <c:forEach items='${gone_myname}' var='vo' >
      <div class="item" style=""><div><a href='info.go?id=${vo.id}'><img src="${vo.filepath}" alt="" style="height: 450px;width: 350px;"></a></div><div><a style="font-size: 20px; font-weight: bold;" href='info.go?id=${vo.id}'>${vo.title}</a></div></div>
     </c:forEach>
    </div> 
  </div>  
  <button class="btn next">></button>
</div>





<script type="text/javascript">
const silder = document.querySelector('#slider');
const wrapper = document.querySelector('.wrapper');
const items = document.querySelector('.items');
const item = document.querySelectorAll('.item');
const next = document.querySelector('.next');
const prev = document.querySelector('.prev');
const itemCount = item.length - 2;
let startX = 0;         //mousedown시 위치
let moveX = 0;         //움직인 정도
let currentIdx = 0;    //현재 위치(index)
let positions = [];

function initializeData() {
  const isActive = items.classList.contains('active');
  if (isActive) items.classList.remove('active');
  const width = wrapper.clientWidth;
  const interval = item[1].clientWidth;
  const margin = (width - interval) / 2
  const initX = Math.floor((interval - margin) * -1);
  let pos = [];
  for (let i=0; i<itemCount; i++) {
    pos.push(initX - interval * i);
  }
  positions = pos;
  items.style.width = (itemCount + 1)*100 + '%';
  items.style.left = positions[currentIdx] + 'px';
  silder.style.visibility = 'visible';
}

window.addEventListener('resize', initializeData);
window.addEventListener('load', initializeData);

// btn click event
next.addEventListener('click', (e) => {
  if (currentIdx === itemCount - 1) return;  
  const isActive = items.classList.contains('active');
  if (!isActive) items.classList.add('active');
  currentIdx = currentIdx + 1;
  items.style.left = positions[currentIdx] + 'px';
});
prev.addEventListener('click', (e) => {
  if (currentIdx === 0) return;
  const isActive = items.classList.contains('active');
  if (!isActive) items.classList.add('active');
  currentIdx = currentIdx - 1;
  items.style.left = positions[currentIdx] + 'px';
});


wrapper.onmousedown =(e)=> {
  const rect = wrapper.getBoundingClientRect();
  startX = e.clientX - rect.left;
  const isActive = items.classList.contains('active');
  if (!isActive) items.classList.add('active');
  items.addEventListener('mousemove', onMouseMove);
  document.onmouseup =(e)=> {
    if (wrapper.classList.contains('active')) wrapper.classList.remove('active');
    items.removeEventListener('mousemove', onMouseMove);
    document.onmouseup = null;
    if (moveX > -70 && moveX <= 70) {
      //   만약 -70~70이면 초기위치로 이동
      return items.style.left = positions[currentIdx] + 'px';
    }
    if (moveX > 0 && currentIdx > 0) {
      currentIdx = currentIdx - 1;
      items.style.left = positions[currentIdx] + 'px';
    }
    if (moveX < 0 && currentIdx < itemCount - 1){
      currentIdx = currentIdx + 1;
      items.style.left = positions[currentIdx] + 'px';
    }
    
  }
}
/* 
function onMouseMove(e) {
  if (!wrapper.classList.contains('active')) wrapper.classList.add('active');
  const rect = wrapper.getBoundingClientRect();
  moveX = e.clientX - rect.left - startX;
  const left = positions[currentIdx] + moveX;
  if (currentIdx === 0 && moveX > 0) return;
  else if(currentIdx === itemCount - 1 && moveX < 0) return;
  items.style.left = left + 'px';
} */
</script>







</html>