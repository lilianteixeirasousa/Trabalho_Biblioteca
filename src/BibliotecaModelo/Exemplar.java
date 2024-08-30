/*
* Classe de Definição de um Exemplar de um Livro.
* */
package BibliotecaModelo;

import java.text.SimpleDateFormat;

/**
 * instancia
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
    /*
    * Método público que verifica se o Exemplar está disponível.
    * */
    
    public boolean estaDisponivel(){
        return (emprestimo==null);
    }


     /*
    * Método público que empresta livro reservado.
    * */
    
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


     /*
    * Método público para encerrar emprestimo.
    * */
    
    public void encerrarEmprestimo(){
        emprestimo = null;
    }

     /*
    * Método público que retorna a situação do Exemplar, se está disponível ou emprestado.
    * */
    
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
