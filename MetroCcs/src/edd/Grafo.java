/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author guante
 */
public class Grafo {
    private Nodo[] vertice;
    private int maxStation;
    private int cantidadStation;
    public int t;
    
    public Grafo(int entrada){
        this.maxStation = entrada;
        this.t = 2;
        this.cantidadStation = 0;
        this.vertice = new Nodo[entrada];
        for (int i = 0; i < entrada; i++) {
            this.vertice[i] = new Nodo("");
        }
    }
    
    
}
