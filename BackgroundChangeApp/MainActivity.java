package com.example.ex1104_01;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);                // return super.onCreateOptionsMenu(menu);에서 return문 삭제
        MenuInflater mInflater = getMenuInflater();     // 메뉴 인플레이터를 생성하고 menu1.xml 파일을 등록한다.
        mInflater.inflate(R.menu.menu1, menu);
        return true;   //return true 지정
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:                                // 선택한 항목이 배경색(빨강)이면 
                baseLayout.setBackgroundColor(Color.RED);     // 레이아웃의 배경색을 빨강으로 설정 
                return true;

            case R.id.itemGreen:                                // 선택한 항목이 배경색(초록)이면 
                baseLayout.setBackgroundColor(Color.GREEN);     // 레이아웃의 배경색을 초록으로 설정 
                return true;

            case R.id.itemBlue:                                // 선택한 항목이 배경색(파랑)이면 
                baseLayout.setBackgroundColor(Color.BLUE);     // 레이아웃의 배경색을 파랑으로 설정
                return true;

            case R.id.subRotate:
                button1.setRotation(45);   // 버튼을 회전시킨다.
                return true;

            case R.id.subSize:
                button1.setScaleX(2);      //버튼의 x축을 2배 확대한다.
                return true;
        }
        return false; //return super.onOptionsItemSelected(item) -> return false;
    }
}