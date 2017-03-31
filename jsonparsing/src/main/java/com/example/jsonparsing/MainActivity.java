package com.example.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuilder builder= new StringBuilder();

        try {
            InputStream is = getAssets().open("my.json");
            while (true) {
                int ch = is.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        parseUsingJsonObjectApi(builder.toString());
    }

    private void parseUsingJsonObjectApi(String json){

        StringBuilder builder= new StringBuilder();

        try {
            JSONObject rootObj = new JSONObject(json);
            String name = rootObj.getString("name");
            String os = rootObj.getString("os");
            double ver = rootObj.getDouble("ver");
            boolean  isUpdateAva = rootObj.getBoolean("isUpdateAva");

            builder.append("\nName = ").append(name);
            builder.append("\nos = ").append(os);
            builder.append("\nversion = ").append(ver);
            builder.append("\nUpdate = ").append(isUpdateAva);

            JSONObject innerObj = rootObj.getJSONObject("allVersions");
            double base = innerObj.getDouble("base");
            double cupCake = innerObj.getDouble("cupCake");

            builder.append("\nBase = ").append(base);
            builder.append("\nCupCake = ").append(cupCake);

            JSONArray devices = rootObj.getJSONArray("devices");

            for (int i = 0; i < devices.length(); i++){
                JSONObject arrObj = devices.getJSONObject(i);
                String mobile = arrObj.getString("mobile");
                int cost = arrObj.getInt("cost");

                builder.append("\nMobile = ").append(mobile);
                builder.append("\nCost = ").append(cost);
            }

            Log.i("@example",builder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
