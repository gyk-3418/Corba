package com.example.corba;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView listView;
    Button btnGoMap,btnNewItem;
    ArrayList<Category> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGoMap=getActivity().findViewById(R.id.btnGoMap);
        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        btnNewItem=getActivity().findViewById(R.id.btnNewItem);
        btnNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intAdd=new Intent(getContext(),ItemAddActivity.class);
                startActivity(intAdd);
            }
        });


        listView=getActivity().findViewById(R.id.lstVwMenu);

        CategoryAdapter adapter = new CategoryAdapter();
        adapter.itemList = createCategoryList();
        adapter.context = getContext();
        listView.setAdapter(adapter);

        Bundle new_item =getActivity().getIntent().getExtras();
        if(new_item != null)
        {
            // new_item.getInt("icon")
            Category c_new = new Category(0,new_item.getString("title").toString());
            adapter.itemList.add(c_new);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
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
