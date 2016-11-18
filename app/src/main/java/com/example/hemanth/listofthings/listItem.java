package com.example.hemanth.listofthings;

/**
 * Created by Hemanth on 11/16/2016.
 */

public class listItem {
    String name = "default";
    int listNumber = 100;
    String message = "None";
    String date = "99999999";
    boolean complete = false;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public listItem(String name,int listNumber,String message,String date){
        this.name = name;
        this.listNumber = listNumber;
        this.message = message;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListNumber() {
        return listNumber;
    }

    public void setListNumber(int listNumber) {
        this.listNumber = listNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

@Override
    public String toString(){
    return this.name;
}
}
