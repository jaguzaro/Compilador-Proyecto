/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source_compi;

/**
 *
 * @author GAMING PC
 */
public class ASymbol {
    public int counter;
    public String name;
    public String type;
    public String value;
    public int row;
    public int column;

    public ASymbol(int counter, String name, String type, String value, int row, int column) {
        this.counter = counter;
        this.name = name;
        this.type = type;
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
