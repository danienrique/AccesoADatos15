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
	public void mostrarAlumnos() {
		// TODO Auto-generated method stub
		String sql = "SELECT a.Nia, a.Nombre, a.Apellidos, a.Genero, a.FechaNac, g.Nombre, g.Curso, g.Ciclo "
				+ "FROM alumnos a JOIN grupos g ON a.Id_grupo = g.Id_grupo";
		try (Connection c = MyDataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.printf("%d %s %s %s %s | Grupo: %s (%s - %s)%n", rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertarGrupo(Grupo g) {
		// TODO Auto-generated method stub
		System.out.print("Nombre del grupo: ");
		String nombre = sc.nextLine();
		System.out.print("Ciclo: ");
		String ciclo = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();

		try (Connection con = MyDataSource.getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO grupos (Nombre, Ciclo, Curso) VALUES (?, ?, ?)");) {
			ps.setString(1, nombre);
			ps.setString(3, ciclo);
			ps.setString(2, curso);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Grupo insertado correctamente");
	}

	@Override
	public void insertarAlumno(Alumno a) {
		// TODO Auto-generated method stub
		try (Connection con = MyDataSource.getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO alumno (Nia, Nombre, Apellidos, Genero, FechaNac, Grupo)"
								+ " VALUES (?, ?, ?, ?, ?, ?)");) {
			ps.setInt(1, a.getNia());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidos());
			ps.setString(4, String.valueOf(a.getGenero()));
			ps.setDate(5, a.getFecha_nacimiento());
			ps.setInt(6, a.getGrupo());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Alumno insertado correctamente");
	}

	@Override
	public void modificarNombreAlumno(int pk) {
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
	}

	@Override
	public void eliminarAlumnoPK(int pk) {
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

	}
	@Override
	public void eliminarAlumnoCurso(int pk) {
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
