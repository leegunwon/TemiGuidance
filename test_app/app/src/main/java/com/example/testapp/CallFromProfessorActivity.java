package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CallFromProfessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_from_professor);
    }

    public void selectDestination(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, WhereToGoActivity.class);
        startActivity(intent);
    }

    public void toMain_call(View view) {
        // 종료하기 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}