package com.example.myapplicationsliding;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import static android.app.PendingIntent.getActivity;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private DataModel[] listdata;
    Activity context;

    // RecyclerView recyclerView;
    public MyListAdapter(Activity context, DataModel[] listdata) {
        this.context = context;
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
//                Log.d("gfgfgfgf","kjkjjkj");
//                getActivity().onBackPressed();
//               Context context = view.getContext();
context.finish();
                    Intent intent = new Intent(context, DetailedActivity.class);
                    context.startActivity(intent);
//                                            Fragment someFragment = new GalleryFragment();
////                Fragment fragment = new projectInformationFragment();
//                FragmentTransaction transaction =
//                       getChildFragmentManager();
//                transaction.replace(R.id.text_gallery, someFragment ); // give your fragment container id in first parameter
//                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//                transaction.commit();



//                NextFragment nextFrag= new NextFragment();
//               context.getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.Layout_container, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();

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