package Dao;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Alumno;
import Model.Grupo;

public interface AlumnoDao {
	public void insertarGrupo(Grupo g);
	public void insertarAlumno(Alumno a);
	public void mostrarAlumnos();
	public void modificarNombreAlumno(int pk);
	public void eliminarAlumnoPK(int pk);
	public void eliminarAlumnoCurso(int pk);
	public ArrayList<Grupo> mostrarGrupos();
	public ArrayList<Alumno> obtenerAlumnos();
	public ArrayList<Alumno> obtenerAlumnosPk(int pk);
}
