/*
 *Define classe AlunoGrad(uação).
 */
package UsuarioModelo;

public class AlunoGrad extends Usuario {
    
    public AlunoGrad(String codigo, String nome) {
        super(codigo, nome, new RegraAluno(), 3, 3);
    } 
}
