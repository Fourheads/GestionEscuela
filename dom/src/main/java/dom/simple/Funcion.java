package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.util.ObjectContracts;

@PersistenceCapable
public class Funcion implements Comparable<Funcion>{
	
	// {{ Nombre (property)
	private E_funciones nombre;

	@Column(allowsNull = "false")
	@MemberOrder(sequence = "1")
	@Persistent
	public E_funciones getNombre() {
		return nombre;
	}

	public void setNombre(final E_funciones nombre) {
		this.nombre = nombre;
	}
	// }}
	
	// {{ Observaciones (property)
	private String observaciones;

	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.1")
	@Persistent
	@MultiLine
	final @MaxLength(2048)
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(final String observacion) {
		this.observaciones = observaciones;
	}
	// }}

	public enum E_funciones{
		SECRETARIO, PRECEPTOR, PROFESOR, DIRECTOR;
	}
	
	@Override
	public int compareTo(Funcion o) {
		
		return ObjectContracts.compare(this, o, "nombre");
	}
}


