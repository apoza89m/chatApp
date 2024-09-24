package chatApp.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Conversacion implements Comparable<Conversacion>, Comparator<Conversacion> {

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversacion other = (Conversacion) obj;
		return Objects.equals(id, other.id);
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
		// 0 - 999
		int numeroAleatorio = random.nextInt(1000);
		return fechaString + numeroAleatorio;
	}

	@Override
	public String toString() {
		return "Conversacion [id=" + id + ", tipoAgente=" + tipoAgente + ", pregunta=" + pregunta + ", respuesta="
				+ respuesta + ", valoracion=" + valoracion + ", fechaConversacion=" + fechaConversacion
				+ ", numeroValoracionesPositivas=" + numeroValoracionesPositivas + "]";
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

	@Override
	public int compareTo(Conversacion o) {
		int tipoComparacion = o.getTipoAgente().compareTo(this.tipoAgente);
		// Si tienen el mismo tipo de agente, comparamos por ID
		if (tipoComparacion == 0) {
			return this.id.compareTo(o.id);
		}
		return tipoComparacion;

	}

	@Override
	public int compare(Conversacion o1, Conversacion o2) {
		return o2.getTipoAgente().compareTo(o1.getTipoAgente());
	}

}
