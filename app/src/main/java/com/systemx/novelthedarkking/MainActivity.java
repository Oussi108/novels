package com.systemx.novelthedarkking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class MainActivity extends AppCompatActivity {

    Button listPage;
    Button gosetting;
    Button Gostore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////ADS
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        ///////
        listPage =(Button)findViewById(R.id.GotoListPage);
        gosetting =(Button) findViewById(R.id.setsettings);
        Gostore = (Button) findViewById(R.id.MoreNovelPage);


        ///////
        Gostore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=SystemX+Apps+:+Puzzle+%26+Games+and+More")));
                } catch (android.content.ActivityNotFoundException anfe) {

                }
            }
        });


        listPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(MainActivity.this,choosechapter.class);
                startActivity(int1);
            }
        });
        gosetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent setpage = new Intent(MainActivity.this,ReadSettingsOptions.class);
                startActivity(setpage);
            }
        });


    }


}
