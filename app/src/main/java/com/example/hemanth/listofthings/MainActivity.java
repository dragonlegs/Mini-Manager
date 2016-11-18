package com.example.hemanth.listofthings;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    private listofthings itemList;
    private ArrayList<listItem> userList;
    private ArrayAdapter<listItem> adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.ListView);
        //itemList.addToList(new listItem("test",0,"hello message","hey"));
        userList = itemList.getList();
        adapter= new customArrayAdapter(this,R.layout.listlayout,userList);
        listView.setAdapter(adapter);
        arrayAdapterListen();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        Log.d(TAG,"Selected " + item.toString());
        switch(item.getItemId()){
            case R.id.add_item:
                Log.d(TAG,"Switch Statement ADD ITEM");
                //itemList.addToList(new listItem("test",0,"hello message","hey"));
                Intent intent = new Intent(MainActivity.this,addItem.class);
                startActivity(intent);
                adapter.notifyDataSetChanged();
                break;

            default:
                Log.d(TAG,"Default Switch");
        }
        return true;
    }
    private void arrayAdapterListen(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"Select Item: " + userList.get(position).toString());
            }
        });
    }
    private void checkBoxListen(){
        CheckBox listButton = (CheckBox) findViewById(R.id.checkBox);
        Log.d(TAG,"listButton is " + R.id.checkBox);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"CheckBox " + ((Button)v).getText());
            }
        });
    }

    public class customArrayAdapter extends ArrayAdapter<listItem> {

        private ArrayList<listItem> userList;

        public customArrayAdapter(Context context, int textViewResourceId, ArrayList<listItem> userList){
            super(context,textViewResourceId,userList);
            this.userList=userList;


        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            ViewHolder holder = null;
            if (convertView == null){
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.listlayout,null);
                holder = new ViewHolder();
                holder.code = (TextView)convertView.findViewById(R.id.text1);
                holder.name = (CheckBox)convertView.findViewById(R.id.checkBox);
                convertView.setTag(holder);
                holder.name.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        Log.d(TAG,"Checkbox selected " + ((CheckBox)v).isChecked());
                    }
                });


            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            listItem choosen = userList.get(position);
            holder.code.setText(choosen.getName());
            holder.name.setChecked(choosen.isComplete());
            holder.name.setTag(choosen);
            return convertView;

        }
    }






}
