package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Direccion {

	// {{ Calle (property)
	private String calle;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1")
	public String getCalle() {
		return calle;
	}

	public void setCalle(final String calle) {
		this.calle = calle;
	}
	// }}


	// {{ Numero (property)
	private int numero;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.1")
	public int getNumero() {
		return numero;
	}

	public void setNumero(final int numero) {
		this.numero = numero;
	}
	// }}

	// {{ Localidad (property)
	private Localidad localidad;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.2")
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(final Localidad localidad) {
		this.localidad = localidad;
	}
	// }}

	public String title(){
		return calle + " " + Integer.toString(numero) + ", " + localidad.title();
	}
}
