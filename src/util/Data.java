/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import compi_view.WindowView;
import java.awt.Dimension;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author GAMING PC
 */
public class Data {
    public HashMap<String, Symbols> symbolsTable = new HashMap<>();
    private int idST = 0;
    public WindowView window = new WindowView();
    
    public void analizar (String entrada){
        System.out.println("entra");
        try {
            source_compi.Lexer lexer = new source_compi.Lexer(new StringReader(entrada)); 
            source_compi.Parser parser = new source_compi.Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        } 
    } 
    
    public void getList(){
        for (Map.Entry<String, Symbols> entry: symbolsTable.entrySet()){
            System.out.println("Clave: " + entry.getKey() + " Valor: " + entry.getValue().value);
        }
    }
    
    public void insertSymbolsTable(String name, String type, Object value, int row, int column){
        Symbols sym = new Symbols(idST += 1, name, type, value, row, column);
        symbolsTable.put(name, sym);
        
        System.out.println(symbolsTable.size());
        for (Map.Entry<String, Symbols> entry: symbolsTable.entrySet()){
            System.out.println("Clave: " + entry.getKey() + " Valor: " + entry.getValue().value);
        }
    }
    
    public void printList(ArrayList<Double> list){
        list.forEach((element)->{
            System.out.println(element);
        });
    }
    
    public void viewList(ArrayList<Object> list){
        StringBuilder output = new StringBuilder();
        for (int i=0; i < list.size(); i++){
            if(i == list.size() - 1){
                output.append(list.get(i).toString().replace("\"", ""));
            }else{
                output.append(list.get(i).toString().replace("\"", "")).append(",");
            }
        }
        window.setOutputText("!Salida: " + output + "\n");
        //System.out.println("!Salida: " + output);
    }

    public void viewColumn(String title, ArrayList<Object> list){
        window.setOutputText("----------------" + "\n");
        window.setOutputText(title.toString().replace("\"", "") + "\n");
        window.setOutputText("----------------" + "\n" );
        
        list.forEach((element)->{
            window.setOutputText(element.toString().replace("\"", "") + "\n");
        });
        
        /*System.out.println("----------------");
        System.out.println(title.toString().replace("\"", ""));
        System.out.println("----------------");
        
        list.forEach((element)->{
            System.out.println(element.toString().replace("\"", "") + "\n");
        });*/
        
    }
    
    public GraphBar saveDataGraphBar(int option, GraphBar lft, ArrayList<Object> rght){
        if(option == 1){
            ArrayList<Object> exps = (ArrayList<Object>)rght;
            GraphBar temp = (GraphBar) lft;
            if(exps.get(0) == "Title"){
                temp.title = exps.get(1).toString();
            }else if(exps.get(0) == "AxisX"){
                temp.axisX = (ArrayList<String>)exps.get(1);
            }else if(exps.get(0) == "AxisY"){
                temp.axisY = (ArrayList<Double>)exps.get(1);
            }else if(exps.get(0) == "TitleX"){
                temp.titleX = exps.get(1).toString();
            }else if(exps.get(0) == "TitleY"){
                temp.titleY = exps.get(1).toString();
            }
            return (GraphBar) temp;
        }else if (option == 2){
            ArrayList<Object> exps = (ArrayList<Object>) rght;
            ArrayList<Double> axisy = new ArrayList<>();
            ArrayList<String> axisx = new ArrayList<>();
            GraphBar gb = new GraphBar("", axisx, axisy, "", "");
            if(exps.get(0) == "Title"){
                gb.title = exps.get(1).toString();
            }else if(exps.get(0) == "AxisX"){
                axisx = (ArrayList<String>)exps.get(1);
                gb.axisX = axisx;
            }else if(exps.get(0) == "AxisY"){
                axisy = (ArrayList<Double>)exps.get(1);
                gb.axisY = axisy;
            }else if(exps.get(0) == "TitleX"){
                gb.titleX = exps.get(1).toString();
            }else if(exps.get(0) == "TitleY"){
                gb.titleY = exps.get(1).toString();
            }
            return gb;
        }
        return null;
    }
    
