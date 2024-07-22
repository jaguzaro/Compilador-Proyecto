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
public class GraphLine {
    public String title;
    public ArrayList<String> axisX;
    public ArrayList<Double> axisY;
    public String titleX;
    public String titleY;

    public GraphLine(String title, ArrayList<String> axisX, ArrayList<Double> axisY, String titleX, String titleY) {
        this.title = title;
        this.axisX = axisX;
        this.axisY = axisY;
        this.titleX = titleX;
        this.titleY = titleY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAxisX() {
        return axisX;
    }

    public void setAxisX(ArrayList<String> axisX) {
        this.axisX = axisX;
    }

    public ArrayList<Double> getAxisY() {
        return axisY;
    }

    public void setAxisY(ArrayList<Double> axisY) {
        this.axisY = axisY;
    }

    public String getTitleX() {
        return titleX;
    }

    public void setTitleX(String titleX) {
        this.titleX = titleX;
    }

    public String getTitleY() {
        return titleY;
    }

    public void setTitleY(String titleY) {
        this.titleY = titleY;
    }
    
    
}
