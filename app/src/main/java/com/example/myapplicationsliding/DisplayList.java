package com.example.myapplicationsliding;



/**
 * Created by design6 on 8/14/2018.
 */

public class DisplayList {

    // Store the name of the movie
//    private String stationName;
    private  String sales_date;
    //    private  String categoryId;
    private String auto_number;
    private String amount;
    private String canceled_amount;
    // Store the release date of the movie
//	    private String mRelease;




    // Constructor that is used to create an instance of the Movie object
    public DisplayList(String sales_date, String amount, String canceled_amount) {

        this.sales_date = sales_date;
//        this.stationId = stationId;
//        this.categoryId = categoryId;
        this.amount=amount;
        this.canceled_amount=canceled_amount;

//	        this.mRelease = mRelease;
    }

    public String getSales_date() {
        return sales_date;
    }

    public void setSales_date(String sales_date) {
        this.sales_date = sales_date;
    }



    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCanceled_amount() {
        return canceled_amount;
    }

    public void setCanceled_amount(String canceled_amount) {
        this.canceled_amount = canceled_amount;
    }
}
