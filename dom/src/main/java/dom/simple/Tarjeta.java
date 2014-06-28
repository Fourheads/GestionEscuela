/*
 * This is a software made for highschool management 
 * 
 * Copyright (C) 2014, Fourheads
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * 
 * 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
*/

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
		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(final LocalDate fecha) {
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
		public String getComentarios() {
			return comentarios;
		}

		public void setComentarios(final String comentarios) {
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
			CERTIFICACION, NOTAS, LLAMADO_DE_ATENCION;
		}

		@Override
		public int compareTo(Tarjeta o) {			
			return this.titulo.compareTo(o.titulo);
		}

		
	
}