    public GraphPie saveDataGraphPie(int option, GraphPie lft, ArrayList<Object> rght){
        if(option == 1){
            ArrayList<Object> exps = (ArrayList<Object>)rght;
            GraphPie temp = (GraphPie) lft;
            if(exps.get(0) == "Title"){
                temp.title = exps.get(1).toString();
            }else if(exps.get(0) == "Label"){
                temp.label = (ArrayList<String>) exps.get(1);
            }else if(exps.get(0) == "Values"){
                temp.values = (ArrayList<Double>) exps.get(1);
            }
            return (GraphPie) temp;
        }else if (option == 2){
            ArrayList<Object> exps = (ArrayList<Object>) rght;
            ArrayList<Double> values = new ArrayList<>();
            ArrayList<String> label = new ArrayList<>();
            GraphPie gb = new GraphPie(label, values, "");
            if(exps.get(0) == "Title"){
                gb.title = exps.get(1).toString();
            }else if(exps.get(0) == "Label"){
                gb.label = (ArrayList<String>) exps.get(1);
            }else if(exps.get(0) == "Values"){
                gb.values = (ArrayList<Double>) exps.get(1);
            }
            return gb;
        }
        return null;
    }
    
    public GraphLine saveDataGraphLine(int option, GraphLine lft, ArrayList<Object> rght){
        if(option == 1){
            ArrayList<Object> exps = (ArrayList<Object>)rght;
            GraphLine temp = (GraphLine) lft;
            if(exps.get(0) == "Title"){
                temp.title = exps.get(1).toString();
            }else if(exps.get(0) == "AxisX"){
                temp.axisX = (ArrayList<String>)exps.get(1);
            }else if(exps.get(0) == "AxisY"){
                temp.axisY = (ArrayList<Double>)exps.get(1);
            }else if(exps.get(0) == "TitleX"){
                temp.titleX = exps.get(1).toString();
            }else if(exps.get(0) == "TitleY"){
                temp.titleY = exps.get(1).toString();
            }
            return (GraphLine) temp;
        }else if (option == 2){
            ArrayList<Object> exps = (ArrayList<Object>) rght;
            ArrayList<Double> axisy = new ArrayList<>();
            ArrayList<String> axisx = new ArrayList<>();
            GraphLine gb = new GraphLine("", axisx, axisy, "", "");
            if(exps.get(0) == "Title"){
                gb.title = exps.get(1).toString();
            }else if(exps.get(0) == "AxisX"){
                axisx = (ArrayList<String>)exps.get(1);
                gb.axisX = axisx;
            }else if(exps.get(0) == "AxisY"){
                axisy = (ArrayList<Double>)exps.get(1);
                gb.axisY = axisy;
            }else if(exps.get(0) == "TitleX"){
                gb.titleX = exps.get(1).toString();
            }else if(exps.get(0) == "TitleY"){
                gb.titleY = exps.get(1).toString();
            }
            return gb;
        }
        return null;
    }
    
    public GraphHistogram saveDataGraphHistogram(int option, GraphHistogram lft, ArrayList<Object> rght){
        if(option == 1){
            ArrayList<Object> exps = (ArrayList<Object>)rght;
            GraphHistogram temp = (GraphHistogram) lft;
            if(exps.get(0) == "Title"){
                temp.title = exps.get(1).toString();
            }else if(exps.get(0) == "Values"){
                temp.values = (ArrayList<Double>) exps.get(1);
            }
            return (GraphHistogram) temp;
        }else if (option == 2){
            ArrayList<Object> exps = (ArrayList<Object>) rght;
            ArrayList<Double> values = new ArrayList<>();
            GraphHistogram gb = new GraphHistogram("", values);
            if(exps.get(0) == "Title"){
                gb.title = exps.get(1).toString();
            }else if(exps.get(0) == "Values"){
                gb.values = (ArrayList<Double>) exps.get(1);
            }
            return gb;
        }
        return null;
    }
    
    public void generateGraphBar(GraphBar data){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0; i < data.axisX.size(); i++){
            dataset.addValue(data.axisY.get(i), "Value", data.axisX.get(i));
        }
        
