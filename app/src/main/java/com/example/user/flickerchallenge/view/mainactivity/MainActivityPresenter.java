package com.example.user.flickerchallenge.view.mainactivity;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.flickerchallenge.data.remote.RemoteDataSource;
import com.example.user.flickerchallenge.model.FlickerData;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 8/17/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {


    private static final String TAG = "MainPresenterTag";
    MainActivityContract.View view;



    @Override
    public void attachView(MainActivityContract.View view) {

        this.view = view;
    }

    @Override
    public void removeView() {

        this.view = null;

    }

    @Override
    public void updateImageList() {
        Log.d(TAG, "updateImageList: ");

        Call<FlickerData> flickerDataCall = RemoteDataSource.getResponse();
        flickerDataCall.enqueue(new Callback<FlickerData>() {
            @Override
            public void onResponse(Call<FlickerData> call, Response<FlickerData> response) {


                view.onListUpdated(response.body().getItems());


            }

            @Override
            public void onFailure(Call<FlickerData> call, Throwable t) {

            }
        });


    }
}
