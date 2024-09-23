# chatApp

MVC

El objetivo de mi sistema es el registro de las conversaciones que ocurren
en un sistema de chat de atención a usuarios.
El diagrama de clases anterior representa una posible solución para un
sistema que registra las peticiones que se han gestionado por un chat de
atención a usuarios.
Cada conversación puede ser atendida por un agente humano o por un
agente bot.
Además cada conversación quedará registrada de manera unívoca por un
identificador que se generará con la fecha de registro de la conversación y
un número aleatorio.
De cada conversación deseamos guardar: el tipo de agente que la ha
atendido, la pregunta, la respuesta, así cómo la valoración recibida.
Deseamos poder: agregar una conversación, recuperar los datos de una
conversación, eliminarla, incrementar o modificar la valoración.
Además deseamos saber la valoración media obtenida tanto por los
agentes humanos como por los agentes de la inteligencia artificial.
Recuerda que en las clases repositorio deben ir toda la funcionalidad
relacionada con el CRUD (Crear, recuperar, actualizar y borrado) de
conversaciones en nuestra colección.
En el servicio, debemos ubicar la funcionalidad de filtrado, ordenación y
validación.
El servicio será invocado por la clase GestionaPeticionesAChat
(Controlador) que en nuestro ejemplo será un método main. Ya veremos
otras opciones en un futuro.
Ten en cuenta que los repositorios devuelven excepciones en algunos
casos, sin embargo, nuestra clase Servicio no (devuelve verdadero o falso si
se ha realizado la operación o ha recibido una excepción).

1. Implementa este diagrama de clases, así como las operaciones
   solicitadas.
2. En este modelo no existe persistencia de datos. De momento…. Intenta
   pensar en el modelo E/R y qué persistimos y qué no.

public interface IServicioConversaciones
{
public void registraNuevaConveracion(TipoAgente tipo, String pregunta,
String respuesta);
public Conversacion getRecuperaConversacion(TipoAgente tipo, String
pregunta, LocalDate fecha);
public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo)
throws ConversacionException;
public boolean incrementaNumeroValoraciones(LocalDate fecha,
TipoAgente tipo, String pregunta);
public double getValoracionMediaParaHumanos();
public double getValoracionMedidaParaBots();
}
public interface IRepositorioConversaciones {
/\*\*

- Operación que agrega una conversación
  **/
  public void agregaConversacion(TipoAgente tipo, String pregunta,
  String respuesta);
  /**
- Operación que recupera una conversación a partir de su fecha,
  pregunta y de su tipo de agente, si existieran varias --> devuelve la primera si
  no existe ninguna --> devuelve excepción
  **/
  public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo,
  String pregunta) throws ConversacionException;
  /** Operación que devuelve cierto si el repositorio una conversación
  **/
  public boolean contieneConversacionConversacion(Conversacion
  conversacion);
  /**
- Operación que elimina una conversación a partir de su fecha y de su
  tipo de agente, si existieran varias --> elimina la primera si no existe ninguna
  --> devuelve excepción
  **/
  public void eliminaConversacion(LocalDate fecha, TipoAgente
  tipo, String pregunta) throws ConversacionException;
  /**
- Incrementa el número de valoraciones en uno para un una
  conversacion a partir de su tipo, su fecha y su pregunta,
- si no la encuentra devuelve una excepcion del tipo
  ConversacionnException si encuentra varias, la incrementa en la primera
  \*/
  public void incrementaNumeroValoraciones(LocalDate fecha,
  TipoAgente tipo, String pregunta, double valoracion) throws
  ConversacionException;
  }

Consideraciones de Persistencia
Persistencia: Este modelo no incluye persistencia de datos. Para implementar la persistencia, podrías considerar utilizar una base de datos (relacional o no relacional) donde almacenar las conversaciones.

Modelo E/R:
Conversación: con atributos como id, fecha, tipoAgente, pregunta, respuesta, numeroValoraciones, y sumaValoraciones.
TipoAgente: que podría ser una tabla de referencia.
