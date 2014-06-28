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

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.joda.time.LocalDate;

import dom.simple.Tarjeta.ECategoria;

//GestionEscuela

@PersistenceCapable
public class Legajo {	

	@Column(allowsNull = "true", name = "TARJETAS_ID")
	@MemberOrder(sequence = "1.1", name = "Nueva Tarjeta")
	@Named("Nueva Tarjeta")
	public Legajo create (
			final @Named("Titulo") String titulo,
			final @MaxLength(2048)
		    	  @MultiLine 
		    	  @Named("Comentarios") String comentario,
		    final @Named("Categoria de Tarjeta") ECategoria categoria	  
			){
		
		final Tarjeta tarjeta = new Tarjeta();
		LocalDate fecha = LocalDate.now();
		
		tarjeta.setTitulo(titulo);
		tarjeta.setComentarios(comentario);
		tarjeta.setFecha(fecha);
		tarjeta.setCategoria(categoria);
		addTarjeta(tarjeta);
		
		//container.persistIfNotAlready(tarjeta);
		addTarjeta(tarjeta);
		return this;
	}
	
	// {{ Tarjetas (property)
	@Element(column = "TARJETA", dependent = "false") //EN dependent DEBERÍA IR true, ¿verdad?.
	private SortedSet<Tarjeta> tarjetas = new TreeSet<Tarjeta>();
	
	//@Persistent
	@Render(Type.EAGERLY)
	@MemberOrder(sequence = "1")
	public SortedSet<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(final SortedSet<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	// }}

	
	// {{ Propietario (property)
	private String propietario;
	
	@Hidden
	@MemberOrder(sequence = "1.1")
	@Column(allowsNull = "false")
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(final String propietario) {
		this.propietario = propietario;
	}
	// }}

	@Hidden
	public void addTarjeta(Tarjeta tarjeta){
		this.tarjetas.add(tarjeta);			
	}
		
	public String title(){
		return "Legajo de " + getPropietario();
	}
	
	 @javax.inject.Inject 
	 DomainObjectContainer container;
	
}
