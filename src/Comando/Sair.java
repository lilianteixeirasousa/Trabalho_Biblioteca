/*
 * Definição da classe Sair.
 */
package Comando;

import Sistema.Trabalhador;

/**
 * Implementa a interface IComando
 */
public class Sair implements IComando {

    @Override
    public void executar(Parametro p) {
        Trabalhador.sair();
    }
    
}
