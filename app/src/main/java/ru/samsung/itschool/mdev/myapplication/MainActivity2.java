package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // R.string.back_text
                intent.putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.back_text));
                setResult(RESULT_OK,intent);
                finish(); // onDestroy()
            }
        });

        tv = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String value = bundle.getString("val");
            tv.setText(value);
        }
    }
}