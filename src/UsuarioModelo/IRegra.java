/*
 * Define interface IRegra.
 */
package UsuarioModelo;

import BibliotecaModelo.Livro;

public interface IRegra {
    public boolean condicoesEmprestimo(Usuario usuario, Livro livro);
}
