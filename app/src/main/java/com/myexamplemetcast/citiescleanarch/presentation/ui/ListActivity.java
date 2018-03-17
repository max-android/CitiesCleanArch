package com.myexamplemetcast.citiescleanarch.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myexamplemetcast.citiescleanarch.R;
import com.myexamplemetcast.citiescleanarch.domain.model.Town;
import com.myexamplemetcast.citiescleanarch.presentation.general.Constants;

import java.util.List;

public class ListActivity extends AppCompatActivity implements CitiesAdapter.TownClickListener {


private  RecyclerView  rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initComponents();

        initData();

    }



    private void initComponents(){

        rvList=(RecyclerView) findViewById(R.id.rvList);
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);
        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }



    private void initData(){

        List<Town> towns = (List<Town>) getIntent().getSerializableExtra(Constants.KEY_DATA);

        rvList.setAdapter(new CitiesAdapter(towns,this));


    }

    @Override
    public void onTownClick(Town town) {

    }
}
