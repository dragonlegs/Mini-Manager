package com.example.hemanth.listofthings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Hemanth on 11/16/2016.
 */

public class addItem extends AppCompatActivity {
    private static final String TAG = "Add Item Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        setResult(RESULT_CANCELED,intent);
        finish();
    }

    public void backButton(View v){
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_item,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Log.d(TAG,"Selected " + item.toString());
        switch(item.getItemId()){
            case R.id.save:
                Log.d(TAG,"Switch Statement Save ITEM");
                break;

            default:
                Log.d(TAG,"Default Switch");
        }
        return true;
    }

    public void toastMessage(String message){

    }

}
