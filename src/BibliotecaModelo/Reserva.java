
package BibliotecaModelo;

import UsuarioModelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Classe de definição de reserva
 */
public class Reserva {
   private Usuario usuario;
   private Livro livro;
   private Date data;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        data = new Date();
    }

    public String codigoUsuario() {
        return usuario.getCodigo();
    }
    
    public String nomeUsuario(){
        return usuario.getNome();
}

    public String codigoLivro() {
        return livro.getCodigo();
    }
    
    private String tituloLivro(){
        return livro.getTitulo();
    }

    public Date getData() {
        return data;
    }
    
    public String consultar(){
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        return "· "+tituloLivro()+" ("+sdt.format(data)+")";
    }
    
}
