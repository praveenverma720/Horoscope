package com.praveen.horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.praveen.horoscope.activities.TodaysHoroscopeActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

   // ImageView aries,taurus,gemini,cancer,virgo,leo,libra,scorpio,sagittarius,capricornus,aquarius,pisces;
    private String zodaic;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, "ca-app-pub-7152815429504851~5661686109");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7152815429504851/8614441716");
        startGame();

        findViewById(R.id.aries).setOnClickListener(this);
        findViewById(R.id.taurus).setOnClickListener(this);
        findViewById(R.id.gemini).setOnClickListener(this);
        findViewById(R.id.cancer).setOnClickListener(this);
        findViewById(R.id.virgo).setOnClickListener(this);
        findViewById(R.id.leo).setOnClickListener(this);
        findViewById(R.id.libra).setOnClickListener(this);
        findViewById(R.id.scorpio).setOnClickListener(this);
        findViewById(R.id.sagittarius).setOnClickListener(this);
        findViewById(R.id.capricornus).setOnClickListener(this);
        findViewById(R.id.aquarius).setOnClickListener(this);
        findViewById(R.id.pisces).setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    //Onclick
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.aries:
                 zodaic = "aries";
                changeActivity(zodaic);
                break;

            case R.id.taurus:
                 zodaic = "taurus";
                changeActivity(zodaic);
                break;

            case R.id.gemini:
                 zodaic = "gemini";
                changeActivity(zodaic);
                break;

            case R.id.cancer:
                 zodaic = "cancer";
                changeActivity(zodaic);
                break;

            case R.id.virgo:
                 zodaic = "virgo";
                changeActivity(zodaic);
                break;


            case R.id.leo:
                 zodaic = "leo";
                changeActivity(zodaic);
                break;

            case R.id.libra:
                 zodaic = "libra";
                changeActivity(zodaic);
                break;


            case R.id.scorpio:
                 zodaic = "scorpio";
                changeActivity(zodaic);
                break;


            case R.id.sagittarius:
                 zodaic = "sagittarius";
                changeActivity(zodaic);
                break;

            case R.id.capricornus:
                 zodaic = "capricorn";
                changeActivity(zodaic);
                break;


            case R.id.aquarius:
                 zodaic = "aquarius";
                changeActivity(zodaic);
                break;


            case R.id.pisces:
                zodaic = "pisces";
                changeActivity(zodaic);
                break;


        }

    }


    public void changeActivity(final String zodaic){

        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
            //  Toast.makeText(this, "We will soon update this technology", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent =  new Intent(MainActivity.this,TodaysHoroscopeActivity.class);
            intent.putExtra("zodaic",zodaic);
            startActivity(intent);
            toastMsg("Please Wait...");
            startGame();
        }

        interstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                Intent intent =  new Intent(MainActivity.this,TodaysHoroscopeActivity.class);
                intent.putExtra("zodaic",zodaic);
                startActivity(intent);
            }
        });





    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
