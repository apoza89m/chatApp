package chatApp.model;

import java.time.LocalDate;
import java.util.Random;

public class Conversacion {

	private String id;
	private String pregunta;
	private String respuesta;
	private int valoracion;
	private LocalDate fechaConversacion;

	public enum TipoAgente {
		IA, HUMANO
	};

	private TipoAgente tipoAgente;
	private int numeroValoracionesPositivas;

	public Conversacion(TipoAgente tipoAgente, String pregunta, String respuesta) {
		this.fechaConversacion = LocalDate.now();
		this.tipoAgente = tipoAgente;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.numeroValoracionesPositivas = 0;
		this.id = calculaId();
	}

	public Conversacion(TipoAgente tipoAgente, String pregunta, String respuesta, LocalDate fecha, int valoracion) {
		this.fechaConversacion = fecha;
		this.tipoAgente = tipoAgente;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.numeroValoracionesPositivas = valoracion;
		this.id = calculaId();
	}

	public String calculaId() {
		String fechaString = fechaConversacion.toString().replace("-", "");
		Random random = new Random();
		int numeroAleatorio = random.nextInt(9000) + 1000;
		return fechaString + numeroAleatorio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public LocalDate getFechaConversacion() {
		return fechaConversacion;
	}

	public void setFechaConversacion(LocalDate fechaConversacion) {
		this.fechaConversacion = fechaConversacion;
	}

	public TipoAgente getTipoAgente() {
		return tipoAgente;
	}

	public void setTipoAgente(TipoAgente tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	public int getNumeroValoracionesPositivas() {
		return numeroValoracionesPositivas;
	}

	public void setNumeroValoracionesPositivas(int numeroValoracionesPositivas) {
		this.numeroValoracionesPositivas = numeroValoracionesPositivas;
	}

}
