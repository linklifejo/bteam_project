#include <ESP8266WiFi.h>
#include <WiFiClient.h>
//#include <WiFi.h>
//#include <HTTPClient.h>
#include <ESP8266WebServer.h>
#include <SoftwareSerial.h> 
#define LED LED_BUILTIN
#define TX D0 // arduino softSerial RX -> NodeMcu D6(TX)
#define RX D1 // arduino softSerial TX -> NodeMcu D7(RX) 
const char* ssid = "hanul201";
const char* password = "hanul201";
SoftwareSerial arduSerial(RX, TX); // (RX, TX)
// WiFiClient client;
// HTTPClient http;
char float1[10] = {0,}; // atof()함수를 위해 char 자료형 배열을 10바이트 선언
ESP8266WebServer server(80);
String check;
 String    member_id;
  String  location_id;
  String  course_id;
  String  loccode;
    void handleRoot() {
     Serial.println("You called root page");
     
     String s = "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>";
     s += "<div><h1>NodeMCU_13</h1>";
     s += "<button type='button' onclick='sendData(1)'>LED ON</button>";
     s += "<button type='button' onclick='sendData(0)'>LED OFF</button><BR></div>";
     s += "<div>ADC Value is : <span id='ADCValue'>0</span><br>";
     s += "LED State is : <span id='LEDState'>NA</span></div>";
     s += "<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>";
     s += "<script>";
     //s += "let member_id,location_id,course_id,loccode; ";
     //s += "ADCValue.onchange = function(){sendGet(ADCValue.text())};";
     s += " function sendGet() {";
    // s += " function sendGet(member_id, location_id, course_id, loccode) {";
     s += "$.ajax({";
     s += "type : 'get',";
     s += "url : 'http://192.168.0.11/ib/stampIn?member_id=" + member_id +"&location_id=" + location_id + "&course_id=" + course_id + "&loccode=" + loccode +"',";
     s += "success : function(result, status, xhr) {";
     s += " if(result=='스템프성공'){;";     
     s += "setJolla();";      
     
     s += "}";        
     s += " $('#ADCValue').html(result);"; 
     s += "},});}";
     
     s += " function sendInfo() {";
     s += "$.ajax({";
     s += "type : 'get',";
     s += "dataType : 'text',";
     s += "url : 'http://192.168.0.11/ib/stampInfo',";
     s += "success : function(result, status, xhr) {";
     s += " console.log('result',result);";
     s += " result = JSON.parse( result );";
     s += " console.log('result',result);";     
     s += " ip=result.ip;"; 
     s += " member_id=result.member_id;"; 
     s += " location_id=result.location_id;";
     s += " course_id=result.course_id;";
     s += " loccode=result.loccode;";  
     s += " console.log('ip> ',ip);";
     s += "},});}";
     
     s += "function sendData(led) {";
     s += "$.ajax({ type : 'get',";
     s += " url : '/setLED?LEDstate=' + led,";
     s += " success : function(result, status, xhr) { ";
     s += " console.log(result);";
     s += " $('#LEDState').html(result);";
    // s += "sendInfo();";      
     s += " sendGet();";
    //  s += " sendGet(member_id,location_id,course_id,loccode);";     
     s += "}, }); }";

     s += "setInterval(function() { ";
    // s += "getData();";
     s += "}, 2000);";

    //  s += "function getData() { ";
    //  s += "$.ajax({ type : 'get',";
    //  s += "url : '/readADC',";
    //  s += "success : function(result, status, xhr) { ";
    //  s += " console.log(result);";
    //  s += " $('#ADCValue').html(result);";
    //  //s += " sendGet($('#ADCValue').text());";
    //  s += " sendGet(ip,member_id,location_id,course_id,loccode);";
    //  s += " }, });";

     s += "function setJolla() { ";
     s += "$.ajax({ type : 'get',";
     s += "url : '/setJolla',";
     s += "success : function(result, status, xhr) { ";
   
     s += " console.log(result);";
     s += " $('#JollaValue').html(result);";
     s += " }, });";


     s += "}</script><br></body></html>";
     server.send(200, "text/html", s);// 웹 브라우저에 표시.
    }


   void handleStamp() {
    Serial.println("You called root page");
     
     String s = "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>";
     s += "<div><h1>NodeMCU_13</h1>";
     s += "<button type='button' onclick='sendData(1)'>LED ON</button>";
     s += "<button type='button' onclick='sendData(0)'>LED OFF</button><BR></div>";
     s += "<div>ADC Value is : <span id='ADCValue'>0</span><br>";
     s += "LED State is : <span id='LEDState'>NA</span></div>";
     s += "<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>";
     s += "<script>";
     s += "sendGet();";     
     //s += "let member_id,location_id,course_id,loccode; ";
     //s += "ADCValue.onchange = function(){sendGet(ADCValue.text())};";
     s += " function sendGet() {";
    // s += " function sendGet(member_id, location_id, course_id, loccode) {";
     s += "$.ajax({";
     s += "type : 'get',";
     s += "url : 'http://192.168.0.11/ib/stampIn?member_id=" + member_id +"&location_id=" + location_id + "&course_id=" + course_id + "&loccode=" + loccode +"',";
     s += "success : function(result, status, xhr) {";
     s += " if(result=='스템프성공'){;";     
     s += "setJolla();";      
     
     s += "}";        
     s += " $('#ADCValue').html(result);"; 
     s += "},});}";
     
     s += " function sendInfo() {";
     s += "$.ajax({";
     s += "type : 'get',";
     s += "dataType : 'text',";
     s += "url : 'http://192.168.0.11/ib/stampInfo',";
     s += "success : function(result, status, xhr) {";
     s += " console.log('result',result);";
     s += " result = JSON.parse( result );";
     s += " console.log('result',result);";     
     s += " ip=result.ip;"; 
     s += " member_id=result.member_id;"; 
     s += " location_id=result.location_id;";
     s += " course_id=result.course_id;";
     s += " loccode=result.loccode;";  
     s += " console.log('ip> ',ip);";
     s += "},});}";
     
     s += "function sendData(led) {";
     s += "$.ajax({ type : 'get',";
     s += " url : '/setLED?LEDstate=' + led,";
     s += " success : function(result, status, xhr) { ";
     s += " console.log(result);";
     s += " $('#LEDState').html(result);";
    // s += "sendInfo();";      
     s += " sendGet();";
    //  s += " sendGet(member_id,location_id,course_id,loccode);";     
     s += "}, }); }";

     s += "setInterval(function() { ";
    // s += "getData();";
     s += "}, 2000);";

    //  s += "function getData() { ";
    //  s += "$.ajax({ type : 'get',";
    //  s += "url : '/readADC',";
    //  s += "success : function(result, status, xhr) { ";
    //  s += " console.log(result);";
    //  s += " $('#ADCValue').html(result);";
    //  //s += " sendGet($('#ADCValue').text());";
    //  s += " sendGet(ip,member_id,location_id,course_id,loccode);";
    //  s += " }, });";

     s += "function setJolla() { ";
     s += "$.ajax({ type : 'get',";
     s += "url : '/setJolla',";
     s += "success : function(result, status, xhr) { ";
   
     s += " console.log(result);";
     s += " $('#JollaValue').html(result);";
     s += " }, });";


     s += "}</script><br></body></html>";
     server.send(200, "text/html", s);// 웹 라우저에 표시.
    }
    // void handleADC() {
    //  int a = analogRead(A0); // 노드엠의 A0 핀의 갑을 읽어와서 정수형 변수에 대입.
     
    //  String adcValue = String(a); // 문자열로 변환.
    //  Serial.println("adcValue (^.^) : " + adcValue); // 시리얼 모니터로 출력.
     
    //  server.send(200, "text/plain", adcValue); // 웹서버에 전송.
    // // unoFromEsp();

    // }
