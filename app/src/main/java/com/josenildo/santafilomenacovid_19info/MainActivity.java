package com.josenildo.santafilomenacovid_19info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.josenildo.santafilomenacovid_19info.json.JsonTask;

public class MainActivity extends AppCompatActivity {

    // String contendo o link para a api REST, obtendo os dados de Santa Filomena a partir do código
    // da cidade fornecido pelo IBGE (2612554).
    String jsonUrl = "https://brasil.io/api/dataset/covid19/caso/data/?format=json&is_last=True&state=PE&city_ibge_code=2612554";
    //String jsonUrl = "https://brasil.io/api/dataset/covid19/caso_full/data/?format=json&is_last=True&state=PE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask().execute(jsonUrl);

    }
}