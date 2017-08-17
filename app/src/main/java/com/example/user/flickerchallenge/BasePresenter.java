package com.example.user.flickerchallenge;

/**
 * Created by user on 8/17/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void removeView();

}
