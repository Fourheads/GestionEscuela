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

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@javax.jdo.annotations.Queries( {
    @javax.jdo.annotations.Query(
            name = "findByDni", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.Alumno "
                    + "WHERE dni == :dni"),
    @javax.jdo.annotations.Query(
            name = "findByApellido", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.Alumno "
                    + "WHERE apellido.startsWith(:apellido)")
})
@ObjectType("ALUMNO")
@Bookmarkable


///GestionEscuela


public class Alumno extends Persona implements Comparable<Alumno>{

	
	
	// {{ Legajo (property)
	private Legajo legajo;

	@Persistent
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false", name = "LEGAJO_ID")
	@Hidden(where = Where.ALL_TABLES)
	public Legajo getLegajo() {
		return legajo;
	}

	public void setLegajo(final Legajo legajo) {
		this.legajo = legajo;
	}
	// }}


	
	
	
	
	
	
	
	@Override
	public int compareTo(Alumno alumno) {
		
		return ObjectContracts.compare(this, alumno, "dni");
	}


	public String title() {
			return getApellido() + ", " + getNombre();
		}
	
	@javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
	
}
