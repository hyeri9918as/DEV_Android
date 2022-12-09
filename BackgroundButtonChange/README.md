<br></br>
# 7-2 배경색변경/버튼 변경 앱 만들기 
* <배경색 변경>을 롱클릭하면 배경색을 변경하는 세 가지 컨텍스트 메뉴가 나오고, <버튼 변경>을 롱클릭하면 버튼을 회전시키기거나 크기를 변경하는 두 가지 컨텍스트 메뉴가 나오게 한다. 
<br></br> 

## 화면 디자인 구성 
<br></br> 
* 바깥 리니어레이아웃 
    - 바깥 리니어레이아웃의 아이디를 baseLayout으로 한다.  
    - 버튼 2개를 생성한다. 버튼의 아이디는 button1, button2로 한다.  
<br></br>    
* 아이디 지정 
    - Java 코드에서 레이아웃과 버튼에 접근하기 위해 아이디를 지정한다.    

<br></br>
---
<br></br>
  
## 자바 코드 설정
<br></br>  
1. activity_main.xml의 레이아웃과 버트에 대응할 전역 변수 2개를 선언한다. 
<br></br>
2. 메인 함수 onCreate( ) 안에서 위젯 변수 2개에 위젯을 대입한다. 
<br></br>
3. onCreateOptionsMenu()메소드를 선택하고 오버라이딩한다. 
- 메뉴 인플레이터를 생성하고 앞에서 작성한 menu.xml을 등록한다. 
<br></br>
4. onOptionsItemSelected()메소드를 오버라이딩한다. 
- switch case문을 사용하여 선택한 항목에 맞는 배경색을 설정한다. 
- setscale로 버튼을 확대하거나 setrotation으로 화면을 회전한다. 
<br></br>

---
<br></br>

## 실행 결과 
<br></br>

### 첫 화면 설정 (버튼과 롱클릭위젯)
<br></br>
<img src="img/img1.png" width="240" height="500">
<img src="img/img2.png" width="240" height="500">
<img src="img/img3.png" width="240" height="500">
<br></br>

