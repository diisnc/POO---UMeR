import java.util.*;
import java.io.*;
import java.time.*;
public class GestorEmpresa implements Serializable
{
    private String cE; // 'current Empresa' (empresa atualmente em uso pela interface)
    private HashMap<String,Empresa> lE; // lista das empresas no sistema
    private static int nGestor=0;
    private LocalDateTime date;
    private static String userName;
    private static String userEmail;
    
    public GestorEmpresa(){
        if(nGestor==0){
            this.nGestor++;            
            cE = null;
            lE = new HashMap<String,Empresa>();
            userName = null;
            userEmail= null;
        }
        else throw new AssertionError();
    }
    
    /** METODOS DO GESTOR **/
    public String getCE(){return cE;}
    public String getNome(){return lE.get(cE).getNome();}
    public boolean containsEmpresa(String s){return lE.containsKey(s.toUpperCase());}
    public boolean containsEmpresa(Empresa e){return containsEmpresa(e.getNome());}
    public boolean addNewEmpresa(String nome){
        if(containsEmpresa(nome)) return false;
        lE.put(nome.toUpperCase(),new Empresa(nome));
        return true;
    }
    public String[] getNomesEmpresas(){
        return lE.entrySet().stream()
                 .map(m->m.getValue().getNome())
                 .toArray(n->new String[n]);
    }
        
    /** METODOS RELATIVOS À EMPRESA **/
    
    public boolean isCliente(String email){return lE.get(cE).isCliente(email);}
    public boolean isMotorista(String email){return lE.get(cE).isMotorista(email);}
    public int emailExists(String email){return lE.get(cE).emailExists(email);}
    public int login(String email,String pass){return lE.get(cE).login(email,pass);}
    public boolean associa(String mat,String emailM)
        throws MatriculaNaoExistenteException, MotoristaInexistenteException
        {return lE.get(cE).associa(mat,emailM);}
    public boolean freePair(String v,String mail){return lE.get(cE).freePair(v,mail);}
    //public boolean addFreeM
    //public boolean addFreeV
    // getActivePair
    public String getTaxi(double x,double y){return lE.get(cE).getTaxi(x,y);}
    public String getTaxi(String mat){return lE.get(cE).getTaxi(mat);}
    // classificar motorista
    public boolean matriculaExiste(String m)  {return lE.get(cE).matriculaExiste(m);}
    public boolean emailExiste(String m){return lE.get(cE).emailExiste(m);}
    
    public String addVeiculo(int tipoVeiculo,String mat,double velM,double pKm,
           double rel,double x,double y,boolean hasQueue)
           throws MatriculaNaoExistenteException,OpcaoInexistenteException{
        return lE.get(cE).addVeiculo(tipoVeiculo,mat,velM,pKm,rel,x,y,hasQueue);
    }
    public String addCliente(String nome,String email,String pass,String morada,
           String dataN,double x,double y) throws EMailExistenteException{
        return lE.get(cE).addCliente(nome,email,pass,morada,dataN,x,y);
    }
    public String addMotorista(String nome,String email,String pass,String morada,
           String dataN,double tKm,double cf,double cm,boolean disp)
           throws EMailExistenteException{
        return lE.get(cE).addMotorista(nome,email,pass,morada,dataN,tKm,cf,cm,disp);
    }
    public boolean podeFazer(String emailMot){return lE.get(cE).podeFazer(emailMot);}
    public boolean addViagem(String mailCliente,String matricula,double x,double y)
        {return lE.get(cE).addViagem(mailCliente,matricula,x,y);}
    
        
    /** GUARDAR / LER ESTADO **/
    
    public void guardaEstado(String nomeFicheiro)
        throws FileNotFoundException,IOException {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this); //guarda-se todo o objecto de uma só vez
        oos.flush();
        oos.close();
    }
    public static GestorEmpresa carregaEstado(String nomeFicheiro)
        throws FileNotFoundException,IOException,ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeFicheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestorEmpresa g = (GestorEmpresa) ois.readObject();
        ois.close();
        return g;
    }
}
