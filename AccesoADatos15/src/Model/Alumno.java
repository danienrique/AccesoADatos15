package Model;

import java.time.LocalDate;

public class Alumno {
	private int nia;
	private String nombre, apellidos;
	private int grupo_id;
	private char genero;
	private LocalDate fecha_nacimiento;
	
	public int getNia() {
		return nia;
	}
	public void setNia(int nia) {
		this.nia = nia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getGrupo() {
		return grupo_id;
	}
	public void setGrupo(int grupo) {
		this.grupo_id = grupo;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public Alumno(){
	}
	public Alumno(int ni, String name, String surname,  char genre, int anio, int mes, int dia, int group) {
		this.nia = ni;
		this.nombre = name;
		this.apellidos = surname;
		this.grupo_id = group;
		comprobacionGenero(genre);
		convertidorDeFechas(anio,mes,dia);
		
	}
	public Alumno(String name, String surname,  char genre, int anio, int mes, int dia, int group) {
		this.nombre = name;
		this.apellidos = surname;
		this.grupo_id = group;
		comprobacionGenero(genre);
		convertidorDeFechas(anio,mes,dia);
		
	}
	public Alumno(int ni, String name, String surname,  char genre,LocalDate fecha , int group) {
		this.nia = ni;
		this.nombre = name;
		this.apellidos = surname;
		this.grupo_id = group;
		comprobacionGenero(genre);
		this.fecha_nacimiento = fecha;
		
	}
	private void comprobacionGenero(char gen) {
		String aux = gen + "";
		if(aux.equals("M")||aux.equals("F")||aux.equals("m")||aux.equals("f")) {
			this.genero = gen;
		} else{
			System.err.println("Genero No Válido");
			System.exit(0);
		}
		
	}
	
	void convertidorDeFechas(int year, int month, int day) {
		fecha_nacimiento=LocalDate.of(year, month, day);
	}
	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero + 
				", fecha_nacimiento=" + fecha_nacimiento + ", grupo=" + grupo_id+ "]";
	}
}
