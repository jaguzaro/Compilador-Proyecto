/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import compi_view.WindowView;
import java.io.StringReader;
import util.Data;

/**
 *
 * @author GAMING PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static Data mainController = new Data();
    public static void main(String[] args) {
        // TODO code application logic here
        //analizadores("src/source_compi/", "Lexer.jflex", "Parser.cup");

        mainController.viewWindow();
        
        //Analizar
        //analizar(entrada);
        

    }
    
    public static void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
    
    public static void analizar (String entrada){
        try {
            source_compi.Lexer lexer = new source_compi.Lexer(new StringReader(entrada)); 
            source_compi.Parser parser = new source_compi.Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        } 
    } 
    
}
