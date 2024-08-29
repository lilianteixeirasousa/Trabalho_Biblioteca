/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comando;

/**
 *
 * @author theou
 */
public class Parametro {
    private String primeiroParametro;
    private String segundoParametro;

    public Parametro() {}
    
    public Parametro(String primeiroParametro) {
        this.primeiroParametro = primeiroParametro;
    }

    public Parametro(String primeiroParametro, String segundoParametro) {
        this.primeiroParametro = primeiroParametro;
        this.segundoParametro = segundoParametro;
    }

    public String getPrimeiroParametro() {
        return primeiroParametro;
    }

    public String getSegundoParametro() {
        return segundoParametro;
    }
    
    
}
