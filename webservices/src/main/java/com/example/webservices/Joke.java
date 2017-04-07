package com.example.webservices;

import java.util.ArrayList;

/**
 * Created by Sandy on 07-04-2017.
 */

public class Joke {

    private String type;
    private ArrayList<JokeInfo> value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<JokeInfo> getValue() {
        return value;
    }

    public void setValue(ArrayList<JokeInfo> value) {
        this.value = value;
    }
}
