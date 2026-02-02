package Dao;

import java.util.ArrayList;

import Model.Alumno;
import Model.Grupo;

public class AlumnoDaoImplJson implements AlumnoDao {
	@Override
	public ArrayList<String> mostrarAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean guardarGrupo(Grupo g) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean guardarAlumno(Alumno a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modificarNombreAlumno(int pk) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean eliminarAlumnoPK(int pk) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean eliminarAlumnoCurso(int pk) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public ArrayList<Grupo> mostrarGrupos() {
		// TODO Auto-generated method stub
		return null;
		
	}
	@Override
	public ArrayList<Alumno> obtenerAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Alumno> obtenerAlumnosPk(int pk) {
		// TODO Auto-generated method stub
		return null;
	}

}
