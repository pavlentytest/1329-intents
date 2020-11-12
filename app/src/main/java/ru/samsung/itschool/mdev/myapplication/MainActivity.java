package ru.samsung.itschool.mdev.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public static final int ACTIVITY_RESULT_CODE = 1;
    private Button btn, btn2;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // явное намерение
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("val",editText.getText().toString());
                // startActivity(intent);
                startActivityForResult(intent,ACTIVITY_RESULT_CODE);
            }
        });
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://myitschool.ru";
                // неявное намерение
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_RESULT_CODE) {
            if(resultCode == RESULT_OK) {
                // получаем переменную из второй активности
             //  Log.d("RRRR",data.);
                String text_from_activity2 = data.getStringExtra(Intent.EXTRA_TEXT);
                Snackbar.make(findViewById(R.id.root),text_from_activity2,Snackbar.LENGTH_LONG).show();

            }
        }
    }
}