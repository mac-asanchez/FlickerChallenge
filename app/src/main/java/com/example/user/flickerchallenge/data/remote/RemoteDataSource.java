package com.example.user.flickerchallenge.data.remote;

import com.example.user.flickerchallenge.model.FlickerData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 8/17/17.
 */

public class RemoteDataSource {

    public static final String BASE_URL = "http://api.flickr.com/";
    public static final String QUERY_TAG = "kitten";
    public static final String QUERY_FORMAT = "json";
    public static final String QUERY_NOJSONCALLBACK = "1";
    public static final String PATH = "services/feeds/photos_public.gne";


    public static Retrofit create(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

    public static Call<FlickerData> getResponse(){

        Retrofit retrofit = create();
        FlickerService flickerService = retrofit.create(FlickerService.class);
        return flickerService.getImageList(QUERY_TAG, QUERY_FORMAT, QUERY_NOJSONCALLBACK);

    }


    public interface FlickerService{

        @GET(PATH)
        Call<FlickerData> getImageList(@Query("tag") String tag, @Query("format") String format, @Query("nojsoncallback") String noJsonCallback);
    }


}
