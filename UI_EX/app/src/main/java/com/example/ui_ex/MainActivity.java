package com.example.ui_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        Button b3 = new Button(this);
        b3.setText("java 첫번째 버튼");
        ll.addView(b3);

        Button b4 = new Button(this);
        b4.setText("java 두번째 버튼");
        ll.addView(b4);
        
        Button b1 = (Button) findViewById(R.id.button);
        b1.setText("Java 코드에서 변경");

        Button b2 = (Button) findViewById(R.id.button2);
        b2.setEnabled(false);

        //setContentView(ll);
    }
}