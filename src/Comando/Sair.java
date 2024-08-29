/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comando;

import Sistema.Trabalhador;

/**
 *
 * @author theou
 */
public class Sair implements IComando {

    @Override
    public void executar(Parametro p) {
        Trabalhador.sair();
    }
    
}
