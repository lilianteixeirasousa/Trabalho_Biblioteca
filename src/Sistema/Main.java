/*
 * Definição da classe main.
 */
package Sistema;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Repositorio repositorio = Repositorio.pegarInstancia();
        repositorio.iniciarDados();
        Entrada entrada = Entrada.pegarInstancia();
        
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.nextLine();
        while(true){
            entrada.executarComandos(comando);
            scanner = new Scanner(System.in);
            comando = scanner.nextLine();
        }
        
    }
}
