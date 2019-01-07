package com.praveen.horoscope.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodayResModal {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("horoscope")
    @Expose
    private String horoscope;
    @SerializedName("sunsign")
    @Expose
    private String sunsign;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

}