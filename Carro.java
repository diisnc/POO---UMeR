import java.util.*;
import java.io.*;
/**
 * Write a description of class Taxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro extends Viatura implements Serializable
{
    public static double preco_acrescido = 0.0;
    
    //construtores
    public Carro(){super();}
    public Carro(Carro c){super(c);}
    public Carro(Viatura v){super(v);}
    public Carro(String mat,double velMedia,double precoKm,double reliability
               ,double x,double y,boolean available){
        super(mat,velMedia,precoKm,reliability,x,y,available);
    }
    
    //n e preciso super pq viatura é uma classe abstrata
   public double getPrecoKm(){
       return (this.getPrecoKm() + preco_acrescido) ; //vai lá cima a viatura buscar preço
   }
    
  
    public Carro clone(){return new Carro(this);}
    //fazemos get ou set de alguma coisa?
    //gets
    
    //sets
    
    //metodos

    

}
