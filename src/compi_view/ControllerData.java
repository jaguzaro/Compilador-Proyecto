/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi_view;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.jfree.chart.ChartPanel;
import source_compi.ASymbol;
import source_compi.LexError;
import source_compi.Token;
import util.Symbols;

/**
 *
 * @author GAMING PC
 */
public class ControllerData {
    
    public ArrayList<ContainersData> listContainers = new ArrayList<>();
    
    public void insertDataContainers(int container, String text, boolean newFile, String namefile, File file){
        ContainersData dataContainer = new ContainersData(container, text, newFile, namefile, file, new HashMap<Integer, ChartPanel>(), false, null, null, null);
        listContainers.add(dataContainer);
    }
    
    public void getDataContainers(){
        listContainers.forEach((element) ->{
            System.out.println(element.container + " " + element.text);
        });
    }
    
    public void updateContainers(int container, String text){
        listContainers.forEach((element) -> {
            if(element.container == container){
                element.text = text;
            }
        });
        
    }
    
    public void updateContainers(int container, String text, String namefile, boolean newFile, File file){
        listContainers.forEach((element) -> {
            if(element.container == container){
                element.text = text;
                element.namefile = namefile;
                element.newFile = newFile;
                element.file = file;
            }
        });
        /* ContainersData dataContainer = listContainers.get(container);
        dataContainer.text = text;
        dataContainer.namefile = namefile;
        dataContainer.newFile = newFile;
        dataContainer.file = file; */
        
    }
    
    public void updateContainers(int container, boolean newFile, File file){
        listContainers.forEach((element) -> {
            if(element.container == container){
                element.newFile = newFile;
                element.file = file;
                element.namefile = file.getName();
            }
        });
    }
    
    public void setReportsContainers(int container, ArrayList<Token> tokensTable, ArrayList<LexError> lexErrorsTable, HashMap<String, Symbols> symbolsTable){
        listContainers.forEach((element)->{
            if(element.container == container){
                element.tokensTable = tokensTable;
                element.errorsTable = lexErrorsTable;
                element.symbolsTable = symbolsTable;
            }
        });
    }
    
    public ContainersData findContainer(int container){
        ArrayList<ContainersData> resultados = new ArrayList<>();
        listContainers.forEach((element)-> {
            if(element.container == container){
                resultados.add(element);
            }
        });
        return resultados.isEmpty() ? null : resultados.get(0);
    }
    
    public void deleteContainer(int container){
        for(int i = 0; i <= listContainers.size(); i++){
            if(listContainers.get(i).container == container){
                listContainers.remove(i);
                return;
            }
        }   
    }
    
    public void setGraphsContainer(ChartPanel panel, int container){
        listContainers.forEach((element)->{
            if(element.container == container){
                element.graphs.put(element.graphs.size()+1,panel);
            }
        });
    }
    
    public void setAnalyzedContainer(int container){
        listContainers.forEach((element)->{
            if(element.container == container){
                element.analyzed = true;
            }
            
        });
    }
    
    public ChartPanel findGraph(ChartPanel panel, int container, int option){
        for (ContainersData element : listContainers) {
            if (element.container == container) {
                for (Integer key : element.graphs.keySet()) {
                    if(option == 3){
                        return element.graphs.get(key);
                    }
                    if (element.graphs.get(key) == panel) {
                        if(option == 2){
                            return element.graphs.get(key + 1);
                        }else if(option == 1){
                            if(key > 1){
                                return element.graphs.get(key - 1);
                            }
                        }
                    }
                    
                }
            }
        }
        return null;
    }
    
}
