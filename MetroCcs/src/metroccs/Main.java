/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metroccs;
import intefaz.*;
import edd.*;

/**
 *
 * @author guante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo g = new Grafo(10);
        Menu test = new Menu(g);

        ColaGrafo e = new ColaGrafo();
        e.encolar("name1");
        e.encolar("name2");
        e.encolar("jaja");
        e.printCola();
        e.desencolar();
        e.printCola();
         
       

    }
    
}
