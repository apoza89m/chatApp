package chatApp.repository;

import java.time.LocalDate;
import java.util.Set;

import chatApp.exceptions.ConversacionException;
import chatApp.model.Conversacion;
import chatApp.model.Conversacion.TipoAgente;

public interface IRepositorioConversaciones {
	/**
	 * Operación que agrega una conversación
	 **/
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta);

	/**
	 * Operación que recupera una conversación a partir de su fecha, pregunta y de
	 * su tipo de agente, si existieran varias --> devuelve la primera si no existe
	 * ninguna --> devuelve excepción
	 **/
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipos, String pregunta)
			throws ConversacionException;

	/**
	 * Operación que devuelve cierto si el repositorio una conversación
	 **/
	public boolean contieneConversacion(Conversacion conversacion);

	/**
	 * Operación que elimina una conversación a partir de su fecha y de su tipo de
	 * agente, si existieran varias --> elimina la primera si no existe ninguna -->
	 * devuelve excepción
	 **/
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException;

	/**
	 * Incrementa el número de valoraciones en uno para un una conversacion a partir
	 * de su tipo, su fecha y su pregunta, si no la encuentra devuelve una excepcion
	 * del tipo ConversacionnException si encuentra varias, la incrementa en la
	 * primera
	 */
	public void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta)
			throws ConversacionException;

	public Set<Conversacion> getConversaciones();
}
