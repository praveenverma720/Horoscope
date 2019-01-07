package com.praveen.horoscope.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonthResModal {

    @SerializedName("horoscope")
    @Expose
    private String horoscope;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("sunsign")
    @Expose
    private String sunsign;

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

}