package com.josenildo.santafilomenacovid_19info;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.josenildo.santafilomenacovid_19info.json.JsonTask;

public class SplashActivity extends AppCompatActivity {

    // String contendo o link para a api REST, obtendo os dados de Santa Filomena a partir do código
    String jsonUrl = "https://brasil.io/api/dataset/covid19/caso/data/?format=json&is_last=True&state=PE&city_ibge_code=2612554";
    // da cidade fornecido pelo IBGE (2612554).
    //String jsonUrl = "https://brasil.io/api/dataset/covid19/caso_full/data/?format=json&is_last=True&state=PE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Oculta o System UI no SDK 15 ou anterior
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        // Oculta a barra de titulo no SDK 16 ou superior
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        new JsonTask().execute(jsonUrl);
    }
}