package dom.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Mask;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.query.QueryDefault;
import org.joda.time.LocalDate;

import dom.simple.Funcion.E_funciones;
import dom.simple.Localidad.E_localidades;
import dom.simple.Persona.E_nacionalidad;
import dom.simple.Persona.E_sexo;

@Named("Personal Educativo")
public class PersonalRepositorio {

	public String getId() {
        return "personal";
    }

    public String iconName() {
        return "SimpleObject";
    }
    
  //Listar personal
    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named ("Listar Personal")
    public List<Personal> listAll(){    	
    	return container.allInstances(Personal.class);
    }
    
//Crear personal
    
    @MemberOrder(sequence = "2")
    @Named ("Crear Personal")
    public Personal create(final @RegEx(validation = "[A-Za-z]+") @Named("Nombre") String nombre,
            final @RegEx(validation = "[A-Za-z]+") @Named("Apellido") String apellido,
            final @Named("Sexo") E_sexo sexo,
            final @RegEx(validation = "/d{6,10}") @Named("DNI") int dni, 
            final @Named("Fecha Nacimiento") LocalDate nacimiento,
            final @Named("Nacionalidad") E_nacionalidad nacionalidad,
            final @Named("Domicilio. Localidad") E_localidades localidad,
            final @Named("Domicilio. Calle") String calle,
            final @RegEx(validation = "/d{5}") @Named("Domicilio. Numero") int numero,
            final @RegEx(validation = "/d+")@org.apache.isis.applib.annotation.Optional @Named("Domicilio. Piso") String piso,
            final @org.apache.isis.applib.annotation.Optional @Named("Domicilio. Departamento") String departamento,
            @RegEx(validation = "/d+") @SuppressWarnings("deprecation") final @Mask("(NNNN)NNN-NNNNNNN") @org.apache.isis.applib.annotation.Optional @Named("TelÃ©fono") String telefono){
    	
    	final Personal newPersonal = container.newTransientInstance(Personal.class);
    	final Direccion newDireccion = new Direccion();
        final Localidad newLocalidad = new Localidad();
    	
        newLocalidad.setNombre(localidad);
        
        newDireccion.setCalle(calle);
        newDireccion.setDepartamento(departamento);
        newDireccion.setLocalidad(newLocalidad);
        newDireccion.setNumero(numero);
        newDireccion.setPiso(piso);
        
        newPersonal.setApellido(apellido);
        newPersonal.setDireccion(newDireccion);
        newPersonal.setDni(dni);
        newPersonal.setFechaNacimiento(nacimiento);
        newPersonal.setNacionalidad(nacionalidad);
        newPersonal.setNombre(nombre);
        newPersonal.setSexo(sexo);
        newPersonal.setTelefono(telefono);
        
        container.persistIfNotAlready(newPersonal);        
    	return newPersonal;
    }
    
    /*
    //Listar Preceptores {{
    
    @MemberOrder(sequence = "2")
    @Named ("Listar por Funcion")
    public List<Personal> ListByDni(
            final @Named("Funcion") E_funciones funcion){
		
		return listByFuncion(funcion);
		
	}
    
    @Programmatic
    public List<Personal> listByFuncion(E_funciones preceptor) {
        return container.allMatches(
            new QueryDefault<Personal>(Personal.class, 
                    "findByFuncion", 
                    "funcion", preceptor));
    }
    
    // }}
     
     */
    private LocalDate choices0FechaNacimiento()//VALIDAR FECHA!!!
	{
		LocalDate dt=new LocalDate();
		LocalDate dtmax=dt.now().year().withMaximumValue();
		return dt;
	}
    
    @javax.inject.Inject 
    DomainObjectContainer container;
}