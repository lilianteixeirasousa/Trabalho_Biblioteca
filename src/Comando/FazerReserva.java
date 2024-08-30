/*
 * Definição da classe FazerReserva.
 */
package Comando;

import BibliotecaModelo.Livro;
import Sistema.Repositorio;
import Sistema.Trabalhador;
import UsuarioModelo.Usuario;

/**
 * Implementa a interface IComando
 */
public class FazerReserva implements IComando{

    @Override
    public void executar(Parametro p) {
        Usuario usuario = Repositorio.pegarInstancia().pegarUsuario(p.getPrimeiroParametro());
        Livro livro = Repositorio.pegarInstancia().pegarLivro(p.getSegundoParametro());
        
        Trabalhador.reservarLivro(usuario, livro);
    }
    
}
