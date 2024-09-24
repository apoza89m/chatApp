package chatApp.services;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;

import chatApp.exceptions.ConversacionException;
import chatApp.model.Conversacion;
import chatApp.model.Conversacion.TipoAgente;
import chatApp.repository.IRepositorioConversaciones;

public class ServicioConversaciones implements IServicioConversaciones {
	private IRepositorioConversaciones repositorio;

	public ServicioConversaciones(IRepositorioConversaciones repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void registraNuevaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		repositorio.agregaConversacion(tipo, pregunta, respuesta);
	}

	@Override
	public Conversacion getRecuperaConversacion(TipoAgente tipo, String pregunta, LocalDate fecha) {
		try {
			return repositorio.getConversacion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException {
		try {
			repositorio.eliminaConversacion(fecha, tipo);
			return true;
		} catch (ConversacionException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta) {
		try {
			repositorio.incrementaNumeroValoraciones(fecha, tipo, pregunta);
			return true;
		} catch (ConversacionException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public double getValoracionMediaParaHumanos() {
		List<Conversacion> conversaciones = repositorio.getConversaciones();
		OptionalDouble media = conversaciones.stream().filter(c -> c.getTipoAgente() == TipoAgente.HUMANO)
				.mapToDouble(Conversacion::getNumeroValoracionesPositivas).average();
		return media.orElse(0);
	}

	@Override
	public double getValoracionMediaParaBots() {
		List<Conversacion> conversaciones = repositorio.getConversaciones();
		OptionalDouble media = conversaciones.stream().filter(c -> c.getTipoAgente() == TipoAgente.IA)
				.mapToDouble(Conversacion::getNumeroValoracionesPositivas).average();
		return media.orElse(0);
	}
}
