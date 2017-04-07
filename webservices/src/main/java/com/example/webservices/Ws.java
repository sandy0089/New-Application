package com.example.webservices;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sandy on 07-04-2017.
 */

public class Ws {

    private static RequestQueue queue;

    public static RequestQueue q(Context context){
        if(queue == null) queue = Volley.newRequestQueue(context);
        return queue;
    }
}
