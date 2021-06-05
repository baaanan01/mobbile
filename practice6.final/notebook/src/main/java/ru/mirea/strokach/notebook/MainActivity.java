package ru.mirea.strokach.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private EditText editText1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.TextView);
        @SuppressLint("SdCardPath")
        String lisst = "/data/data/ru.mirea.strokach.notebook/files/Name.txt";
        File file = new File(lisst);
        if (file.exists()) {
            try
            {
                lisst = "fileName.txt";
                FileInputStream outputStream = openFileInput(lisst);
                byte[] bytes = new byte[outputStream.available()];
                outputStream.read(bytes);
                String text = new String(bytes);
                outputStream = openFileInput(text);
                byte[] bytess = new byte[outputStream.available()];
                outputStream.read(bytess);
                text = new String(bytess);
                textView.setText(text);
                Log.d("ONCREATE","SETTEXT "+text);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("SetText")
    public void onSaveText(View view) throws IOException {
        String fileName = editText1.getText().toString();
        fileName= fileName+".txt";
        @SuppressLint("SdCardPath") String path = "/data/data/ru.mirea.strokach.notebook/files/"+fileName;
        File file = new File(path);
        String text=editText.getText().toString();

        if (file.exists())
        {
            PrintWriter prWr = new PrintWriter(new BufferedWriter
                    (new FileWriter(path, true)));
            text=" "+text;
            prWr.write(text);
            prWr.close();
            Log.d("OPENFILE","SAVED TEXT "+text);
        }

        else
        {
            FileOutputStream outputStream;
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
            Log.d("CREATEFILE","SAVED TEXT "+text);
        }
        textView.setText("Текст : " +text+ "\nзаписали в файл : "+fileName);

    }

    @Override
    public void onStop()
    {
        super.onStop();
        String path = "Name.txt";
        String text = editText1.getText().toString() + ".txt";
        FileOutputStream outputStream;

        try
        {
            outputStream = openFileOutput(path, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("STOPPING","SAVED PATH "+text);
    }
}