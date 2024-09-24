package chatApp.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import chatApp.exceptions.ConversacionException;
import chatApp.model.Conversacion;
import chatApp.model.Conversacion.TipoAgente;

public class RepositorioConversaciones implements IRepositorioConversaciones {
	private List<Conversacion> conversaciones;

	public RepositorioConversaciones() {
		conversaciones = new ArrayList<>();
	}

	@Override
	public void agregaConversacion(TipoAgente tipoAgente, String pregunta, String respuesta) {
		Conversacion conversacion = new Conversacion(tipoAgente, pregunta, respuesta);
		conversaciones.add(conversacion);
	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipoAgente, String pregunta)
			throws ConversacionException {
		for (Conversacion conversacion : conversaciones) {
			if (conversacion.getFechaConversacion().equals(fecha) && conversacion.getTipoAgente() == tipoAgente
					&& conversacion.getPregunta().equalsIgnoreCase(pregunta)) {
				return conversacion;
			}
		}
		throw new ConversacionException("Conversación no encontrada");
	}

	@Override
	public boolean contieneConversacion(Conversacion conversacion) {
		return conversaciones.contains(conversacion);
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipoAgente) throws ConversacionException {
		for (Conversacion conversacion : conversaciones) {
			if (conversacion.getFechaConversacion().equals(fecha) && conversacion.getTipoAgente() == tipoAgente) {
				conversaciones.remove(conversacion);
				return;
			}
		}
		throw new ConversacionException("No existe la conversación para eliminar");
	}

	@Override
	public void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipoAgente, String pregunta)
			throws ConversacionException {
		Conversacion conversacion = getConversacion(fecha, tipoAgente, pregunta);
		conversacion.setNumeroValoracionesPositivas(conversacion.getNumeroValoracionesPositivas() + 1);
	}

	@Override
	public List<Conversacion> getConversaciones() {
		return conversaciones;
	}
}
