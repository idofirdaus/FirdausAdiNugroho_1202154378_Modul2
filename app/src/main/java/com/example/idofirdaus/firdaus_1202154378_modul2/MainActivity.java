package com.example.idofirdaus.firdaus_1202154378_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button a ;
    private RadioGroup b;
    private RadioButton c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //melakukan inisiasi berdasarkan id yang ada di layout mulai dari button samapai radio button

        a = (Button) findViewById(R.id.pesan);

        b = (RadioGroup) findViewById(R.id.pilihmenu);

        c = (RadioButton) findViewById(R.id.dine);

        d = (RadioButton) findViewById(R.id.take);



    }

    //jika kita memasang onclick pada button dan agar dapat membuat tombol mempunyai aksi
    public void pesan(View view) {

        b = (RadioGroup) findViewById(R.id.pilihmenu);

        c = (RadioButton) findViewById(R.id.dine);

        d = (RadioButton) findViewById(R.id.take);

        // agar radio button dapat di pilih
        int selecteditem = b.getCheckedRadioButtonId();

        //jika yang dpilih adalah Dine In dan akan muncul toast yang beriikan anda memilih dine in
        if (selecteditem == c.getId()){
            Toast.makeText(this,"Anda Memilih Dine In",Toast.LENGTH_LONG).show();

            //membuat intent yang mengarah ke DineIn.class
            Intent a = new Intent(MainActivity.this,DineIn.class);
            startActivity(a);
        }
        else if (selecteditem == d.getId()){
            Toast.makeText(this,"Anda Memilih Take Away",Toast.LENGTH_LONG).show();

            //membuat intent yang mengarah ke TakeAway.class
            Intent a = new Intent(MainActivity.this,TakeAway.class);
            startActivity(a);
        }

    }
}