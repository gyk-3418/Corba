package com.example.corba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Button btnGoMap,btnNewItem;
    ArrayList<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btnGoMap=findViewById(R.id.btnGoMap);
        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        btnNewItem=findViewById(R.id.btnNewItem);
        btnNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intAdd=new Intent(getApplicationContext(),ItemAddActivity.class);
                startActivity(intAdd);
            }
        });


        listView=findViewById(R.id.lstVwMenu);

        CategoryAdapter adapter = new CategoryAdapter();
        adapter.itemList = createCategoryList();
        adapter.context = this;
        listView.setAdapter(adapter);

        Bundle new_item = getIntent().getExtras();
        if(new_item != null)
        {
            // new_item.getInt("icon")
            Category c_new = new Category(0,new_item.getString("title").toString());
            adapter.itemList.add(c_new);
            adapter.notifyDataSetChanged();
        }
    }


    private ArrayList<Category> createCategoryList() {
        Category c1 = new Category(R.drawable.muzik,"Müzikler");
        Category c2 = new Category(R.drawable.resim,"Resimler");
        Category c3 = new Category(R.drawable.video,"Videolar");

        list.add(c1);
        list.add(c2);
        list.add(c3);
        return list;
    }
}
