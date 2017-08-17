package com.example.user.flickerchallenge.view.mainactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.user.flickerchallenge.BasePresenter;
import com.example.user.flickerchallenge.BaseView;
import com.example.user.flickerchallenge.model.Item;

import java.util.List;

/**
 * Created by user on 8/17/17.
 */

public interface MainActivityContract {


    interface View extends BaseView{


        void onListUpdated(List<Item> items);

    }


    interface Presenter extends BasePresenter<View>{

        void updateImageList();



    }
}
