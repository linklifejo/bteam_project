<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h3>오픈소스 기반 지능형 IoT 융합 개발자 과정</h3>
<img src='imgs/hanul.png' style='width:80%'>
<script>
let ip, location_id, course_id, loccode, member_id  ;
sendInfo();
function sendInfo() {
    $.ajax({
        type: 'get',
        dataType: 'text',
        url: 'http://192.168.0.11/ib/stampInfo',
        success: function(result, status, xhr) {
            console.log('result 1> ', result);
            result = JSON.parse( result )
            console.log('result 2> ', result);
            
            ip = result.ip;
            member_id = result.member_id;
            location_id = result.location_id;
            course_id = result.course_id;
            loccode = result.loccode;
            console.log('ip> ', ip);
        },
    });
}



</script>
</body>
</html>
