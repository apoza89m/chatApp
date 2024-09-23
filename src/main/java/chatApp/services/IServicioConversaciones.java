package chatApp.services;

import java.time.LocalDate;

import chatApp.exceptions.ConversacionException;
import chatApp.model.Conversacion;
import chatApp.model.Conversacion.TipoAgente;

public interface IServicioConversaciones {
	public void registraNuevaConveracion(TipoAgente tipo, String pregunta, String respuesta);

	public Conversacion getRecuperaConversacion(TipoAgente tipo, String pregunta, LocalDate fecha);

	public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException;

	public boolean incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta);

	public double getValoracionMediaParaHumanos();

	public double getValoracionMedidaParaBots();
}
