/**
 * Classe que descreve a localização de um cliente e de um veículo.
 * 
 * @author Diana
 */

import java.lang.Math;
import java.io.*;
public class Coordenadas implements Serializable
{    
    /** VARIAVEIS DE INSTANCIA **/
    private double x, y;
    
    /** CONSTRUTORES **/
    public Coordenadas(){
        this.x=0.0;
        this.y=0.0;
    }

    public Coordenadas(double xx, double yy){
        this.x = xx;
        this.y = yy;
    }
    
    public Coordenadas(Coordenadas p){
        this.x = p.getX();
        this.y = p.getY();
    }
    
    
    /** GETTERS **/
    public double getX(){ return this.x; }
    public double getY(){ return this.y; }
    
    /** SETTERS **/
    public void setX(double xx){ this.x = xx; }
    public void setY(double yy){ this.y = yy; }
    
    /** Outros Métodos **/
    //distancia euclidiana entre dois pontos
    public double distEuc(Coordenadas p1){
        double deltaX = this.x - p1.getX();
        double deltaY = this.y - p1.getY();
        double result = Math.sqrt( deltaX*deltaX + deltaY*deltaY );
        return result;
    }
        
    public Coordenadas clone(){return new Coordenadas(this);}
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        
        Coordenadas p = (Coordenadas) o;
        return (this.x == p.getX() && this.y == p.getY());
    }
        
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("( " +this.x+ " , " +this.y+ " )\n");
        return s.toString();
    }
}
