package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button btn_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textHello);
        registerForContextMenu(textView);

        btn_agree = findViewById(R.id.btn_agree);
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setMessage("동의 하시겠습니까?");
                //if 예
                alertBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "동의하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                //if 아니오
                alertBuilder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_apple:
                Toast.makeText(this, "🍎사과 메뉴를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                 break;
            case R.id.menu_grape:
                Toast.makeText(this, "🍇포도 메뉴를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_banana:
                Toast.makeText(this, "🍌바나나 메뉴를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("코드로 만든 컨텍스트 메뉴");
        menu.add(0, 1, 1, "배경색: RED");
        menu.add(0, 2, 2, "배경색: RED");
        menu.add(0, 3, 3, "배경색: RED");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_bg_red:
                textView.setBackgroundColor(Color.RED);
                return true;
            case R.id.context_bg_green:
                textView.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.context_bg_blue:
                textView.setBackgroundColor(Color.BLUE);
                return true;
            default:
                 return super.onContextItemSelected(item);
        }
    }
}