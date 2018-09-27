/**
 * Escreva a descrição da classe Clientes aqui.
 * 
 * @author Diana Costa
 * @version (número de versão ou data)
 */

import java.util.*;
import java.io.Serializable;
public class Cliente extends User implements Serializable
{
    //VARIÁVEIS DE INSTÂNCIA
    private Coordenadas localizacao;
    
    //CONSTRUTORES
    public Cliente(){
        super();
        this.localizacao = new Coordenadas();
    }
    
    public Cliente(String email, String nome, String passw, String morada, String dataN, double x, double y){
        super(nome, email, passw, morada, dataN);
        this.localizacao = new Coordenadas(x,y);
    }
    
    public Cliente(Cliente c){
        super(c);
        this.localizacao = c.getLocalizacao();
    }
    
    //MÉTODOS DE INSTANCIA
    
    public double getLocalizacaoX()     {return this.localizacao.getX();}
    public double getLocalizacaoY()     {return this.localizacao.getY();}
    public Coordenadas getLocalizacao() {return this.localizacao.clone();}
    
    public void setLocalizacaoX(double xx)      {this.localizacao.setX(xx);}
    public void setLocalizacaoY(double yy)      {this.localizacao.setY(yy);}
    public void setLocalizacao(Coordenadas c)   {this.localizacao=c.clone();}
    /*public void setLocalizacao(double x, double y){
        this.localizacao = new Coordenadas(x,y);//pode-se fazer isto?
    }
    */
    public void setLocalizacao(double x, double y){
        this.localizacao.setX(x);
        this.localizacao.setY(y);
    }
    
    /*
    
    //escolher taxi específico, vai receber uma classe taxi q marco vai fzr
    //a nossa matricula é como se fosse um id especifico de uma viatura
    //retorna o identificador do veiculo
    public Viatura pedirTaxiEspec(String matricula, ArrayList<Viatura> veic){
        Iterator<Viatura> it = veic.iterator();
        Viatura v = null;
        String matric;
        boolean encontrou = false;
        
        while( it.hasNext() && !encontrou){
            v = it.next();
            matric = v.getMatricula();
            if( matric.equals(matricula) ){//&& v.getMotorista().getDisponibilidade() ){
                encontrou = true;
            }
        
        }
        
        return encontrou ? v.clone() : null;
    }
    
    //escolher taxi disponível mais próximo
    public Viatura pedirTaxiMaisProx(ArrayList<Viatura> veic){
        double menor_dist = Double.MAX_VALUE;
        double dist_tmp;
        Viatura v_mais_prox = null;
    
        for(Viatura v : veic){
            dist_tmp = this.localizacao.distEuc(v.getCoord());
            
            if( dist_tmp < menor_dist){ //&& v.getMotorista().getDisponibilidade() ){
                menor_dist = dist_tmp;
                v_mais_prox = v;
            }
        }
    
        return v_mais_prox.clone();
    }
    */
    
        public Cliente clone(){
        return new Cliente(this);        
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("Coordenadas: " + localizacao.toString() + "\n");
        return s.toString();
    }
}
