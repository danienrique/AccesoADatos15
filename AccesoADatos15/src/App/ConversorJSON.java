package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Alumno;
import Model.Grupo;

public class ConversorJSON implements Conversor {

	@Override
	public void exportarAlumnos(ArrayList<Alumno> alm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportarGrupos(ArrayList<Grupo> grp) {
		// TODO Auto-generated method stub
		JSONArray gruposJS = new JSONArray();
		String nombreArchivo = "Grupos.json";
		for (Grupo g : grp) {
			JSONObject objGrupo = new JSONObject();
			objGrupo.put("id_grupo", g.getId_grupo());
			objGrupo.put("nombre", g.getNombre());
			objGrupo.put("ciclo", g.getCiclo());
			objGrupo.put("curso", g.getCurso());
			
			JSONArray alumnosJS = new JSONArray();
			for (Alumno a : g.getAlumnos()) {
				JSONObject objAlu = new JSONObject();
				objAlu.put("nia", a.getNia());
				objAlu.put("nombre", a.getNombre());
				objAlu.put("apellidos", a.getApellidos());
				objAlu.put("genero", String.valueOf(a.getGenero()));
				objAlu.put("fechaNac", a.getFecha_nacimiento().toString());

				alumnosJS.put(objAlu);
			}

			objGrupo.put("alumnos", alumnosJS);
			gruposJS.put(objGrupo);
		}

		try (FileWriter fw = new FileWriter(nombreArchivo)) {
			fw.write(gruposJS.toString(4)); // Indentación de 4 espacios para que sea legible
			System.out.println("Archivo JSON generado: " + nombreArchivo);
		} catch (IOException e) {
			System.err.println("Error al guardar el JSON: " + e.getMessage());
		}
	}

	@Override
	public ArrayList<Alumno> importarAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Grupo> importarGrupos() {

		ArrayList<Grupo> listaGrupos = new ArrayList<>();
		try {
			String nombreArchivo = "Grupos.json";
			BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
			StringBuilder sb = new StringBuilder();
			String linea;
			while ((linea = br.readLine()) != null) {
				sb.append(linea);
			}
			br.close();
			JSONArray gruposJS = new JSONArray(sb.toString());

			for (int i = 0; i < gruposJS.length(); i++) {
				JSONObject objGrupo = gruposJS.getJSONObject(i);

				Grupo grupo = new Grupo();
				grupo.setId_grupo(objGrupo.getInt("id_grupo"));
				grupo.setNombre(objGrupo.getString("nombre"));
				grupo.setCiclo(objGrupo.getString("ciclo"));
				grupo.setCurso(objGrupo.getString("curso"));

				ArrayList<Alumno> listaAlu = new ArrayList<>();

				JSONArray alumnosJS = objGrupo.getJSONArray("alumnos");
				for (int j = 0; j < alumnosJS.length(); j++) {
					JSONObject objAlu = alumnosJS.getJSONObject(j);

					Alumno alu = new Alumno();
					alu.setNia(objAlu.getInt("nia"));
					alu.setNombre(objAlu.getString("nombre"));
					alu.setApellidos(objAlu.getString("apellidos"));
					alu.setGenero(objAlu.getString("genero").charAt(0));
					alu.setFecha_nacimiento(LocalDate.parse(objAlu.getString("fechaNac")));

					listaAlu.add(alu);
				}

				grupo.setAlumnos(listaAlu);
				listaGrupos.add(grupo);
			}

			System.out.println("Importación JSON finalizada con éxito.");
		} catch (Exception e) {
			System.err.println("Error al importar el JSON: " + e.getMessage());
			e.printStackTrace();
		}

		return listaGrupos;
	}

}
