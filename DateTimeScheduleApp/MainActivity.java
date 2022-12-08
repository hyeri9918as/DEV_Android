package com.example.ex1028_01;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;                                 // 타이머로 사용할 크로노미터 변수
    Button btnStart, btnEnd;                            // <예약시작>과 <예약완료>의 변수
    RadioButton rdoCal, rdoTime;                        // 라디오 버튼 변수 2개
    CalendarView calView;                               // 날짜를 설정할 캘린더 뷰 변수
    TimePicker tPicker;                                 // 시간을 설정할 타임피커 변수
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;  // 어플 맨아래에 출력될 연,월,일,시,분의 숫자에 해당하는 텍스트 뷰 변수 5개
    int selectYear, selectMonth, selectDay;             // 캘린더뷰에서 선택할 연,월,일에 해당하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        //위젯 변수 12개에 위젯을 대입한다.
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        chrono = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        //타임피커와 캘린더뷰가 보이지 않게 설정한다.
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);   //날짜 설정 라디오 버튼을 클릭하면 타임 피커는 안보이게 설정
                calView.setVisibility(View.VISIBLE);     //날짜 설정 라디오 버튼을 클릭하면 캘린더뷰는 보이게 설정
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);    //시간 설정 라디오 버튼을 클릭하면 타임 피커는 보이게 설정
                calView.setVisibility(View.INVISIBLE);  //시간 설정 라디오 버튼을 클릭하면 캘린더뷰는 안보이게 설정
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());     //크로노미터를 0으로 초기화한다. <예약 시작>을 클릭할 때마다 초기화된다.
                chrono.start();                                    //크로노미터를 시작한다.
                chrono.setTextColor(Color.RED);                    //타이머가 시작되면 글자를 빨간색으로 설정 
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                chrono.stop();                                    //크로노미터를 정지한다.
                chrono.setTextColor(Color.BLUE);                  //타이머가 시작되면 글자를 파란색으로 설정

                //캘린더뷰에서 선택한 연,월,일에 해당하는 텍스트뷰에 채운다.
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                //타임피커에서 설정한 시간과 분을 구하여 해당하는 텍스트 뷰에 채운다.
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

        // 캘린더뷰를 클릭하면 선택한 연, 월, 일이 전역변수에 대입된다. 월은 0부터 시작하므로 1을 더해준다.
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectYear=year;
                selectMonth=month+1;
                selectDay=dayOfMonth;
            }
        });

    }
}
