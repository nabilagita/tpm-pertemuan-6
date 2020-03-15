package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.databases2.AppDatabase;
import com.example.database.databases2.DataDiri;

public class UpdateActivity extends AppCompatActivity {

    private String nama, alamat, kelamin;
    private int id;

    private EditText etNama, etAlamat, etJkelamin;
    private Button btnUpdate, btnDelete;
    private AppDatabase appDatabase;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateactivity);

        appDatabase = AppDatabase.initDB(this);

        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        alamat = intent.getStringExtra("alamat");
        kelamin = "" + intent.getCharExtra("jeniskelamin", ' ');
        id = intent.getIntExtra("id", 0);

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etJkelamin = findViewById(R.id.etKelamin);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        etNama.setText(nama);
        etAlamat.setText(alamat);
        etJkelamin.setText(kelamin);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    void update() {
        nama = etNama.getText().toString();
        alamat = etAlamat.getText().toString();
        char kelamin = etJkelamin.getText().toString().charAt(0);

        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJkelamin(kelamin);
        item.setId(id);

        appDatabase.dao().insertData(item);
        Toast.makeText(getApplicationContext(), "Data berhasil diubah", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void delete(){
        nama = etNama.getText().toString();
        alamat = etAlamat.getText().toString();
        char kelamin = etJkelamin.getText().toString().charAt(0);

        DataDiri item = new DataDiri();
        item.setNama(nama);
        item.setAlamat(alamat);
        item.setJkelamin(kelamin);
        item.setId(id);

        appDatabase.dao().deleteData(item);
        Toast.makeText(getApplicationContext(), "Data sukses dihapus", Toast.LENGTH_SHORT).show();

        finish();
    }
}