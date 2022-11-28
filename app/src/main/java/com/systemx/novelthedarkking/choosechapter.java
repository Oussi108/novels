package com.systemx.novelthedarkking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class choosechapter extends AppCompatActivity {

    public int Numchoosen;
    int a = 0;
    private InterstitialAd mInterstitialAd;
    FragmentTransaction manger;
    final   ArrayList<chapter> Items=new  ArrayList<chapter> ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosechapter);
////////////////////////////ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
        ///////////////////



        for(int i=1;i<=474;i++){

            Items.add(new chapter(i,"Chapter: "));


        }
        final chapterlist mychlist= new chapterlist(Items);

        ListView ls=(ListView)findViewById(R.id.chapterlist);
        ls.setAdapter(mychlist);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private AdapterView<?> parent;
            private View view;
            private int position;
            private long id;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //////////////ADS





                ////////////
                this.parent = parent;
                this.view = view;
                this.position = position;
                this.id = id;

                TextView txtTit =(TextView) view.findViewById(R.id.chaptertest);
                TextView txtnum =(TextView) view.findViewById(R.id.numch);
                Numchoosen =Integer.parseInt(txtnum.getText().toString());
                createintents();
               // Toast.makeText(getApplicationContext(),String.valueOf(Items.size()),Toast.LENGTH_LONG).show();

                mychlist.notifyDataSetChanged();

            }
        });
        /////////////////////////

    }
///////////////////////Menu
    @Override
    public boolean onCreateOptionsMenu(Menu A){
        getMenuInflater().inflate(R.menu.choosechapter_menu,A);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem AB){

     int A = AB.getItemId();
      if (A==R.id.findchapter){
          ////////////////// searching 2
          manger=getSupportFragmentManager().beginTransaction();
        searchingpop search= new searchingpop();
        search.show(manger,null);





          /////////////searching 1
          /*LayoutInflater mylayout =getLayoutInflater();
          View myview = mylayout.inflate(R.layout.searchbar,(ViewGroup)findViewById(R.id.mysearchbar));
          EditText searchingchapter =(EditText)myview.findViewById(R.id.searchinPut);
          Button getsearchnum = (Button)myview.findViewById(R.id.searchbtn);
          final FrameLayout mysearchbaar =(FrameLayout)findViewById(R.id.searchingbar);
          mysearchbaar.addView(myview);
          getsearchnum.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  mysearchbaar.removeAllViews();
              }
          });*/



      }


        return true;
    }


////////////////////////////////////////////////Listview
class chapterlist extends BaseAdapter
{
    ArrayList<chapter> chapters=new ArrayList<chapter>();
    chapterlist(ArrayList<chapter> Items ) {
        this.chapters=Items;

    }

    @Override
    public int getCount() {
        return chapters.size();
    }

    @Override
    public String getItem(int position) {
        return chapters.get(position).title;

    }

    @Override
    public long getItemId(int position) {
        return  position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater linflater = getLayoutInflater();
        View view1=linflater.inflate(R.layout.chapterbar, null);


        TextView txttit =(TextView) view1.findViewById(R.id.chaptertest);
        TextView txtnum =(TextView) view1.findViewById(R.id.numch);
        txttit.setText(chapters.get(i).title);
        txtnum.setText(String.valueOf(chapters.get(i).chapternum));

        return view1;

    }
}
////////////////////////////////////////////////

    public void createintents(){
        Intent readnow= new Intent(choosechapter.this,readingpage.class);

        readnow.putExtra("chapterid",Numchoosen-1);
        startActivity(readnow);
        a++;
        if(a > 1){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }}

    }
    /////////////////////////////////////////////////
    public void checkchapterexistandgo(int A){

        if (A > 0&& A <= Items.size()){

            Numchoosen = A;
            createintents();


        }
        else {
            Toast.makeText(getApplicationContext(),"This chapter doesnot exist",Toast.LENGTH_LONG).show();

        }


    }



}
