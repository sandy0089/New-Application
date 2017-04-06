package com.example.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import dto.Device;
import dto.My;
import dto.Versions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        parseUsingJsonObjectApi(readJsonFromAssets());

        parseUsingGson(readJsonFromAssets());
    }

    private String readJsonFromAssets(){
        StringBuilder builder= new StringBuilder ();

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
        return builder.toString();
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

    private void parseUsingGson(String json){

        Gson gson = new Gson();
        My my = gson.fromJson(json, My.class);
        Log.i("@example","Gson - "+my);

        My myCon = new My();
        myCon.setName("codekul.com");
        myCon.setOs("Android");
        myCon.setVer(5.1);

        Versions versions = new Versions();
        versions.setBase("android");
        versions.setCupCake("android");

        ArrayList<Device> devices = new ArrayList<>();
        Device d1 = new Device();
        d1.setCost(800);
        d1.setMobile("android");
        myCon.setDevices(devices);

        String newJson = gson.toJson(myCon);
        Log.i("@example", "Converted - "+newJson);
    }
}