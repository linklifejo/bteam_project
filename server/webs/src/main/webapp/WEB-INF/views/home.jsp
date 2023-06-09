<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
  </head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>


	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="Viewport" content="width=device-width, initial-scale-1.0" />
	<title>기상청 날씨API</title>	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css" integrity="sha512-SbiR/eusphKoMVVXysTKG/7VseWii+Y3FdHrt0EpKgpToZeemhqHeZeLWLhJutz/2ut2Vw1uQEj2MbRF+TVBUA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<style type="text/css">


/* 		position: relative;
		position: absolute; */
	.smdd{
		/* width: 800px; */
		container: text-center;
		text-align: center; margin: 0 auto;
	}
	
/* 	.img1{
		container: text-center;
		text-align: center; margin: 0 auto;
		width:100%;
		height:800px;
		position: relative;
		z-index: -1;
	} */
	.img1{
		font-size: 100px;
		font-weight: bold;
		position: absolute;
		left: 10px;
		top:0px;
		right: 10px;
		z-index: -1;
	}
	
	
	.mainfont{
		font-size: 100px;
		font-weight: bold;
		position: absolute;
		left: 10px;
		top:200px;
		right: 10px;
	}
	
	.mainfont_1{
		font-size: 50px;
		font-weight: 900;
	}
	
	
	.bd-example-cssgrid{
		container: text-center;
		text-align: center; margin: 0 auto;	
	}
	
	
	.card-text{
	  width:300px;
	  webkit-line-clamp:2;
      padding:0 5px;
      margin-bottom: 40px;
      overflow:hidden;
      text-overflow:ellipsis;
      white-space:nowrap;
	}
	
	
	.text-center{
		container: text-center;
		text-align: center; margin: 0 auto;
		padding: 100px 0 100px 0;
		width: 900px;
		height: 700px;
		background-color: fff;
	}
	
	.grid{
	width: 900dp;
	height: 700dp;
	gap: var(--bs-gap, 0rem);
	background-color: fff;
	}
	
	
	.mapmain{
		position: relative;
		width: 450px;
	}
	
	.map1{
		position: absolute;
		left: 10px;
		top:210px;
		
	}


	.climbmain{
		position: relative;
		width: 450px;
	}
	

	.climb{
		position: absolute;
		left: 10px;
		top:210px;
		
	}

	.btn-dark{
		position: absolute;
		left: 10px;

	}
	
	.region{
		container: text-center;
		text-align: center; margin: 0 auto;	
	}
	
	
	
.text {
  width: 300px;
  display: -webkit-box;
  word-wrap: break-word;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
  overflow: hidden;
}
	
	
</style>
	
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pyPw+upLPUjgMXY0G+800xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

	

<!-- 
<script type="text/javascript">
var date = new Date();

var year = date.getFullYear();
var month = ('0' + (date.getMonth() + 1)).slice(-2);
var day = ('0' + date.getDate()).slice(-2);
var initDate = year + month + day;

console.log(date.getHours());
console.log(initDate);

var url ="https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"
	+ "?serviceKey=H%2B2%2ByRkjGYPQjyO0QIsSEBqKP%2Bna4lYEnkYd2suNuR6VKwU%2FT8hO8TU%2BctSqX9rXxgYxq0xsiq0rTxhOWGstag%3D%3D"
	+ "&pageNo=1&numOfRows=1000&dataType=json&base_date=" + initDate
	+ "&base_time=0500&nx=55&ny=127";		
	$.ajax({
		url: url,
		success: function (result) {
			console.log(result);
			var item = result.response.body.items.item[3];
			var content ='';
			item.baseDate + "," + item.baseTime + "," + item.obsrValue + "입니다";
			
			$(".result").text(content);
			
		},
	});

</script>

 -->

<!-- https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst?serviceKey=H%2B2%2ByRkjGYPQjyO0QIsSEBqKP%2Bna4lYEnkYd2suNuR6VKwU%2FT8hO8TU%2BctSqX9rXxgYxq0xsiq0rTxhOWGstag%3D%3D&pageNo=1&numOfRows=1000&dataType=json&base_date=20230504&base_time=0500&nx=60&ny=127
 -->
<!-- 
<script type="text/javascript">
var sky;
var pty;	
var date = new Date();

