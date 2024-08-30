
package BibliotecaModelo;

import UsuarioModelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 Classe de definição de empréstimo
 */
public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private Date diaInicial;
    private Date previsaoEntrega;
    private boolean devolvido = false;

    public Emprestimo(Usuario u, Exemplar e) {
        this.usuario = u;
        this.exemplar = e;
        
        diaInicial = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(diaInicial); 
        c.add(Calendar.DATE, u.getLimiteDia());
        previsaoEntrega = c.getTime();
    }
/**
 Métodos para a definição da situação do empréstimo: se está em dia, qual a previsão de entrega, se foi devolvido, encerra e consulta.
 */
  
    public boolean estaEmDia(Date hoje){
        return !(hoje.after(previsaoEntrega));
    }
    
    private String situacao(){
        if(devolvido){return "(Finalizado)";}
        else if(estaEmDia(new Date())){return "(Em curso)";}
        else{return "(Atrasado)";}
    }

    public Date getDiaInicial() {
        return diaInicial;
    }
    
    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }
    
    public boolean getDevolvido(){
        return devolvido;
    }
    
    public String codigoLivro(){
        return exemplar.codigoLivro();
    }
    
    public String codigoUsuario(){
        return usuario.getCodigo();
    }
    
    public String nomeUsuario(){
        return usuario.getNome();
    }
    
    private String tituloLivro(){
        return exemplar.tituloLivro();
    }
    
    public void encerrarEmprestimo(){
        devolvido = true;
        exemplar.encerrarEmprestimo();
    }
    
    public String consultar(){
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        return "· "+tituloLivro()+" "+situacao()+"\nDesde "+sdt.format(diaInicial)+" até "+sdt.format(previsaoEntrega);
    }
    
}
