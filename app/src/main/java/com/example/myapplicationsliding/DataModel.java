package com.example.myapplicationsliding;

public class DataModel{
    private String descriptiontop;
    private String desc;
    public DataModel(String description, String desc) {
        this.descriptiontop = description;
        this.desc = desc;
    }

    public String getDescriptiontop() {
        return descriptiontop;
    }

    public void setDescriptiontop(String descriptiontop) {
        this.descriptiontop = descriptiontop;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}