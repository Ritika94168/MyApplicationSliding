package com.example.myapplicationsliding;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationsliding.ui.gallery.GalleryFragment;

import static android.app.PendingIntent.getActivity;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private DataModel[] listdata;

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

//                getActivity().onBackPressed();
//               Context context = view.getContext();
////                context.finish();
////               context.onb
//                    Intent intent = new Intent(context, DetailedActivity.class);
//                    context.startActivity(intent);
//                Fragment someFragment = new GalleryFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, someFragment ); // give your fragment container id in first parameter
//                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//                transaction.commit();

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