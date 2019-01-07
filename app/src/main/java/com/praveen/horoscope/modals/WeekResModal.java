package com.praveen.horoscope.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeekResModal {

    @SerializedName("horoscope")
    @Expose
    private String horoscope;
    @SerializedName("sunsign")
    @Expose
    private String sunsign;
    @SerializedName("week")
    @Expose
    private String week;

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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

}