package dom.simple;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;
import org.joda.time.LocalDate;


///GestionEscuela

@PersistenceCapable
public class Persona {
	
	// {{ Dni (property)
	private int dni;

	@Persistent
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull="false")
	public int getDni() {
		return dni;
	}

	public void setDni(final int dni) {
		this.dni = dni;
	}
	// }}


	// {{ Apellido (property)
	private String apellido;

	@Persistent
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}
	// }}


	// {{ Nombre (property)
	private String nombre;

	@Persistent
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	// }}


	// {{ Direccion (property)
	private Direccion direccion;

	@Persistent
	@MemberOrder(sequence = "7")
	@javax.jdo.annotations.Column(allowsNull="false", name = "DIRECCION_ID")
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(final Direccion direccion) {
		this.direccion = direccion;
	}
	// }}


	// {{ FechaNacimiento (property)
	private LocalDate fechaNacimiento;

	@Persistent
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Column(allowsNull="false")
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	// }}

	
	// {{ Nacionalidad (property)
	private E_nacionalidad nacionalidad;

	@Persistent
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(final E_nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	// }}


	// {{ Sexo (property)
	private E_sexo sexo;

	@Persistent
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_sexo getSexo() {
		return sexo;
	}

	public void setSexo(final E_sexo sexo) {
		this.sexo = sexo;
	}
	// }}


	// {{ Telefono (property)
	private String telefono;

	@Persistent
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}
	// }}



	public enum E_sexo{
		
		MASCULINO, FEMENINO
	}
	
	public enum E_nacionalidad{
		
		ARGENTINA, BOLIVIA, BRASIL, CHILE, 
		COLOMBIA, ECUADOR, PARAGUAY, PERU,
		URUGUAY, VENEZUELA, OTRO
	}

}
