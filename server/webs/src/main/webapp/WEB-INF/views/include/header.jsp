<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<header>

    
	<div class="head">
	<div class="mainhead">
		</li>
	</div>
	<div class="header">
			 
			<!-- <div style="background-color: #80c3ed;">
	<MARQUEE scrolldelay="2000" scrollamount="70" width="200" height="50" direction="up">
<body>
 
 	<table class="weather">
		<tbody>
		
		</tbody>
 	</table>
 
	
</body>
	</MARQUEE>
			</div> -->
	<div>
	<nav>
		<ul>
		<li><a href='<c:url value="/"/>'><img src='imgs/bteam.main.png'></a></li>
		<c:if test='${not empty loginInfo}'>
			<c:choose>
				<c:when test='${loginInfo.admin eq "Y"}'>
					<li><a ${category eq 'hr' ? "class='active'" : ''} href='<c:url value="/"/>list.hr'>사원관리</a></li>
					<li><a ${category eq 'vi' ? "class='active'" : ''} href='<c:url value="/"/>visual/list'>시각화</a></li>
					<li><a ${category eq 'cu' ? "class='active'" : ''} href='<c:url value="/"/>list.cu'>고객관리</a></li>
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
		</c:if>
		<div class="dropdown">
  <button class="dropbtn">지역별산</button><%-- href='list.re?id=${vo.gone_id}' --%>
  <div class="dropdown-content">
    <a ${category eq 're1' ? "class='active'" : ''} href='<c:url value="/"/>list.re?loccode=L01'>서울.경기</a>
    <a ${category eq 're2' ? "class='active'" : ''} href='<c:url value="/"/>list.re?loccode=L02'>강원</a>
    <a ${category eq 're3' ? "class='active'" : ''} href='<c:url value="/"/>list.re?loccode=L03'>전라도</a>
    <a ${category eq 're4' ? "class='active'" : ''} href='<c:url value="/"/>list.re?loccode=L04'>경상도</a>
    <a ${category eq 're5' ? "class='active'" : ''} href='<c:url value="/"/>list.re?loccode=L05'>충청도</a>
    <a ${category eq 're6' ? "class='active'" : ''} href='<c:url value="/"/>list.re?loccode=L06'>제주도</a>
  </div>
</div>
		
		
					<li><a ${category eq 'go' ? "class='active'" : ''} href='<c:url value="/"/>list.go'>탐방정보</a></li>
					<li><a ${category eq 'co' ? "class='active'" : ''} href='<c:url value="/"/>list.co'>코스정보</a></li>
					<li><a ${category eq 'lo' ? "class='active'" : ''} href='<c:url value="/"/>list.lo'>전국산정보</a></li>
			<li><a ${category eq 'bo' ? "class='active'" : ''} href='<c:url value="/"/>list.bo'>자유 게시판</a></li>
			<!--지역별산 region -->
			<li><a ${category eq 'no' ? "class='active'" : ''} href='<c:url value="/"/>list.no'>찜</a></li>
			<li><a ${category eq 'no' ? "class='active'" : ''} href='<c:url value="/"/>list.no'>공지사항</a></li>
			<li><a ${category eq 'da' ? "class='active'" : ''} href='<c:url value="/"/>list.da'>공공데이터(산)</a></li>
		</ul>
	</nav>
	</div>
	<div class="login" style="float: right;">
		<ul style="padding-top: 0px;">
		<!-- 로그인하지 않은 경우 -->
		<c:if test='${empty loginInfo}'>
			<li><a class=' btn btn-primary' href='login'>로그인</a></li>
			<li><a class=' btn btn-primary' href='member'>회원가입</a></li>
		</c:if>
		<!-- 로그인된 경우 -->
		<c:if test='${not empty loginInfo}'>
			<c:choose>
				<c:when test='${empty loginInfo.profile}'>
					<i class="font-profile fa-regular fa-circle-user"></i>
				</c:when>
				<c:otherwise>
					<img class='profile' src='${loginInfo.profile}'>
				</c:otherwise>
			</c:choose>
		
			<li><strong>${loginInfo.name}</strong> 님</li><!-- href='info.go?id=${vo.id}' -->
			<li><a class='btn-fill' ${category eq 'na' ? "class='active'" : ''} href='list.na?member_id=${loginInfo.id}'>내정보</a></li>
			<!-- <li><a class='btn-empty' href='changepw'>비밀번호변경</a></li> -->
			<li><a class='btn-fill' href='logout'>로그아웃</a></li>
		</c:if>
		</ul>
	</div>
	
	
	</div>
	</div>
	<div>
	<div>
		<img alt="" src="imgs/main_2.png" style="height: 90px;" width="100%;">
		<div>${resultMap}</div>
	</div>
	</div>
</header>

</html>


<style>
.dropbtn {
  font-weight: bold;
  border: none;
  background-color: rgba(0, 0, 0, 0); /* rgb+alpha(=투명도) */	
  margin-left: 50px;
  color:#fff;
}
 
.dropdown {
  position: relative;
  display: inline-block;
  container: text-center;
  text-align: center; margin: 0 auto;
}
 
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #ebebeb; /* 서브메뉴 */
  min-width: 160px;

}
 
.dropdown-content a {
  color: black;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}
 
.dropdown:hover .dropdown-content {display: block;}
 
.dropdown:hover .dropbtn {background-color: background-color: rgba(0, 0, 0, 1);}






