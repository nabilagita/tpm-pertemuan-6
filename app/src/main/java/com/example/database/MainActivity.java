package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.databases2.AppDatabase;
import com.example.database.databases2.DataDiri;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etAlamat, etKelamin;
    private Button btnInsert, btnRead;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appDatabase = AppDatabase.initDB(getApplicationContext()); //nyambungin database ke apk


        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etKelamin = findViewById(R.id.etKelamin);
        btnInsert = findViewById(R.id.btnInsert);
        btnRead = findViewById(R.id.btnRead);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                startActivity(intent);
            }
        });

    }

    private void insertData(){
        try {

            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            char kelamin = etKelamin.getText().toString().charAt(0);

            DataDiri item = new DataDiri();
            item.setNama(nama);
            item.setAlamat(alamat);
            item.setJkelamin(kelamin);

            //kirim ke database
            appDatabase.dao().insertData(item);

            Toast.makeText(getApplicationContext(), "Data berhasil dimasukkan", Toast.LENGTH_SHORT).show();


        }
        catch (NumberFormatException nfe){
            Toast.makeText(getApplicationContext(), "Field tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }

        etNama.setText("");
        etAlamat.setText("");
        etKelamin.setText("");
    }

}
