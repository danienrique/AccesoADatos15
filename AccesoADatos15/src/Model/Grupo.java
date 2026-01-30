package Model;

import java.util.ArrayList;

public class Grupo {
	private String nombre, ciclo, curso;
	private ArrayList<Alumno> alumnos;
	private int Id_grupo;
	
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
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public int getId_grupo() {
		return Id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		Id_grupo = id_grupo;
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
		return "Grupo [id: " + this.Id_grupo+"nombre=" + nombre + ", ciclo=" + ciclo + ", curso=" + curso + ", alumnos=" + alumnos + "]";
	}
	public void aniadirAlumno(Alumno al) {
		alumnos.add(al);
	}

}
