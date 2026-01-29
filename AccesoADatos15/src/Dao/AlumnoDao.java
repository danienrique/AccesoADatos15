package Dao;

import Model.Alumno;
import Model.Grupo;

public interface AlumnoDao {
	public void insertarGrupo(Grupo g);
	public void insertarAlumno(Alumno a);
	public void mostrarAlumnos();
	public void modificarNombreAlumno(int pk);
	public void eliminarAlumnoPK(int pk);
	public void eliminarAlumnoCurso(int pk);
	public void mostrarGrupos();
}
