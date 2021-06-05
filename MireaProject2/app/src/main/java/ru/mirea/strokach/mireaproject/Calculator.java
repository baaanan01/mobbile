package ru.mirea.strokach.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Calculator extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Calculator() {

    }

    public static Calculator newInstance(String param1, String param2) {
        Calculator fragment = new Calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    Button btS;
    Button btM;
    Button btU;
    Button btD;
    TextView textView;
    EditText editText;
    EditText editText1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_calculator, container, false);
        btS = (Button) root.findViewById(R.id.buttonPlay);
        btM = (Button) root.findViewById(R.id.buttonStop);
        btU = (Button) root.findViewById(R.id.buttonMult);
        btD = (Button) root.findViewById(R.id.buttonDiv);
        editText = (EditText) root.findViewById(R.id.firstNum);
        editText1 = (EditText) root.findViewById(R.id.secondNum);
        textView = (TextView) root.findViewById(R.id.album_name);
        btS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());
                double k = a1 + b1;
                String str1 = Double.toString(k);
                textView.setText(str1);
            }
        });

        btM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());

                double k1 = a1 - b1;
                String str1 = Double.toString(k1);
                textView.setText(str1);
            }

        });

        btU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());
                double k2 = a1 * b1;
                String str1 = Double.toString(k2);
                textView.setText(str1);
            }

        });

        btD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                double a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                double b1 = Integer.parseInt(b.trim());
                if (b1 == 0)
                {
                    textView.setText("Error");
                }
                else
                {
                    double k3 = a1 / b1;
                    String str1 = Double.toString(k3);
                    textView.setText(str1);
                }

            }
        });

        return root;

    }

    @Override
    public void onClick(View v) {

    }
}