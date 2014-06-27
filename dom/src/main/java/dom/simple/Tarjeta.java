package dom.simple;

import javax.jdo.annotations.*;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.joda.time.LocalDate;

@PersistenceCapable
public class Tarjeta implements Comparable<Tarjeta>{
	
		
	// {{ Fecha (property)
		private LocalDate fecha;

		@Persistent
		@MemberOrder(sequence = "1")
		@javax.jdo.annotations.Column(allowsNull="false")
		public LocalDate getFechaNacimiento() {
			return fecha;
		}

		public void setFechaNacimiento(final LocalDate fecha) {
			this.fecha = fecha;
		}
		// }}
	
	
		// {{ Titulo (property)
		private String titulo;

		@Column(allowsNull = "false")
		@Persistent
		@MemberOrder(sequence = "1.1")
		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(final String titulo) {
			this.titulo = titulo;
		}
		// }}

		// {{ Comentarios (property)
		private String comentarios;
		
		@Column(allowsNull = "true")
		@Persistent
		@MemberOrder(sequence = "1.2")
		@MultiLine
		public String getComentario() {
			return comentarios;
		}

		public void setComentario(final String comentarios) {
			this.comentarios = comentarios;
		}
		// }}
		
		// {{ Categoria (property)
		private ECategoria categoria;
		
		@Column(allowsNull = "false")
		@Persistent
		@MemberOrder(sequence = "1.3")
		public ECategoria getCategoria() {
			return categoria;
		}

		public void setCategoria(final ECategoria categoria) {
			this.categoria = categoria;
		}
		// }}


		//Considerar los tipos de categoría. No sé muy bien cuales son.
		//No los habiamos discutido, esos estan buenisimos (leo)
		public enum ECategoria{
			Certificacion, Notas, LlamadoDeAtencion;
		}

		@Override
		public int compareTo(Tarjeta o) {			
			return this.titulo.compareTo(o.titulo);
		}

		
	
}
