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
        
        newDireccion.setCalle(calle.toUpperCase());
        newDireccion.setDepartamento(departamento);
        newDireccion.setLocalidad(newLocalidad);
        newDireccion.setNumero(numero);
        newDireccion.setPiso(piso);
        
        newPersonal.setApellido(apellido.toLowerCase());
        newPersonal.setDireccion(newDireccion);
        newPersonal.setDni(dni);
        newPersonal.setFechaNacimiento(nacimiento);
        newPersonal.setNacionalidad(nacionalidad);
        newPersonal.setNombre(nombre.toUpperCase());
        newPersonal.setSexo(sexo);
        newPersonal.setTelefono(telefono);
        
        container.persistIfNotAlready(newPersonal);        
    	return newPersonal;
    }
    
    
    // LISTADOS//
        
    //Listar personal
    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named ("Listar Personal")
    public List<Personal> listAll(){    	
    	return container.allInstances(Personal.class);
    }
    
    
    //Listar Preceptores
    
    @MemberOrder(sequence = "1.1")
    @ActionSemantics(Of.SAFE)
    @Named ("Preceptores")
    public List<Personal> listPreceptor(){
    	return container.allMatches(
    			new QueryDefault<Personal>(Personal.class, "findPreceptores"));
    }
    
    /* @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    @Named ("Preceptores")    
    public List<Personal> listByPreceptor(){   	  	
    	
    	return container.allMatches(
    			new QueryDefault<Personal>(Personal.class,
    					"findPreceptores"));
    	
    	
    }*/
    
    
    //Listar Profesores
    
    @MemberOrder(sequence = "1.2")
    @Named ("Profesores")
    public List<Personal> listProfesor(){
    	return container.allMatches(
    			new QueryDefault<Personal>(Personal.class, "findProfesores"));
    }
    
    //Listar Directores
    
    @MemberOrder(sequence = "1.3")
    @Named ("Directores")
    public List<Personal> listDirector(){
    	return container.allMatches(
    			new QueryDefault<Personal>(Personal.class, "findDirectores"));
    }
    
    //Listar Secretarios
    
    @MemberOrder(sequence = "1.4")
    @Named ("Secretarios")
    public List<Personal> listSecretario(){
    	return container.allMatches(
    			new QueryDefault<Personal>(Personal.class, "findSecretarios"));
    }
    
    
    // FIN LISTADOS //
    
    private LocalDate choices0FechaNacimiento()//VALIDAR FECHA!!!
	{
		LocalDate dt=new LocalDate();
		LocalDate dtmax=dt.now().year().withMaximumValue();
		return dt;
	}
    
    @javax.inject.Inject 
    DomainObjectContainer container;
}
