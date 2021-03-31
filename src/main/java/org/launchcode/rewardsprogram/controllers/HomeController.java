package org.launchcode.rewardsprogram.controllers;

import org.launchcode.rewardsprogram.models.Customer;
import org.launchcode.rewardsprogram.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("home-page")
    public String displayHomePage(Model model) {
        //I am strictly creating transactions here since I cannot use live data
        HashMap<String, ArrayList<Double>> customerTransactions = new HashMap<>();
        ArrayList<Double> transactionListJanuary = new ArrayList<>();
        transactionListJanuary.add(120.00);
        customerTransactions.put("January", transactionListJanuary);

        ArrayList<Double> transactionListFebruary = new ArrayList<>();
        transactionListFebruary.add(100.00);
        transactionListFebruary.add(100.00);
        customerTransactions.put("February", transactionListFebruary);

        ArrayList<Double> transactionListMarch = new ArrayList<>();
        transactionListMarch.add(300.00);
        customerTransactions.put("March", transactionListMarch);
        //
        //Creating customer with given values
        Customer customer = new Customer(1, "Nur", 0, customerTransactions);
        model.addAttribute("customerName", customer.getCustomerName());
        //

        //Calculating earned reward points with using the algorithm I created in customer service class
        Integer earnedRewardPointsInJanuary = customerService.calculateEarnedRewardPointsPerMonth("January", customer.getTotalRewardsPoint(), customer.getCustomerTransactions());
        model.addAttribute("earnedRewardPointsInJanuary", earnedRewardPointsInJanuary);

        Integer earnedRewardPointsInFebruary = customerService.calculateEarnedRewardPointsPerMonth("February", customer.getTotalRewardsPoint(), customer.getCustomerTransactions());
        model.addAttribute("earnedRewardPointsInFebruary", earnedRewardPointsInFebruary);

        Integer earnedRewardPointsInMarch = customerService.calculateEarnedRewardPointsPerMonth("March", customer.getTotalRewardsPoint(), customer.getCustomerTransactions());
        model.addAttribute("earnedRewardPointsInMarch", earnedRewardPointsInMarch);

        Integer earnedTotalRewardPoints = customerService.calculateEarnedTotalRewardPoints(customer.getTotalRewardsPoint(), customer.getCustomerTransactions());
        model.addAttribute("earnedTotalRewardPoints",earnedTotalRewardPoints);
        //

        return "home-page";
    }


}
