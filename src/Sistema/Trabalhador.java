/*
 * Define classe trabalhador.
 */

package Sistema;

import BibliotecaModelo.Emprestimo;
import BibliotecaModelo.IObjeto;
import BibliotecaModelo.Livro;
import BibliotecaModelo.Reserva;
import UsuarioModelo.IObservador;
import UsuarioModelo.IRegra;
import UsuarioModelo.Usuario;


public class Trabalhador {

    public static boolean reservarLivro(Usuario user, Livro livro){
        if(user.testarLimiteReserva()){
            MensagemSistema.limiteDeReservas(user.getNome(), livro.getTitulo());
            return false;
        }
        else if(livro.usuarioReservou(user.getCodigo())){
            MensagemSistema.reservaRepetida(user.getNome(), livro.getTitulo());
            return false;
        }
        else{
            Reserva r = new Reserva(user, livro);
            user.incluirReserva(r);
            livro.incluirReserva(r);
            MensagemSistema.reservaSucesso(user.getNome(), livro.getTitulo());
            return true;
        }
    }
    
    public static boolean emprestarLivro(Usuario user, Livro livro){
        IRegra regra = user.getRegra();
        return regra.condicoesEmprestimo(user, livro);
    }
    
    public static boolean devolverLivro(Usuario user, Livro livro){
        Emprestimo emprestimo = user.pegarEmprestimo(livro.getCodigo());
        if(emprestimo!=null){
            emprestimo.encerrarEmprestimo();
            MensagemSistema.devolucaoSucesso(user.getNome(), livro.getTitulo());
            return true;
        }
        MensagemSistema.emprestimoNaoEncontrado(user.getNome(), livro.getTitulo());
        return false;
    }
    
    public static void registrarObservador(IObservador observador, Livro livro){
        livro.registraObservador(observador);
        MensagemSistema.inscritoComSucesso(livro.getCodigo());
    }
    
    public static void consultarUsuario(Usuario user){
        System.out.println(user.consultar());
    }
    
    public static void consultarLivro(Livro livro){
        System.out.println(livro.consultar());
    }
    
    public static void consultarObservador(IObservador observador){
        System.out.println(observador.consultarObservador());
    }
    
    public static void sair(){
        MensagemSistema.saindo();
        System.exit(0);
    }
    
}
