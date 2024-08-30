/*
 * Definição da classe Consultar Notificações.
 */
package Comando;

import Sistema.Repositorio;
import Sistema.Trabalhador;
import UsuarioModelo.IObservador;

/**
 * Implementa a interface IComando
 */
public class ConsultarNotificacoes implements IComando{

    @Override
    public void executar(Parametro p) {
        IObservador observador = Repositorio.pegarInstancia().pegarObservador(p.getPrimeiroParametro());
        
        Trabalhador.consultarObservador(observador);
    }   
    
}
