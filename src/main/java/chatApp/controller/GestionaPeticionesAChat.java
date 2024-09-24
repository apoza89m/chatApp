package chatApp.controller;

import java.util.Set;

import chatApp.exceptions.ConversacionException;
import chatApp.model.Conversacion;
import chatApp.model.Conversacion.TipoAgente;
import chatApp.repository.IRepositorioConversaciones;
import chatApp.repository.RepositorioConversaciones;

public class GestionaPeticionesAChat {
	public static void main(String[] args) throws ConversacionException {

		System.out.println("Bienvenido a chatApp\n");

		IRepositorioConversaciones repositorio = new RepositorioConversaciones();

		// Conversacion c1 = new Conversacion(TipoAgente.HUMANO, "¿Como estas?",
		// "bien");
		// Conversacion c2 = new Conversacion(TipoAgente.IA, "¿Como no estas?", "mal");

		repositorio.agregaConversacion(TipoAgente.HUMANO, "¿Como estas?", "Bien");
		repositorio.agregaConversacion(TipoAgente.IA, "¿Como no estas?", "Mal");
		repositorio.agregaConversacion(TipoAgente.IA, "¿aaaaaaaa?", "a");
		repositorio.agregaConversacion(TipoAgente.HUMANO, "¿bbbbbb?", "b");
		repositorio.agregaConversacion(TipoAgente.IA, "¿ccccccc?", "c");
		repositorio.agregaConversacion(TipoAgente.HUMANO, "¿ddddddd?", "d");
		repositorio.agregaConversacion(TipoAgente.IA, "¿eeeeeee?", "e");

		System.out.println(repositorio.getConversaciones().size() + " conversaciones.\n");

		Set<Conversacion> conversaciones = repositorio.getConversaciones();

		conversaciones.forEach(c -> System.out.println(c.getId() + " - " + c.getTipoAgente() + ": " + c.getPregunta()));

		/*
		 * for (Conversacion c : conversaciones) { System.out.println(c); }
		 */

		/*
		 * // Inicializar repositorio y servicio IRepositorioConversaciones repositorio
		 * = new RepositorioConversaciones(); IServicioConversaciones servicio = new
		 * ServicioConversaciones(repositorio);
		 * 
		 * // 1. Registrar nuevas conversaciones
		 * servicio.registraNuevaConversacion(TipoAgente.HUMANO, "¿Cómo está el clima?",
		 * "El clima está soleado."); servicio.registraNuevaConversacion(TipoAgente.IA,
		 * "¿Qué hora es?", "Son las 3 PM.");
		 * 
		 * // 2. Recuperar una conversación LocalDate fecha = LocalDate.now();
		 * Conversacion conversacion =
		 * servicio.getRecuperaConversacion(TipoAgente.HUMANO, "¿Cómo está el clima?",
		 * fecha); if (conversacion != null) { System.out.println(
		 * "Conversación recuperada: " + conversacion.getPregunta() + " - " +
		 * conversacion.getRespuesta()); }
		 * 
		 * boolean incrementado = servicio.incrementaNumeroValoraciones(fecha,
		 * TipoAgente.HUMANO, "¿Cómo está el clima?"); System.out.println(incrementado ?
		 * "Valoración incrementada para humano." :
		 * "No se pudo incrementar la valoración para humano.");
		 * 
		 * // 4. Obtener valoraciones medias
		 * System.out.println("Valoración media para humanos: " +
		 * servicio.getValoracionMediaParaHumanos());
		 * System.out.println("Valoración media para bots: " +
		 * servicio.getValoracionMediaParaBots());
		 * 
		 * // 5. Eliminar una conversación try { boolean eliminado =
		 * servicio.eliminaConversacion(fecha, TipoAgente.HUMANO);
		 * System.out.println(eliminado ? "Conversación eliminada." :
		 * "No se pudo eliminar la conversación."); } catch (ConversacionException e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * // 6. Intentar recuperar la conversación eliminada Conversacion
		 * conversacionEliminada = servicio.getRecuperaConversacion(TipoAgente.HUMANO,
		 * "¿Cómo está el clima?", fecha); if (conversacionEliminada != null) {
		 * System.out.println( "Conversación recuperada después de la eliminación: " +
		 * conversacionEliminada.getPregunta()); }
		 * 
		 * // 7. Registrar más conversaciones para realizar pruebas adicionales
		 * servicio.registraNuevaConversacion(TipoAgente.IA, "¿Cuál es tu nombre?",
		 * "Soy un asistente virtual.");
		 * servicio.registraNuevaConversacion(TipoAgente.HUMANO, "¿Cómo te sientes?",
		 * "Me siento genial.");
		 * 
		 * // 8. Mostrar todas las conversaciones registradas
		 * System.out.println("\nConversaciones registradas:"); for (Conversacion c :
		 * repositorio.getConversaciones()) { System.out.println("ID: " + c.getId() +
		 * ", Tipo: " + c.getTipoAgente() + ", Pregunta: " + c.getPregunta() +
		 * ", Respuesta: " + c.getRespuesta()); }
		 */
	}
}
