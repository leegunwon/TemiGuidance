package com.example.testapp;

// SecondActivity.java
import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
public class SecondActivity extends AppCompatActivity implements
    OnGoToLocationStatusChangedListener{
    Robot robot = Robot.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 웹뷰 초기화
        WebView webView = findViewById(R.id.webView);

        // 웹뷰 설정
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript 활성화

        // WebViewClient 설정 (클릭 시 새 창 안 띄워짐)
        webView.setWebViewClient(new WebViewClient());

        // 앱에서 보여줄 웹 페이지 주소 설정
        String url = "https://www.tukorea.ac.kr/mec/1788/subview.do"; // 여기에 원하는 주소를 넣어주세요.

        // 웹뷰에 웹 페이지 표시
        webView.loadUrl(url);
    }

    public void goToProfessorPage(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, ProfessorActivity.class);
        startActivity(intent);
    }

    public void goToLectureHallPage(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, LectureHallActivity.class);
        startActivity(intent);
    }
    public void toMain(View view) {
        // 종료하기 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToOffice(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("학과사무실");
    }

    public void onGoToLocationStatusChanged(@NonNull String s, @NonNull String s1, int i, @NonNull String s2) {
        switch(s1){
            case "start":
                robot.speak(TtsRequest.create("start",false));
                break;
            case "going":
                robot.speak(TtsRequest.create("going",false));
                break;
            case "complete":
                robot.speak(TtsRequest.create("complete",false));
                break;
        }
    }
}

