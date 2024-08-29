/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.util.Scanner;


/**
 *
 * @author theou
 */
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
