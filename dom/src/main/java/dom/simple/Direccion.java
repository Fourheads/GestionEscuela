package dom.simple;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Direccion {

	// {{ Calle (property)
	private String calle;

	@Column(allowsNull = "true", name = "LOCALIDAD_ID")
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

	// {{ Piso (property)
	private String piso;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.1.1")
	public String getPiso() {
		return piso;
	}

	public void setPiso(final String piso) {
		this.piso = piso;
	}
	// }}


	// {{ Departamento (property)
	private String departamento;

	@Column(allowsNull = "true")
	@Persistent
	@MemberOrder(sequence = "1.1.2")
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(final String departamento) {
		this.departamento = departamento;
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
		return calle + " " + numero;
	}
}
