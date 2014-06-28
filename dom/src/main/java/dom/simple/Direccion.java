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

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Direccion {

	// {{ Calle (property)
	private String calle;

	@Column(allowsNull = "true", name = "LOCALIDAD_ID")
	@Persistent
	@MemberOrder(sequence = "1")
	public String getCalle() {
		return calle;
	}

	public void setCalle(final String calle) {
		this.calle = calle;
	}
	// }}


	// {{ Numero (property)
	private int numero;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.1")
	public int getNumero() {
		return numero;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}
	// }}

	// {{ Piso (property)
	private String piso;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.1.1")
	public String getPiso() {
		return piso;
	}

	public void setPiso(final String piso) {
		this.piso = piso;
	}
	// }}


	// {{ Departamento (property)
	private String departamento;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.1.2")
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(final String departamento) {
		this.departamento = departamento;
	}
	// }}


	
	
	// {{ Localidad (property)
	private Localidad localidad;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.2")
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(final Localidad localidad) {
		this.localidad = localidad;
	}
	// }}

	public String title(){
		return calle + " " + numero;
	}
}
