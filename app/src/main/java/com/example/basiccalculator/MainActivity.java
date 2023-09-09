package com.example.basiccalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btn_c, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9,
            btn_dot, btn_div, btn_mult, btn_plus, btn_minus, btn_mod, btn_equal;
    ImageButton btn_del;
    TextView tv_screen, tv_screen_result;

    String screen_text;
    int last_char;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_c = findViewById(R.id.btn_C);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_del = findViewById(R.id.btn_del);
        btn_dot = findViewById(R.id.btn_dot);
        btn_div = findViewById(R.id.btn_div);
        btn_mult = findViewById(R.id.btn_mult);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mod = findViewById(R.id.btn_mod);
        btn_equal = findViewById(R.id.btn_equal);
        tv_screen = findViewById(R.id.tv_screen);
        tv_screen_result = findViewById(R.id.tv_screen_result);

        tv_screen.setMovementMethod(new ScrollingMovementMethod());

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_screen.setText("");
                tv_screen_result.setText("");
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                if (!screen_text.isEmpty()) {
                    screen_text = Calculator.del(screen_text);
                    tv_screen.setText(screen_text);
                    tv_screen_result.setText("");
                }
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_0));
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_1));
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_2));
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_3));
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_4));
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_5));
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_6));
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_7));
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_8));
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                tv_screen.setText(screen_text + getResources().getString(R.string.btn_9));
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                last_char = Calculator.last_char(screen_text);
                if (last_char != -1) {
                    String[] numbers_sybols = screen_text.split(" ");
                    if (!numbers_sybols[numbers_sybols.length - 1].contains(".")) {
                        if (last_char == 0)
                            tv_screen.setText(screen_text + getResources().getString(R.string.btn_dot));
                        else
                            tv_screen.setText(screen_text + getResources().getString(R.string.btn_0) + getResources().getString(R.string.btn_dot));
                    }
                }
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                last_char = Calculator.last_char(screen_text);
                if (last_char == 0)
                    tv_screen.setText(screen_text + " " + getResources().getString(R.string.btn_plus) + " ");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                last_char = Calculator.last_char(screen_text);
                if (last_char == 0)
                    tv_screen.setText(screen_text + " " + getResources().getString(R.string.btn_minus) + " ");
                else
                    tv_screen.setText(screen_text + "-");
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                last_char = Calculator.last_char(screen_text);
                if (last_char == 0)
                    tv_screen.setText(screen_text + " " + getResources().getString(R.string.btn_div) + " ");
            }
        });

        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                last_char = Calculator.last_char(screen_text);
                if (last_char == 0)
                    tv_screen.setText(screen_text + " " + getResources().getString(R.string.btn_mult) + " ");
            }
        });

        btn_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                last_char = Calculator.last_char(screen_text);
                if (last_char == 0)
                    tv_screen.setText(screen_text + " " + getResources().getString(R.string.btn_mod) + " ");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen_text = tv_screen.getText().toString();
                try {
                    String result = Calculator.calculateResult(screen_text);
                    tv_screen_result.setText(result);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}