/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioModelo;

import BibliotecaModelo.Exemplar;
import BibliotecaModelo.Livro;
import BibliotecaModelo.Emprestimo;
import Sistema.MensagemSistema;

/**
 *
 * @author theou
 */
public class RegraAluno implements IRegra{

    @Override
    public boolean condicoesEmprestimo(Usuario usuario, Livro livro) {
        
        if(usuario.testarAtraso()){
            MensagemSistema.usuarioDevedor(usuario.getNome());
            return false;
        }
        else if(usuario.testarLimiteEmprestimo()){
            MensagemSistema.maximoEmprestimo(usuario.getNome());
            return false;
        }
        else if(usuario.emprestimoRepetido(livro.getCodigo())){
            MensagemSistema.emprestimoRepetido(usuario.getNome(), livro.getTitulo());
        }
        
        Exemplar disponivel = livro.pegarExemplarDisponivel();
        if(disponivel!=null){
            if(livro.exemplarNaoReservado() || livro.usuarioReservou(usuario.getCodigo())){
                Emprestimo e = new Emprestimo(usuario, disponivel);
                disponivel.emprestado(e);
                usuario.incluirEmprestimo(e);
                MensagemSistema.emprestimoSucesso(usuario.getNome(), livro.getTitulo(), e.getPrevisaoEntrega());
                return true;
            }
            else{
                MensagemSistema.livroReservado(livro.getTitulo());
                return false;
            }
        }
        else{
            MensagemSistema.livroIndisponivel(livro.getTitulo());
            return false;
        }
    }
    
    
}
