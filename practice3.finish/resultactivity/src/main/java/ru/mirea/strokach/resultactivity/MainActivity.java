package ru.mirea.strokach.resultactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tex;
    private final int REQUEST_CODE = 143;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tex = findViewById(R.id.textView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            String univ = data.getStringExtra("name");
            setUni(univ);
        }
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(MainActivity.this, DataActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void setUni(String uni){
        tex.setText(uni);
    }
}