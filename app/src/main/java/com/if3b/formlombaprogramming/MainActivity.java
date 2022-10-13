package com.if3b.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etNoWhatsapp, etAlamat, etPassword, etPin;
    private RadioGroup rgJenisKelamin;
    private RadioButton rbJenisKelamin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etNoWhatsapp = findViewById(R.id.et_no_whatsapp);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJenisKelamin = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String noWhatsapp = etNoWhatsapp.getText().toString();
                String alamat = etAlamat.getText().toString();
                String password = etPassword.getText().toString();
                String pin = etPin.getText().toString();

                int JenisKelaminID = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin = findViewById(JenisKelaminID);

                String jeniskelamin = rbJenisKelamin.getText().toString();

                if(nama.trim().equals("") || noWhatsapp.trim().equals("") || alamat.trim().equals("") || password.trim().equals("") || pin.trim().equals("") || pin.trim().length() < 6){
                    if(nama.trim().equals("")){
                        etNama.setError("Nama tidak boleh kosong");
                    }
                    if(noWhatsapp.trim().equals("")){
                        etNoWhatsapp.setError("No Whatsapp tidak boleh kosong");
                    }
                    if(alamat.trim().equals("")){
                        etAlamat.setError("Alamat tidak boleh kosong");
                    }
                    if(password.trim().equals("")){
                        etPassword.setError("Password tidak boleh kosong");
                    }
                    if(pin.trim().equals("")){
                        etPin.setError("PIN tidak boleh kosong");
                    }
                    else if(pin.trim().length() < 6){
                        etPin.setError("PIN harus berisi 6 angka");
                    }
                }
                else{
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varNoWhatsapp", noWhatsapp);
                    intent.putExtra("varAlamat", alamat);
                    intent.putExtra("varJenisKelamin", jeniskelamin);

                    startActivity(intent);
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etNoWhatsapp.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");
    }
}