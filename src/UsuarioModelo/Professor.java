/*
 * Define classe Professor.
 */
package UsuarioModelo;

import Sistema.Repositorio;

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
