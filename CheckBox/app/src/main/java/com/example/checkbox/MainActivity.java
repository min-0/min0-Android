package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean isCkP, isCkJ, isCkC;
    String sp = "";
    String sj = "";
    String sc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CheckList(View view) {
        if(view.getId() == R.id.chP) {
            if(isCkP) {
                isCkP = false;
                sp = " ";
            }
            else {
                isCkP = true;
                sp = "Python";
            }
        }
        else if(view.getId() == R.id.chJ) {
            if(isCkJ) {
                isCkJ = false;
                sj = " ";
            }
            else {
                isCkJ = true;
                sj = "Java";
            }
        }
        else if(view.getId() == R.id.chC) {
            if(isCkC) {
                isCkC = false;
                sc = " ";
            }
            else {
                isCkC = true;
                sc = "C++";
            }
        }
        EditText res = (EditText) findViewById(R.id.res);
        res.setText(sp + sj + sc + "언어가 선택됨");
    }
}