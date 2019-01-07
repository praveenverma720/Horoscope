package com.praveen.horoscope.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.praveen.horoscope.Network.APIClient;
import com.praveen.horoscope.R;
import com.praveen.horoscope.interfaces.APIInterface;
import com.praveen.horoscope.modals.TodayResModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodaysHoroscopeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TodaysHoroscopeActivity";

    private TextView title, today_horoscope;
    private LinearLayout progress_circular;
    APIInterface apiInterface;
    private String zodaic;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horoscope_details_activity);

        MobileAds.initialize(this, "ca-app-pub-7152815429504851~5661686109");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7152815429504851/8614441716");
        startGame();

        title = findViewById(R.id.title);
        progress_circular = findViewById(R.id.progress_circular);
        today_horoscope = findViewById(R.id.today_horoscope);
        zodaic = getIntent().getStringExtra("zodaic");
        Log.d(TAG,zodaic);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        progress_circular.setVisibility(View.VISIBLE);
        getTodayHoro();

        findViewById(R.id.week_horoscope).setOnClickListener(this);
        findViewById(R.id.month_horoscope).setOnClickListener(this);
        findViewById(R.id.year_horoscope).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.week_horoscope:
                if (interstitialAd != null && interstitialAd.isLoaded()) {
                    interstitialAd.show();
                    //  Toast.makeText(this, "We will soon update this technology", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(TodaysHoroscopeActivity.this,WeeklyHoroscopeActivity.class);
                    intent.putExtra("zodaic",zodaic);
                    startActivity(intent);
                    toastMsg("Please Wait...");
                    startGame();
                }

                interstitialAd.setAdListener(new AdListener(){

                    @Override
                    public void onAdClosed() {
                        Intent intent = new Intent(TodaysHoroscopeActivity.this,WeeklyHoroscopeActivity.class);
                        intent.putExtra("zodaic",zodaic);
                        startActivity(intent);
                    }
                });

                break;

            case R.id.month_horoscope:
                if (interstitialAd != null && interstitialAd.isLoaded()) {
                    interstitialAd.show();
                    //  Toast.makeText(this, "We will soon update this technology", Toast.LENGTH_SHORT).show();
                } else {
                    Intent monthintent = new Intent(TodaysHoroscopeActivity.this,MonthlyHoroscopeActivity.class);
                    monthintent.putExtra("zodaic",zodaic);
                    startActivity(monthintent);
                    toastMsg("Please Wait...");
                    startGame();
                }

                interstitialAd.setAdListener(new AdListener(){

                    @Override
                    public void onAdClosed() {
                        Intent monthintent = new Intent(TodaysHoroscopeActivity.this,MonthlyHoroscopeActivity.class);
                        monthintent.putExtra("zodaic",zodaic);
                        startActivity(monthintent);
                    }
                });

                break;

            case R.id.year_horoscope:
                if (interstitialAd != null && interstitialAd.isLoaded()) {
                    interstitialAd.show();
                    //  Toast.makeText(this, "We will soon update this technology", Toast.LENGTH_SHORT).show();
                } else {
                    Intent yearintent = new Intent(TodaysHoroscopeActivity.this,YearlyHoroscopeActivity.class);
                    yearintent.putExtra("zodaic",zodaic);
                    startActivity(yearintent);
                    toastMsg("Please Wait...");
                    startGame();
                }

                interstitialAd.setAdListener(new AdListener(){

                    @Override
                    public void onAdClosed() {
                        Intent yearintent = new Intent(TodaysHoroscopeActivity.this,YearlyHoroscopeActivity.class);
                        yearintent.putExtra("zodaic",zodaic);
                        startActivity(yearintent);
                    }
                });

                break;
        }
    }

    //GEt Today horoscope
    public void getTodayHoro() {
        String url = "http://horoscope-api.herokuapp.com/horoscope/today/" + zodaic;
        Call<TodayResModal> call = apiInterface.getTodayHoroscope(url);
        call.enqueue(new Callback<TodayResModal>() {
            @Override
            public void onResponse(Call<TodayResModal> call, Response<TodayResModal> response) {

                Log.d("Horoscope for today", "-----");
                if (response.message().toString().equals("OK")){
                    progress_circular.setVisibility(View.GONE);
                    title.setText("Your "+response.body().getSunsign()+" Zodiac Horoscope for "+response.body().getDate());
                    today_horoscope.setText(response.body().getHoroscope());
                }else {
                    Toast.makeText(getApplicationContext(),"Some Thing Went Wrong...",Toast.LENGTH_SHORT).show();
                    progress_circular.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<TodayResModal> call, Throwable t) {

            }
        });
    }

    private void startGame() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }

        //  retryButton.setVisibility(View.INVISIBLE);

    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
}
