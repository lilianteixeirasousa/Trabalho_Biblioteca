/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comando;

import BibliotecaModelo.Livro;
import Sistema.Repositorio;
import Sistema.Trabalhador;

/**
 *
 * @author theou
 */
public class ConsultarLivro implements IComando{

    @Override
    public void executar(Parametro p) {
        Livro livro = Repositorio.pegarInstancia().pegarLivro(p.getPrimeiroParametro());
        
        Trabalhador.consultarLivro(livro);
    }
    
}
