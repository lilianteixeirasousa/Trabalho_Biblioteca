/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioModelo;

/**
 *
 * @author theou
 */
public class AlunoGrad extends Usuario {
    
    public AlunoGrad(String codigo, String nome) {
        super(codigo, nome, new RegraAluno(), 3, 3);
    } 
}
