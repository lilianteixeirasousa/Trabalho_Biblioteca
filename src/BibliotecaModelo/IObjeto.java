/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecaModelo;

import UsuarioModelo.IObservador;

/**
 *
 * @author theou
 */
public interface IObjeto {
  public void registraObservador(IObservador o);
  public void removeObservador(IObservador o);
  public void notificaObservadores();
}