var year = date.getFullYear();
var month = ('0' + (date.getMonth() + 1)).slice(-2);
var day = ('0' + date.getDate()).slice(-2);
var initDate = year + month + day;
var hours = date.getHours()+'00';

console.log(hours);
console.log(initDate);


function sendDate(nx,ny){	

var url ="https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"
	+ "?serviceKey=H%2B2%2ByRkjGYPQjyO0QIsSEBqKP%2Bna4lYEnkYd2suNuR6VKwU%2FT8hO8TU%2BctSqX9rXxgYxq0xsiq0rTxhOWGstag%3D%3D"
	+ "&pageNo=1&numOfRows=1000&dataType=json&base_date=" + initDate
	+ "&base_time=0500&nx=" + nx
	+ "&ny=" + ny;
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
				$("#cst").attr('src', s[sky]);
			}else{
				pty = Number(pty.fcstValue);
				console.log('pty',pty,p[pty])
				$("#cst").attr('src', p[pty]);
			}
			console.log($("#cst").attr('src'))
		/* 	
			$("#cst").text(sky);
			$("#cst").text(pty); */
			
		},
	});
}
	 -->
	
	

<%-- 	/*}	
 	weather(initDate);

	function makeTable(src){
		var tableHTML ='';
		src.forEach(item=>{
			tableHTML += 
			'<tr><td>${filteredItems.fcstDate}</td><td>${filteredItems.fcstTime}</td><td>${filteredItems.fcstValue}</td></tr>';
		});
		$("table tbody").html(tableHTML);
	} */
	
/* 	weather(initDate);
	
	function makeTable(src){
		var tableHTML = '';
		src.forEach(item=>{
			tableHTML +='<tr><td>${item.fcstDate}</td><td>${item.fcstTime}</td><td>${item.fcstValue}</td></tr>';
		});
		$('table tbody').html(tableHTML);
	} */ --%>
</script>




<!--  
<script type="text/javascript">
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
				return (item.category.toLowerCase() == "sky" || item.category.toLowerCase() == "pty" || item.category.toLowerCase() == "tmp" || item.category.toLowerCase() == "reh") 
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
 			
 			var tmp = filteredsky.filter((item) => {
// 				return item.category == "SKY";
				return item.category.toLowerCase() == "tmp" 	
			});
 			
 			var reh = filteredsky.filter((item) => {
// 				return item.category == "SKY";
				return item.category.toLowerCase() == "reh" 	
			});
 			
 			pty = pty[0]
 			sky = sky[0]
 			tmp = tmp[0]
 			reh = reh[0]
 			console.log('pty ',pty);
 			console.log('sky ',sky);
 			console.log('tmp ',tmp);
 			console.log('reh ',reh);
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
 			var t = [0]
 			var r = [0]
			
			
			/* $("#cst").css('src', 'img/heart'+weather+'.png'); */
/* 			$("#cst").css('src', s[sky]);
			$("#cst").css('src', s[pty]); */
			
			console.log('pty.fcstValue> ',pty.fcstValue);
			console.log('sky.fcstValue> ',sky.fcstValue);
			console.log('tmp.fcstValue> ',tmp.fcstValue);
			console.log('reh.fcstValue> ',reh.fcstValue);

			if(Number(pty.fcstValue) == 0){
				sky = Number(sky.fcstValue);
				console.log('sky',sky,s[sky])
// 				$("table.weather tbody").append('<tr><td><img src="'+s[sky]+'"></td></tr>');
				$("table.weather tbody tr").eq(1).append('<td><img src="'+s[sky]+'"></td>');
				
			}else{
				pty = Number(pty.fcstValue);
				console.log('pty',pty,p[pty])
				//$("table.weather tbody").append('<tr><td><img src="'+p[pty]+'"></td></tr>');
				$("table.weather tbody tr").eq(1).append('<td><img src="'+p[pty]+'"></td>');
				/* $("#cst").attr('src', p[pty]); */
			}
				$("table.weather tbody tr").eq(0).append('<th>${vo.region}</th>');
			/* console.log($("#cst").attr('src')) */
		/* 	
			$("#cst").text(sky);
			$("#cst").text(pty); */
			
		},
	});
</c:forEach>
})

</script>


  <h3>날씨</h3>
 	<table class="weather">
		<tbody>
			<tr>
			
			</tr>
			<tr>
			</tr>
		</tbody>
 	</table>
	  


	 -->
	
	
<body onload="showImage()">

