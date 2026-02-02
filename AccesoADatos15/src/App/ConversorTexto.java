package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Alumno;
import Model.Grupo;

public class ConversorTexto implements Conversor{

	@Override
	public void exportarAlumnos(ArrayList<Alumno> alm) {
		// TODO Auto-generated method stub
		String nombreArchivo = "Alumnos.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
	        
	        for (Alumno alu : alm) {
	            // Construimos la línea con el formato: NIA/Nombre/Apellidos/Genero/Fecha/IdGrupo
	            String linea = String.format("%d/%s/%s/%s/%s/%s",
	                alu.getNia(),
	                alu.getNombre(),
	                alu.getApellidos(),
	                alu.getGenero(),
	                alu.getFecha_nacimiento(), // LocalDate usa formato YYYY-MM-DD por defecto
	                alu.getGrupo()
	            );
	            
	            writer.write(linea);
	            writer.newLine(); // Salto de línea para el siguiente alumno
	        }
	        
	        System.out.println("Archivo '" + nombreArchivo + "' exportado con éxito.");
	        
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo: " + e.getMessage());
	    }
	}

	@Override
	public void exportarGrupos(ArrayList<Grupo> grp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Alumno> importarAlumnos() {
		// TODO Auto-generated method stub
		String nombreArchivo = "Alumnos.txt";
		ArrayList<Alumno> listaCargada = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            // Separamos la línea usando el delimitador "/"
	            String[] datos = linea.split("/");
	            
	            // Verificamos que la línea tenga todos los campos necesarios (6 en este caso)
	            if (datos.length == 6) {
	                Alumno alu = new Alumno();
	                
	                // Mapeo de datos (ajustado a los setters de tu clase)
	                alu.setNia(Integer.parseInt(datos[0]));
	                alu.setNombre(datos[1]);
	                alu.setApellidos(datos[2]);
	                alu.setGenero(datos[3].charAt(0)); // Convertimos String a char
	                alu.setFecha_nacimiento(LocalDate.parse(datos[4])); // Convierte YYYY-MM-DD
	                alu.setGrupo(Integer.parseInt(datos[5]));
	                
	                listaCargada.add(alu);
	            }
	        }
	        System.out.println("Importación completada. Total: " + listaCargada.size() + " alumnos.");
	        
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Error en el formato de datos: " + e.getMessage());
	    }

	    return listaCargada;
	}

	@Override
	public ArrayList<Grupo> importarGrupos() {
		// TODO Auto-generated method stub
		return null;
	}


}
