package com.example.todoapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class todolist extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemadapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        listView=findViewById(R.id.list_view);
        button=findViewById(R.id.button_to_do);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        items=new ArrayList<>();
        itemadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemadapter);
        setUpListViewListener();
    }
    public void setUpListViewListener()
    {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context=getApplicationContext();
                Toast.makeText(context,"ItemRemoved",Toast.LENGTH_LONG).show();
                items.remove(i);
                itemadapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    public void addItem(View view)
    {
        EditText input=findViewById(R.id.edit_text_to_do);
        String itemtxt=input.getText().toString();
        if(!(itemtxt.equals("")))
        {
            itemadapter.add(itemtxt);
            input.setText("");
        }
        else
        {
            Toast.makeText(getApplicationContext(), "please enter text...", Toast.LENGTH_LONG).show();
        }

    }
}