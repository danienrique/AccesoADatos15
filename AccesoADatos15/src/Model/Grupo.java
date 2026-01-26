package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grupo {
	private String nombre, ciclo, curso;
	private ArrayList<Alumno> alumnos;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		curso = curso;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Grupo() {
		// TODO Auto-generated constructor stub
	}
	public Grupo(String name, String cicle, String curse){
		this.nombre = name;
		this.ciclo = cicle;
		this.curso = curse;
		alumnos = new ArrayList<Alumno>();
	}
	public Grupo(String name, String cicle, String curse, ArrayList<Alumno> school){
		this.nombre = name;
		this.ciclo = cicle;
		this.curso = curse;
		this.alumnos = school;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", ciclo=" + ciclo + ", curso=" + curso + ", alumnos=" + alumnos + "]";
	}
	public void aniadirAlumno(Alumno al) {
		alumnos.add(al);
	}
}
