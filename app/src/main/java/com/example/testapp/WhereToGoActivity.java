package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.Robot;

public class WhereToGoActivity extends AppCompatActivity implements
        OnGoToLocationStatusChangedListener {

    Robot robot = Robot.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_go);
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
    public void goToNamDaeProfessor(View view) {
        // 남대훈 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("남대훈교수님");
    }
    public void goToShimProfessor(View view) {
        // 심재홍 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("심재홍교수님");
    }
    public void goToChaProfessor(View view) {
        // 차동혁 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("차동혁교수님");
    }
    public void goToHyoProfessor(View view) {
        // 김효영 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("김효영교수님");
    }
    public void goToKiProfessor(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("김기현교수님");
    }
    public void goToNamProfessor(View view) {
        // 남윤석 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("남윤석교수님");
    }
    public void goToChuProfessor(View view) {
        // 주형길 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("주형길교수님");
    }
    public void goToCheongProfessor(View view) {
        // 정명진 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("정명진교수님");
    }
    public void goToIckProfessor(View view) {
        // 이익현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("이익현교수님");
    }
    public void goToOfficeProfessor(View view) {
        // 학과사무실 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("학과사무실");
    }


    public void goToNamDaeProfessor_d(View view) {
        robot.goTo("남대훈교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);

    }

    public void goToShimProfessor_d(View view) {
        robot.goTo("심재홍교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToYangProfessor_d(View view) {
        robot.goTo("이양희교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToIckProfessor_d(View view) {
        robot.goTo("이익현교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToChaProfessor_d(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("차동혁교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToKiProfessor_d(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("김기현교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToNamProfessor_d(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("남윤석교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToChuProfessor_d(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("주형길교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToCheongProfessor_d(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("정명진교수님");
        Intent intent = new Intent(this, DeliveryToActicity.class);
        startActivity(intent);
    }

    public void goToOfficeProfessor_d(View view) {
        // 김기현 교수님 버튼이 클릭되었을 때 실행되는 메소드
        robot.goTo("학과사무실");
        Intent intent = new Intent(this, DeliveryToActicity.class);
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