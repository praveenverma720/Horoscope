package com.praveen.horoscope.interfaces;

import com.praveen.horoscope.modals.MonthResModal;
import com.praveen.horoscope.modals.TodayResModal;
import com.praveen.horoscope.modals.WeekResModal;
import com.praveen.horoscope.modals.YearResModal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIInterface {

    //get Today Horoscope
    @GET
    Call<TodayResModal> getTodayHoroscope(@Url String url);

    //get Week Horoscope

    @GET
    Call<WeekResModal> getWeekHoroscope(@Url String url);

    //get Month Horoscope
    @GET
    Call<MonthResModal> getMonthHoroscope(@Url String url);

    //get Year Horoscope
    @GET
    Call<YearResModal> getYearHoroscope(@Url String url);


}