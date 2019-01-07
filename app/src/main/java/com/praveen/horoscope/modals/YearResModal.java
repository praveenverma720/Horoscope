package com.praveen.horoscope.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YearResModal {

    @SerializedName("horoscope")
    @Expose
    private String horoscope;
    @SerializedName("sunsign")
    @Expose
    private String sunsign;
    @SerializedName("year")
    @Expose
    private String year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
