package com.systemx.novelthedarkking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.InputStream;

public class readingpage extends AppCompatActivity {

    TextView chapterText;
    Resources res;
    int textsize;
    int colorBG ;
    SharedPreferences sharedcolor;
    SharedPreferences sharedfont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readingpage);
        Bundle AAA= getIntent().getExtras();
        int numch = AAA.getInt("chapterid");
        String path = "android.resource://com.cpt.sample/raw/a"+String.valueOf(numch)+".txt";
        chapterText =(TextView)findViewById(R.id.viewchap);
        chapterText.setMovementMethod(new ScrollingMovementMethod());
        /////////
        sharedcolor = getSharedPreferences("colorst",MODE_PRIVATE);
        sharedfont = getSharedPreferences("fontst",MODE_PRIVATE);
        //////////

      try {
        Resources res = getResources();
       int id = getResources().getIdentifier("a"+String.valueOf(numch+1), "raw", getPackageName());

        InputStream in_s = res.openRawResource(id);

        byte[] b = new byte[in_s.available()];
        in_s.read(b);
        String textshowing = new String(b);
          textshowing = textshowing.replace(".",".\n");
        chapterText.setText(textshowing);
    } catch (Exception e) {
        // e.printStackTrace();
        chapterText.setText("Error: can't show .");
    }

        /////////
        //chapterText.setText("ff");
        res = getResources();
        textsize = sharedfont.getInt("fontsetting",15);
        colorBG = sharedcolor.getInt("colorsetting",0);
        checksettings(textsize,colorBG);


    }

    /////////////////////////////////////////Menu
    @Override
    public boolean onCreateOptionsMenu(Menu mym){
        getMenuInflater().inflate(R.menu.readingmenu,mym);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem AB){

        int A= AB.getItemId();
       if(A == R.id.blackbg){
           chapterText.setBackgroundColor(Color.BLACK);
           chapterText.setTextColor(Color.GRAY);
           colorBG = 1;
    }
       else if(A == R.id.whitebg){
           chapterText.setBackgroundColor(Color.WHITE);
           chapterText.setTextColor(Color.BLACK);
           colorBG = 1;
       }
       else if(A == R.id.smallfont){
           textsize-=2;
           chapterText.setTextSize(textsize);
       }
       else if(A == R.id.middlefont){
           textsize= 15;
           chapterText.setTextSize(textsize);
       }
       else if(A == R.id.bigfont){
           textsize+=2;
           chapterText.setTextSize(textsize);}


        return true;
    }

    void checksettings(int T,int P){
        if(P==1){
            chapterText.setBackgroundColor(Color.BLACK);
            chapterText.setTextColor(Color.GRAY);
            colorBG = 1;

        }
        chapterText.setTextSize(T);
    }





    }


    /////////////////////////////////////////

