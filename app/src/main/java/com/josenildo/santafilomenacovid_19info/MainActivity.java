package com.josenildo.santafilomenacovid_19info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.josenildo.santafilomenacovid_19info.json.JsonTask;

public class MainActivity extends AppCompatActivity {

    TextView txtCidade;
    TextView txtIbgeCode;
    TextView txtConfirmados;
    TextView txtCasosConfirmados100k;
    TextView txtData;
    TextView txtTaxaMortlidade;
    TextView txtMortes;
    TextView txtPopulacao2019;
    TextView txtOrderForPlace;
    TextView txtPlaceType;
    TextView txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCidade = findViewById(R.id.txtCidade);
        txtIbgeCode = findViewById(R.id.txtIbgeCode);
        txtConfirmados = findViewById(R.id.txtConfirmados);
        txtCasosConfirmados100k = findViewById(R.id.txtCasosPor100K);
        txtData = findViewById(R.id.txtData);
        txtTaxaMortlidade = findViewById(R.id.txtTaxaMortalidade);
        txtMortes = findViewById(R.id.txtMortesConfirmadas);
        txtPopulacao2019 = findViewById(R.id.txtPopulacao);
        txtOrderForPlace = findViewById(R.id.txtOrderForPlace);
        txtPlaceType = findViewById(R.id.txtPlaceType);
        txtEstado = findViewById(R.id.txtEstado);

    }
}