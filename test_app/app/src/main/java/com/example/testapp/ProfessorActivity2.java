package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.TtsRequest;


public class ProfessorActivity2 extends AppCompatActivity implements
        OnGoToLocationStatusChangedListener {

    Robot robot = Robot.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor2);
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
    public void goToProfessorPage(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, ProfessorActivity.class);
        startActivity(intent);
    }
    public void goToProfessorPage3(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, ProfessorActivity3.class);
        startActivity(intent);
    }

    public void goToSecondPage2(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void goToShimProfessor(View view) {
        // 심재홍 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("심재홍교수님");
    }
    public void goToLeeProfessor(View view) {
        // 심재홍 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("이양희교수님");
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