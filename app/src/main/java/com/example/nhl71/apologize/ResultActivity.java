package com.example.nhl71.apologize;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by nhl71 on 02/06/2017.
 */

public class ResultActivity extends Activity {
    EditText txtResult;
    Button btnCopy;
    String [] s1;
    String []s2;
    Intent i ;
    Bundle b;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        txtResult = (EditText) findViewById(R.id.txtResult);
        btnCopy = (Button) findViewById(R.id.btnCopy);
        i = getIntent();
        b = i.getExtras();
        String yourName = b.getString("yourName");
        String yourLoverName = b.getString("yourLoverName");
        Boolean male = b.getBoolean("male");
        if(male){
            s1 = new String[]{"Anh ","Tui ","Cho anh ","Cho tui ","",yourName+" ","Anh muốn ","Tui muốn ","T_T ",
                    "Cho "+yourName+" ","Anh thật lòng "};
            s2 = new String[]{" em"," :'("," :("," mà"," "+yourLoverName," em mà :("," nha"," T_T"," "+yourLoverName+" nha",
            " bé"," mà :'( T_T"," :))"," cục cưng"};
        }
        else{
            s1 = new String[]{"Em ","Tui ","Cho em ","Cho tui ","",yourName+" ","em muốn ","Tui muốn ","T_T ",
                    "Cho "+yourName+" ","em thật lòng "};
            s2 = new String[]{" anh"," :'("," :("," mà"," "+yourLoverName," anh mà :("," nha"," T_T"," "+yourLoverName+" nha",
                    " ôngg :("," mà :'( T_T"," :))"," cục cưng"};
        }
        List<String> saveText = new ArrayList<String>();
        List<Integer> saveIndex =  new ArrayList<Integer>();

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if(s1[i].length() == 0){
                    saveText.add((s1[i]+"Xin lỗi"+s2[j]).toString());
                }
                else{
                    saveText.add((s1[i]+"xin lỗi"+s2[j]).toString());
                }
            }
        }
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int index = rand.nextInt(saveText.size());
            while(saveIndex.contains(index)){
                index = rand.nextInt(saveText.size());

            }

            saveIndex.add(index);
            txtResult.setText(txtResult.getText()+saveText.get(index)+"\n");
        }

    }
    public void copyText(View v){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(this.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("",txtResult.getText().toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this,"Đã copy vào bộ nhớ ",Toast.LENGTH_LONG).show();
    }
}
