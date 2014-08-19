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

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;

@javax.jdo.annotations.Queries( {
    @javax.jdo.annotations.Query(
            name = "DefautMateria", language = "JDOQL",
            //value = "SELECT "
            value="SELECT nombre, programa"
                    + " FROM dom.simple.Materia")
})

@PersistenceCapable
public class Materia {
	
	private String nombre;	
	
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.1")
	@Persistent
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private String programa;
	
	final @MaxLength(2048)
	@MultiLine 
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.2")
	@Persistent
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
	private Personal Profesor;
	
	@Column(allowsNull = "false")
	@MemberOrder(sequence = "1.3")
	@Persistent
	public Personal getProfesor() {
		return Profesor;
	}
	public void setProfesor(Personal profesor) {
		Profesor = profesor;
	}

	public String title(){
		String titulo=String.valueOf("Materia: "+getNombre());
		return titulo;
	}
	
}
