/*
 * Definição da interface objeto
 * Padrão Observer
 */

package BibliotecaModelo;

import UsuarioModelo.IObservador;

/**
 * métodos vazios de registrar, remover e notificar observadores.
 */
public interface IObjeto {
  public void registraObservador(IObservador o);
  public void removeObservador(IObservador o);
  public void notificaObservadores();
}
