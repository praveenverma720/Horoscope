package com.praveen.horoscope.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {


//    private static Retrofit retrofit;
//
////Define the base URL//
//
//    private static final String BASE_URL = "http://3.16.93.165/api/";
//
////Create the Retrofit instance//
//
//    public static Retrofit getRetrofitInstance() {
//        if (retrofit == null) {
//            retrofit = new retrofit2.Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//
////Add the converter//
//
//                    .addConverterFactory(GsonConverterFactory.create())
//
////Build the Retrofit instance//
//
//                    .build();
//        }
//        return retrofit;
//    }



    private static Retrofit retrofit = null;

   public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl("http://horoscope-api.herokuapp.com/horoscope/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

}