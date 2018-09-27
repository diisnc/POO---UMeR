import java.util.*;
import java.io.*;
/**
 * Write a description of class Bicicleta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicicleta extends Viatura implements Serializable
{
    public static double preco_acrescido = -0.4;
    

    
    //construtores
    public Bicicleta(){super();}
    public Bicicleta(Bicicleta b){super(b);}
    public Bicicleta(String mat,double velMedia,double precoKm,double reliability
                    ,double x,double y,boolean available){
        super(mat,velMedia,precoKm,reliability,x,y,available);
    }
    //n e preciso super pq viatura é uma classe abstrata
    public double getPrecoKm(){
       return (this.getPrecoKm() + preco_acrescido) ;
    }
    
    public Bicicleta clone(){return new Bicicleta(this);}
    
    /*
    public Bicicleta(double velMedia, double precoKm, double reliability, double x, double y, boolean temf, String mat, Motorista mot){
        super(velMedia, precoKm, reliability, x, y, temf, mat, mot);
    }
    
    public Bicicleta(Bicicleta c){
        super(c);
    }
    */
}
