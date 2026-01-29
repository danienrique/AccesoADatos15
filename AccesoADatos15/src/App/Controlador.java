package App;


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
				Dao.insertarGrupo(new Grupo(vista.pedirNombreGrupo(), vista.pedirCiclo(), vista.pedirCurso()));
				break;
			case 2:
				Dao.mostrarGrupos();
				Dao.insertarAlumno(new Alumno(vista.pedirNia(), vista.pedirNombreAlumno(), vista.pedirApellidos(), vista.pedirGenero(), vista.pedirFecha(), vista.pedirIdGrupo()));
				break;
			case 3:
				Dao.mostrarAlumnos();
				break;
			case 4:
				
				break;
			case 5: 
				
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
				
				break;
			case 10:
				
				break;
			case 0:
				
				break;
			default:
				break;
			}
		} while(opcion != 0);
	}
}
