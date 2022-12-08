package com.example.ex1028_02;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //위젯에 대응되는 변수 선언
    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.web);

        //4개의 변수에 위젯을 대입한다.
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);

        // CookWebViewClient 클래스를 생성하여 웹뷰에 대입한다.
        web.setWebViewClient(new CookWebViewClient());

        //WebSettings 클래스를 이용하여 줌 버튼 컨트롤이 화면에 보이게 한다.
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        //웹뷰에서 자바스크립트가 작동되게 한다.
        webSet.setJavaScriptEnabled(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //에디트텍스트에 입력한 URL 웹페이지가 웹뷰에 나오게 한다.
                web.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //웹뷰의 이전 화면으로 돌아간다.
                web.goBack();
            }
        });
    }

    //WebViewClient의 상속을 받는 CookWebViewClient 클래스 정의
    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}