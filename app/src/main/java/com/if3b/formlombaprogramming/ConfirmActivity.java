package com.if3b.formlombaprogramming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {

    DatePickerDialog datePickerDialog;

    TextView tvNama, tvJK, tvNoWhatsapp, tvAlamat, tvTanggal;
    Button btnTanggal, btnKonfirmasi;

    String nama, jk, noWhatsapp, alamat, choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJK = findViewById(R.id.tv_jk);
        tvNoWhatsapp = findViewById(R.id.tv_no_whatsapp);
        tvAlamat = findViewById(R.id.tv_Alamat);
        tvTanggal = findViewById(R.id.tv_tgl);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);

        //mengambil intent
        Intent dapatkan = getIntent();

        nama = dapatkan.getStringExtra("varNama");
        jk = dapatkan.getStringExtra("varJenisKelamin");
        noWhatsapp = dapatkan.getStringExtra("varNoWhatsapp");
        alamat = dapatkan.getStringExtra("varAlamat");

        //set variabel ke dalam set view yang sudah kita buat sebelumnya
        tvNama.setText(nama);
        tvJK.setText(jk);
        tvNoWhatsapp.setText(noWhatsapp);
        tvAlamat.setText(alamat);

        btnTanggal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int tahun, int bulan, int tanggal) {
                        String year = Integer.toString(tahun);
                        String month = Integer.toString(bulan + 1);
                        String day = Integer.toString(tanggal);

                        choosenDate = day + "/" + month + "/" + year;
                        tvTanggal.setText(choosenDate);

                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),  newCalendar.get(Calendar.DAY_OF_MONTH));
                //tampilkan date picker dialog
                datePickerDialog.show();
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data anda sudah benar ?");

                //Button positif
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ConfirmActivity.this, "Terima kasih, Pendaftaran Anda berhasil.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //Button negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                //tampilkan dialog
                dialog.show();
            }
        });
    }
}