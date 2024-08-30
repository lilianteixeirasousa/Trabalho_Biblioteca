/*
 * Definição da classe MensagemUsuário.
 */
package Sistema;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contém os métodos que imprimem as mensagens do sistema.
 */
public class MensagemSistema {
    
    private static String horario(){
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return ("["+sdt.format(new Date())+"]");
    }
    
    public static void reservaSucesso(String nomeUsuario, String tituloLivro){
        System.out.println(horario()+" "+nomeUsuario+" reservou "+tituloLivro+".\n");
    }
    
    public static void reservaRepetida(String nomeUsuario, String tituloLivro){
        System.out.println(horario()+" "+nomeUsuario+" já possui uma reserva para "+tituloLivro+".\n");
    }
    
    public static void limiteDeReservas(String nomeUsuario, String tituloLivro){
        System.out.println(horario()+" "+nomeUsuario+" não pode reservar "+tituloLivro+", pois já atingiu o limite de reservas.\n");
    }
    
    public static void emprestimoSucesso(String nomeUsuario, String tituloLivro, Date entrega){
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(horario()+" "+nomeUsuario+" está com "+tituloLivro+", e terá que devolver até "+sdt.format(entrega)+".\n");
    }
    
    public static void emprestimoNaoEncontrado(String nomeUsuario, String tituloLivro){
        System.out.println(horario()+" "+tituloLivro+" não foi encontrado em nenhum empréstimo de "+nomeUsuario+".\n");
    }
    
    public static void devolucaoSucesso(String nomeUsuario, String tituloLivro){
        System.out.println(horario()+" "+nomeUsuario+" devolveu "+tituloLivro+".\n");
    }
    
    public static void livroIndisponivel(String tituloLivro){
        System.out.println(horario()+" Nenhum exemplar de "+tituloLivro+" está disponível no momento.\n");
    }
    
    public static void livroReservado(String tituloLivro){
        System.out.println(horario()+" Todos os exemplares de "+tituloLivro+" estão reservados no momento.\n");
    }
    
    public static void emprestimoRepetido(String nomeUsuario, String tituloLivro){
        System.out.println(horario()+" "+nomeUsuario+", um exemplar de "+tituloLivro+" já está sobre sua posse atualmente.\n");
    }
    
    public static void usuarioDevedor(String nomeUsuario){
        System.out.println(horario()+" "+nomeUsuario+" não pode realizar nenhum empréstimo, pois há um livro em sua posse que não foi devolvido ainda.\n");
    }
    
    public static void maximoEmprestimo(String nomeUsuario){
        System.out.println(horario()+" "+nomeUsuario+" excedeu o limite de empréstimos.\n");
    }
    
    public static void inscritoComSucesso(String tituloLivro){
        System.out.println(horario()+" Mais um usuário observando "+tituloLivro+".\n");
    }
    
    public static void saindo(){
        System.out.println(horario()+" encerrando o sistema...");
    }
    
}
