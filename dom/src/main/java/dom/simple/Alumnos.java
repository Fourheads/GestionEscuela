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

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Mask;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
import org.joda.time.LocalDate;

import dom.simple.Localidad.E_localidades;
import dom.simple.Persona.E_nacionalidad;
import dom.simple.Persona.E_sexo;

///GestionEscuela

public class Alumnos {


    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    public String getId() {
        return "alumno";
    }

    public String iconName() {
        return "SimpleObject";
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////
    
    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named ("Listar Alumnos")
    public List<Alumno> listAll() {
        return container.allInstances(Alumno.class);
    }


    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "2")
    @Named ("Crear Alumno")
    public Alumno create(
            final @RegEx(validation = "[A-Za-z]+") @Named("Nombre") String nombre,
            final @RegEx(validation = "[A-Za-z]+") @Named("Apellido") String apellido,
            final @Named("Sexo") E_sexo sexo,
            final @Mask("NN.NNN.NNN") @Named("DNI") int dni,
            final @Named("Fecha Nacimiento") LocalDate nacimiento,
            final @Named("Nacionalidad") E_nacionalidad nacionalidad,
            final @Named("Domicilio. Localidad") E_localidades localidad,
            final @Named("Domicilio. Calle") String calle,
            final @Mask("NNNN") @Named("Domicilio. Numero") int numero,
            final @org.apache.isis.applib.annotation.Optional @Named("Domicilio. Piso") String piso,
            final @org.apache.isis.applib.annotation.Optional @Named("Domicilio. Departamento") String departamento,
            @SuppressWarnings("deprecation") final @Mask("(NNNN)NNN-NNNNNNN") @org.apache.isis.applib.annotation.Optional @Named("Teléfono") String telefono) {
        final Alumno obj = container.newTransientInstance(Alumno.class);
        final Direccion dire = new Direccion();
        final Localidad loca = new Localidad();
        final Legajo legajo = new Legajo();
        
        String propietario = nombre.substring(0, 1) + ". " + apellido; 
        
        loca.setNombre(localidad);
        
        dire.setCalle(calle);
        dire.setNumero(numero);
        dire.setPiso(piso);
        dire.setDepartamento(departamento);
        dire.setLocalidad(loca);
        
        legajo.setPropietario(propietario);
        
        obj.setSexo(sexo);
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setDni(dni);
        obj.setFechaNacimiento(nacimiento);
        obj.setDireccion(dire);
        obj.setLegajo(legajo);
        obj.setTelefono(telefono);
        
        
        container.persistIfNotAlready(obj);
        return obj;
    }

    // //////////////////////////////////////
    // Injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;
}
