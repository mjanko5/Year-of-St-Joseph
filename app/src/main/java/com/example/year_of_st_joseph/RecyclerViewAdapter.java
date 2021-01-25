package com.example.year_of_st_joseph;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    String data1[], data2[], data3[];
    int pics[];
    Context ct;

    public RecyclerViewAdapter(Context context, String devotions[], String desctiptions[], String content[], int pictures[]){
        ct = context;
        data1 = devotions;
        data2 = desctiptions;
        data3 = content;
        pics = pictures;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        holder.devotion.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.picture.setImageResource(pics[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ct, Activity2.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("pics", pics[position]);
                ct.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView devotion, description;
        ImageView picture;
        ConstraintLayout mainLayout;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            devotion = itemView.findViewById(R.id.devotion);
            description = itemView.findViewById(R.id.description);
            picture = itemView.findViewById(R.id.picture);
            mainLayout = itemView.findViewById(R.id.mainLayout); ///hmmm..

        }
    }
}
