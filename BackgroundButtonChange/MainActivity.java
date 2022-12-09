package com.example.ex1104_02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // activity_main.xml의 레이아웃과 버튼 2개에 대응할 전역변수 생성
    LinearLayout baseLayout;
    Button button1, button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");

        //위젯 변수 3개에 위젯을 대입한다.
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        // 버튼 위젯 변수를 registerForContextMenu()에 등록한다.
        registerForContextMenu(button1);
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);

        // 메뉴의 XML파일을 인플레이트한다.
        MenuInflater mInflater = getMenuInflater();
        if(v == button1) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == button2) {
            mInflater.inflate(R.menu.menu2, menu);
        }
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
                button2.setRotation(45);   // 버튼을 회전시킨다.
                return true;

            case R.id.subSize:
                button2.setScaleX(2);      //버튼의 x축을 2배 확대한다.
                return true;
        }
        return false; //return super.onOptionsItemSelected(item) -> return false;
    }
}