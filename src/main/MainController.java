/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import compi_view.WindowView;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import util.GraphLine;

/**
 *
 * @author GAMING PC
 */
public class MainController {
    
    public WindowView window = new WindowView();
    
    public void viewWindow(){
        window.setVisible(true);
        
    }
    
    public void generateGraphLine(GraphLine data){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0; i < data.axisX.size(); i++){
            dataset.setValue(data.axisY.get(i), "Value", data.axisX.get(i));
        }
        
        JFreeChart graph = ChartFactory.createLineChart(data.title, data.titleX, data.titleY, dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(graph);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400,200));
        if(window == null){
            System.out.println("es nulo");
        }
        window.setGraph(panel);
        /*ChartFrame frame = new ChartFrame("Example", graph);
        frame.pack();
        frame.setVisible(true); */

    }
    
}
