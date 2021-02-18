package com.geekbrains.firstlesson;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;


public class ThirdActivity extends AppCompatActivity {

    private static final String NameSharedPreference = "SETTING";
    private static final String appTheme = "APP_THEME";
    private static final int CalcStyleVerOne = 0;
    private static final int CalcStyleDark = 1;
    private static final int BaseStyle = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppTheme(getAppTheme(R.style.calcStyleVerOne));
        setContentView(R.layout.activity_third);
        initThemeChooser();

    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioBase),
                BaseStyle);
        initRadioButton(findViewById(R.id.radioLight),
                CalcStyleVerOne);
        initRadioButton(findViewById(R.id.radioDark),
                CalcStyleDark);
        RadioGroup rg = findViewById(R.id.radioButtons);
        //не смог разобраться с данной строчкой, почему то падает с ошибкой
        //((MaterialRadioButton)rg.getChildAt(getCodeStyle(CalcStyleVerOne))).setChecked(true);
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPreferences.getInt(appTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case CalcStyleVerOne:
            default:
                return R.style.calcStyleVerOne;
            case CalcStyleDark:
                return R.style.CalcStyleDark;
            case BaseStyle:
                return R.style.Theme_FirstLesson;
        }
    }
}

