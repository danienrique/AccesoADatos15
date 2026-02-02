package Dao;

import java.util.ArrayList;

import Model.Alumno;
import Model.Grupo;

public interface AlumnoDao {
	public boolean guardarGrupo(Grupo g);
	public boolean guardarAlumno(Alumno a);
	public ArrayList<String> mostrarAlumnos();
	public boolean modificarNombreAlumno(int pk);
	public boolean eliminarAlumnoPK(int pk);
	public boolean eliminarAlumnoCurso(int pk);
	public ArrayList<Grupo> mostrarGrupos(); //Que tambien nos sirve para obtenerGrupos()
	public ArrayList<Alumno> obtenerAlumnos();//Es diferente de mostrarAlumnos() ya que este nos da todos los datos del alumno con todos los datos del grupo
	public ArrayList<Alumno> obtenerAlumnosPk(int pk);
}
