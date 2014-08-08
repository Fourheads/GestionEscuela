/*
 * This is a software made for highschool management 
 * 
 * Copyright (C) 2014, Fourheads
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * 
 * 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
*/


package dom.simple;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;


@PersistenceCapable
public class Curso {
	
	// {{ Division (property)
	private String division;

	@Persistent
	@Title
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.1")
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	//}}
	
	// {{ Turno (property)
	private Turno turno;
	
	@Persistent
	@Title
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.2")
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	//}}
	
	// {{ Anio (property)
	private int anio;

	@Persistent
	@Title
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.3")
	public int getAño() {
		return anio;
	}
	public void setAño(int anio) {
		this.anio = anio;
	}
	//}}	

	//private List<Materia> materias;

	// {{ Materias (Property)
	@Join
	@Element(dependent = "true")
	private SortedSet<Materia> ListaMateria = new TreeSet<Materia>();

	@MemberOrder(sequence = "1.4")
	public SortedSet<Materia> getListaMateria() {
		return ListaMateria;
	}

	public void setListaMateria(final SortedSet<Materia> listamateria) {
		this.ListaMateria = listamateria;
	}
	// }}
	/*
	@Title
	//@Element(column="Materia_ID")
	@MemberOrder(sequence = "1.4")
	public List<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(final List<Materia> materias) {
		this.materias = materias;
	}
	
	public void addMaterias(Materia NuevaMateria){
		this.materias.add(NuevaMateria);
	}
	//}}*/
	
	
	// {{ Alumnos (Property)
	@Join
	@Element(dependent = "true")
	private SortedSet<Alumno> ListaAlumno = new TreeSet<Alumno>();

	@MemberOrder(sequence = "1.5")
	public SortedSet<Alumno> getAlumnos() {
		return ListaAlumno;
	}

	public void setAlumnos(final SortedSet<Alumno> listaalumno) {
		this.ListaAlumno = listaalumno;
	}
	// }}
	
	/*
	private List<Alumno> alumnos;
	
	@Title
	@Column(allowsNull = "true")
	@Element(column="Alumno_id")
	@MemberOrder(sequence = "1.5")
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(final List<Alumno> Alumnos) {
		this.alumnos = Alumnos;
	}
	public void addAlumno(Alumno NuevaAlumno){
		this.alumnos.add(NuevaAlumno);
	}
	//}}*/
	
	// {{ Preceptor (property)
	private Personal preceptor;
	
	@Persistent
	@Title
	@Column(allowsNull = "true")
	@MemberOrder(sequence = "1.6")
	public Personal getPreceptor() {
		return preceptor;
	}
	public void setPreceptor(Personal Preceptor) {
		this.preceptor = Preceptor;
	}
	//}}
}
