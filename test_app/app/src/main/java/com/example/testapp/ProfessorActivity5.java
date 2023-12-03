package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfessorActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor5);
    }
    public void goToProfessorPage4(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, ProfessorActivity4.class);
        startActivity(intent);
    }

    public void goToSecondPage(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}