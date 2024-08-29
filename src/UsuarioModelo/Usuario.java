/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioModelo;

import BibliotecaModelo.Emprestimo;
import BibliotecaModelo.Emprestimo;
import BibliotecaModelo.Reserva;
import BibliotecaModelo.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author theou
 */
public abstract class Usuario {
    private String codigo;
    private String nome;
    private IRegra regra;
    private int limiteDia;
    private int limiteEmprestimo;
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String codigo, String nome, IRegra regra, int limiteDia) {
        this.codigo = codigo;
        this.nome = nome;
        this.regra = regra;
        this.limiteDia = limiteDia;
    }
    
    public Usuario(String codigo, String nome, IRegra regra, int limiteDia, int limiteEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.regra = regra;
        this.limiteDia = limiteDia;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public IRegra getRegra() {
        return regra;
    }

    public int getLimiteDia() {
        return limiteDia;
    }
    
    public void incluirReserva(Reserva r){
        reservas.add(r);
    }
    
    public void incluirEmprestimo(Emprestimo e){
        emprestimos.add(e);
        String codigoLivro = e.codigoLivro();
        for(Reserva r: reservas){
            if(r.codigoLivro().equalsIgnoreCase(codigoLivro)){
                reservas.remove(r);
                break;
            }
        }
    }
    
    public Emprestimo pegarEmprestimo(String codigoLivro){
        for(Emprestimo e: emprestimos){
            if(e.codigoLivro().equalsIgnoreCase(codigoLivro))
            return e;
        }
        
        return null;
    }
    
    public boolean emprestimoRepetido(String codigoLivro){
        for(Emprestimo e: emprestimos){
            if(e.codigoLivro().equalsIgnoreCase(codigoLivro) && !e.getDevolvido()){
               return true; 
            }            
        }
        return false;
    }
    
    public boolean testarLimiteEmprestimo(){
        int emprestimosAtuais = 0;
        
        for(Emprestimo e: emprestimos){
            if(!e.getDevolvido()){emprestimosAtuais++;}
        }
        return (emprestimosAtuais==limiteEmprestimo);
    }
    
    public boolean testarAtraso(){
        Date hoje = new Date();
        for(Emprestimo e: emprestimos){
            if(!(e.estaEmDia(hoje)))
            return true;
        }
        
        return false;
    }
    
    public boolean testarLimiteReserva(){
        return (reservas.size()==3);
    }
    
    public String consultar(){
        String texto = texto=nome+" ("+codigo+")\n";
        texto+="EMPRÉSTIMOS: "+consultarEmprestimos();
        texto+="RESERVAS: "+consultarReservas();        
        return texto;
    }
    
    private String consultarEmprestimos(){
        String texto = emprestimos.size()+"\n";
        for(Emprestimo e: emprestimos){
            texto+=e.consultar()+"\n";
        }
        return texto;
    }
    
    private String consultarReservas(){
        String texto = reservas.size()+"\n";
        for(Reserva r: reservas){
            texto+=r.consultar()+"\n";
        }
        return texto;
    }
}
