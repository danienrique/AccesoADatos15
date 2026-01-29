package App;

import Dao.AlumnoDao;
import Dao.AlumnoDaoImplSQL;
import Vista.IVista;
import Vista.VistaImplConsola;

public class App {
	public static void main(String[] args) {
		IVista vista = new VistaImplConsola();
		AlumnoDao alumnoDao = new AlumnoDaoImplSQL();
		Controlador control = new Controlador(vista, alumnoDao);
		control.iniciar();
	}
}
