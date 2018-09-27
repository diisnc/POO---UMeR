import java.util.*;
import java.io.*;
/**
 * Write a description of class Moto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moto extends Viatura implements Serializable
{
    public static double preco_acrescido = -0.3;


    
    //construtores
    
    public Moto(){super();}
    public Moto(Moto c){super(c);}
    public Moto(String mat,double velMedia,double precoKm,double reliability
               ,double x,double y,boolean available){
        super(mat,velMedia,precoKm,reliability,x,y,available);
    }
    
    //n e preciso super pq viatura é uma classe abstrata
    public double getPrecoKm(){
       return (this.getPrecoKm() + preco_acrescido) ;
    }
    
    public Moto clone(){return new Moto(this);}
    /*
    public Moto(double velMedia, double precoKm, double reliability, double x, double y, boolean temf, String mat, Motorista mot){
        super(velMedia, precoKm, reliability, x, y, temf, mat, mot);
    }
    */
    
}
