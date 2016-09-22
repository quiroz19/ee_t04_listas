/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaligada;

/**
 *
 * @author Anita
 */
public class Nodo 
{
    private Object dato;
    private Nodo sig;
    public Nodo(Object d,Nodo s){
        dato=d;
        sig=s;
    }

    public Nodo(Object o){
        dato=o;
        sig=null;
    }
    public Nodo(){
        dato=null;
        sig=null;
    }
    

    public Object getDato(){return dato;}

    public void setDato(Object d){dato=d;}

    public Nodo getSig(){return sig;}

    public void setSig(Nodo s){sig=s;}

}
