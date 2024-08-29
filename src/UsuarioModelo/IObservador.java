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
public interface IObservador {
    public void atualizar();
    public String consultarObservador();
    public boolean testarCodigo(String codigo);
}

