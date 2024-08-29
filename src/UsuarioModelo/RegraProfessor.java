/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioModelo;

import BibliotecaModelo.Emprestimo;
import BibliotecaModelo.Exemplar;
import BibliotecaModelo.Livro;
import Sistema.MensagemSistema;

/**
 *
 * @author theou
 */
public class RegraProfessor implements IRegra{

    @Override
    public boolean condicoesEmprestimo(Usuario usuario, Livro livro) {
        if(usuario.testarAtraso()){
            MensagemSistema.usuarioDevedor(usuario.getNome());
            return false;
        }
        
        Exemplar disponivel = livro.pegarExemplarDisponivel();
        if(disponivel!=null){
            Emprestimo e = new Emprestimo(usuario, disponivel);
            disponivel.emprestado(e);
            usuario.incluirEmprestimo(e);
            MensagemSistema.emprestimoSucesso(usuario.getNome(), livro.getTitulo(), e.getPrevisaoEntrega());
            return true;
        }
        else{
            MensagemSistema.livroIndisponivel(livro.getTitulo());
            return false;
        }
    }
    
}
