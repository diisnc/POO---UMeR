//apaguei nesta classe as coordenadas, pq só o cliente é q as tem, nao o motorista
import java.util.*;
import java.io.Serializable;
public abstract class User implements Serializable
{
    /** VARIÁVEIS DE INSTÂNCIA **/
    private String nome;
    private String email;
    private String password;
    private String morada;
    private String dataNascimento;
    private ArrayList<Viagem> viagensInfo; //ordenadas por data, por exemplo 
    
    /** CONSTRUTORES **/
    public User(){
        this.nome="n/a";
        this.email="n/a";
        this.password="n/a";
        this.morada="n/a";
        this.dataNascimento="n/a";
        this.viagensInfo=new ArrayList<Viagem>();
    }
    
    public User(String n,String e,String pw,String m,String dN){
        this.nome=n;
        this.email=e;
        this.password=pw;
        this.morada=m;
        this.dataNascimento=dN;
        //this.viagensInfo=getViagensInfo(vI);
    }
    
    public User(User u){
        this.nome=u.getNome();
        this.email=u.getEmail();
        this.password=u.getPassword();
        this.morada=u.getMorada();
        this.dataNascimento=u.getDataNascimento();
        this.viagensInfo=u.getViagensInfo();
    }
    
    public abstract User clone();
    
    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        
        User u = (User) o;
        return(
           this.nome.equals(u.getNome()) &&
           this.email.equals(u.getEmail()) &&
           this.password.equals(u.getPassword()) &&
           this.morada.equals(u.getMorada()) &&
           this.dataNascimento.equals(u.getDataNascimento()) &&
           this.viagensInfo.equals(u.getViagensInfo())
        );
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("; \n");
        sb.append("Email: ").append(this.email).append("; \n");
        sb.append("Morada: ").append(this.morada).append("; \n");
        sb.append("Nascido em: ").append(this.dataNascimento).append("; \n");
        //sb.append("Viagens: ").append(this.viagensInfo.toString()).append("\n");
        return sb.toString();
    }
        
    /** GETs **/
    public String getNome()     {return this.nome;}    
    public String getEmail()    {return this.email;}
    public String getPassword() {return this.password;}
    public String getMorada()   {return this.morada;}
    public String getDataNascimento()   {return this.dataNascimento;}
    public ArrayList<Viagem> getViagensInfo(){
        ArrayList<Viagem> novo = new ArrayList<Viagem>();
        for(Viagem v : this.viagensInfo){
            novo.add(v.clone()); 
        }
        return novo;
    }
    public ArrayList<Viagem> getViagensInfo(ArrayList<Viagem> vI){ //Deep Copy
        ArrayList<Viagem> novo = new ArrayList<Viagem>();
        for(Viagem v : vI){
            novo.add(v.clone()); 
        }
        return novo;
    }
    public int getNViagens()    {return this.viagensInfo.size();}
     
    /** SETs **/
    public void setNome(String nome)      {this.nome = nome;}
    public void setEmail(String email)    {this.email = email;}
    public void setPassword(String pass)  {this.password = pass;}
    public void setMorada(String morada)  {this.morada = morada;}
    public void setDataNascimento(String data)  {this.dataNascimento = data;}

    
    /** Outros Métodos **/
    //tenho q verificar se contais já uma viagem, caso o utilizador se engane
    //ou n vale a pena já que duas viagens nao sao iguais ????????????????????????????
    public void addViagem(Viagem viagem){
        this.viagensInfo.add(viagem.clone());
    }
       
    
    
}