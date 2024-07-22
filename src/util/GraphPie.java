/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author GAMING PC
 */
public class GraphPie {
    
    public ArrayList<String> label;
    public ArrayList<Double> values;
    public String title;

    public GraphPie(ArrayList<String> label, ArrayList<Double> values, String title) {
        this.label = label;
        this.values = values;
        this.title = title;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
