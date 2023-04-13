<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<header>
	<div class="head">
	<div class="mainhead">
		<a href='<c:url value="/"/>'><img src='imgs/main.png' width="100%" height="30px" ></a></li>
	</div>
	<div class="header">
	<div>
	<nav>
		<ul>

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
    <a ${category eq 're' ? "class='active'" : ''} href='<c:url value="/"/>list.re?L01'>서울.경기</a>
    <a ${category eq 're' ? "class='active'" : ''} href='<c:url value="/"/>region_2.re'>강원</a>
    <a ${category eq 're' ? "class='active'" : ''} href='<c:url value="/"/>region_3.re'>전라도</a>
    <a ${category eq 're' ? "class='active'" : ''} href='<c:url value="/"/>region_4.re'>경상도</a>
    <a ${category eq 're' ? "class='active'" : ''} href='<c:url value="/"/>region_5.re'>충청도</a>
    <a ${category eq 're' ? "class='active'" : ''} href='<c:url value="/"/>region_6.re'>제주도</a>
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
		
			<li><strong>${loginInfo.name}</strong> 님</li>
			<li><a class='btn-fill' ${category eq 'na' ? "class='active'" : ''} href='<c:url value="/"/>list.na'>내정보</a></li>
			<!-- <li><a class='btn-empty' href='changepw'>비밀번호변경</a></li> -->
			<li><a class='btn-fill' href='logout'>로그아웃</a></li>
		</c:if>
		</ul>
	</div>
	</div>
	</div>
	<div>
	<!-- <img src='imgs/mainm.png' style='width:100%'> -->
	<img class="mainimg object-fit-cover border rounded" src='imgs/mainm.png' style='width:100%;height:400px;'>
	</div>
</header>

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
}

</style>
