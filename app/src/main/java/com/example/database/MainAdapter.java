package com.example.database;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import com.example.database.databases2.DataDiri;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
   Context context;


   private DataDiri[] list;

    public MainAdapter(DataDiri[] list, Context context) {
        this.context = context;
        this.list = list;

    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    final DataDiri item = list[position];

    holder.tvNama.setText(item.getNama());
    holder.tvJK.setText(item.getJkelamin());
    holder.tvAlamat.setText(item.getAlamat());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("nama", item.getNama());
            intent.putExtra("alamat", item.getAlamat());
            intent.putExtra("jenis kelamin", item.getJkelamin());
            intent.putExtra("id", item.getId());
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvJK, tvAlamat;
        View itemView;
        LinearLayout itemLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvJK = itemView.findViewById(R.id.tvJK);
            this.itemView = itemView;
        }
    }
}