// 외부 웹서버 정보

 
void handleInfo() {
   member_id = server.arg("member_id");
   location_id = server.arg("location_id");
   course_id = server.arg("course_id");
   loccode = server.arg("loccode");
  Serial.println(member_id);   
  Serial.println(location_id); 
  Serial.println(course_id); 
  Serial.println(loccode);   
  handleStamp();
  // const char* serverUrl = 'http://192.168.0.11/ib/';
  // const int serverPort = 80;
 

  //   // 외부 웹서버에 Ajax 요청을 보냄
  //   if (client.connect(serverUrl, serverPort)) {
  //     String url = '/stampIn?member_id=' + member_id +'&location_id=' + location_id + '&course_id=' + course_id + '&loccode=' + loccode;
  //     http.begin(client, url);
  //     int httpCode = http.GET();
  //     String response = http.getString(); // 응답 값을 문자열로 저장
  //     http.end();

  //       // 외부 웹서버로부터 받은 응답 값을 클라이언트에게 전송
  //       if (httpCode == 200) {
  //         server.send(200, "text/plain", "LED 상태를 변경하였습니다.");
  //       } else {
  //         server.send(500, "text/plain", "외부 웹서버에 접속하지 못했습니다.");
  //       }
  //     } else {
  //       server.send(500, "text/plain", "외부 웹서버에 접속하지 못했습니다.");
  //     }
  

//server.send(200, "text/html", s);// 웹 브라우저에 표시.
  // do something with the parameters
}
    // 잘못된 접근시 안내 메세지 생성.
    void handleNotFound() {
     String message = "File Not Found\n\n";
     message += "URI: ";
     message += server.uri();
     message += "\nMethod: ";
     message += (server.method() == HTTP_GET) ? "GET" : "POST";
     message += "\nArguments: ";
     message += server.args();
     message += "\n";
     for (uint8_t i = 0; i < server.args(); i++) {
     message += " " + server.argName(i) + ": " + server.arg(i) + "\n";
     }
     server.send(404, "text/plain", message);
    }

    void handleLED() {
     String ledState = "OFF";
   
     String t_state = server.arg("LEDstate");
     //Refer xhttp.open("GET", "setLED?LEDstate="+led, true);
     Serial.print(t_state + " ");
     if (t_state == "1")
     {
     digitalWrite(LED, LOW); //LED ON
     ledState = "ON"; //Feedback parameter
     Serial.println("led_on");
     Serial.println(server.arg("LEDstate"));
     
     }
     else
     {
     digitalWrite(LED, HIGH); //LED OFF
     ledState = "OFF"; //Feedback parameter
     Serial.println("led_off");
     arduSerial.println("end");      
     
     }
//arduSerial.println(arduSerial.readString());       

      
    server.send(200, "text/plain", ledState); //Send web page
    }

    void handleJolla() {
        digitalWrite(D2, HIGH); //LED OFF
        arduSerial.println("success");             
        digitalWrite(D2, LOW); //LED ON   
         
//    server.send(200, "text/plain", jollaState); //Send web page      
 
    }    

    IPAddress local_IP(192, 168, 0, 4);
    IPAddress gateway(192, 168, 1, 1);
    IPAddress subnet(255, 255, 0, 0);
    IPAddress primaryDNS(8, 8, 8, 8);   //optional
    IPAddress secondaryDNS(8, 8, 4, 4); //optional
    void setup() {
     Serial.begin(9600);
     arduSerial.begin(9600);
     pinMode(LED, OUTPUT);
     pinMode(D2, OUTPUT);     
//     pinMode(A0, INPUT);
 // Configures static IP address
  if (!WiFi.config(local_IP, gateway, subnet, primaryDNS, secondaryDNS)) {
    Serial.println("STA Failed to configure");
  }
     WiFi.mode(WIFI_STA);
     WiFi.begin(ssid, password);
     Serial.println("");
     // Wait for connection
     while (WiFi.status() != WL_CONNECTED) {
     delay(500);
     Serial.print(".");
     }
     Serial.println("");
     Serial.print("Connected to ");
     Serial.println(ssid);
     Serial.print("IP address: ");
     Serial.println(WiFi.localIP());
     server.on("/", handleRoot);
     server.on("/setLED", handleLED);
     server.on("/setInfo", handleInfo);
     server.on("/setJolla", handleJolla);
  
     server.onNotFound(handleNotFound);
     server.begin();
     Serial.println("HTTP server started");
    }
    void loop() {
    
     server.handleClient();
     
    // unoFromEsp();
    }
   
  
    
      
    

