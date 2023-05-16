<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=481d31f68d1e3ee3ef028e3423236be5"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=08dd488f50a99d25a7a8d38a4634f0d5"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=08dd488f50a99d25a7a8d38a4634f0d5&libraries=services"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css">

	.main{
		text-align: center; margin: 0 auto;
		container: text-center;
		margin:50px;


	.container{
		text-align: center; margin: 0 auto;
		container: text-center;
	}
	

	.main1{
		text-align: center; margin: 0 auto;
		container: text-center;	
	}

	.button{
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





 <div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-3 justify-content-center">
                <div class="col mb-5" style="width: 800px">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" style="width: 750px" height="600px" src="${vo.filepath}" alt="...">
                        <!-- Product details-->
             <div>
                 <div>
					<div class="text-center">
					 <table style="width:100%">
					 <tr>
					 	<th><h2>주소</h3></th>
					 </tr>
					 <tr>
						<td>${vo.address}</td>
					 </tr>
					 <tr>
					 	<th><h2>설명</h3></th>
					 </tr>
					 <tr>
						<td>${vo.name_desc}</td>
					 </tr>
					 </table>
							 <table style="width: 100%;">
							 
							 	<th><h2>코스정보</h3></th>
							 
									<c:forEach items='${cou}' var='cou'>
									<tr>
									<td>${cou.couname}</td>
									</tr>
									</c:forEach>
							 
							 </table>						
					</div>
				</div>
             </div>
                        <!-- Product actions-->
		
						<div id="staticMap" style="width:750px;height:450px;">
						</div>         
		       		</div>
		 	   </div>
</div>
<div class="button">
<button><a href='list.re?loccode=${vo.loccode}'>목록으로</a></button>
</div>

</div>






<%-- 				<div class="col mb-5">
				    <div class="card h-100">
				        <!-- Product image-->
				        <img class="card-img-top" style="width: 750px" height="600px" src="${vo.filepath}" alt="...">
				        <!-- Product details-->
				        <div class="card-body p-4">
				            <div class="text-center">
				                <!-- Product name-->
				                <h5 class="fw-bolder">Fancy Product</h5>
				                <!-- Product price-->
				                $40.00 - $80.00
				            </div>
				        </div>
				        <!-- Product actions-->
				        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
				        </div>
				    </div>
				</div>

 --%>

<%-- 	<table width="900px"'>
	<colgroup>
		<col width="140px">
		<col>
	</colgroup>
	<tr><th>산이름</th>
		<td>${vo.locname }</td>
	</tr>
	<tr><th>사진</th>
		<td><img class="mainimg object-fit-cover border rounded" style="width: 750px" height="600px" src="${vo.filepath}"
    		 alt="사진파일"></td>
	</tr>
	
	<tr><th>추가설명</th>
		<td>${vo.name_desc }</td>
	</tr>
	<tr><th>주소</th>
		<td>${vo.address}</td>
	</tr>
	<tr><th>지도</th>
		<td><!-- <div id="kakao_map" style="width:100%;height:300px;"></div> -->
		
				<div id="staticMap" style="width:600px;height:350px;"></div>    
		
		
		</td>
	</tr> 
	</table> --%>
	
	
<!-- 찜버튼 -->
	
<%-- <div class="container">
<img style="width: 50px;height: 50px;" alt="찜하기버튼" src="./imgs/heart1.png" id="pic">

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


</script> --%>



<script>


$.ajax({
    url:'https://dapi.kakao.com/v2/local/search/address.json?query='+encodeURIComponent('${vo.address}'),
    dataType:"json",
    type:'GET',
    headers: {'Authorization' : 'KakaoAK 481d31f68d1e3ee3ef028e3423236be5'},
success:function(data){
console.log('위경도 : ', data);
var address = data.documents[0];
console.log('경도 : ', address.x );
console.log('위도 : ', address.y );
console.log('주소 : ', address );
map_position(address);
},
error : function(e){
console.log(e);
}
});

</script>



<script>
// 이미지 지도에서 마커가 표시될 위치입니다 
function map_position(address) {
var markerPosition  = new kakao.maps.LatLng(address.y,address.x); 

// 이미지 지도에 표시할 마커입니다
// 이미지 지도에 표시할 마커는 Object 형태입니다
var marker = {
    position: markerPosition
};

var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
    staticMapOption = { 
        center: new kakao.maps.LatLng(address.y, address.x), // 이미지 지도의 중심좌표
        level: 3, // 이미지 지도의 확대 레벨
        marker: marker // 이미지 지도에 표시할 마커 
    };    

// 이미지 지도를 생성합니다
var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
}
</script>




<!-- 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=481d31f68d1e3ee3ef028e3423236be5&libraries=LIBRARY"></script>

services 라이브러리 불러오기
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=481d31f68d1e3ee3ef028e3423236be5&libraries=services"></script>

services와 clusterer, drawing 라이브러리 불러오기
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=481d31f68d1e3ee3ef028e3423236be5&libraries=services,clusterer,drawing"></script>

 -->




<!-- <script type="text/javascript">
axios.get(`https://dapi.kakao.com/v2/local/search/address.json?query=${fullAddress}`, {
    headers: { Authorization: 'KakaoAK {발급받은 REST 키}' },
})
    .then(res => {
        const location =res.data.documents[0];
        setLocationObj({
            si:location.address.region_1depth_name,
            gu:location.address.region_2depth_name,
            dong:location.address.region_3depth_name,
            locationX:location.address.x,
            locationY:location.address.y,
        })
    })
</script>
 -->





</body>
</html>