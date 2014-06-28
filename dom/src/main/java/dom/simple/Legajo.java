package dom.simple;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MaxLength;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MultiLine;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.joda.time.LocalDate;

import dom.simple.Tarjeta.ECategoria;

//GestionEscuela

@PersistenceCapable
public class Legajo {	

	@Column(allowsNull = "true", name = "TARJETAS_ID")
	@MemberOrder(sequence = "1.1", name = "Nueva Tarjeta")
	@Named("Nueva Tarjeta")
	public Legajo create (
			final @Named("Titulo") String titulo,
			final @MaxLength(2048)
		    	  @MultiLine 
		    	  @Named("Comentarios") String comentario,
		    final @Named("Categoria de Tarjeta") ECategoria categoria	  
			){
		
		final Tarjeta tarjeta = new Tarjeta();
		LocalDate fecha = LocalDate.now();
		
		tarjeta.setTitulo(titulo);
		tarjeta.setComentario(comentario);
		tarjeta.setFecha(fecha);
		tarjeta.setCategoria(categoria);
		addTarjeta(tarjeta);
		
		//container.persistIfNotAlready(tarjeta);
		addTarjeta(tarjeta);
		return this;
	}
	
	// {{ Tarjetas (property)
	@Element(column = "TARJETA", dependent = "false") //EN dependent DEBERÍA IR true, ¿verdad?.
	private SortedSet<Tarjeta> tarjetas = new TreeSet<Tarjeta>();
	
	//@Persistent no se usa cuando se usa @Element
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

	@Hidden
	public void addTarjeta(Tarjeta tarjeta){
		this.tarjetas.add(tarjeta);			
	}
		
	public String title(){
		return "Legajo de " + getPropietario();
	}
	
	 @javax.inject.Inject 
	 DomainObjectContainer container;
	
}
