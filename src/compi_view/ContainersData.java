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
public class ContainersData {
    public int container;
    public String text;
    public boolean newFile;
    public String namefile;
    public File file;
    public HashMap<Integer, ChartPanel> graphs;
    public boolean analyzed;
    public ArrayList<Token> tokensTable;
    public ArrayList<LexError> errorsTable;
    public HashMap<String, Symbols> symbolsTable;

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isNewFile() {
        return newFile;
    }

    public void setNewFile(boolean newFile) {
        this.newFile = newFile;
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public HashMap<Integer, ChartPanel> getGraphs() {
        return graphs;
    }

    public void setGraphs(HashMap<Integer, ChartPanel> graphs) {
        this.graphs = graphs;
    }

    public boolean isAnalyzed() {
        return analyzed;
    }

    public void setAnalyzed(boolean analyzed) {
        this.analyzed = analyzed;
    }

    public ArrayList<Token> getTokensTable() {
        return tokensTable;
    }

    public void setTokensTable(ArrayList<Token> tokensTable) {
        this.tokensTable = tokensTable;
    }

    public ArrayList<LexError> getErrorsTable() {
        return errorsTable;
    }

    public void setErrorsTable(ArrayList<LexError> errorsTable) {
        this.errorsTable = errorsTable;
    }

    public HashMap<String, Symbols> getSymbolsTable() {
        return symbolsTable;
    }

    public void setSymbolsTable(HashMap<String, Symbols> symbolsTable) {
        this.symbolsTable = symbolsTable;
    }

    public ContainersData(int container, String text, boolean newFile, String namefile, File file, HashMap<Integer, ChartPanel> graphs, boolean analyzed, ArrayList<Token> tokensTable, ArrayList<LexError> errorsTable, HashMap<String, Symbols> symbolsTable) {
        this.container = container;
        this.text = text;
        this.newFile = newFile;
        this.namefile = namefile;
        this.file = file;
        this.graphs = graphs;
        this.analyzed = analyzed;
        this.tokensTable = tokensTable;
        this.errorsTable = errorsTable;
        this.symbolsTable = symbolsTable;
    }




}
