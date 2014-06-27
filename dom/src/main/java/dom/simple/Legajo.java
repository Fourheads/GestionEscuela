package dom.simple;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;

@PersistenceCapable
public class Legajo {

	// {{ Tarjetas (property)
	@Element(column = "TARJETA", dependent = "false") //EN dependent DEBERÍA IR true, ¿verdad?.
	private SortedSet<Tarjeta> tarjetas = new TreeSet<Tarjeta>();
	
	@Persistent
	@Render(Type.EAGERLY)
	@MemberOrder(sequence = "1")
	public SortedSet<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(final SortedSet<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	// }}

	
	// {{ Propietario (property)
	private String propietario;
	
	@Hidden
	@MemberOrder(sequence = "1.1")
	@Column(allowsNull = "false")
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(final String propietario) {
		this.propietario = propietario;
	}
	// }}


	
		
	public String title(){
		return "Legajo de " + getPropietario();
	}
	
}
