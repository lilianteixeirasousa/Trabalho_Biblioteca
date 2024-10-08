/*
 * Definição da classe parâmetro.
 */
package Comando;

/**
 * instancia os parâmetros para realizar as ações de devolução, empréstimo, reserva e registro de observadores.
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
