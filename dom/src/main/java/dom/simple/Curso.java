package dom.simple;

import java.util.List;

public class Curso {
	
	private Turno Turno;
	private int Año;
	private String Division;
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	private List<Materia> Materias;
	private List<Alumno> Alumnos;
	//private Preceptor Preceptor;
	private Personal Preceptor;
	
	public Turno getTurno() {
		return Turno;
	}
	public void setTurno(Turno turno) {
		Turno = turno;
	}
	public int getAño() {
		return Año;
	}
	public void setAño(int año) {
		Año = año;
	}
	public List<Materia> getMaterias() {
		return Materias;
	}
	public void setMaterias(List<Materia> materias) {
		Materias = materias;
	}
	public List<Alumno> getAlumnos() {
		return Alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		Alumnos = alumnos;
	}
	public Personal getPreceptor() {
		return Preceptor;
	}
	public void setPreceptor(Personal preceptor) {
		Preceptor = preceptor;
	}
	
	
	

}
