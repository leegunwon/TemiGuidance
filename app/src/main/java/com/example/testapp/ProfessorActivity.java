package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.Robot;

public class ProfessorActivity extends AppCompatActivity implements
        OnGoToLocationStatusChangedListener {

    Robot robot = Robot.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
    }
    protected void onStart() {
        super.onStart();
        Robot.getInstance().addOnGoToLocationStatusChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Robot.getInstance().removeOnGoToLocationStatusChangedListener(this);
    }
    public void goToProfessorPage2(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, ProfessorActivity2.class);
        startActivity(intent);
    }
    public void goToSecondPage(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void goToKiProfessor(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("김기현교수님");
    }
    public void goToHyoProfessor(View view) {
        // 김효영 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("김효영교수님");
    }
    public void goToNamProfessor(View view) {
        // 남윤석 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("남윤석교수님");
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





