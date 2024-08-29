/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comando;

import BibliotecaModelo.Livro;
import Sistema.Repositorio;
import Sistema.Trabalhador;
import UsuarioModelo.IObservador;

/**
 *
 * @author theou
 */
public class RegistrarObservador implements IComando{

    @Override
    public void executar(Parametro p) {
       IObservador observador =  Repositorio.pegarInstancia().pegarObservador(p.getPrimeiroParametro());
       Livro livro = Repositorio.pegarInstancia().pegarLivro(p.getSegundoParametro());
       
       Trabalhador.registrarObservador(observador, livro);
    }
    
}
