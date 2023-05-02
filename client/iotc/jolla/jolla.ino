#include <stdio.h>
#include <string.h>//함수가 선언된 헤더 파일
#include "LedControl.h"   
LedControl lc=LedControl(12,11,10,1);     // 핀들을 접속
int check = 0;
unsigned long delayTime=200;                    // delayTime의 시간을 정의합니다
int q = 9;                                                  // 버튼을 추가합니다
byte a[] =
{
  B00111100,
  B00111101,
  B00011010,
  B00111100,
  B01011000,
  B10011000,
  B01111110,
  B01000010
};                                                            // 춤 동작 1 추가

byte b [] =
{
 B00111100,
 B10111100,
 B01011000,
 B00111100,
 B00011010,
 B00011001,
 B01111110,
 B01000010
};                                                              //춤 동작 2 추가

byte c [] =
{
 B00111100,
 B00111100,
 B00011000,
 B01111110,
 B01011010,
 B00011000,
 B00111100,
 B00100100
};                                                               // 서있는 모습 추가

void serial_setup(){
Serial.begin(9600);
}

void jolla_setup(){
 lc.shutdown(0,false);                                   // 절전모드를 끄고,
 lc.setIntensity(0,5);                                     // 밝기를 설정합니다(0~15까지 밝기 설정가능합니다
lc.clearDisplay(0);                                        // 화면을 정리합니다
}

void setup()
{
  serial_setup();
 jolla_setup();  
}
void loop(){
  serial_loop();
  if(check == 1){
   jolla_loop();

  }
  else{
    jolla_setup();
  }
  
}

void serial_loop(){
  String target = "success";
  if (Serial.available()) {
  String  message = Serial.readStringUntil('\n');
  message.trim();
   if (message.equals(target)) { // 입력받은 문자열과 비교할 문자열이 같으면
         check = 1;    
         Serial.println(message);
    }
    else{
      check = 0;
         Serial.println(message);

    }
 
  }
}

void jolla_loop(){

  if(digitalRead(q)==HIGH)                                   // 버튼이 HIGH가 되면
  {
    A();                                                              // 춤 동작 1이 출력
    delay(delayTime);                                           // 딜레이
    B();                                                              // 춤 동작 2가 출력
    delay(delayTime);                                          // 딜레이
  } 

  else                                                           //버튼이 눌리지 않는다면
  {
    C();                                                          // 서 있는 동작 출력
  }
}

void A()
{  for (int i = 0; i < 8; i++)  
{
   lc.setRow(0,i,a[i]);
 }
}                                                                   // 춤 동작 1을 작동할 수 있도록 함

void B()
{
 for (int i = 0; i < 8; i++)  
 {
   lc.setRow(0,i,b[i]);
 }
}                                                                   // 춤 동작 2를 작동 할 수 있도록 함

void C()
{
 for (int i = 0; i < 8; i++)  
 {
   lc.setRow(0,i,c[i]);
 }
}                                                                  // 서있는 동작을 작동 할 수 있도록 함


