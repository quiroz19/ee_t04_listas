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
public class ListaLigada{
    private Nodo fin, inicio;
    private int cont;

    public ListaLigada(){
       
        cont=0;
        fin=inicio=null;
    }

    public boolean Vacia(){
        return inicio==null;
    }

    public boolean agregarFin(Object o){
        Nodo n=new Nodo(o);
        if(n!=null){
            if(!Vacia()){
                fin.setSig(n);
                fin=n;
            }
            else
                fin=inicio=n;
            cont++;
            return true;
        }
        return false;
    }

    public boolean agregar(Object o){
        Nodo n=new Nodo(o);
        if(n!=null){
            if(Vacia())
                inicio=n;
            else
                fin.setSig(n);
            fin=n;
            cont++;
            return true;
        }
        return false;
    }

    public Nodo buscarNodo(Object d){

        Nodo aux=inicio;
        while(aux!=null){
            if(aux.getDato().equals(d)){
                return aux;
            } else aux=aux.getSig();
        }
        return null;
    }
    
 public int buscar(Object o){
        int c = -1;
        if (!Vacia()){
            if(inicio.getDato()!=null){
                if(inicio.getDato().equals(o))return 0;
            }
            if(fin.getDato()!=null){
                if(fin.getDato().equals(o))return (int)cont-1;
            }
            Nodo aux = inicio;c++;
            while (c<size()){
                if(aux.getDato()!=null){
                    if (!aux.getDato().equals(o)){
                        c++;
                        aux = aux.getSig();
                    }
                    
                    else return c;
                }else
                    
                if(o==null){return c;}else{
                    c++;
                    aux = aux.getSig();
                }
            }  
            c=-1;
        }
        return c;
    }

    public  boolean AgregarPos(Object obj,int p){
        if(p<=size()&&p>=0){
            Nodo aux=inicio,principio=null,fin1=null;
            if(p==0){Nodo n=new Nodo(obj);
                if(Vacia()){
                    return agregar(obj);}else{
                    n.setSig(aux);
                    inicio=n;cont++;return true;}  }
            if(p==size()){
                agregar(obj); return true;  }
            for(int i=0;i<size();i++){
                if(i==p){
                    Nodo pii=new Nodo(obj);
                    fin1.setSig(pii);
                    pii.setSig(aux);
                    inicio=principio;  cont++;
                    return true;   }
                if(i!=0){
                    Nodo pi=new Nodo(aux.getDato());
                    fin1.setSig(pi);
                    fin1=pi;
                    aux=aux.getSig(); }
                else{Nodo pi=new Nodo(aux.getDato());
                    principio=fin1=pi; aux=aux.getSig(); }
            } 
        }   
        return false;
    }

    public int size(){return cont;}

 

    private double cov(Nodo c){
        //String  cc=(String)(c.getDato()) ;
      //  return Double.parseDouble((double)c.getDato());
      return (double)c.getDato();
    }

    private int cov1(Nodo c,Nodo n){
        String  cc=c.getDato().toString() ;
        String  c1=n.getDato().toString() ;
        int resultado=cc.compareTo(c1);

        return resultado ;
    }

    public void ordenNumerico(){
        if(!Vacia())
            for(Nodo x=inicio;x!=null;x=x.getSig())
                for(Nodo y=x.getSig();y!=null;y=y.getSig()){
                    if(cov(x)>cov(y)){
                        Object o=x.getDato();
                        x.setDato(y.getDato());
                        y.setDato(o);
                    }
                }
    }

    public void ordenAlfabetico(){
        if(!Vacia())
            for(Nodo x=inicio;x!=null;x=x.getSig())
                for(Nodo y=x.getSig();y!=null;y=y.getSig()){
                    if(cov1(x,y)>0){
                        Object o=x.getDato();
                        x.setDato(y.getDato());
                        y.setDato(o);
                    }
                }
    }

    public Object eliminarInicio(){
        Object o=null;
        if(!Vacia()){
            o=inicio.getDato();
            inicio=inicio.getSig();
            if(size()==1)
                fin=null;
            cont--;
        }
        return o;
    }
       public Object verInicio(){
        if(!Vacia())
            return  inicio.getDato();
        return null;
    }

    public Object verPos(int p){
        if(p==0){return verInicio();}
        if(p==size()-1){return verFinal();}
        Object o=null; int z=0;
        if(p>0&&p<cont){
            if(!Vacia())
                for(Nodo x=inicio;x!=null;x=x.getSig()){
                    if(p==z){
                        o=x.getDato();
                        return o;
                    }
                    z++;
                }
        }
        return o;
    }

    public Object verFinal(){
        Object o=null;
        if(!Vacia()){
            o=fin.getDato();
            fin=inicio.getSig();
            if(size()==1){
                fin=null;
                inicio=null;}

        }
        return o;
    }

    public Object eliminarPos(int p){
        if(p<size()&&p>=0){
            Nodo aux=inicio,principio=null,fin1=null;
            if(p==0){
                return eliminarInicio(); }
            Object ccc=null;
            for(int i=0;i<size();i++){
                if(i==p&&i!=size()-1){
                    ccc=aux.getDato();
                    Nodo pi=new Nodo(aux.getDato());
                    fin1.setSig(pi);
                    fin1=pi;
                    aux=aux.getSig();
                    fin1.setDato(aux.getDato());
                    aux=aux.getSig();  }
                if(i==size()-1){
                    if(aux==null){
                        inicio=principio;
                        fin =fin1;
                        cont--;
                        return ccc;}else{
                        ccc=aux.getDato();
                        inicio=principio;
                        fin =fin1;   cont--;
                        return ccc;
                    }
                }
                if(i!=0&&i!=p){
                    Nodo pi=new Nodo(aux.getDato());
                    fin1.setSig(pi);
                    fin1=pi;
                    aux=aux.getSig();    }
                else{
                    if(i!=p){
                        Nodo pi=new Nodo(aux.getDato());
                        principio=fin1=pi;
                        aux=aux.getSig();} }
            } 
        }   
        return null;
    }
}