/*
 * Classe que define as regras de empréstimo para o professor.
 */
package UsuarioModelo;

import BibliotecaModelo.Emprestimo;
import BibliotecaModelo.Exemplar;
import BibliotecaModelo.Livro;
import Sistema.MensagemSistema;


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