<div class="img1">
 <img id="introimg" border="0" style= height:500px;width:100%;>
 
</div>

<div class="mainsm">









<%-- <c:forEach items='${weather_list}' var='vo'>
<tr onclick="location='info.hr?id=${vo.id}'"><td>${vo.id }</td>
	<td>${vo.region}</td>
	<td>${vo.region_child}</td>
	<td>${vo.nx}</td>
	<td>${vo.ny}</td>
</tr>
</c:forEach>
 --%>
<div class='smdd'>




<%-- 
<button style="width: 50px; height: 50px;" type='button' onclick='sendDate(${ny},${ny})'></button>

<script>
$('button').on({
    'click': function() {
         var onclick = ($(this).attr('onclick') === 'sendDate(${ny},${ny})')
            ? 'sendDate(98,76)'
            : 'sendDate(89,90)';
         $(this).attr('onclick', onclick);
    }
});
</script> -->

 --%>




<div>
	<h1 class="mainfont"><img alt="" src="imgs/mainclimb.png"></h1>
	
	
	<!-- <h1 class="mainfont">등산 가이드</h1> -->
</div>
<%-- 							<div class="region">
								<h1 class="mainfont_1">인기산</h1>
							
							<table class='w-px600 tb-list'>
							
							<tbody>
							<div class="homeimg">
							<c:forEach items='${Loc_info}' var='vo'>
								<a href='info.go?id=${vo.id}'></a>
									<span style="display:inline-block; height:450px; width:350px;">
								
									<div  style= "height:450px; width:353px;" class="card"><a href='info.re?id=${vo.id}'><img style= "height:450px; width:350px;" class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
							    		 alt="사진파일"></a>
									</div>
								
									</span>
							</c:forEach>
							</div>
							</tbody>
							</table>
							</div> --%>

<h1 class="mainfont_1" style="margin-bottom: 50px;margin-top: 100px;">인기산</h1>

<%-- <c:forEach items='${Loc_info}' var='vo'>
           <span style="display:inline-block; height:450px; width:350px;">
                
                    <div class="col mb-5">
                    <div class="card h-100">
                     <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                    <div  style= "height:450px; width:353px;" class="card"><a href='info.re?id=${vo.id}'><img style= "height:450px; width:350px;" class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
							    		 alt="사진파일"></a>
									</div>
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${vo.filepath}" alt="사진">
                            <!-- Product details-->
                        </div>
                    </div>
			</div>
			</span>
</c:forEach>
</div>


 --%>



<c:forEach items='${Loc_info}' var='vo'>
   
   
  <!--  <section class="py-5"> -->
            <span style="display:inline-block; height:500px; width:400px;">
              
                    
                    <div class="col mb-5">
                        <div class="card h-100" style="width:400px;">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute " style="top: 0.5rem; right: 0.5rem width:50px; height:50px; font-size:30px;">${vo.rownum}</div>
                            <!-- Product image-->
                             <a href='info.re?id=${vo.id}' style= "height:500px; width:400px;"><img style= "height:700px; width:400px;" src="${vo.filepath}" class="card-img-top h-100" alt="사진">
                   			</a>
                   			<div style="font-size:30px; font-weight: bold;">${vo.locname}</div>
                            <!-- Product details-->
                 
                        </div>
                
				</div>
           </span>
    <!--     </section> -->
        
       
   </c:forEach>













  <body class="bd-example-cssgrid">

    <!-- Example Code -->
    
    <div class="grid text-center" style="--bs-columns: 1; width:1400px;margin-top: 100px;margin-bottom: 100px;" >
        <div class="grid" style="--bs-columns: 2; padding: 0 0 0 0">
          <div class="g-col-1 mapmain" style="padding-top: 0px;
		    padding-bottom: 0px;
		    border-top-width: 0px;
		    border-bottom-width: 0px;
		    border-left-width: 0px;
		    border-right-width: 0px;">  
		    
		    <a style="vertical-align: inherit;">
		    <img style="width: 700px;height: 600px;" alt="" src='imgs/kakaomap.png'>
		    <div class="map1" style="font-size: 40px; color: white; font-weight:bold;">
			<div>
			<a>지도로 위치 찾아보기</a>
			</div>
			<div>
		    <a href="#" onclick="window.open('https://map.kakao.com/','width=#,height=#')"><button type="button" class="btn btn-dark" style="font-size: 20dp;">위치 찾기</button></a>		    
			</div>
		    </div>
		    </a>
	      </div>
          
          
        
        <div class="g-col-1 climbmain"  style="padding-top: 0px;
		    padding-bottom: 0px;
		    border-top-width: 0px;
		    border-bottom-width: 0px;
		    border-left-width: 0px;
		    border-right-width: 0px;
		    font inherit;">
		    
		    <a style="vertical-align: inherit;">
		    <img style="width: 700px;height: 600px;" alt="" src='imgs/climb.png'>
		    <div class="climb" style="font-size: 40px; color: white; font-weight:bold;">
		    <div>
			<a>산 정보 찾아보기</a>
			</div>
			<div>
		    <a href="#" onclick="window.open('https://map.forest.go.kr/forest/?systype=mapSearch&searchOption=trail#/','width=#,height=#')"><button type="button" class="btn btn-dark">산정보 찾기</button></a>		    
			</div>
		    </div>
		    </a>
	      </div>
	    </div>
   </div>
   </body>
   
   

