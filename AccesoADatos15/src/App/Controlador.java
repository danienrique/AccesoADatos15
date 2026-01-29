package App;

import java.util.Scanner;

import Dao.AlumnoDao;
import Vista.IVista;
import Vista.VistaImplConsola;

public class Controlador {
	private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		AlumnoDao dao = null;
		IVista vista = new VistaImplConsola();
		new Controlador().ejecutar(dao, vista);
	}
	public void ejecutar(AlumnoDao dao, IVista vista) {
		
	}
}
