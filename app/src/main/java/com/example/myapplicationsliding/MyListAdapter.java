package com.example.myapplicationsliding;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import static android.app.PendingIntent.getActivity;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private DataModel[] listdata;
    Activity context;
    // RecyclerView recyclerView;
    public MyListAdapter(DataModel[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.customlist, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataModel myListData = listdata[position];
        holder.textView.setText(myListData.getDescriptiontop());
        holder.textView1.setText(myListData.getDesc());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescriptiontop(),Toast.LENGTH_LONG).show();
//                Intent i = new Intent(context, DetailedActivity.class);
//                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public ImageView imageView;
        public TextView textView;
        public TextView textView1;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.textViewTitle);
            this.textView1 = (TextView) itemView.findViewById(R.id.textViewShortDesc);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}