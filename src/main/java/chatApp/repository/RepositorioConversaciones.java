package chatApp.repository;

import java.time.LocalDate;

import chatApp.exceptions.ConversacionException;
import chatApp.model.Conversacion;
import chatApp.model.Conversacion.TipoAgente;

public class RepositorioConversaciones implements IRepositorioConversaciones {

	@Override
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta)
			throws ConversacionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contieneConversacionConversacion(Conversacion conversacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta, double valoracion)
			throws ConversacionException {
		// TODO Auto-generated method stub

	}

}
