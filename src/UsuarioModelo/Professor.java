/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioModelo;

import Sistema.Repositorio;

/**
 *
 * @author theou
 */
public class Professor extends Usuario implements IObservador{
    
    private int vezesNotificado;
    
    public Professor(String codigo, String nome) {
        super(codigo, nome, new RegraProfessor(), 7);
        vezesNotificado = 0;
        Repositorio.pegarInstancia().salvarObservador(this);
    }  

    @Override
    public void atualizar() {
        vezesNotificado++;
    }

    @Override
    public String consultarObservador() {
        return this.getNome()+" foi notificado(a) "+vezesNotificado+" vez(es) até agora.";
    }

    @Override
    public boolean testarCodigo(String codigo) {
        return this.getCodigo().equalsIgnoreCase(codigo);
    }
    
}
