package com.example.testapp;
// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase; //데이터 읽기
    private DatabaseReference mReference; //데이터 쓰기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yourButton = findViewById(R.id.buttonH); //

        // Firebase 데이터베이스의 "변수명" 경로에 대한 참조를 얻습니다.
        mDatabase = FirebaseDatabase.getInstance().getReference().child("변수명");
        // ValueEventListener를 사용하여 데이터 변경 감지
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // "call" 값이 true이면 CallActivity로 이동
                Boolean callValue = dataSnapshot.getValue(Boolean.class);
                if (callValue != null && callValue) {
                    startActivity(new Intent(MainActivity.this, CallFromProfessorActivity.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // 오류 처리
            }
        });

    }
    public void goToSecondPage(View view) {
        // 버튼이 클릭되었을 때 실행되는 메소드
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


}
