/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaModelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author theou
 */
public class Exemplar {
    private String codigoExemplar;
    private Livro livro;
    private Emprestimo emprestimo;

    public Exemplar(String codigoExemplar, Livro livro) {
        this.codigoExemplar = codigoExemplar;
        this.livro = livro;
        this.emprestimo = null;
    }
    
    public boolean estaDisponivel(){
        return (emprestimo==null);
    }
    
    public void emprestado(Emprestimo e){
        emprestimo = e;
        livro.consumirReserva(e.codigoUsuario());
    }
    
    public String codigoLivro(){
        return livro.getCodigo();
    }
    
    public String tituloLivro(){
        return livro.getTitulo();
    }
    
    public void encerrarEmprestimo(){
        emprestimo = null;
    }
    
    public String consultar(){
        if (emprestimo==null){
            return "- "+codigoExemplar+" [Disponível]";
        }
        else{
            SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
            return "- "+codigoExemplar+" [Emprestado]\n→ Por "+emprestimo.nomeUsuario()+", desde "+sdt.format(emprestimo.getDiaInicial())+" até "+sdt.format(emprestimo.getPrevisaoEntrega())+"";
        }
    }
}
