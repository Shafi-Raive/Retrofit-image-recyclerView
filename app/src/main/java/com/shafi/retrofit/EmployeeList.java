package com.shafi.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EmployeeList {
    @SerializedName("Model")
    private ArrayList<Model> employeeList;

    public ArrayList<Model> getEmployeeArrayList() {
        return employeeList;
    }

    public void setEmployeeArrayList(ArrayList<Model> employeeArrayList) {
        this.employeeList = employeeArrayList;
    }
}
