/*
* Classe de Definição do Livro
* */

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

      /*
    * Método que adiciona um exemplar na lista de exemplares.
    * */
    public void adicionarExemplar(Exemplar e){
        exemplares.add(e);
    }

     /*
    * Método para pegar o exemplar que estiver disponível.
    * */
    public Exemplar pegarExemplarDisponivel(){
        for (Exemplar e: exemplares){
            if(e.estaDisponivel()){return e;}
        }
        return null;
    }

     /*
    * Método que verifica se o exemplar está disponível.
    * */
    public boolean exemplarNaoReservado(){
        int livre = 0;
        for (Exemplar e: exemplares){
            if(e.estaDisponivel()){livre++;}
        }
        return (livre>reservas.size());
    }

     /*
    * Método que verifica se o usuário realizou reserva.
    * */
    public boolean usuarioReservou(String codigoUsuario){
        for(Reserva r: reservas){
            if(r.codigoUsuario().equalsIgnoreCase(codigoUsuario)){return true;}
        }
        return false;
    }

     /*
    * Método que adiciona reserva.
    * */
    public void incluirReserva(Reserva r){
        reservas.add(r);
        if(reservas.size()==3){
            notificaObservadores();
        }
    }

     /*
    * Método que cancela reserva.
    * */
    public void consumirReserva(String codigoUsuario){
        for(Reserva r: reservas){
            if(r.codigoUsuario().equalsIgnoreCase(codigoUsuario)){
                reservas.remove(r);
                break;
            }
        }
    }

     /*
    * Métodos para consultar reservas.
    * */
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

     /*
    * Métodos vinculados ao padrão observer, registrando, removendo e notificando observadores.
    * */
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
