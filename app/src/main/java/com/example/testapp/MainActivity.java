package com.example.testapp;
// MainActivity.java

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import com.robotemi.sdk.Robot;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        OnGoToLocationStatusChangedListener {
    private DatabaseReference mDatabase_chung; //데이터 읽기
    private DatabaseReference mDatabase_mecha; //데이터 읽기
    private DatabaseReference mDatabase_stair; //데이터 읽기

    private DatabaseReference mReference; //데이터 쓰기
    private FirebaseDatabase mDatabase;

    Robot robot = Robot.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("running");

        Button HelloButton = findViewById(R.id.buttonH);

        HelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다음 페이지로 이동하는 코드
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                // Firebase에 값을 쓰기
                mReference.setValue(true);
            }
        });

        // Firebase 데이터베이스의 "변수명" 경로에 대한 참조를 얻습니다.
        mDatabase_chung = FirebaseDatabase.getInstance().getReference().child("chung_pl");
        // ValueEventListener를 사용하여 데이터 변경 감지
        mDatabase_chung.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // "call" 값이 true이면 CallActivity로 이동
                Boolean callValue = dataSnapshot.getValue(Boolean.class);
                if (callValue != null && callValue) {
                    startActivity(new Intent(MainActivity.this, CallFromProfessorActivity.class));
                    robot.goTo("정명진교수님");
                }

            }
            // 정명진교수님으로 이동하는 함수 추가해줘 병민아


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // 오류 처리
            }
        });

        mDatabase_mecha = FirebaseDatabase.getInstance().getReference().child("mecha_pl");
        // ValueEventListener를 사용하여 데이터 변경 감지
        mDatabase_mecha.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // "call" 값이 true이면 CallActivity로 이동
                Boolean callValue = dataSnapshot.getValue(Boolean.class);
                if (callValue != null && callValue) {
                    startActivity(new Intent(MainActivity.this, CallFromProfessorActivity.class));
                    robot.goTo("학과사무실");
                }

            }
            // 학과사무실로 이동하는 함수 추가해줘 병민아

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // 오류 처리
            }
        });

        mDatabase_stair = FirebaseDatabase.getInstance().getReference().child("stair_pl");
        // ValueEventListener를 사용하여 데이터 변경 감지
        mDatabase_stair.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // "call" 값이 true이면 CallActivity로 이동
                Boolean callValue = dataSnapshot.getValue(Boolean.class);
                if (callValue != null && callValue) {
                    startActivity(new Intent(MainActivity.this, CallFromProfessorActivity.class));
                    robot.goTo("계단1");
                }
                // 계단으로 이동하는 함수 추가해줘 병민아

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // 오류 처리
            }
        });


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
