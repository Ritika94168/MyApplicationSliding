package com.example.myapplicationsliding;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationsliding.Server.MultipartUtility;
import com.example.myapplicationsliding.Server.ServerConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("SALE");
        new DetailedActivity.loadBmrList().execute(ServerConstants.TEST);
    }
    private class loadBmrList extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DetailedActivity.this);
            pDialog.setMessage("Please Wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
//            pDialog.show();

        }
        @Override
        protected JSONObject doInBackground(String... args) {
            String responseSTR = "";
            JSONObject json = null;
            try {
                String charset = "UTF-8";
                MultipartUtility multipart = new MultipartUtility(args[0], charset);
                multipart.addFormField("action", "get_sales_data");


                List<String> response = multipart.finish();
                for (String line : response) {
                    responseSTR = line;
                }
                Log.i("Server DATA", responseSTR);
                json = new JSONObject(responseSTR);
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//	                        pDialog.cancel();
                        Toast.makeText(getApplicationContext(),"Connection Error",Toast.LENGTH_LONG).show();

                    }
                });
            }
            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            if(json!=null) {
//                pDialog.cancel();
                try {
                    int autonumber=0;
//                    Toast.makeText(getApplicationContext(),"hlo",Toast.LENGTH_LONG).show();
                    JSONArray array=json.getJSONArray("data");

                    ArrayList<DisplayList> bmrList = new ArrayList<DisplayList>();
                    for (int i = 0; i < array.length(); i++) {

                        //array.getJSONObject(i);
                        JSONObject jsonObject=array.getJSONObject(i);
//	                		Log.i("NAME", array.getString(i).toString());
                        //data.add( array.getString(i).toString());
//	                		adapter2.clear();
                        String bmr_number=jsonObject.getString("bmr_number");
                        String lot_number=jsonObject.getString("lotno");
                        String creation_date =jsonObject.getString("added_on");
                        String bmr_id =jsonObject.getString("id");
                        String product_type =jsonObject.getString("product_type");
                        autonumber=autonumber+1;
//                        Toast.makeText(getApplicationContext(),lot_number+"craetion_date"+creation_date,Toast.LENGTH_LONG).show();
//                         autonumber++;
//                        BMRidArray.add(jsonObject.getString("id"));
//                        LotNoArray.add(lot_number);
                        bmrList.add(new DisplayList(lot_number,creation_date,autonumber,bmr_id));
                    }

                    CustomListAdapter   adapter=new CustomListAdapter(DetailedActivity.this, bmrList);
//	                    list.setAdapter( adapter );
                    ListView bmr_list = (ListView) findViewById(R.id.sale);


//                    LayoutInflater inflater = getLayoutInflater();
//                    ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header_view, bmr_list,
//                            false);
//
//                    TextView qty=(TextView) header.findViewById(R.id.textview_label);
//                    qty.setText("Date");
//                    bmr_list.addHeaderView(header, bmr_list, false);
//                    bmr_list.addFooterView(footer, bmr_list, false);
                    bmr_list.setAdapter(adapter);
//                    View headerView = getLayoutInflater().inflate(R.layout.header_view, bmr_list,false);
//                    bmr_list.addHeaderView(headerView);


//	                	Log.d("this is my array", "arr: " +Arrays.toString(unapprovedList));
//	               	 boolean error = json.getBoolean("error");
//                    adapter=new ListViewAdapter(BmrNumber.this, bmrList);
////	                    list.setAdapter( adapter );
//                    ListView bmr_list = (ListView) findViewById(R.id.bmr_list);
//                    bmr_list.setAdapter(adapter);
//
//
//                    bmr_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, final View view,
//                                                int position, long id) {
////                            final String item = (String) parent.getItemAtPosition(position);
////                            final String item = (String) parent.getItemAtPosition(position);
//                            //  parent.getItemAtPosition(position);
////                            BMRIdSTR=BMRidArray.get(position-1);
////                            LOTNOSTR=LotNoArray.get(position-1);
////                            Toast.makeText(getApplicationContext(),"kkkkk", Toast.LENGTH_LONG)
////				.show();
//
////                            SharedPreferences pref = getApplicationContext().getSharedPreferences(LoginConstant.LOGINPREFS, 0);
////                            SharedPreferences.Editor editor = pref.edit();
////                            editor.clear();
////                            editor.putString(LoginConstant.SELECTEDCATEGORY,BMRIdSTR);
////
////                            editor.commit();
////                            Toast.makeText(getApplicationContext(),BMRIdSTR, Toast.LENGTH_LONG)
////				.show();
//
////				Intent intent=new Intent(getApplicationContext(),UpdateDetails.class);
//
////
//
////				new CheckApprovedStation().execute(ServerConstants.TEST);
////                            new MultipleRowsData().execute(ServerConstants.TEST);
//                            new CheckValueAvailable().execute(ServerConstants.TEST);
////                            Intent appInfo = new Intent(BmrNumber.this,DisplayFieldsList.class);
////                            appInfo.putExtra("bmr_id", BMRIdSTR);
////                            startActivity(appInfo);
////				Toast.makeText(getApplicationContext(),idSTR, Toast.LENGTH_LONG)
////				.show();
//                        }
//
//                    });
//	                	 if (!error) {
//	                         // new category created successfully
//	                         Log.e("Record added successfully ",
//	                                 "> " + json.getString("message"));
//	                     } else {
//	                         Log.e("Add Record Error: ",
//	                                 "> " + json.getString("message"));
//	                     }

                } catch (Exception e) {
                }

            }
        }
    }
}
