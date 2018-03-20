package com.example.ralha.velvetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.ralha.velvetapp.adapter.AdapterUerModel;
import com.example.ralha.velvetapp.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends AppCompatActivity implements  SearchView.OnQueryTextListener {

    // DEFIND ATT
    public ImageView imageView2;

    TabLayout mTablayout;
    private RecyclerView recyclerView;
    private AdapterUerModel adapterUerModel;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        imageView2 = findViewById(R.id.imageView2);

        searchView=(SearchView) findViewById(R.id.seach_view);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        adapterUerModel = new AdapterUerModel(Constant.mList, this);
        recyclerView.setAdapter(adapterUerModel);

        searchView.setOnQueryTextListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                adapterUerModel.getFilter().filter(s);
//                Log.d("s",s);
//                adapterUerModel.filterNew(s);


////                adapterUerModel.getFilter().filter(s.toLowerCase());
//
//
//
//
//
//                List<ItemModel> tempList = new ArrayList<>();
//                List<ItemModel> tempCountry= new ArrayList<>();
//                for (int j = 0; j < itemModelList.size(); j++) {
//                     ItemModel itemModel = itemModelList.get(j);
//
//                    if (itemModel.getColor().toLowerCase().startsWith(s.toString().toLowerCase())||itemModel.getColor().toLowerCase().contains(s.toString().toLowerCase())) {
////                        recyclerView.setAdapter(null);
////                        recyclerView.setAdapter(adapterCountryList);
//                        tempList.addAll(tempCountry);
//
//
//                    }
//                }
//
//
//
//                adapterUerModel.updateList(tempList);
//
//                if (s.length() == 0) {
//
//
//                    adapterUerModel.updateList(itemModelList);
//                }


                return true;
            }
        });

        mTablayout = (TabLayout) findViewById(R.id.filter);

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:

                        break;
                    case 1:
                        Intent intent = new Intent(HomePage.this, Fill_leanding.class);
                        startActivity(intent);
                        break;

                    case 2:
                        break;

                    case 3:
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });


    }// CLOSE ONcREATE METHOD

    public void onClick(ImageView imgView) {
        if (imgView == imageView2) {
            startActivity(new Intent(getApplicationContext(), Fill_leanding.class));
        }

    }// CLOSE ONCLICK METHOD

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String searchString) {
//     adapterUerModel.getFilter().filter(searchString);
        return true;
    }
}
