/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaModelo;

import UsuarioModelo.IObservador;
import UsuarioModelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author theou
 */
public class Livro implements IObjeto{
    
    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private int edicao;
    private int ano;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Reserva> reservas;
    private ArrayList<IObservador> inscritos;

    public Livro(String codigo, String titulo, String editora, String autores, int edicao, int ano) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.ano = ano;
        this.exemplares = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.inscritos = new ArrayList<>();
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void adicionarExemplar(Exemplar e){
        exemplares.add(e);
    }
    
    public Exemplar pegarExemplarDisponivel(){
        for (Exemplar e: exemplares){
            if(e.estaDisponivel()){return e;}
        }
        return null;
    }
    
    public boolean exemplarNaoReservado(){
        int livre = 0;
        for (Exemplar e: exemplares){
            if(e.estaDisponivel()){livre++;}
        }
        return (livre>reservas.size());
    }
    
    public boolean usuarioReservou(String codigoUsuario){
        for(Reserva r: reservas){
            if(r.codigoUsuario().equalsIgnoreCase(codigoUsuario)){return true;}
        }
        return false;
    }
    
    public void incluirReserva(Reserva r){
        reservas.add(r);
        if(reservas.size()==3){
            notificaObservadores();
        }
    }
    
    public void consumirReserva(String codigoUsuario){
        for(Reserva r: reservas){
            if(r.codigoUsuario().equalsIgnoreCase(codigoUsuario)){
                reservas.remove(r);
                break;
            }
        }
    }
    
    public String consultar(){
        String texto = titulo+"("+codigo+")\n";
        texto+="RESERVAS: "+consultarReservas();
        texto+="EXEMPLARES: "+consultarExemplares();
        return texto;
    }
    
    private String consultarReservas(){
        if(reservas.size()==0){
            return "Nenhuma reserva.\n";
        }
        else{
            String texto = reservas.size()+"\n";
            for(Reserva r: reservas){
                texto+="- "+r.nomeUsuario()+"\n";
            }
            return texto;
        }
    }
    
    private String consultarExemplares(){
        String texto = exemplares.size()+"\n";
        for(Exemplar e: exemplares){
            texto+=e.consultar()+"\n";
        }
        return texto;
    }

    @Override
    public void registraObservador(IObservador o) {
        inscritos.add(o);
    }

    @Override
    public void removeObservador(IObservador o) {
        inscritos.remove(o);
    }

    @Override
    public void notificaObservadores() {
        for(IObservador o: inscritos){
            o.atualizar();
        }
    }
}
