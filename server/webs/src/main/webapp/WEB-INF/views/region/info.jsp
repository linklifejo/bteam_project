<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=481d31f68d1e3ee3ef028e3423236be5"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css">

	.main{
		text-align: center; margin: 0 auto;
		container: text-center;
	}

	.container{
		text-align: center; margin: 0 auto;
		container: text-center;
	}
	

	.main1{
		text-align: center; margin: 0 auto;
		container: text-center;	
	}


.dropdown-content a:hover {background-color: #ddd;}
 
.dropdown:hover .dropdown-content {display: block;}
 
.heart:hover {
	
}


</style>

<body>
<div class="main">
	<h3>${vo.locname }</h3>
</div>
	<table width="900px"'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>산이름</th>
		<td>${vo.locname }</td>
	</tr>
	<tr><th>사진</th>
		<td><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepath}"
    		 alt="사진파일">
	</tr>
	
	<tr><th>추가설명</th>
		<td>${vo.name_desc }</td>
	</tr>
	<tr><th>위도</th>
		<td></td>
	</tr>
	<tr><th>경도</th>
		<td></td>
	</tr>
	<tr><th>주소</th>
		<td>${vo.address }</td>
	</tr>
	<tr><th>지도</th>
		<td><div id="kakao_map" style="width:100%;height:300px;"></div></td>
	</tr> 
	</table>
	
	
	
<!-- 찜버튼 -->
	
<div class="container">
<img style="width: 50px;height: 50px;" alt="찜하기버튼" src="./imgs/heart1.png" id="pic">
<button><a href='list.re?id=${vo.id}'>목록으로</a></button>
</div>



<script type="text/javascript">
$(function () {
	
	let num = 0;
	$("#pic").click(function () {
		if(num == 0) {
			$(this).attr("src", "./imgs/heart1.png");
			num = 1;
		}else {
			$(this).attr("src", "./imgs/heart2.png");
			num = 0;
		}
	});
});

</script>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=08dd488f50a99d25a7a8d38a4634f0d5"></script>

 

<!-- 카카오 지도 -->

<script>

var kakao_mapContainer = document.getElementById('kakao_map'), // 지도의 중심좌표

    kakao_mapOption = {

        center: new kakao.maps.LatLng(36.332326, 127.434211), // 지도의 중심좌표

        level: 4 // 지도의 확대 레벨

    };

 

var kakao_map = new kakao.maps.Map(kakao_mapContainer, kakao_mapOption); // 지도를 생성합니다

 

// 지도에 마커를 표시합니다

var marker = new kakao.maps.Marker({

    map: kakao_map,

    position: new kakao.maps.LatLng(36.332326, 127.434211)

});

 

// 커스텀 오버레이에 표시할 컨텐츠 입니다

var content='<div class="map-info-panel">' +

            '       <div class="heading">' +

            '         <strong><?=$view->title?></strong>' +

            '         <div class="close" onclick="closeOverlay()" title="닫기"></div>' +

            '       </div>' +

            '       <div class="body">' +

            '           <div class="cont">'+

            '               <i class="fa fa-map-marker"></i> <?=mb_substr($view->address,5)?>'+

            '           </div>'+

            '           <a href="https://map.kakao.com/link/to/${vo.locname},36.332326,127.434211" target="_blank" class="btn btn-primary btn-sm" role="button"  target="_blank"><i class="fa fa-pencil hidden-xs hidden-sm"></i>길찾기</a>' +

            '       </div>' +

            '</div>';

 

// 마커 위에 커스텀오버레이를 표시합니다

// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다

var overlay = new kakao.maps.CustomOverlay({

    content: content,

    map: kakao_map,

    position: marker.getPosition()

});

 

// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다

kakao.maps.event.addListener(marker, 'click', function() {

    overlay.setMap(kakao_map);

});

 

// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다

function closeOverlay() {

    overlay.setMap(null);

}

</script>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>

<!-- services 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>

<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
 

</body>


</html>