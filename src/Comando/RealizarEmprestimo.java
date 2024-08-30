/*
 * Definição da classe RealizarEmpréstimo
 */
package Comando;

import BibliotecaModelo.Livro;
import Sistema.Repositorio;
import Sistema.Trabalhador;
import UsuarioModelo.Usuario;

/**
 * implementa a interface IComando
 */
public class RealizarEmprestimo implements IComando{

    @Override
    public void executar(Parametro p) {
        Usuario usuario = Repositorio.pegarInstancia().pegarUsuario(p.getPrimeiroParametro());
        Livro livro = Repositorio.pegarInstancia().pegarLivro(p.getSegundoParametro());
        
        Trabalhador.emprestarLivro(usuario, livro);
    }
    
}
