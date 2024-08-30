/*
 * Definição da classe ConsultarLivro.
 */

package Comando;

import BibliotecaModelo.Livro;
import Sistema.Repositorio;
import Sistema.Trabalhador;

/**
 *implementa a interface IComando
 */

public class ConsultarLivro implements IComando{

    @Override
    public void executar(Parametro p) {
        Livro livro = Repositorio.pegarInstancia().pegarLivro(p.getPrimeiroParametro());
        
        Trabalhador.consultarLivro(livro);
    }
    
}
