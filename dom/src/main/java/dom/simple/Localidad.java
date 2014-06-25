package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Localidad {

	// {{ Nombre (property)
	private localidades nombre;

	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1")
	@Persistent
	public localidades getNombre() {
		return nombre;
	}

	public void setNombre(final localidades nombre) {
		this.nombre = nombre;
	}
	// }}


	public enum localidades{	
		Neuquen, Cipolletti, Plottier, Centenario, Roca, Allen;
	}
	
	public String title(){
		return nombre.toString();
	}
}
