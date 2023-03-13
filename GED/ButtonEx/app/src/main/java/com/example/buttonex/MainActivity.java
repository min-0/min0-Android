package com.example.buttonex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv =(TextView)findViewById(R.id.txt1);
    }

    public void textPrint(View view) {
        cnt++;
        tv.setText("버튼을 " + cnt + "회 클릭했습니다");
    }
}
