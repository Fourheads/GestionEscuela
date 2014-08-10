package dom.simple;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.util.ObjectContracts;

import dom.simple.Funcion.E_funciones;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@ObjectType("PERSONAL")
@Bookmarkable

public class Personal extends Persona implements Comparable<Personal>{
	
	//@Column(allowsNull = "true", name = "FUNCIONES_ID")
	@MemberOrder(sequence = "1", name = "Nueva Funcion")
	@Named("Nueva Funcion")
	public Personal createFuncion(
			final @Named("Funcion") E_funciones funcion,
			final @MaxLength(2048)
	    	  	  @MultiLine 
	    	  	  @Named("Observaciones") String observaciones){
			
		final Funcion newFuncion = new Funcion();
			
		newFuncion.setObservaciones(observaciones);
		newFuncion.setNombre(funcion);
			
		addFuncion(newFuncion);
		return this;
			
	}
	
	
	
	// {{ Funciones (property)
	@Join
	@Element(column = "FUNCION", dependent = "true")
	private SortedSet<Funcion> funciones = new TreeSet<Funcion>();
	
	@Render(Type.EAGERLY)
	@MemberOrder(sequence = "1.1")
	public SortedSet<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(final SortedSet<Funcion> funciones) {
		this.funciones = funciones;
	}
	// }}
	
	
	
	//Agregar funcion
	@Hidden
	public void addFuncion(Funcion newFuncion){
		funciones.add(newFuncion);
	}
	
	public String title() {
		return getApellido() + ", " + getNombre();
	}

	@Override
	public int compareTo(Personal comparePersonal) {
		return ObjectContracts.compare(this, comparePersonal, "dni");
	}
}
