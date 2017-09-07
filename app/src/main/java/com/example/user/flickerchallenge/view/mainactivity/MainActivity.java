package com.example.user.flickerchallenge.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.flickerchallenge.R;
import com.example.user.flickerchallenge.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    RecyclerView rvFlickerList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        presenter = new MainActivityPresenter();

        rvFlickerList = (RecyclerView) findViewById(R.id.rvFlickerList);
        presenter.attachView(this);
        presenter.updateImageList();
    }


    @Override
    public void showError(String e) {

    }

    @Override
    public void onListUpdated(List<Item> itemList) {

        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(itemList);

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFlickerList.setLayoutManager(layoutManager);
        rvFlickerList.setItemAnimator(itemAnimator);
        rvFlickerList.setAdapter(mainActivityAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }
}
