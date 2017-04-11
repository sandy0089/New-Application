package com.example.customgridview;

//1800 1122 67

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set grid view item
        Bitmap enquiries = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
        Bitmap fees = BitmapFactory.decodeResource(this.getResources(), R.drawable.personal);
        Bitmap oldBatch = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
        Bitmap newBatch = BitmapFactory.decodeResource(this.getResources(), R.drawable.personal);


        gridArray.add(new Item(enquiries, "Enquiries"));
        gridArray.add(new Item(fees, "Fees"));
        gridArray.add(new Item(oldBatch, "Ongoing Batches"));
        gridArray.add(new Item(newBatch, "New Batches"));
//        gridArray.add(new Item(homeIcon, "Home"));
//        gridArray.add(new Item(userIcon, "Personal"));
//        gridArray.add(new Item(homeIcon, "Home"));
//        gridArray.add(new Item(userIcon, "User"));
//        gridArray.add(new Item(homeIcon, "Building"));
//        gridArray.add(new Item(userIcon, "User"));
//        gridArray.add(new Item(homeIcon, "Home"));
//        gridArray.add(new Item(userIcon, "xyz"));


        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
    }
}

