package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v){
        Button btn=new Button(this);
        btn.setText("Android");
        Toast toast = Toast.makeText(this,"Hello",Toast.LENGTH_SHORT);
        toast.setView(btn);
        toast.show();
    }
}
