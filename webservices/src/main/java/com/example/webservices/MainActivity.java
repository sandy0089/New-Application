package com.example.webservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnApi).setOnClickListener(this::click);
    }

    private void click(View view) {
        post();
    }

    private void get(){
        Ws.q(this).add(new StringRequest("http://api.icndb.com/jokes/random/3",
                this::onJoke,
                this::onJokeError));
    }

    private void onJokeError(VolleyError volleyError) {
        Log.i("@example","Volley Error - "+volleyError.toString());
    }

    private void onJoke(String s) {
        Log.i("@example","Json - "+s );

        Gson gson = new Gson();
        Joke joke = gson.fromJson(s, Joke.class);

        updateJokeList(joke);
    }

    private void post(){

        JSONObject obj = new JSONObject();
        try {

            obj.put("name", "android");
            obj.put("job", "os");
        }catch (JSONException e){
            e.printStackTrace();
        }
            Ws.q(this)
                .add(new JsonObjectRequest("https://reqres.in/api/users" , obj,
                this::onPostSuccess,
                this::onPostError));
    }

    private void onPostSuccess(JSONObject ob) {
        Log.i("@example", "Response - "+ob.toString());
    }

    private void onPostError(VolleyError e){
        Log.i("@example","Error - "+e.toString());

    }

    private void updateJokeList(Joke joke){

        ArrayList<String> jokes = new ArrayList<>();
        for(JokeInfo info: joke.getValue()){
            jokes.add(info.getJoke());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jokes );
        ((ListView)findViewById(R.id.listJokes)).setAdapter(adapter);
    }


}
