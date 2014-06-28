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
public class Localidad {

	// {{ Nombre (property)
	private E_localidades nombre;

	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1")
	@Persistent
	public E_localidades getNombre() {
		return nombre;
	}

	public void setNombre(final E_localidades nombre) {
		this.nombre = nombre;
	}
	// }}


	public enum E_localidades{	
		Neuquen, Cipolletti, Plottier, Centenario, Roca, Allen;
	}
	
	public String title(){
		return nombre.toString();
	}

	@Override
	public String toString() {
		return nombre.toString();
	}
	
	
	
}
