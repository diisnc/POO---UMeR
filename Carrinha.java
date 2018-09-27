import java.util.*;
import java.io.*;
/**
 * Write a description of class Carrinha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carrinha extends Viatura implements Serializable
{
   //variaveis de intância
   public static double preco_acrescido = 0.6;

    
   //construtores
   public Carrinha(){super();}
   public Carrinha(Carrinha c){super(c);}
   public Carrinha(String mat,double velMedia,double precoKm,double reliability
                  ,double x,double y,boolean available){
        super(mat,velMedia,precoKm,reliability,x,y,available);
    }
   
   //n e preciso super pq viatura é uma classe abstrata
   public double getPrecoKm(){
       return (this.getPrecoKm() + preco_acrescido) ;
   }
    
   public Carrinha clone(){return new Carrinha(this);}
}
