package com.josenildo.santafilomenacovid_19info;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toolbar;

import com.josenildo.santafilomenacovid_19info.modeldata.InfosCovid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // String contendo o link para a api REST, obtendo os dados de Santa Filomena a partir do código
    String jsonUrl = "https://brasil.io/api/dataset/covid19/caso/data/?format=json&is_last=True&state=PE&city_ibge_code=2612554";
    // da cidade fornecido pelo IBGE (2612554).
    //String jsonUrl = "https://brasil.io/api/dataset/covid19/caso_full/data/?format=json&is_last=True&state=PE";

    /*
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
     */

    TextView lblCidade;
    TextView lblIbgeCode;
    TextView lblConfirmados;
    TextView lblCasosConfirmados100k;
    TextView lblData;
    TextView lblTaxaMortlidade;
    TextView lblMortes;
    TextView lblPopulacao2019;
    TextView lblOrderForPlace;
    TextView lblPlaceType;
    TextView lblEstado;
    private androidx.appcompat.widget.Toolbar mainActivityToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar mainToolbar = findViewById(R.id.mainActivityToolbar);

        mainActivityToolbar = findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(mainActivityToolbar);
        getWindow().setFlags(Window.FEATURE_ACTION_BAR, ActionBar.DISPLAY_SHOW_CUSTOM);


        lblCidade = (TextView) findViewById(R.id.lblCidade);
        lblIbgeCode = (TextView)  findViewById(R.id.lblIbgeCode);
        lblConfirmados = (TextView)  findViewById(R.id.lblConfirmados);
        lblCasosConfirmados100k = (TextView)  findViewById(R.id.lblCasosPor100K);
        lblData = (TextView)  findViewById(R.id.lblData);
        lblTaxaMortlidade = findViewById(R.id.lblTaxaMortalidade);
        lblMortes = findViewById(R.id.lblMortesConfirmadas);
        lblPopulacao2019 = findViewById(R.id.lblPopulacao);
        lblOrderForPlace = findViewById(R.id.lblOrderForPlace);
        lblPlaceType = findViewById(R.id.lblPlaceType);
        lblEstado = findViewById(R.id.lblEstado);

        new JsonTask().execute(jsonUrl);
    }



    public class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject json = new JSONObject(result);

                JSONArray getResults = json.getJSONArray("results");

                for (int i = 0; i < getResults.length(); i++) {
                    JSONObject dados = getResults.getJSONObject(Integer.parseInt(String.valueOf(i)));

                    String cidade = dados.getString("city");
                    int cityIbgeCode = dados.getInt("city_ibge_code");
                    int confirmados = dados.getInt("confirmed");
                    double casosConfirmadosPor100k = dados.getDouble("confirmed_per_100k_inhabitants");
                    String data = dados.getString("date");
                    int taxaMortalidade = dados.getInt("death_rate");
                    int mortes = dados.getInt("deaths");
                    int populacaoEstimada2019 = dados.getInt("estimated_population_2019");
                    int orderForPlace = dados.getInt("order_for_place");
                    String placeType = dados.getString("place_type");
                    String estado = dados.getString("state");

                    InfosCovid infosCovid = new InfosCovid(cidade, cityIbgeCode, confirmados, casosConfirmadosPor100k, data, taxaMortalidade, mortes, populacaoEstimada2019, orderForPlace, placeType, estado);

                    lblCidade.setText(String.valueOf(cidade));
                    lblIbgeCode.setText(String.valueOf(cityIbgeCode));
                    lblConfirmados.setText(String.valueOf(confirmados));
                    lblCasosConfirmados100k.setText(String.valueOf(casosConfirmadosPor100k));
                    lblData.setText(String.valueOf(data));
                    lblTaxaMortlidade.setText(String.valueOf(taxaMortalidade));
                    lblMortes.setText(String.valueOf(mortes));
                    lblPopulacao2019.setText(String.valueOf(populacaoEstimada2019));
                    lblOrderForPlace.setText(String.valueOf(orderForPlace));
                    lblPlaceType.setText(String.valueOf(placeType));
                    lblEstado.setText((String.valueOf(estado)));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sobre:
                // User chose the "Settings" item, show the app about UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu_main_activity, menu);
        return true;
    }
}