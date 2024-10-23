/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

/**
 *
 * @author guante
 */
public class Lista {
    public Nodo head;
    public int size;
    
    public Lista(){
        this.head = null;
        this.size = 0;
    
    }
    
    public Lista(Nodo object){
        this.head = object;
        this.size = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    public void insertBegin(String name){
        Nodo temp = new Nodo(name);
        if(isEmpty()){
            this.head = temp;
        }else{
            temp.setPnext(this.head);
            this.head = temp;
            
        }
        size++;
        
    }
    
    public String print(){
        String lista = "--> ";
        if(isEmpty()){
            System.out.println("La lista esta vacia");
        }
        else{
            Nodo temp = this.head;
            while(temp != null){
                lista += ("  ["+temp.getName()+"]  ");
                System.out.println(temp.getName());
                temp = temp.getPnext();
            }
        }
        return lista;
    }
    
    public Nodo seacrh(Object element){
        Nodo temp = this.head;
        if(isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            while(temp!= null && !temp.getName().equals(element)){
                temp = temp.getPnext();
            }
            return temp;
        }
    
        return null;
    }
    
    
    
}
