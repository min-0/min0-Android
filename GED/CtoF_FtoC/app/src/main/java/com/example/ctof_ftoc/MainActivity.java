package com.example.ctof_ftoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText C, F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CtoF_FtoC(View view) {
        float c, f;
        C = (EditText) findViewById(R.id.Cdeg);
        F = (EditText) findViewById(R.id.Fdeg);
        switch (view.getId()) {
            case(R.id.CtoF):
                c = Float.parseFloat(C.getText().toString());
                f = 9/5*c+32;
                F.setText(String.valueOf(f));
                break;
            case(R.id.FtoC):
                f = Float.parseFloat(F.getText().toString());
                c = (f-32)*5/9;
                C.setText(String.valueOf(c));
                break;
        }
    }
}