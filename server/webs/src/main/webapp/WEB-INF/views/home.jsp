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
	
	.img{
		container: text-center;
		text-align: center; margin: 0 auto;
		width:100%;
		height:800px;
		position: relative;
		z-index: -1;
	}
	

	.mainimg {
		width: 250px;
		height: 300px;
		object-fit: contain;
	}


	.homeimg{
		width: 2000px;
		text-align: center; margin: 0 auto;
		padding-bottom:100px;
		z-index: -2;
	}
	.homeimg2{
		width: 1200px;
		text-align: center; margin: 0 auto;
		padding-bottom:100px;
		z-index: -2;
	}
	
	
	
	.mainfont{
		font-size: 100px;
		font-weight: bold;
		position: absolute;
		left: 10px;
		top:250px;
		right: 10px;
		color: white;
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
	
	.mainbtn{
	margin-top: 50px;
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
	
</style>
	
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pyPw+upLPUjgMXY0G+800xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>

	


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
			var content = item.baseDate + "," + item.baseTime + "," + item.obsrValue + "입니다";
			
			$(".result").text(content);
		},
	});

</script>







<script type="text/javascript">
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

var url ="https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"
	+ "?serviceKey=H%2B2%2ByRkjGYPQjyO0QIsSEBqKP%2Bna4lYEnkYd2suNuR6VKwU%2FT8hO8TU%2BctSqX9rXxgYxq0xsiq0rTxhOWGstag%3D%3D"
	+ "&pageNo=1&numOfRows=1000&dataType=json&base_date=" + initDate
	+ "&base_time=0500&nx=55&ny=127";		
	$.ajax({
		url: url,
		success: function (result) {
			console.log('result> ',result);
			var items = result.response.body.items.item;
			console.log('ITEMS> ', items)
/* 			var filteredItems = [];
			for (var i = 0; i < items.length; i++){
				if (items[i].category == "TMP"){
					filteredItems.push(items[i]);
				}
			} */
		
	/* 		var filteredItems = items.filter((item) => {
				return item.fcstTime = hours;
			}); */
			var filteredItems = items.filter((item) => {
// 				return item.category == "SKY";
				return item.category.toLowerCase() == "sky" 
					&&  item.fcstTime == hours;
			});

			console.log('filteredItems> ',filteredItems);
			
			/* makeTable(filteredItems); */
			
		},
	});
	/*}	
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
	} */
</script>

	<div class="container">
 	<h1>기상청 날씨 API</h1>
	<h2>종로 날씨</h2>
	<form action="">
		<label for="datepick">날짜 선택</label>
		<input type="date" id="datepick"/>
		<button>조회</button>
	</form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>날짜</th>
				<th>시간</th>
				<th>온도</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan>조회내용이 없습니다</th>
			</tr>
		</tbody>
	</table>
	</div>
	<p class="result"></p>
	
	
	
	
<body onload="showImage()">
<div class="img">
 <img id="introimg" border="0" style= height:700px;width:100%;>
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

<div>
	<h1 class="mainfont"><img alt="" src="imgs/mainclimb.png"></h1>
	<!-- <h1 class="mainfont">등산 가이드</h1> -->
</div>
							<div class="region">
								<h1 class="mainfont_1">인기산</h1>
							
							<table class='w-px600 tb-list'>
							
							<tbody>
							<div class="homeimg">
							<c:forEach items='${Loc_info}' var='vo'>
								<a href='info.go?id=${vo.id}'></a>
									<span style="display:inline-block; height:450px; width:350px;">
								
									<div  style= "height:450px; width:350px;" class="card"><a href='info.re?id=${vo.id}'><img style= "height:450px; width:350px;" class="mainimg object-fit-cover border rounded" src="${vo.filepath}"
							    		 alt="사진파일"></a>
									</div>
								
									</span>
							</c:forEach>
							</div>
							</tbody>
							</table>
							</div>
</div>
  <body class="bd-example-cssgrid">

    <!-- Example Code -->
    
    <div class="grid text-center" style="--bs-columns: 1;" >
        <div class="grid" style="--bs-columns: 2; padding: 0 0 0 0">
          <div class="g-col-1 mapmain" style="padding-top: 0px;
		    padding-bottom: 0px;
		    border-top-width: 0px;
		    border-bottom-width: 0px;
		    border-left-width: 0px;
		    border-right-width: 0px;">  
		    
		    <a style="vertical-align: inherit;">
		    <img style="width: 450px;height: 500px;" alt="" src='imgs/kakaomap.png'>
		    <div class="map1" style="font-size: 40px; color: white; font-weight:bold;">
			<div>
			<a>지도로 위치 찾아보기</a>
			</div>
			<div>
		    <a href="https://map.kakao.com/"><button type="button" class="btn btn-dark" style="font-size: 20dp;">지도 찾기</button></a>		    
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
		    <img style="width: 450px;height: 500px;" alt="" src='imgs/climb.png'>
		    <div class="climb" style="font-size: 40px; color: white; font-weight:bold;">
		    <div>
			<a>산 정보 찾아보기</a>
			</div>
			<div>
		    <a href="https://map.forest.go.kr/forest/?systype=mapSearch&searchOption=trail#/" ><button type="button" class="btn btn-dark">산정보 찾기</button></a>		    
			</div>
		    </div>
		    </a>
	      </div>
	    </div>
   </div>
   </body>
</div>

								<div class='btnSet'>
									<a href='list.go' class='btn-fill'>게시판</a>
								</div>

								
								<table class='w-px600 tb-list'>
								
								<tbody>
								<div class="homeimg2">
								<c:forEach items='${list}' var='vo'>
								    
										<span style="display:inline-block; height:500px; width:350px;">
								     
								<div class="card" style= "height:450px; width:350px;">
								  <img src="${vo.filepath}" class="card-img-top" alt="사진" >
								  <div class="card-body">
								    <h5 class="card-title">${vo.title}</h5>
								    <p class="card-text">${vo.content}</p>
								    <a href='info.go?id=${vo.gone_id}' class="btn btn-primary mainbtn">확인하기</a>
								  </div>
								</div>
								     
								     
										</span>
								
								</c:forEach>
								</div>
								
								
								</tbody>
								</table>


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