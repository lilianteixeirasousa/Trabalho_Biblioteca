/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Comando.ConsultarLivro;
import Comando.ConsultarNotificacoes;
import Comando.ConsultarUsuario;
import Comando.FazerReserva;
import Comando.IComando;
import Comando.Parametro;
import Comando.RealizarDevolucao;
import Comando.RealizarEmprestimo;
import Comando.RegistrarObservador;
import Comando.Sair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author theou
 */
public class Entrada {
    private static HashMap<String, IComando> comandos = new HashMap<String, IComando>();
    
    private Entrada() {
      iniciarComandos();
    }
    
    private static Entrada instancia;
    
    
    public static Entrada pegarInstancia(){
        if(instancia==null){
            instancia = new Entrada();
        }
        return instancia;
    }
    
    private void iniciarComandos() {
      comandos.put("emp", new RealizarEmprestimo());
      comandos.put("dev", new RealizarDevolucao());
      comandos.put("res", new FazerReserva());
      comandos.put("obs", new RegistrarObservador());
      comandos.put("liv", new ConsultarLivro());
      comandos.put("usu", new ConsultarUsuario());
      comandos.put("ntf", new ConsultarNotificacoes());
      comandos.put("sai", new Sair());
    }

    public void executarComandos(String comando) {
      ArrayList<String> chaves = new ArrayList<>();
      chaves.addAll(Arrays.asList(comando.split(" ")));
      if(chaves.size()==1){
          comandos.get(chaves.get(0)).executar(new Parametro());
      }
      else if(chaves.size()==2){
          comandos.get(chaves.get(0)).executar(new Parametro(chaves.get(1)));
      }
      else{
          comandos.get(chaves.get(0)).executar(new Parametro(chaves.get(1), chaves.get(2)));
      }
    }
}
