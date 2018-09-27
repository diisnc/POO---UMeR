/** TODO: é necessário ter matricula/veiculo associado? - SIM **/
import java.util.*;
import java.io.Serializable;
public class Motorista extends User implements Serializable
{
    /** VARIÁVEIS DE INSTÂNCIA **/
    
    private boolean disponibilidade;
    private double totalKms;
    private double classificacao; // [0..100]
    private double cumprimento;// -> isto fazemos um ciclo q analiza as viagens do condutor  grau de cumprimento de horário com o cliente [0..100]

    /** CONSTRUTORES **/
    public Motorista(){
        super();
        this.disponibilidade=false;
        this.totalKms=0;
        this.classificacao=0;
        this.cumprimento=0;
    }
    
    public Motorista(Motorista m){
        super(m);
        this.disponibilidade = m.getDisponibilidade();
        this.totalKms = m.getTotalKms();
        this.classificacao = m.getClassificacao();
        this.cumprimento = m.getCumprimento();
    }
    
    public Motorista(String n,String e,String pw,String m,String dN
                    ,double t,double cf,double cm, boolean available){
        super(n,e,pw,m,dN);
        this.disponibilidade = available;
        this.totalKms=t;
        this.classificacao=cf;
        this.cumprimento=cm;
    }
    
    public Motorista clone(){return new Motorista(this);}
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        
        Motorista m = (Motorista) o;
        return (super.equals(m) &&  
                this.totalKms==m.getTotalKms() &&
                this.classificacao==m.getClassificacao() && 
                this.disponibilidade == m.getDisponibilidade() &&
                this.cumprimento==m.getCumprimento()); 
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.disponibilidade?"Está":"Não está").append(" a trabalhar; ");
        sb.append("Total kms: ").append(this.totalKms).append("; ");
        sb.append("Classificação: ").append(this.classificacao).append("; ");
        sb.append("Cumprimento: ").append(this.cumprimento).append("; ");
        return sb.toString();
    }
        
    /** GETs **/
    public double getTotalKms() {return this.totalKms;}
    public double getClassificacao() {return this.classificacao;}
    public double getCumprimento()   {return this.cumprimento;}
    public boolean getDisponibilidade() { return this.disponibilidade; }
    
    /** SETs **/
    public void setTotalKms(double t) {this.totalKms=t;}
    public void setClassificacao(double c) {this.classificacao=c;}
    public void setCumprimento(double c)   {this.cumprimento=c;}
    public void setDisponibilidade(boolean disp) { this.disponibilidade = disp; }
    
    /** Outros Métodos **/
    
    
}
