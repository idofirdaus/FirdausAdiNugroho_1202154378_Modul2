package com.example.idofirdaus.firdaus_1202154378_modul2;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class TakeAway extends AppCompatActivity {

    private TextInputLayout a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        //melakukan inisiasi TextInputLayout dengan menggunakan id
        a = (TextInputLayout) findViewById(R.id.nama);
        b = (TextInputLayout) findViewById(R.id.phone);
        c = (TextInputLayout) findViewById(R.id.alamat);
        d = (TextInputLayout) findViewById(R.id.catatan);


    }

    public void pilihpesan(View view) {

        String nama = a.getEditText().getText().toString();
        String telepon = b.getEditText().getText().toString();
        String alamat = c.getEditText().getText().toString();
        String catatan = d.getEditText().getText().toString();

        if (nama.isEmpty()|| telepon.isEmpty() || alamat.isEmpty() || catatan.isEmpty()){
            Toast.makeText(this,"Isi dulu bro",Toast.LENGTH_LONG).show();
        }

        //mengirimkan nama dan jumlah ke dalam intent agar bisa di get pada class yang di tuju
        Intent c = new Intent(TakeAway.this,ListPesanan.class);
        startActivity(c);
    }
    //mengambil method dari DatePickerFragment untuk menampilkan tanggal yang sudah dipilih
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    //mengam method dari TimePickerFragment untuk menampilkan yang sudah di pilih
    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    public void processDatePickerResult(int year, int month, int day) {

        a = (TextInputLayout) findViewById(R.id.nama);
        b = (TextInputLayout) findViewById(R.id.phone);

        //membuat string nama dana jumlah untuk mengambil nilai dari TextInputLayout
        String nama = a.getEditText().getText().toString();
        String telepon = b.getEditText().getText().toString();

        if (nama.isEmpty() || telepon.isEmpty()) {
            Toast.makeText(this, "Isi dulu bro", Toast.LENGTH_LONG).show();
        } else {

            //Memasukkan bulan pertama dan bulan selanjutnya
            String month_string = Integer.toString(month + 1);
            String day_string = Integer.toString(day);
            String year_string = Integer.toString(year);
            // Assign the concatenated strings to dateMessage.
            String dateMessage = (month_string + "/" + day_string + "/" + year_string);
            Toast.makeText(this, "Atas Nama : " + nama + "\n No Telepon : " + telepon + "\n Akan Mengambil pada : " + getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
        }
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        //membuat string nama dana jumlah untuk mengambil nilai dari TextInputLayout
        String nama = a.getEditText().getText().toString();
        String telepon = b.getEditText().getText().toString();

        if (nama.isEmpty() || telepon.isEmpty()) {
            Toast.makeText(this, "Isi dulu bro", Toast.LENGTH_LONG).show();
        } else {


            // melakukan convert kedalam waktu
            String hour_string = Integer.toString(hourOfDay);
            String minute_string = Integer.toString(minute);
            String timeMessage = (hour_string + ":" + minute_string);
            Toast.makeText(this, "Atas Nama : " + nama + "\n No Telepon : " + telepon + "\n Akan Mengambil pada : " + getString(R.string.time) + timeMessage, Toast.LENGTH_SHORT).show();
        }
    }

}
