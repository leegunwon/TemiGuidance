package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.TtsRequest;
public class ProfessorActivity3 extends AppCompatActivity implements
        OnGoToLocationStatusChangedListener{
    Robot robot = Robot.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor3);
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
    public void goToProfessorPage4(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, ProfessorActivity4.class);
        startActivity(intent);
    }
    public void goToCheongProfessor(View view) {
        // 정명진 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("정명진교수님");
    }
    public void goToChuProfessor(View view) {
        // 주형길 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("주형길교수님");
    }
    public void goToLeeProfessor(View view) {
        // 이익현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("이익현교수님");
    }

    public void goToSecondPage3(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
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