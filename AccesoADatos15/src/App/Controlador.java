package App;


import java.util.ArrayList;

import Dao.AlumnoDao;
import Model.Alumno;
import Model.Grupo;
import Vista.IVista;

public class Controlador {
	private IVista vista;
	private AlumnoDao Dao;
	
	public Controlador(IVista v, AlumnoDao ad){
		this.vista = v;
		this.Dao = ad;
	}
	public void iniciar() {
		int opcion = 1;
		do {
			vista.mostrarMenu();
			opcion = vista.pedirOpcion();
			switch(opcion) {
			case 1: 
				Dao.guardarGrupo(new Grupo(vista.pedirNombreGrupo(), vista.pedirCiclo(), vista.pedirCurso()));
				break;
			case 2:
				Dao.mostrarGrupos();
				Dao.guardarAlumno(new Alumno(vista.pedirNia(), vista.pedirNombreAlumno(), vista.pedirApellidos(), vista.pedirGenero(), vista.pedirFecha(), vista.pedirIdGrupo()));
				break;
			case 3:
				vista.mostrarDatosAlumnoGrupo(Dao.mostrarAlumnos());
				break;
			case 4:
				ArrayList<Alumno> aOpcion4 = Dao.obtenerAlumnos();
				Conversor convOpcion4 = new ConversorTexto();
				convOpcion4.exportarAlumnos(aOpcion4);
				break;
			case 5: 
				Conversor convOpcion5 = new ConversorTexto();
				ArrayList<Alumno> aOpcion5 = convOpcion5.importarAlumnos();
				for(Alumno aux:aOpcion5) {
					Dao.guardarAlumno(aux);
				}
				break;
			case 6:
				int pk = vista.pedirNia();
				Dao.modificarNombreAlumno(pk);
				break;
			case 7:
				int pke = vista.pedirNia();
				Dao.eliminarAlumnoPK(pke);
				break;
			case 8:
				int pk3 = vista.pedirIdGrupo();
				Dao.eliminarAlumnoCurso(pk3);
				break;
			case 9: 
				ArrayList<Grupo> gOpcion9 = Dao.mostrarGrupos();
				Conversor convOpcion9 = new ConversorJSON();
				convOpcion9.exportarGrupos(gOpcion9);
				break;
			case 10:
				Conversor convOpcion10 = new ConversorJSON();
				ArrayList<Grupo> gOpcion10 = convOpcion10.importarGrupos();
				for(Grupo auxG:gOpcion10) {
					for(Alumno auxA:auxG.getAlumnos()) {
						Dao.guardarAlumno(auxA);
					}
					Dao.guardarGrupo(auxG);
				}
				break;
			case 0:
				
				break;
			default:
				break;
			}
		} while(opcion != 0);
	}
}
