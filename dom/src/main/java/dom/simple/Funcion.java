package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

public class Funcion {
	
	// {{ Nombre (property)
	private E_funciones nombre;


	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1")
	@Persistent
	public E_funciones getNombre() {
		return nombre;
	}

	public void setNombre(final E_funciones nombre) {
		this.nombre = nombre;
	}
	// }}

	public enum E_funciones{
		SECRETARIO, PRECEPTOR, PROFESOR, DIRECTOR;
	}
}