<div class='btnSet' style="margin-top: 200px; font-size:25px;margin-bottom: 50px;">
				<a href='list.go' class='btn-fill'>탐방글</a>
			</div>

   
<div class="row mx-5 justify-content-center">

		<div style="width:1400px;" class="row mx-5 justify-content-center">
	
			<c:forEach items='${list}' var='vo'>
                       
                        <div class="col-xl-3 col-md-6 mb-4" style="width:450px">
                            <div class="card border-left-primary shadow h-100 py-2">
                                                        <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute " style="top: 0.5rem; right: 0.5rem width:50px; height:50px; font-size:30px;">ID: ${vo.member_id}</div>
                            <!-- Product image-->
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div style="height:400px;" class="text-xs font-weight-bold text-primary text-uppercase mb-1">
			                            		<img src="${vo.filepath}" class="card-img-top h-100" alt="사진">
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                             <div class="card-body p-4">
                               <div>
                                   <!-- Product name-->
                                   <h5 class="fw-bolder">${vo.title}</h5>
                                   <!-- Product reviews-->
                                   <!-- Product price-->
                                   <span class="text-muted text">${vo.content}</span>
                                   <div class="d-flex justify-content-center small text-warning mb-2">
                                       <div class="bi-star-fill"></div>
                                       <div class="bi-star-fill"></div>
                                       <div class="bi-star-fill"></div>
                                       <div class="bi-star-fill"></div>
                                       <div class="bi-star-fill"></div>
                                   </div>
                                   
                               </div>
                           </div>
                                            
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><a class="btn btn-outline-dark mt-auto" href='info.go?id=${vo.gone_id}'>확인하기</a></div>
                                        </div>
                                      
                                    </div>
                                </div>
                            </div>
                        </div>
                      

                  </c:forEach>    
		</div>	

 
   </div>
   
   </div>
  
   
   
</div>

<!-- 								<div class='btnSet' style="margin-top: 100px;">
									<a href='list.go' class='btn-fill'>게시판</a>
								</div> -->

								
<%-- 								<table class='w-px600 tb-list'>
								
								<tbody>
								<div class="homeimg2">
								<c:forEach items='${list}' var='vo'>
								    
										<span style="display:inline-block; height:700px; width:450px;">
								     <div class="col mb-5">
								<div class="card" style= "height:600px; width:450px;">
								  <img src="${vo.filepath}" class="card-img-top h-100" alt="사진">
								  <div class="card-body">
								    <h5 class="card-title">${vo.title}</h5>
								    <p class="card-text">${vo.content}</p>
								    <a href='info.go?id=${vo.gone_id}' class="btn btn-primary mainbtn" style="color: white;">확인하기</a>
								  </div>
								</div>
								     </div>
								     
										</span>
								
								</c:forEach>
								</div>
								
								
								</tbody>
								</table> --%>


</div>

</div>


</body>
</html>

<script type="text/javascript">
var imgArray=new Array();
imgArray[0]='imgs/mainm.png'
imgArray[1]='imgs/juwang.png'
imgArray[2]='imgs/dobog.png'
imgArray[3]='imgs/tebak.png'

function showImage(){
 var imgNum=Math.round(Math.random()*3);
 var objImg=document.getElementById("introimg");
 objImg.src=imgArray[imgNum];
 setTimeout(showImage,10000);
}
</script>