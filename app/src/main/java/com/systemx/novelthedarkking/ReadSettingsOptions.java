package com.systemx.novelthedarkking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReadSettingsOptions extends AppCompatActivity {
    Button subset;
    Spinner mysp;
    EditText myfont;
    SharedPreferences sharedcolor;
    SharedPreferences sharedfont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_settings_options);
        subset =(Button)findViewById(R.id.submitsetting);
        mysp =(Spinner)findViewById(R.id.colorsetting);
        myfont=(EditText)findViewById(R.id.sizeSetting);
        ////////
        sharedcolor = getSharedPreferences("colorst",MODE_PRIVATE);
        sharedfont = getSharedPreferences("fontst",MODE_PRIVATE);

        ////////

        final List<String> myclors= new ArrayList<String>();
        myclors.add("White");
        myclors.add("Black");
       ArrayAdapter<String> Adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,myclors);
        Adap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mysp.setAdapter(Adap);

        subset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String colorselected = mysp.getSelectedItem().toString();
                int fontselected;
                String aa =myfont.getText().toString();

                if(aa.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Font size is empty",Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor myfonted =sharedfont.edit();

                    myfonted.putInt("fontsetting",15);

                    myfonted.commit();
                }else if (Integer.parseInt(aa)>100){
                    Toast.makeText(getApplicationContext(),"Font size is too much",Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor myfonted =sharedfont.edit();

                    myfonted.putInt("fontsetting",100);

                }


                else{
                    fontselected = Integer.parseInt(myfont.getText().toString());
                    SharedPreferences.Editor myfonted =sharedfont.edit();

                    myfonted.putInt("fontsetting",fontselected);

                    myfonted.commit();
                }



               if(colorselected!=null){
               SharedPreferences.Editor mycolored =sharedcolor.edit();
                int c = 0;
                if (colorselected =="Black") c =1;
                mycolored.putInt("colorsetting", c);
                mycolored.commit();}




                Toast.makeText(getApplicationContext(),"You changed the Settings",Toast.LENGTH_LONG).show();


            }
        });

    }
}
