/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author guante
 */
public class ColaGrafo {

    private Nodo head, tail;
    private int size;

    public ColaGrafo() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmptyCola() {
        return this.head == null;
    }

    public void encolar(String element) {
        Nodo temp = new Nodo(element);
        if (isEmptyCola()) {
            this.head = temp;
            this.tail = temp;
        } else {
            tail.setPnext(temp);
            this.tail = temp;

        }
        size++;

    }

    public String desencolar() {
        Nodo temp = this.head;
        if (isEmptyCola()) {
            System.out.println("La cola ya esta vacia");
            return "";
        } else {           
            this.head = this.head.getPnext();
            
            size--;

        }
        return temp.getName();
    }

    public String printCola() {

        String lista = "--> ";
        if (this.isEmptyCola()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo temp = this.head;
            while (temp != null) {
                lista += ("  [" + temp.getName() + "]  ");
                System.out.println(temp.getName());
                temp = temp.getPnext();
            }
        }
        return lista;

    }

}
