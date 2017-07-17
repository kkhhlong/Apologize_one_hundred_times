package com.example.nhl71.apologize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by nhl71 on 02/06/2017.
 */

public class InforActivity extends Activity {
    RadioButton cFemale,cMale;
    EditText editTxtYourName,editTxtYourLoverName;
    Button btnOutput;
    String yourName,yourLoverName;
    Boolean male;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infor_layout);
        connectView();
    }

    void connectView(){
        cFemale = (RadioButton) findViewById(R.id.cFemale);
        cMale = (RadioButton) findViewById(R.id.cMale);
        editTxtYourLoverName = (EditText) findViewById(R.id.editTxtNameYourLover);
        editTxtYourName = (EditText) findViewById(R.id.editTxtYourName);
        btnOutput = (Button) findViewById(R.id.btnOutput);
    }
    public void setBtnOutputClick(View v ){
        yourLoverName = (editTxtYourLoverName.getText().toString()).trim();
        male = cMale.isChecked()?true:false;
        yourName = (editTxtYourName.getText().toString()).trim();
        if(yourLoverName.length()==0 || yourName.length()==0){
            Toast.makeText(InforActivity.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
            return;
        }
        Bundle b = new Bundle();
        b.putString("yourName",yourName);
        b.putString("yourLoverName",yourLoverName);
        b.putBoolean("male",male);
        Intent i = new Intent(InforActivity.this,ResultActivity.class);
        i.putExtras(b);
        startActivity(i);


    }
}
