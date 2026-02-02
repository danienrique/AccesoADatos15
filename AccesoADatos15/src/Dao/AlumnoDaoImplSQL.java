package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Alumno;
import Model.Grupo;
import Pool.MyDataSource;

public class AlumnoDaoImplSQL implements AlumnoDao {
	private static final Scanner sc = new Scanner(System.in);
	private static AlumnoDaoImplSQL instancia;
	static {
		instancia = new AlumnoDaoImplSQL();
	}

	public AlumnoDaoImplSQL() {
	}

	public static AlumnoDaoImplSQL getInstancia() {
		return instancia;
	}

	@Override
	public ArrayList<String> mostrarAlumnos() {
		// TODO Auto-generated method stub
		ArrayList<String> alumnoGrupos = new ArrayList<String>();
		String linea;
		String sql = "SELECT a.Nia, a.Nombre, a.Apellidos, a.Genero, a.FechaNac, g.Nombre, g.Curso, g.Ciclo "
				+ "FROM alumnos a LEFT JOIN grupos g ON a.Id_grupo = g.Id_grupo";
		try (Connection c = MyDataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				linea = String.format("%d %s %s %s %s | Grupo: %s (%s - %s)%n", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8));
				alumnoGrupos.add(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumnoGrupos;
	}

	@Override
	public boolean guardarGrupo(Grupo g) {
		try (Connection con = MyDataSource.getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO grupos (Nombre, Ciclo, Curso) VALUES (?, ?, ?)");) {
			ps.setString(1, g.getNombre());
			ps.setString(2, g.getCiclo());
			ps.setString(3, g.getCurso());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		System.out.println("Grupo insertado correctamente");
		return true;
	}

	@Override
	public boolean guardarAlumno(Alumno a) {
		// TODO Auto-generated method stub
		try (Connection con = MyDataSource.getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO alumno (Nia, Nombre, Apellidos, Genero, FechaNac, Grupo)"
								+ " VALUES (?, ?, ?, ?, ?, ?)");) {
			ps.setInt(1, a.getNia());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidos());
			ps.setString(4, String.valueOf(a.getGenero()));
			ps.setDate(5, java.sql.Date.valueOf(a.getFecha_nacimiento()));
			ps.setInt(6, a.getGrupo());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		System.out.println("Alumno insertado correctamente");
		return true;
	}

	@Override
	public boolean modificarNombreAlumno(int pk) {
		System.out.println("Indique el nuevo nombre de la persona");
		String nombreNuevo = sc.nextLine();
		try (Connection con = MyDataSource.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE alumnos SET Nombre = ? WHERE Nia = ?");) {
			ps.setString(1, nombreNuevo);
			ps.setInt(2, pk);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean eliminarAlumnoPK(int pk) {
		// TODO Auto-generated method stub
		System.out.print("NIA del alumno: ");
		int nia = sc.nextInt();
		sc.nextLine();

		try (Connection con = MyDataSource.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM alumnos WHERE Nia = ?");) {
			ps.setInt(1, nia);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean eliminarAlumnoCurso(int pk) {
		// TODO Auto-generated method stub
		try (Connection con = MyDataSource.getConnection()) {
//			try (PreparedStatement ps = con.prepareStatement("SELECT Nombre, Curso, Ciclo FROM grupos")) {
//				ResultSet rs = ps.executeQuery();
//				System.out.println("Cursos existentes:");
//				while (rs.next()) {
//					System.out.println("- " + rs.getString(1));
//				}
//			}
//			System.out.print("Curso a eliminar: ");
//			String curso = sc.nextLine();

			try (PreparedStatement ps = con.prepareStatement(
					"DELETE a FROM alumnos a JOIN grupos g ON a.Id_grupo = g.Id_grupo WHERE g.Id_grupo = ?");) {
				ps.setInt(1, pk);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public ArrayList<Grupo> mostrarGrupos() {
		// TODO Auto-generated method stub
		ArrayList<Grupo> grps = new ArrayList<Grupo>();
		try(Connection con = MyDataSource.getConnection()){
			ResultSet rs = con.createStatement().executeQuery("SELECT Id_grupo, Nombre, Curso, Ciclo FROM grupos");
		    System.out.println("Grupos disponibles:");
		    while (rs.next()) {
		    	Grupo aux = new Grupo(rs.getString(2), rs.getString(3), rs.getString(4));
		    	aux.setId_grupo(rs.getInt(1));
		    	grps.add(aux);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grps;
	}

	@Override
	public ArrayList<Alumno> obtenerAlumnos() {
		// TODO Auto-generated method stub
		ArrayList<Alumno> alms = new ArrayList<Alumno>();
		String sql = "SELECT Nia, Nombre, Apellidos, Genero, FechaNac, Id_grupo FROM alumnos";
		try (Connection c = MyDataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno aux = new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).charAt(0),
						rs.getDate(5).toLocalDate(), rs.getInt(6));
				alms.add(aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alms;
	}

	@Override
	public ArrayList<Alumno> obtenerAlumnosPk(int pk) {
		// TODO Auto-generated method stub
		ArrayList<Alumno>alms = new ArrayList<Alumno>();
		String sql = "SELECT Nia, Nombre, Apellidos, Genero, FechaNac, Id_grupo FROM alumnos WHERE "
				+ "Id_grupo = ?";
		try (Connection c = MyDataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno aux = new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).charAt(0),
						rs.getDate(5).toLocalDate(), rs.getInt(6));
				alms.add(aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alms;
	}

}
