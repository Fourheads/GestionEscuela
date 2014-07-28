package dom.simple;

import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("PERSONAL")
@Bookmarkable

public class Personal extends Persona implements Comparable<Personal>{
	
	// {{ Funciones (property)
	private List<Funcion> funciones;

	@MemberOrder(sequence = "1")
	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(final List<Funcion> funciones) {
		this.funciones = funciones;
	}
	// }}
	
	//Agregar funcion
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
