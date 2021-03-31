package org.launchcode.rewardsprogram.models;


import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    private int customerId;

    private String customerName;

    private int totalRewardsPoint;

    //I thought using HashMap would be helpful for this specific problem. Storing transactions by month and reaching when/which needed
    private HashMap<String,ArrayList<Double>> customerTransactions;

    public Customer() {
    }

    public Customer(int customerId, String customerName, int totalRewardsPoint, HashMap<String,ArrayList<Double>> customerTransactions){
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalRewardsPoint = totalRewardsPoint;
        this.customerTransactions = customerTransactions;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTotalRewardsPoint() {
        return totalRewardsPoint;
    }

    public void setTotalRewardsPoint(int totalRewardsPoint) {
        this.totalRewardsPoint = totalRewardsPoint;
    }

    public HashMap<String, ArrayList<Double>> getCustomerTransactions() {
        return customerTransactions;
    }

    public void setCustomerTransactions(HashMap<String, ArrayList<Double>> customerTransactions) {
        this.customerTransactions = customerTransactions;
    }
}
