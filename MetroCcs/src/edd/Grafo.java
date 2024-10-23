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
    /*Guarda todos los vertices (estaciones) del grafo*/
    private Nodo[] vertice;
    /*Es el numero de vertices*/
    private int maxStation;
    private int cantidadStation;
    /*Numero de estaciones que alcanza una sucursal*/
    public int t;

    public Grafo(int entrada) {
        this.maxStation = entrada;
        this.t = 2;
        this.cantidadStation = 0;
        this.vertice = new Nodo[entrada];
        /*Se inicializa el arreglo de Nodos*/
        for (int i = 0; i < entrada; i++) {
            this.vertice[i] = new Nodo("");
        }
    }

    public void insertGrafo(String name) {
        if (maxStation != cantidadStation) {
            for (int i = 0; i < maxStation; i++) {
                /*Si el nodo esta vacio (su ombre es "") inserta la estacion*/
                if (this.vertice[i].getName().equals("")) {
                    this.vertice[i].setName(name);
                    break;
                }
            }
            this.cantidadStation++;
        } else {
            /*Si el arreglo esta lleno, crea una copia con mas capacidad e inserta la nueva estacion*/
            int max = this.maxStation + 10;
            Nodo[] aux = new Nodo[max];
            /*Inicializa el nuevo arreglo*/
            for (int i = 0; i < this.maxStation + 10; i++) {
                aux[i] = new Nodo("");
            }
            /*Establece el nuevo arreglo como el arreglo de verticces de; grafo*/
            aux[maxStation].setName(name);
            this.vertice = aux;
            this.cantidadStation++;
            this.maxStation += max;
        }
    }

    /*Muestra las estaciones que tienen sucursal*/
    public String[] verSucursales() {
        String[] temp = new String[this.maxStation];
        for (int i = 0; i < this.maxStation; i++) {
            if (this.vertice[i].getSucursal()) {
                temp[i] = this.vertice[i].getName();
            }
        }
        return temp;

    }

    /*Busca las estaciones y, de existir, agrega una a la lista de adyacencia de la otra y visceversa*/
    public void insertArista(String name1, String name2) {
        Nodo aux1 = null;
        Nodo aux2 = null;

        for (int i = 0; i < this.maxStation; i++) {
            if (this.vertice[i].getName().equals(name1)) {
                aux1 = this.vertice[i];
            } else if (this.vertice[i].getName().equals(name2)) {
                aux2 = this.vertice[i];
            }
        }
        if (aux1 != null && aux2 != null) {
            aux1.getAdyacente().insertBegin(name2);
            aux2.getAdyacente().insertBegin(name1);
        }
    }

    public String mostrar() {
        String grafo = "";
        for (int i = 0; i < this.maxStation; i++) {
            grafo += this.vertice[i].getName() + this.vertice[i].getAdyacente().print() + "\n";

        }
        return grafo;
    }

    //PENDIENTE.....
    public Nodo searchGraf(String name) {
        for (int i = 0; i < maxStation; i++) {
            if (this.vertice[i].getName().equals(name)) {
                return vertice[i];
            }
        }
        return null;

    }

    public int searchPosGraf(String name) {
        for (int i = 0; i < maxStation; i++) {
            if (this.vertice[i].getName().equals(name)) {
                return i;
            }

        }
        return -1;

    }

    public String[] arregloPosition() {
        String[] temp = new String[this.maxStation];
        for (int i = 0; i < this.maxStation; i++) {
            temp[i] = this.vertice[i].getName();
        }
        return temp;

    }

    public boolean existeArista(int i, int j) {
        return this.vertice[i].getAdyacente().seacrh(this.vertice[j].getName()) != null;
    }

    //procedimiento recursivo
    public String recorrerProfundidad(int v, boolean[] visitados, int pos, String sucursales) {
        //se marca el vértice v como visitado
        visitados[v] = true;
        this.vertice[v].cubierta = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        sucursales += (this.vertice[v].getName()) + "\n";
        if (pos == t) {
            return sucursales;
        }
        //se examinan los vértices adyacentes a v para continuar el recorrido
        for (int i = 0; i < this.maxStation; i++) {
            if ((v != i) && (!visitados[i]) && (this.existeArista(v, i))) {
                sucursales = recorrerProfundidad(i, visitados, pos + 1, sucursales);
            }
        }
        return sucursales;
    }

    //procedimiento no recursivo
    public String profundidad(String estacion) {
        Nodo est = this.searchGraf(estacion);
        int v = 0;
        boolean visitados[] = new boolean[this.maxStation];
        for (int i = 0; i < this.maxStation; i++) { //inicializar vector con campos false
            visitados[i] = false;
            if (this.vertice[i].getName().equals(estacion)) {
                v = i;
            }
        }
        return this.recorrerProfundidad(v, visitados, 0, "");
        /*v es la posicion en this.vertices de la estacion, 0 es la variable que lleva la cuenta de 
        cuantas estaciones faltan para llegar a t, y "" es donde guardamos las estaciones visitadas*/
    }

    public String amplitud(String estacion) {
        ColaGrafo cola = new ColaGrafo();
        String recorrido = "";
        boolean visitados[] = new boolean[this.maxStation];
        String nombre;
        int cont = 0;
        int aux = 1;
        int v;//vértice actual
//Se inicializa el vector visitados [] a false
        for (int i = 0; i < this.maxStation; i++) {
            visitados[i] = false;
        }
        Nodo est = this.searchGraf(estacion);
        int i = this.searchPosGraf(estacion);
//El recorrido en amplitud se inicia en cada vértice no visitado
        if (est != null) {
//se pone en la cola el vértide de partida y se marca como visitado
            cola.encolar(estacion);
            visitados[i] = true;
            while (!cola.isEmptyCola() && this.t >= cont) {
                nombre = cola.desencolar(); //desencolar y tratar el vértice
                v = this.searchPosGraf(nombre);
                recorrido += (nombre) + "\n";

//y encolo los nodos adyacentes a v.
                for (int j = 0; j < this.maxStation; j++) {
                    if ((v != j) && (this.existeArista(v, j)) && (!visitados[j])) {
                        cola.encolar(this.vertice[j].getName());
                        visitados[j] = true;

                    }
                }

                aux--;
                System.out.println(cola.printCola());
                System.out.println("----------------------- AUX --------" + (aux));
                if (aux == 0) {
                    System.out.println(cola.printCola());
                    cont += 1;
                    System.out.println("-----------------------" + (cont));
                    aux = cola.getSize();
                }

            }

        }
        return recorrido;
    }

    public Lista verAlcance() {
        Lista sinCubrir = new Lista();
        for (int i = 0; i < this.maxStation; i++) {
            if (this.vertice[i].getSucursal()) {
                this.profundidad(this.vertice[i].getName());
            }
        }
        for (int i = 0; i < this.maxStation; i++) {
            if (!this.vertice[i].cubierta && !this.vertice[i].getName().equals("")) {
                sinCubrir.insertBegin(this.vertice[i].getName());
            }
        }
        return sinCubrir;
    }

    public Lista sugerirSucursales(Lista sinCubrir) {
        Lista sugeridas = new Lista();
        while (!sinCubrir.isEmpty()) {
            sugeridas.insertBegin(sinCubrir.getHead().getName());
            this.searchGraf(sinCubrir.getHead().getName()).setSucursal(true);
            sinCubrir = this.verAlcance();
            System.out.println(sinCubrir.print());
        }
        Nodo aux = sugeridas.getHead();
        while(aux != null){
            this.profundidadDesmarque(aux.getName());
            aux = aux.getPnext();
        }
        this.verAlcance();
        return sugeridas;

    }
    
    
    private void recorrerProfundidadDesmarcar(int v, boolean[] visitados, int pos) {
        //se marca el vértice v como visitado
        visitados[v] = true;
        this.vertice[v].cubierta = false;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        
        if (pos == t) {
            return;
        }
        //se examinan los vértices adyacentes a v para continuar el recorrido
        for (int i = 0; i < this.maxStation; i++) {
            if ((v != i) && (!visitados[i]) && (this.existeArista(v, i))) {
                 recorrerProfundidadDesmarcar(i, visitados, pos + 1);
            }
        }
        return ;
    }

    //procedimiento no recursivo
    public void profundidadDesmarque(String estacion) {
        Nodo est = this.searchGraf(estacion);
        est.setSucursal(false);
        int v = 0;
        boolean visitados[] = new boolean[this.maxStation];
        for (int i = 0; i < this.maxStation; i++) { //inicializar vector con campos false
            visitados[i] = false;
            if (this.vertice[i].getName().equals(estacion)) {
                v = i;
            }
        }
         this.recorrerProfundidadDesmarcar(v, visitados, 0);

    }

}
