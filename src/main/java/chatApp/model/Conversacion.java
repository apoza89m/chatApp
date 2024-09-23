package chatApp.model;

import java.time.LocalDate;

public class Conversacion {
	
	private String id;
	private String pregunta;
	private String respuesta;
	private int valoracion;
	private LocalDate fechaConversacion;
	public enum TipoAgente{IA, HUMANO};
	
	
	public Conversacion(String pregunta, String respuesta, int valoracion) {
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.valoracion = valoracion;
		this.fechaConversacion = LocalDate.now();
		this.id = fechaConversacion.toString() + Math.random();
				
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
	
	
	

}
