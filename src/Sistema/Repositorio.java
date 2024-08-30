/*
 * Definição da classe Repositório.
 * Padrão Singleton.
 */
package Sistema;

import BibliotecaModelo.Exemplar;
import BibliotecaModelo.Livro;
import UsuarioModelo.AlunoGrad;
import UsuarioModelo.AlunoPos;
import UsuarioModelo.IObservador;
import UsuarioModelo.Professor;
import UsuarioModelo.Usuario;
import java.util.ArrayList;

/**
 * contém as listas de usuarios, livros, e observadores
 */
public class Repositorio {
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<IObservador> observadores = new ArrayList<>();
    private static Repositorio instancia;
    
    private Repositorio(){}
    
    public static Repositorio pegarInstancia(){
        if(instancia==null){
            instancia = new Repositorio();
        }
        return instancia;
    }
    
    public void salvarUsuario(Usuario u){
        usuarios.add(u);
    }
    
    public Usuario pegarUsuario(String codigo){
        for(Usuario u: usuarios){
            if (u.getCodigo().equals(codigo)){return u;}
        }
        return null;
    }
    
    public void salvarLivro(Livro l){
        livros.add(l);
    }
    
    public Livro pegarLivro(String codigo){
        for(Livro l: livros){
            if (l.getCodigo().equals(codigo)){return l;}
        }
        return null;
    }
    
     public void salvarObservador(IObservador observador){
        observadores.add(observador);
    }
    
    public IObservador pegarObservador(String codigo){
        for(IObservador o: observadores){
            if (o.testarCodigo(codigo)){return o;}
        }
        return null;
    }
    
    public void iniciarDados(){
        Usuario joao =  new AlunoGrad("123", "João da Silva");
        Usuario luiz = new AlunoPos("456", "Luiz Fernando Rodrigues");
        Usuario pp =  new AlunoGrad("789", "Pedro Paulo");
        Usuario carlos = new Professor("100", "Carlos Lucena");
        
        Livro l1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", 6, 2000);
        Livro l2 = new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", 7, 2000);
        Livro l3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", 2, 2014);
        Livro l4 = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", 1, 2002);
        Livro l5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", 1, 1999);
        Livro l6 = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", 3, 2014);
        Livro l7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1, 1994);
        Livro l8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", 3, 2003);
        
        l1.adicionarExemplar(new Exemplar("01", l1));
        l1.adicionarExemplar(new Exemplar("02", l1));
        
        l2.adicionarExemplar(new Exemplar("03", l2));
        
        l3.adicionarExemplar(new Exemplar("04", l3));
        
        l4.adicionarExemplar(new Exemplar("05", l4));
        
        l5.adicionarExemplar(new Exemplar("06", l5));
        l5.adicionarExemplar(new Exemplar("07", l5));
        
        l7.adicionarExemplar(new Exemplar("08", l7));
        l7.adicionarExemplar(new Exemplar("09", l7));
        
        salvarLivro(l1);
        salvarLivro(l2);
        salvarLivro(l3);
        salvarLivro(l4);
        salvarLivro(l5);
        salvarLivro(l6);
        salvarLivro(l7);
        salvarLivro(l8);
        
        salvarUsuario(joao);
        salvarUsuario(luiz);
        salvarUsuario(pp);
        salvarUsuario(carlos);
        
        salvarObservador((IObservador) carlos);
    } 
}
