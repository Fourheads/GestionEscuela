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
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

@Named("Cursos")
public class CursoRepositorio {
	
    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    public String getId() {
        return "Curso";
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
    @Named ("Listar Cursos")
    public List<Curso> listAll() {
        return container.allInstances(Curso.class);
    }


    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////
      
    
    @MemberOrder(sequence = "2")
    @Named ("Crear curso")
    public Curso create(
            final @RegEx(validation = "[A-Ha-h]") @Named("Divicion") String divicion,
            @Named("Turno") Turno turno,
            final @RegEx(validation = "/d{1,1}") @Named("Año") int anio, 
            final @RegEx(validation = "[A-Za-z]+") @Named("Prceptor") Personal preceptor) {
        
    	final Curso obj = container.newTransientInstance(Curso.class);
        //final Personal pe=new Personal();
        
        obj.setAño(anio);
        obj.setDivision(divicion);
        obj.setTurno(turno);
        obj.setPreceptor(preceptor);
        
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
