package com.josenildo.santafilomenacovid_19info.json;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.josenildo.santafilomenacovid_19info.MainActivity;

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

import static androidx.core.content.ContextCompat.startActivity;

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

        //Log.i("meuLog",""+result);

        try {
            JSONObject json = new JSONObject(result);
            JSONObject getResults = json.getJSONObject("results");
            JSONObject getDados = getResults.getJSONObject("0");

            //for (int i = 0;)

        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*
        try {
            JSONObject listaJson = new JSONObject(result);
            titulo.setText(listaJson.getString("titulo"));
            JSONArray questionario = listaJson.getJSONArray("questionario");

            for(int i=0; i<questionario.length(); i++){
                JSONObject questao = questionario.getJSONObject(i);

                String perg = questao.getString("Pergunta");
                String ra = questao.getString("respA");
                String rb = questao.getString("respB");
                String rc = questao.getString("respC");
                int correta = questao.getInt("correta");

                Questao minhaQuestao = new Questao(perg,ra,rb,rc,correta);
                questoes.add(minhaQuestao);

            }
        }catch (JSONException e){e.printStackTrace();}


         */
    }
}
