/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GAMING PC
 */
public class StatisticalOperations {
    
    public double calculateAverage(ArrayList<Double> dArray){
        double total = 0;
        for(double number : dArray){
            total += number;
        }
        return total / dArray.size();
    }
    
    public double calculateMedian(ArrayList<Double> dArray){
        ArrayList<Double> list = new ArrayList<>(dArray);
        Collections.sort(list);
        double median=0;
        int n = list.size();
            
        if (n%2 == 0){
           double median1 = list.get( n/2 - 1);
           double median2 = list.get(n/2);
           
           median = (median1 + median2) / 2;
        }else{
            median = list.get(n/2);
        }
        return median;
    }
    
    public double calculateModa(ArrayList<Double> dArray){
        HashMap<Double,Integer> frequency = new HashMap<>();
        for (Double number: dArray){
            frequency.put(number, frequency.getOrDefault(number, 0)+1);
        }
        
        double moda = 0;
        int maxFrequency = 0;
        for (Map.Entry<Double, Integer> entry: frequency.entrySet()){
            if (entry.getValue() > maxFrequency){
                moda = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return moda;
    }
    
    public double calculateVariance(ArrayList<Double> dArray){
        double avg = calculateAverage(dArray);
        double sumSquares = 0;
        for (double data: dArray){
            double diff = data - avg;
            sumSquares += Math.pow(diff, 2);
        }
        
        double variance  = sumSquares / dArray.size();
        return variance;
    }
    
    public double getMax(ArrayList<Double> dArray){
        double max = dArray.get(0);
        for (int i = 1; i < dArray.size(); i++){
            double element = dArray.get(i);
            if(element > max){
                max = element;
            }
        }
        return max;
    }
    
    public double getMin(ArrayList<Double> dArray){
        double min = dArray.get(0);
        for (int i = 1; i < dArray.size(); i++){
            double element = dArray.get(i);
            if(element < min){
                min = element;
            }
        }
        return min;
    }
    
    
}
