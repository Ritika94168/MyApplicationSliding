package com.example.myapplicationsliding.ui.home;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplicationsliding.DataModel;
import com.example.myapplicationsliding.DataSet;
import com.example.myapplicationsliding.MyListAdapter;
import com.example.myapplicationsliding.R;
import com.example.myapplicationsliding.Server.MultipartUtility;
import com.example.myapplicationsliding.Server.ServerConstants;
import com.example.myapplicationsliding.ui.gallery.GalleryFragment;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    //    private static ArrayList<DataModel> data;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<DataModel> data;
    private static String value,value1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        new HomeFragment.InsertLogoutinfo().execute(ServerConstants.TEST);
//        Toast.makeText(getActivity(),"vvvv"+value,Toast.LENGTH_LONG).show();
//        DataModel[] myListData = new DataModel[] {
//                new DataModel(value, "Todays Sale"),
//                new DataModel("8000", "Total IPD"),
//                new DataModel("8000", "Todays OPD"),
//        };

        recyclerView =root.findViewById(R.id.my_recycler_view);
//        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("","kjkjjkj");
//                Toast.makeText(getActivity(),"ritika",Toast.LENGTH_LONG).show();
//                Fragment someFragment = new GalleryFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.text_gallery, someFragment ); // give your fragment container id in first parameter
//                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//                transaction.commit();MyListAdapter
            }
        });

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

    class InsertLogoutinfo extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;
        //	        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            pDialog = new ProgressDialog(SupervisorLogin.this);
//            pDialog.setMessage("Please Wait...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(false);
//            pDialog.show();

        }

        @Override
        protected JSONObject doInBackground(String... args) {
            String responseSTR = "";
            JSONObject json = null;
            try {

                String charset = "UTF-8";
                MultipartUtility multipart = new MultipartUtility(args[0], charset);
                multipart.addFormField("action", "get_ipds");
                multipart.addFormField("admin_id", "");
                multipart.addFormField("close", "close");
                List<String> response = multipart.finish();
                for (String line : response) {
                    responseSTR = line;
                }
                Log.i("Server DATA", responseSTR);
                json = new JSONObject(responseSTR);
            } catch (Exception e) {

            }


            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json) {

            if(json!=null) {
                int login=0;
//	            	ArrayList<String> data=new ArrayList<String>();
//	            	adapter2.add("Select Hall");
//	                pDialog.cancel();
                try {
                    value = json.getString("category_desc");
                  value1 = json.getString("ff");
//                    if (!error) {
                    Toast.makeText(getActivity(),"hhh"+value,Toast.LENGTH_LONG).show();
////                        Intent intent = new Intent(getApplicationContext(),InsertNew.class);
////                        //	            intent.putExtras(dataBundle);
////                        startActivity(intent);
////                        // new category created successfully
////                        Log.e("Record added successfully ", "> " + json.getString("message"));
//                    } else {
////                        Log.e("Add Record Error: ",
////                                "> " + json.getString("message"));
//                    }
                    DataModel[] myListData = new DataModel[] {
                            new DataModel(value, "Todays Sale"),
                            new DataModel(value1, "Total IPD"),
                            new DataModel("8000", "Todays OPD"),
                    };

                    MyListAdapter adapter = new MyListAdapter(getActivity(),myListData);
                    recyclerView.setAdapter(adapter);

//                    recyclerView.se
//                    recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, final View view,
//                                                int position, long id) {
//                        }
//                    });

                } catch (Exception e) {
                }

            }
        }

    }

}
