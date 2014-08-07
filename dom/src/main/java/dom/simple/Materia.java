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

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Materia {
	
	private String Nombre;	
	
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.1")
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	private String Programa;
	
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.2")
	public String getPrograma() {
		return Programa;
	}
	public void setPrograma(String programa) {
		Programa = programa;
	}
	
	private Personal Profesor;
	
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.3")
	public Personal getProfesor() {
		return Profesor;
	}
	public void setProfesor(Personal profesor) {
		Profesor = profesor;
	}
}
