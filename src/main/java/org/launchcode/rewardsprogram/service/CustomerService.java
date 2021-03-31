package org.launchcode.rewardsprogram.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CustomerService {

    public Integer calculateEarnedRewardPointsPerMonth(String month, Integer customerTotalRewardPoints, HashMap<String, ArrayList<Double>> customerTransactions){

        Integer totalRewardPoints = customerTotalRewardPoints;

            for(Double d : customerTransactions.get(month)){
                int doubleToInt = (int)Math.floor(d);
                if(doubleToInt > 50 && doubleToInt <= 100){
                    totalRewardPoints += (doubleToInt - 50);
                }
                if(doubleToInt > 100){
                    totalRewardPoints += ((doubleToInt - 100) * 2) + 50;
                }
            }


        return totalRewardPoints;
    }

    public Integer calculateEarnedTotalRewardPoints(Integer customerTotalRewardPoints, HashMap<String, ArrayList<Double>> customerTransactions){
        Integer totalRewardPoints = customerTotalRewardPoints;

        for(String month : customerTransactions.keySet()){
                for (Double d : customerTransactions.get(month)) {
                    int doubleToInt = (int) Math.floor(d);
                    if (doubleToInt > 50 && doubleToInt <= 100) {
                        totalRewardPoints += (doubleToInt - 50);
                    }
                    if (doubleToInt > 100) {
                        totalRewardPoints += ((doubleToInt - 100) * 2) + 50;
                    }
                }
        }

        return totalRewardPoints;
    }
}
