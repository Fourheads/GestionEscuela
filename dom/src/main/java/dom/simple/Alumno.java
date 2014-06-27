package dom.simple;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
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
@ObjectType("ALUMNO")
@Bookmarkable


///GestionEscuela


public class Alumno extends Persona implements Comparable<Alumno>{

	
	// {{ Legajo (property)
	private Legajo legajo;

	@Persistent
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false", name = "LEGAJO_ID")
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
