package com.example.myapplicationsliding.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplicationsliding.DataModel;
import com.example.myapplicationsliding.DataSet;
import com.example.myapplicationsliding.MyListAdapter;
import com.example.myapplicationsliding.R;


import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
//    private static ArrayList<DataModel> data;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<DataModel> data;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        DataModel[] myListData = new DataModel[] {
                new DataModel("8000", "Todays Sale"),

        };

        RecyclerView recyclerView =root.findViewById(R.id.my_recycler_view);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        recyclerView =root.findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//
////        layoutManager = new LinearLayoutManager();
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
//        data = new ArrayList<DataModel>();
//        for (int i = 0; i < DataSet.title_Array.length; i++) {
//            data.add(new DataModel(
//                    DataSet.title_Array[i],
//                    DataSet.desc_Array[i]
//            ));
//        }
//
//        adapter = new CustomAdapter(data);
//        recyclerView.setAdapter(adapter);

        return root;
    }
}
