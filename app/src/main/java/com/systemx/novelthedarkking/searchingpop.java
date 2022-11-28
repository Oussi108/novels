package com.systemx.novelthedarkking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class searchingpop extends DialogFragment implements View.OnClickListener {


    View Mysearchview;
    Button srchbtn;
    EditText chptnum;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle saveInstanceState){
        /////////////////ADS


        /////////////////
        Mysearchview = inflater.inflate(R.layout.searchbar,container,false);
        srchbtn =(Button)Mysearchview.findViewById(R.id.searchbtn);
        chptnum =(EditText)Mysearchview.findViewById(R.id.searchinPut);
        View mysearchview = Mysearchview;
        ///////////////ADS





        /////////////

        srchbtn.setOnClickListener(this);
        return mysearchview;

    }
    @Override
    public void onClick(View v) {

 this.dismiss();
 String BB = chptnum.getText().toString();
 if (BB.isEmpty()){
     Toast.makeText(getActivity(), "Empty input!!",Toast.LENGTH_LONG).show();
 }else if(Integer.parseInt(BB)>474){
     Toast.makeText(getActivity(), "Chapter Not Found!!",Toast.LENGTH_LONG).show();
 }
    else {

        //////////////////////ADS





        //////////////////////////
 int ChapterSearchingValue = Integer.parseInt(chptnum.getText().toString());
 choosechapter AP =(choosechapter)getActivity();
 AP.checkchapterexistandgo(ChapterSearchingValue);}


    }
}
