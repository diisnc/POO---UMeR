/**
 * Write a description of class Viaturas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public abstract class Viatura implements Serializable
{
    //variaveis de intância
    /** Velocidade média de um veiculo **/
    private double velMedia;
    private double precoKm; //em euro s     /** Preço base por quilometro **/
    private double fiabilidade;//    /** Factor de fiabilidade *  É calculado através do cumprimento ou não o tempo acordado com o cliente.     */
    private Coordenadas coord;//    /** Localização da viatura **/
    private String matricula; //identificador de 1 veiculo
    private boolean hasQueue; //     
    //private Motorista motorista; //motorista desta viatura    
    
    
    //NOTA: RETIREI A DISPONIBILIDADE DESTA CLASSE, PQ QUEM ESTÁ DISPONIVEL É O MOTORISTA (QUE CONDUZ UM ARRAY DE CARROS DELE) (está no enunciado)
    /** CONSTRUTORES **/
    public Viatura(){
        this.velMedia = 0;
        this.precoKm = 0;
        this.fiabilidade = 100;
        this.coord = new Coordenadas();
        this.matricula = "00-00-00";
        this.hasQueue = false;
    }
    public Viatura(String mat,double velMedia,double precoKm,double reliability
                  ,double x,double y,boolean hasQueue){
        this.matricula = mat;
        this.velMedia = velMedia;
        this.precoKm = precoKm;
        this.fiabilidade = reliability;
        this.coord = new Coordenadas(x,y);
        this.hasQueue = hasQueue;
    }
    public Viatura(Viatura v){
        this.velMedia = v.getVelMedia();
        this.precoKm  = v.getPrecoKm();
        this.fiabilidade = v.getFiabilidade();
        this.coord = v.getCoord();
        this.matricula = v.getMatricula();
        //this.motorista = v.getMotorista();
    }
    public abstract Viatura clone();
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || (o.getClass() != this.getClass())) return false;
        
        Viatura v = (Viatura) o;        
        return ( this.velMedia==v.getVelMedia() && 
                 this.precoKm==v.getPrecoKm() && 
                 this.fiabilidade==v.getFiabilidade() && 
                 this.coord.equals(v.getCoord()) &
                 this.matricula.equals(v.getMatricula()) //&&
                 //this.motorista.equals(v.getMotorista()) 
                 );
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Velocidade média por Km: ").append(this.velMedia).append("; \n");
        sb.append("Preço base por Km: ").append(this.precoKm).append("; \n");
        sb.append("Fiabilidade: ").append(this.fiabilidade).append("; \n");
        sb.append("Localização: ").append(this.coord.toString()).append("; \n");
        sb.append("Matrícula: " +this.matricula+ "; \n");
        //sb.append("Motorista: " +this.motorista.toString()+ "; \n");
        return sb.toString();
    }

    /** GETs **/
    public double getVelMedia()         {return this.velMedia;}
    public double getPrecoKm()          {return this.precoKm;}
    public double getFiabilidade()      {return this.fiabilidade;}
    public Coordenadas getCoord()       {return this.coord.clone();}
    public String getMatricula()        {return this.matricula;}
    public boolean hasQueue()           {return this.hasQueue;}
    
    /** SETs **/
    public void setVelMedia(double vel)      {this.velMedia = vel;}
    public void setPrecoKm(double preco)     {this.precoKm = preco;}
    public void setFiabilidade(double rel)   {this.fiabilidade = rel;}
    public void setCoord(double x, double y) {this.coord = new Coordenadas(x,y);}
    public void setCoord(Coordenadas c)      {this.coord = c.clone();}
    public void setMatricula(String m)       {this.matricula = m;}
        
}
