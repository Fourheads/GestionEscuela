package dom.simple;

import javax.jdo.annotations.*;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;

public class Tarjeta {
	
	// {{ Titulo (property)
		private String titulo;

		@Column(allowsNull = "true")
		@Persistent
		@MemberOrder(sequence = "1")
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
		public String getDetalle() {
			return comentarios;
		}

		public void setDetalle(final String comentarios) {
			this.comentarios = comentarios;
		}
		// }}

		
	
}
