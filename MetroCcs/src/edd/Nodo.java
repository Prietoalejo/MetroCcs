/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Alejandro Prieto
 */


public class Nodo {
    private Lista adyacente;
    private Nodo pnext;
    private String name;
    /* Guarda si la estacion es sucursal o no*/
    private Boolean sucursal;
    /*Guarda si la estacion esta cubierta por una sucursal cercana o no*/
    public Boolean cubierta;
    
    public Nodo(){}

    public Nodo(String nombre){
        this.name = nombre;
        this.adyacente = new Lista();
        this.pnext = null;
        this.sucursal = this.cubierta = false;
    }
    
    public Lista getAdyacente() {
        return adyacente;
    }

    public void setAdyacente(Lista adyacente) {
        this.adyacente = adyacente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSucursal() {
        return sucursal;
    }

    public void setSucursal(Boolean sucursal) {
        this.sucursal = sucursal;
    }


    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }
    
    
    
    
}