        JFreeChart graph = ChartFactory.createBarChart(data.title, data.titleY, data.titleY, dataset, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel = new ChartPanel(graph);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(350,200));
        window.setGraph(panel);
        
    }
    
    public void generateGraphPie(GraphPie data){
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(int i=0; i< data.label.size(); i++){
            dataset.setValue(data.label.get(i), data.values.get(i));
        }
        JFreeChart graph = ChartFactory.createPieChart(data.title, dataset);
        ChartPanel panel = new ChartPanel(graph);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(375,200));
        window.setGraph(panel);
    }
    
    
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
        window.setGraph(panel);
        //window.setVisible(true);
        /*ChartFrame frame = new ChartFrame("Example", graph);
        frame.pack();
        frame.setVisible(true); */

    }
    
    public void generateHistogram(GraphHistogram data){
        HashMap<Double, Double> frecuency = new HashMap<>();
        Collections.sort(data.values);
        for(Double num: data.values){
            if(frecuency.containsKey(num)){
                frecuency.put(num, frecuency.get(num) + 1);
            }else{
                frecuency.put(num, 1.0);
            }
            
        }
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        double totalNumeros = data.values.size();
        double frecuenciaAcumulada = 0;
        window.setOutputText(data.title + "\n");
        window.setOutputText("---------------------------------------------------------------------------" + "\n");
        window.setOutputText("Valor\tFb\tFa\tFr" + "\n");
        window.setOutputText("---------------------------------------------------------------------------" + "\n");
        for (Map.Entry<Double, Double> entry : frecuency.entrySet()) {
            double numero = entry.getKey();
            double frecuenciaNumero = entry.getValue();
            frecuenciaAcumulada += frecuenciaNumero;
            double frecuenciaPorcentual = (double) frecuenciaNumero / totalNumeros * 100;
            window.setOutputText(numero + "\t" + Math.round(frecuenciaNumero*100)/100  + "\t" + Math.round(frecuenciaAcumulada*100)/100 + "\t" +  Math.round(frecuenciaPorcentual*100)/100 + "%" + "\n");
            dataset.addValue(frecuenciaNumero, "value", String.valueOf(numero));
        }
        window.setOutputText("---------------------------------------------------------------------------" + "\n");
        window.setOutputText("\nTotales:\t" + totalNumeros + "\t" + Math.round(frecuenciaAcumulada * 100) / 100 + "\t100%" + "\n");
        window.setOutputText("---------------------------------------------------------------------------" + "\n");
        
        JFreeChart graph = ChartFactory.createBarChart(data.title, "", "", dataset, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel = new ChartPanel(graph);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(350,200));
        window.setGraph(panel);
    }
    
    public void createHTML(String filename, String type, String header, String content){
        try{
            PrintWriter text = new PrintWriter(filename);
            String template;
            template = String.format("""
                                     <!DOCTYPE html>
                                     <html>
                                     <head>
                                         <title>Report</title>
                                         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                                         <style>
                                             body {
                                                 background-color: #f8f9fa;
                                                 font-family: Arial, sans-serif;
                                             }
                                             .container {
                                                 margin-top: 50px;
                                             }
                                             .table {
                                                 border-radius: 5px;
                                                 box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                                             }
                                             th {
                                                 background-color: #6c757d;
                                                 color: white;
                                             }
                                             .header {
                                                 display: flex;
                                                 justify-content: space-between;
                                                 align-items: center;
                                                 padding: 20px;
                                                 background-color: #6c757d;
                                                 color: white;
                                             }
                                     
                                             .logo {
                                                 height: 50px;
                                             }
                                     
                                             .info {
                                                 text-align: right;
                                             }
                                     
                                             .date, .name {
                                                 margin: 0;
                                             }
                                         </style>
                                     </head>
                                     <body>
                                         <div class="header">
                                             <img src="./fiusac_negro.png" alt="Logo" class="logo">
                                             <div class="info">
                                                 <p class="date">Fecha: <span id="date"></span></p>
                                                 <p class="time">Hora: <span id="time"></span></p>
                                             </div>
                                         </div>
                                         <div class="container">
                                             <h1>%s</h1>
                                             <table class="table table-striped">
                                                 <thead>
                                                     <tr>
                                                         %s
                                                     </tr>
                                                 </thead>
                                                 <tbody>
                                                     %s
                                                 </tbody>
                                             </table>
                                         </div>
                                         <script>
                                             function showDateTime() {
                                                 var now = new Date();
                                                 var date = now.toLocaleDateString();
                                                 var time = now.toLocaleTimeString();
                                                 document.getElementById('date').textContent = date;
                                                 document.getElementById('time').textContent = time;
                                             }
                                             showDateTime();   
                                         </script>
                                     </body>
                                     </html>
                                     """, type, header, content);
            text.print(template);
            text.close();
            
        } catch(IOException e){
            System.out.println("Ocurrio un error" + e.getMessage());
        }
    }
}
