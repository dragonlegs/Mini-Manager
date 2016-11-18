package com.example.hemanth.listofthings;

import android.app.LauncherActivity;

import java.util.ArrayList;

/**
 * Created by Hemanth on 11/16/2016.
 */

public class listofthings {

    private static listofthings singleton = new listofthings();
    public static ArrayList<listItem> itemList = new ArrayList<listItem>();
    private listofthings(){}

    public static listofthings getInstance(){
        return singleton;
    }

    public static void addToList (listItem value){
        itemList.add(value);
    }

    public static void removeFromList (int value){
        itemList.remove(value);
    }
    public static ArrayList<listItem> getList(){
        return itemList;
    }

}
