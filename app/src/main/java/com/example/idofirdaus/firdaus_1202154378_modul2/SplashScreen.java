package com.example.idofirdaus.firdaus_1202154378_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    //mensetting lama nya splash akan muncul
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mensetiingan agar splashscreen dapat muncul dengan fullscreen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
     setContentView(R.layout.activity_splash_screen);

        //menampilkan pesan berisikan Nama_NIM
        Toast.makeText(SplashScreen.this,"Firdausa Adi Nugroho_1202154378",Toast.LENGTH_LONG).show();


        //memungkinkan anda untuk mengirim atau memproses objek message disini kasusnya adalah menampilkan toast setelah muncul
        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {
                                          // TODO Auto-generated method stub

                                          //melakukan intent ke menu selanjutnya setelah splash screen sudah muncul
                                          Intent i = new Intent(SplashScreen.this, MainActivity.class);
                                          startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent


                                          //jeda selesai Splashscreen
                                          this.finish();
                                      }

                                      private void finish() {
                                          // TODO Auto-generated method stub

                                      }
                                  }, //menjalankan timer yang splash screen yang sudah di setting di atas
                splashInterval);

    };
}