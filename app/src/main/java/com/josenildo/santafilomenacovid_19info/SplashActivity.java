package com.josenildo.santafilomenacovid_19info;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class SplashActivity extends AppCompatActivity {

    // String contendo o link para a api REST, obtendo os dados de Santa Filomena a partir do código
    //String jsonUrl = "https://brasil.io/api/dataset/covid19/caso/data/?format=json&is_last=True&state=PE&city_ibge_code=2612554";
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
        setContentView(R.layout.activity_splash);

        // Oculta a barra de titulo no SDK 16 ou superior
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cria um intent para a transição
                Intent splashToMain = new Intent(SplashActivity.this, MainActivity.class);
                // Cria uma animação de fade in
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.zoom_out);

                //View splashScreen = (View) findViewById(R.anim.zoom_in);

                //Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                //splashScreen.startAnimation(aniSlide);

                // inicia a Main Activity
                ActivityCompat.startActivity(SplashActivity.this, splashToMain, activityOptionsCompat.toBundle());

                // Destroi a activity, impossibilitando do usuario voltar a mesma caso use o botão 'voltar'
                finish();
            }
        }, 5000);



        //new JsonTask().execute(jsonUrl);

    }
}