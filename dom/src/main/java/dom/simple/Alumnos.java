package dom.simple;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

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
    public List<Alumno> listAll() {
        return container.allInstances(Alumno.class);
    }


    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////
    
    @MemberOrder(sequence = "2")
    public Alumno create(
            final @Named("Nombre") String nombre,
            final @Named("Apellido") String apellido,
            final @Named("Sexo") E_sexo sexo,
            final @Named("DNI") int dni,
            final @Named("Nacionalidad") E_nacionalidad nacionalidad,
            final @Named("Domicilio. Calle") String calle,
            final @Named("Domicilio. Numero") int numero,
            final @Named("Teléfono") String telefono) {
        final Alumno obj = container.newTransientInstance(Alumno.class);
        //final Direccion dire = new Direccion();
        
       
        String propietario = nombre.substring(0, 1) + ". " + apellido; 
        //dire.setCalle(calle);
        //dire.setNumero(numero);
        //legajo.setPropietario(propietario);
        obj.setSexo(sexo);
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setDni(dni);
        //obj.setDireccion(dire);
        
        container.persistIfNotAlready(obj);
        return obj;
    }

    // //////////////////////////////////////
    // Injected services
    // //////////////////////////////////////

    @javax.inject.Inject 
    DomainObjectContainer container;
}
