/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author Alejandro Prieto
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
    
        public void insertGrafo(String name){
        if(maxStation != cantidadStation){
            for (int i = 0; i < maxStation; i++) {
                if(this.vertice[i].getName().equals("")){
                    this.vertice[i].setName(name);
                    break;
                }
            }
            this.cantidadStation ++;
        }else{
            Nodo[] aux = new Nodo[this.maxStation + 10];
            
            for (int i = 0; i < this.maxStation +10; i++) {
                aux[i] = new Nodo("");
            }
            
            
            for (int i = 0; i < this.maxStation; i++) {
                aux[i] = this.vertice[i];
            }
            
            aux[maxStation].setName(name);
            this.cantidadStation ++;
            this.maxStation += 10;
        }
    }
        
            public void insertArista(String name1, String name2){
        Nodo aux1 = null;
        Nodo aux2 = null;
        
        for (int i = 0; i < this.maxStation; i++) {
            if(this.vertice[i].getName().equals(name1)){
                aux1 = this.vertice[i];
            }else if(this.vertice[i].getName().equals(name2)){
                aux2 = this.vertice[i];
            }         
        }
        aux1.getAdyacente().insertBegin(name2);
        aux2.getAdyacente().insertBegin(name1);
    }
    
    public String mostrar(){
        String grafo = "";
        for (int i = 0; i < this.maxStation; i++) {
            grafo += this.vertice[i].getName() + this.vertice[i].getAdyacente().print() + "\n";
            
        }
        return grafo;
    }
    
    public Nodo searchGraf(String name){
        for (int i = 0; i < maxStation; i++) {
            if(this.vertice[i].getName().equals(name))
                return vertice[i];
            
        }return null;
    
    }
    
    public String[] arregloPosition(){
        String [] temp = new String[this.maxStation];
        for (int i = 0; i < this.maxStation; i++) {
            temp[i] = this.vertice[i].getName();
        }
        return temp;
        
    }
    
    public boolean existeArista(int i, int j){
        return this.vertice[i].getAdyacente().seacrh(this.vertice[j].getName()) != null;
    }
    
    
        //procedimiento recursivo
    public void recorrerProfundidad (int v, boolean [ ] visitados, int pos) {
    //se marca el vértice v como visitado
        visitados [v] = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        System.out.println (this.vertice[v].getName());
        if(pos == t){return;}
        //se examinan los vértices adyacentes a v para continuar el recorrido
        for (int i = 0; i < this.maxStation; i++) {
            System.out.println(this.existeArista (v, i));
            if ((v != i) && (!visitados [i]) && (this.existeArista (v, i)) )
                recorrerProfundidad (i, visitados, pos +1);
            }
        }


    //procedimiento no recursivo
    public void profundidad (String estacion) {
        Nodo est = this.searchGraf(estacion);
        int v = 0;
        boolean visitados [ ] = new boolean [this.maxStation];
        for (int i = 0; i < this.maxStation; i++){ //inicializar vector con campos false
            visitados [i] = false;
            if(this.vertice[i].getName().equals(estacion)){
                v = i;
            }
        }
        this.recorrerProfundidad ( v, visitados, 1);


        }
    
}
