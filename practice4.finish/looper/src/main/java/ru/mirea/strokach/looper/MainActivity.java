package ru.mirea.strokach.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    myLooper MyLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyLooper = new myLooper();
        MyLooper.start();

    }
    public void onClick(View view)
    {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "mirea");
        msg.setData(bundle);
        if (MyLooper != null) {
            MyLooper.handler.sendMessage(msg);
        }
    }
}