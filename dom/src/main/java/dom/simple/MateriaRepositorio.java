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

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.query.QueryDefault;
import org.joda.time.LocalDate;

import com.google.common.base.Predicate;

@Named("Materias")
public class MateriaRepositorio {
	
	
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
    public List<Materia> complete() {
        final List<Materia> items = listAll();
       //for (int i = 0; i < items.size(); i++) {
    	 //  items.get(i).setProfesor(DefautPersonal());		
	//}
        
        // List<String> LSMate=new ArrayList<String>();
       /*
        for (Materia materia : items) {
        	materia.setProfesor(DefautPersonal());
        	//LSMate.add(materia.getNombre()+" "+materia.getPrograma());
		}*/
        //return LSMate;
        return items;
    }
/*    
private Personal DefautPersonal(){
    	Personal pe=new Personal();
    			pe.setApellido(" ");
    			pe.setNombre(" ");
    			pe.setDni(0);
    			pe.setNacionalidad(dom.simple.Persona.E_nacionalidad.OTRO);
    			new LocalDate();
    			pe.setFechaNacimiento(LocalDate.now());
    			pe.setSexo(dom.simple.Persona.E_sexo.MASCULINO);
    			pe.setTelefono(" ");
    			Funcion Fu=new Funcion();
    			Fu.setNombre(dom.simple.Funcion.E_funciones.PRECEPTOR);
    			pe.addFuncion(Fu);
    		return pe;
    }    
    */
    
    
    @Programmatic
    public List<Materia> listAll() {
        //long range=2;
    	return container.allMatches(
                new QueryDefault<Materia>(Materia.class, 
                        "DefautMateria"));
		//return container.allInstances(Materia.class,range);
    	 //return container.allMatches(
           //      new QueryDefault<Materia>(Materia.class, 
             //            "blabla 1", 
               //          "blabla 2", "blabla 3"));
    }
        

        // //////////////////////////////////////
        // Create (action)
        // //////////////////////////////////////
          
        
        @MemberOrder(sequence = "2")
        @Named ("Crear Materia")
        public Materia create(
                final @RegEx(validation = "[A-Za-z]+") @Named("Nombre") String Nombre,
                final @RegEx(validation = ".+") @MaxLength(2048)
		    	@MultiLine @Named("Programa") String Programa)
        {
        	final Materia obj = container.newTransientInstance(Materia.class);
            obj.setNombre(Nombre);
            obj.setPrograma(Programa);
        	
            container.persistIfNotAlready(obj);
            return obj;
        }
        
        // //////////////////////////////////////
        // Injected services
        // //////////////////////////////////////

        @javax.inject.Inject 
        DomainObjectContainer container;
    }

