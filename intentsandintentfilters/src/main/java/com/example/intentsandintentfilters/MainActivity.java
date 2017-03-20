package com.example.intentsandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startNew(View view){
        location();
    }

    private void concept(){
        Intent intent = new Intent();
        intent.setAction("com.example.action.COMMAN");
        intent.addCategory("com.example.category.ENTERTAINMENT");
        intent.setData(Uri.parse("http://youtube.com"));
        startActivity(intent);
    }

    private void dial(){
        startActivity(new Intent(Intent.ACTION_DIAL));
    }

    private void call(){
       Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel://8180070089"));
        startActivity(intent);
    }

    private void browser(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://youtube.com"));
        startActivity(intent);
    }

    private void location() {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=18.4816196,74.0098947 (Sandy's Home)")); //@18.4816196,74.0098947
        startActivity(intent);
    }
}
