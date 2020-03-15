package com.example.database;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.databases2.AppDatabase;
import com.example.database.databases2.DataDiri;


public class ReadActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private RecyclerView rc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_activity);

        //init database
        appDatabase = AppDatabase.initDB(this);

        rc = findViewById(R.id.rv_data);
        rc.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        read();
    }

    private void read() {
        // TODO 1: mengambil data dari database
        DataDiri[] list = appDatabase.dao().getData();
        // TODO 2: Tampilin Databse
        rc.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter mainAdapter = new MainAdapter(list, this);
        rc.setAdapter(mainAdapter);
    }


}
