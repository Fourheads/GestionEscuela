package dom.simple;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;


///GestionEscuela

@PersistenceCapable
public class Persona {
	
	// {{ Dni (property)
	private int dni;

	@Persistent
	@MemberOrder(sequence = "1")
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
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	// }}


	// {{ Direccion (property)
	private String direccion;

	@Persistent
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}
	// }}


	// {{ FechaNacimiento (property)
	private String fechaNacimiento;

	@Persistent
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(final String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	// }}

	
	// {{ Nacionalidad (property)
	private E_nacionalidad nacionalidad;

	@Persistent
	@MemberOrder(sequence = "1")
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
	@MemberOrder(sequence = "1")
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
	@MemberOrder(sequence = "1")
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