.font-profile { font-size: 50px; }
.profile { width:50px; height: 50px;  border-radius: 50%; }
.header { 
	border-bottom: 1px solid #aaa;
	align-items: center; justify-content: space-between;
	width:auto; justify-content: center; padding: 0 100px; 
	
	display: flex;
	position: relative;
}
.login{
	position: absolute;
	left: 10ox;
	bottom: 0px;
	right: 10px;
	top: 2px;
}



header nav ul { font-size: 18px; font-weight: bold; color:#fff;}
header ul { display: flex; 	padding-top: 8px; }
header nav ul li:not(:first-child) { margin-left: 50px }
header nav a:hover, header nav a.active { color:#fff;
  }

.head {
	background-color: rgba(0, 0, 0, .5); /* rgb+alpha(=투명도) */	 
	position: fixed; /* 절대위치 : top,right,bottom,left등의 좌표값 속성 */
	width: 100%;
	z-index: 100;
}



</style>


<!-- <script type="text/javascript">
var sky;
var pty;
/* var intiDate = $("#datepick").val();

$("form").submit(() => {
	let tDate = $("#datepcik").val();
	weather(tDate);
	return false;
});

function weather(initDate){ */
	
var date = new Date();

var year = date.getFullYear();
var month = ('0' + (date.getMonth() + 1)).slice(-2);
var day = ('0' + date.getDate()).slice(-2);
var initDate = year + month + day;
var hours = date.getHours()+'00';

console.log(hours);
console.log(initDate);

$(function(){
	
	
	<c:forEach items='${weather_list}' var='vo'>
			
var url ="https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"
	+ "?serviceKey=H%2B2%2ByRkjGYPQjyO0QIsSEBqKP%2Bna4lYEnkYd2suNuR6VKwU%2FT8hO8TU%2BctSqX9rXxgYxq0xsiq0rTxhOWGstag%3D%3D"
	+ "&pageNo=1&numOfRows=1000&dataType=json&base_date=" + initDate
	+ "&base_time=0500&nx=" + ${vo.nx}
	+ "&ny=" + ${vo.ny};	
	$.ajax({
		url: url,
		success: function (result) {
		console.log(result);
		var items = result.response.body.items.item
	/* 		var filteredItems = items.filter((item) => {
				return item.fcstTime = hours;
			}); */
 			var filteredsky = items.filter((item) => {
// 				return item.category == "SKY";
				return (item.category.toLowerCase() == "sky" || item.category.toLowerCase() == "pty") 
					&&  item.fcstTime == hours
				&&  item.fcstDate == initDate;
			});
 			var sky = filteredsky.filter((item) => {
// 				return item.category == "SKY";
				return item.category.toLowerCase() == "sky" 
		
			});
 			var pty = filteredsky.filter((item) => {
// 				return item.category == "SKY";
				return item.category.toLowerCase() == "pty" 
		
			});
 			pty = pty[0]
 			sky = sky[0]
 			console.log('pty ',pty);
 			console.log('sky ',sky);
/*  			var filteredpty = items.filter((item) => {
// 				return item.category == "SKY";
				return item.category.toLowerCase() == "pty" 
					&&  item.fcstTime == hours;
			}); */

			console.log('filteredsky> ',filteredsky);

			
			console.log('filteredsky> ',filteredsky[0].fcstValue);
		
/* 			
			- 하늘상태(SKY) 코드 : 맑음(1) sun, 구름많음(3)cloudy, 흐림(4)blur
			- 강수형태(PTY) 코드 : (초단기) 없음(0), 비(1) rain, 비/눈(2)rain_snow, 눈(3)snow, 빗방울(5) , 빗방울눈날림(6), 눈날림(7) 

			
			(단기) 없음(0), 비(1), 비/눈(2), 눈(3), 소나기(4)  */
		
			/* makeTable(filteredItems); */
			
			var s = ['', 'imgs/sun.png','','imgs/cloudy.png', 'imgs/blur.png']
			var p = ['', 'imgs/rain.png','imgs/rain_snow.png', 'imgs/snow.png','','imgs/raindrop.png','imgs/drift.png']
			
			/* $("#cst").css('src', 'img/heart'+weather+'.png'); */
/* 			$("#cst").css('src', s[sky]);
			$("#cst").css('src', s[pty]); */
			
			console.log('pty.fcstValue> ',pty.fcstValue);
			console.log('sky.fcstValue> ',sky.fcstValue);
			
			if(Number(pty.fcstValue) == 0){
				sky = Number(sky.fcstValue);
				console.log('sky',sky,s[sky])
 				$("table.weather tbody").append('<tr><td><img src="'+s[sky]+'"></td><td>${vo.region}</td></tr>');
				//$("table.weather tbody tr").eq(1).append('<td><img src="'+s[sky]+'"></td>');
				
			}else{
				pty = Number(pty.fcstValue);
				console.log('pty',pty,p[pty])
				$("table.weather tbody").append('<tr><td><img src="'+p[pty]+'"></td><td>${vo.region}</td></tr>');
				//$("table.weather tbody tr").eq(1).append('<td><img src="'+p[pty]+'"></td>');
				/* $("#cst").attr('src', p[pty]); */
			}
				//$("table.weather tbody tr").eq(0).append('<th>${vo.region}</th>');
			/* console.log($("#cst").attr('src')) */
		/* 	
			$("#cst").text(sky);
			$("#cst").text(pty); */
			
		},
	});
</c:forEach>
})
 -->
	
</script>


