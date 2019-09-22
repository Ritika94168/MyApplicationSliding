package com.example.myapplicationsliding;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by root on 4/8/17.
 */

public class CustomListAdapter extends BaseAdapter implements Filterable {
    Activity context;
    ArrayList<DisplayList> reportsData;
    ArrayList<DisplayList> reportsDataOriginal;

    public CustomListAdapter(Activity context, ArrayList<DisplayList> reportsData) {
        super();
        this.context = context;
        this.reportsData = reportsData;

    }


    public int getCount() {
        // TODO Auto-generated method stub
        return reportsData.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                reportsData = (ArrayList<DisplayList>) results.values; // has

                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults(); // Holds the
                // results of a
                // filtering
                // operation in
                // values
                // List<String> FilteredArrList = new ArrayList<String>();
                List<DisplayList> FilteredArrList = new ArrayList<DisplayList>();

                if (reportsDataOriginal == null) {
                    reportsDataOriginal = new ArrayList<DisplayList>(reportsData); // saves

                }

                /********
                 *
                 * If constraint(CharSequence that is received) is null returns
                 * the mOriginalValues(Original) values else does the Filtering
                 * and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = reportsDataOriginal.size();
                    results.values = reportsDataOriginal;
                } else {

                    Locale locale = Locale.getDefault();
                    constraint = constraint.toString().toLowerCase(locale);
                    for (int i = 0; i < reportsDataOriginal.size(); i++) {
                        DisplayList model = reportsDataOriginal.get(i);

                        String data = model.getAmount();
                        if (data.toLowerCase(locale).contains(constraint.toString())) {
                            FilteredArrList.add(model);
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;

                }
                return results;
            }
        };
        return filter;
    }


    private class ViewHolder {

        TextView sales_date;
        TextView canceled_amount;
        //        TextView station_id;
        TextView amount;
        TextView auto_number;

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_for_sales_layout, null);
            holder = new ViewHolder();
            holder.sales_date = (TextView) convertView.findViewById(R.id.sales_date);
            holder.amount = (TextView) convertView.findViewById(R.id.amount);
            holder.canceled_amount = (TextView) convertView.findViewById(R.id.cancelled_amount);

//            holder.auto_number = (TextView) convertView.findViewById(R.id.auto_number);
//            holder.product_type = (TextView) convertView.findViewById(R.id.product_type);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        DisplayList medicineListModel=reportsData.get(position);
        holder.sales_date.setText(medicineListModel.getSales_date());
        holder.amount.setText(medicineListModel.getAmount());
        holder.canceled_amount.setText(medicineListModel.getCanceled_amount());

//        holder.auto_number.setText(medicineListModel.getAuto_number());
//        holder.product_type.setText(medicineListModel.getProduct_type());
//        holder.product_type.setText(medicineListModel.getProduct_type());
        return convertView;
    }
}
