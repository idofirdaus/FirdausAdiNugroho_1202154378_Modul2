package com.example.idofirdaus.firdaus_1202154378_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPesanan extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataMenu;
    private ArrayList<String> dataHarga;
    private ArrayList<Integer> gambar;
    private TextView a,b;

    //Daftar Menu Makanan
    private String[] Judul = {"Nasi Goreng Spesial", "Sate Ayam Bumbu Kacang","Mie Bakso Spesial","Mie Goreng Spesial","Soto Ayam","Gurame Asam Manis"};
    //Daftar Harga
    private String[] test = {"Rp. 35.000", "Rp. 25.000","Rp. 18.000","Rp. 23.000","Rp. 19.000","Rp. 50.000"};
    //Daftar Gambar
    private int[] Gambar = {R.drawable.nasgor, R.drawable.sate,R.drawable.bakso,R.drawable.miegoreng,R.drawable.soto,
            R.drawable.gurame};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pesanan);


        //mendeklarasikan array list untuk menu, harga dan gambar
        dataMenu = new ArrayList<>();
        dataHarga = new ArrayList<>();
        gambar = new ArrayList<>();
        DaftarItem();

        rvView = (RecyclerView) findViewById(R.id.recyclerview);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataMenu,dataHarga,gambar);
        rvView.setAdapter(adapter);

    }

    //Mengambil data dari Varibale Gambar dan Judul, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void DaftarItem(){
        for (int w=0; w<Judul.length; w++){
            dataMenu.add(Judul[w]);
            dataHarga.add(test[w]);
            gambar.add(Gambar[w]);
        }
    }
}