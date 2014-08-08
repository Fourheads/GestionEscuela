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
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.joda.time.LocalDate;

@Named("Materias")
public class MateriaRepositorio {
	
	private Personal TraerPersonal(){
		Personal pe=container.newTransientInstance(Personal.class);
		pe.setApellido("lasjdas");
		pe.setNombre("Gogo");
		pe.setDni(213213213);
		pe.setNacionalidad(dom.simple.Persona.E_nacionalidad.ARGENTINA);
		new LocalDate();
		pe.setFechaNacimiento(LocalDate.now());
		pe.setSexo(dom.simple.Persona.E_sexo.MASCULINO);
		pe.setTelefono("123802183021");
		Funcion Fu=new Funcion();
		Fu.setNombre(dom.simple.Funcion.E_funciones.PRECEPTOR);
		pe.addFuncion(Fu);
		container.persistIfNotAlready(pe);
		container.flush();
		return pe;
		}
		/*
		container.persistIfNotAlready(pe);
		//******************************************************
		pe.setApellido("jojolas");
		pe.setNombre("MAgis");
		pe.setDni(2013123);
		pe.setSexo(dom.simple.Persona.E_sexo.FEMENINO);
		pe.setTelefono("4895789345");
		pe.addFuncion(Fu);
		container.persistIfNotAlready(pe);
		//******************************************************
		pe.setApellido("plapla");
		pe.setNombre("Dopolus");
		pe.setDni(32874243);
		pe.setSexo(dom.simple.Persona.E_sexo.MASCULINO);
		pe.setTelefono("857968973");
		pe.addFuncion(Fu);
		container.persistIfNotAlready(pe);
	}*/
    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    public String getId() {
        return "Materia";
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
    @Named ("Listar Materias")
    public List<Materia> listAll() {
        return container.allInstances(Materia.class);
    }
        

        // //////////////////////////////////////
        // Create (action)
        // //////////////////////////////////////
          
        
        @MemberOrder(sequence = "2")
        @Named ("Crear Materia")
        public Materia create(
                final @RegEx(validation = "[A-Za-z]+") @Named("Nombre") String Nombre,
                final @RegEx(validation = ".+") @MaxLength(2048)
		    	@MultiLine @Named("Programa") String Programa)//,
                //final @Named("Prceptor") Personal preceptor) {
        {
        	final Materia obj = container.newTransientInstance(Materia.class);
            obj.setNombre(Nombre);
            obj.setPrograma(Programa);
            obj.setProfesor(TraerPersonal());
            
            //¿Como sigo???
        	
            container.persistIfNotAlready(obj);
            return obj;
        }
        
        // //////////////////////////////////////
        // Injected services
        // //////////////////////////////////////

        @javax.inject.Inject 
        DomainObjectContainer container;
    }

