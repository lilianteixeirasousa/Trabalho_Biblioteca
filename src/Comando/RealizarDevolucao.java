/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comando;

import BibliotecaModelo.Livro;
import Sistema.Repositorio;
import Sistema.Trabalhador;
import UsuarioModelo.Usuario;

/**
 *
 * @author theou
 */
public class RealizarDevolucao implements IComando {
    
    @Override
    public void executar(Parametro p) {
        Usuario usuario = Repositorio.pegarInstancia().pegarUsuario(p.getPrimeiroParametro());
        Livro livro = Repositorio.pegarInstancia().pegarLivro(p.getSegundoParametro());
        
        Trabalhador.devolverLivro(usuario, livro);
    }
}
