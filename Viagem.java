import java.io.*;
/**
 * Classe com informação relativa a uma determinada viagem
 * (Duração minutos, destino, partida, preço, satisfaçao, etc)
 * 
 * @author Diana 
 */
public class Viagem implements Serializable
{
    /** VARIÁVEIS DE INSTANCIA **/
    double duracaoT; //em minutos, duracao da viagem no taxi
    double esperaT;  //em minutos, duracao da espera pelo taxi
    double duracaoR;
    double esperaR;
    double preco;
    int classificacao;
    Coordenadas partida;
    Coordenadas destino;
        
    /** CONSTRUTORES **/
    public Viagem(){
        this.duracaoT = 0;
        this.esperaT  = 0;
        this.duracaoR = 0;
        this.esperaR = 0;
        this.partida = new Coordenadas();
        this.destino = new Coordenadas();
        this.preco   = 0;
        this.classificacao = 0;
    }
    
    public Viagem(double durT,double durR,double espT,double espR
                 ,Coordenadas ptd,Coordenadas dtn,double prc){
        this.duracaoT = durT;
        this.esperaT  = espT;
        this.duracaoR = durR;
        this.esperaR = espR;
        this.partida = ptd;
        this.destino = dtn;
        this.preco   = prc;
        //this.classificacao = c;
    }
    
    public Viagem(Viagem v){
        this.duracaoT = v.getDuracaoT();
        this.esperaT  = v.getEsperaT();
        this.duracaoR = v.getDuracaoR();
        this.esperaR  = v.getEsperaR();
        this.partida = v.getPartida();
        this.destino = v.getDestino();
        this.preco   = v.getPreco();
        this.classificacao = v.getClassificacao();
    }
    
    public Viagem clone(){return new Viagem(this);}
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        
        Viagem v = (Viagem) o;
        return (this.partida.equals(v.getPartida()) && this.preco==v.getPreco() &&
                this.destino.equals(v.getDestino()) &&
                this.esperaT==v.getEsperaT() && this.esperaR==v.getEsperaR() && 
                this.duracaoT==v.getDuracaoT() && this.duracaoR==v.getDuracaoR() &&
                this.classificacao==this.getClassificacao());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Duração Teórica: ").append(this.duracaoT).append("; ");
        sb.append("Duração Real: ").append(this.duracaoR).append("; ");
        sb.append("Tempo de espera teórico: ").append(this.esperaT)
          .append(" minutos; ");
        sb.append("Tempo de espera real: ").append(this.esperaR).append(" minutos; ");
        sb.append("Ponto de partida: ").append(this.partida.toString()).append("; ");
        sb.append("Destino: ").append(this.destino.toString()).append("; ");
        sb.append("Distância percorrida: ").append(this.getDistancia()).append("; ");
        sb.append("Preço: ").append(this.getPreco()).append("; ");
        sb.append("Classificação atribuida: ").append(this.getClassificacao())
          .append("; ");
        return sb.toString();
    }
    
    /** GETs **/
    public double getDuracaoT()         {return this.duracaoT;}
    public double getEsperaT()          {return this.esperaT;}
    public double getDuracaoR()         {return this.duracaoR;}
    public double getEsperaR()          {return this.duracaoR;}
    public double getPreco()        {return this.preco;}
    public int getClassificacao()   {return this.classificacao;}
    public Coordenadas getPartida() {return this.partida.clone();}
    public double getPartidaX()     {return this.partida.getX();}
    public double getPartidaY()     {return this.partida.getY();}
    public Coordenadas getDestino() {return this.destino.clone();}
    public double getDestinoX()     {return this.destino.getX();}
    public double getDestinoY()     {return this.destino.getY();}
    public double getDistancia()    {return this.partida.distEuc(destino);}
    
    /** SETs **/
    public void setDuracaoT(double d)         {this.duracaoT=d;}
    public void setEsperaT(double e)          {this.esperaT=e;}
    public void setDuracaoR(double d)         {this.duracaoR=d;}
    public void setEsperaR(double e)          {this.esperaR=e;}
    public void setPartida(Coordenadas p) {this.partida=p.clone();}
    public void setDestino(Coordenadas d) {this.destino=d.clone();}
    public void setPreco(double p)        {this.preco=p;}
    public void setClassificacao(int c)   {this.classificacao=c;}
        
}
