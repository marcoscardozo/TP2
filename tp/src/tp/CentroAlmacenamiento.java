package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CentroAlmacenamiento {

	private HashMap<String, ArrayList<Vacuna>> vacunas;
	private HashMap<String, ArrayList<Vacuna>> vacunasVencidas;
	

	public CentroAlmacenamiento() {
		vacunas = new HashMap<String, ArrayList<Vacuna>>();
		vacunas.put("Pfizer", new ArrayList<Vacuna>());
		vacunas.put("Moderna", new ArrayList<Vacuna>());
		vacunas.put("Astranezca", new ArrayList<Vacuna>());
		vacunas.put("Sputnik", new ArrayList<Vacuna>());
		vacunas.put("Sinopharm", new ArrayList<Vacuna>());
		

	}

	public void agregarVacunas(String nombre, int cant, Fecha ingreso){//listo
		if (nombre.equals("Pfizer"))
			rellenarVacunas18(nombre, cant, ingreso);
		else if (nombre.equals("Moderna"))
			rellenarVacunas18(nombre, cant, ingreso);
		else if (nombre.equals("Sinopharm"))
			rellenarVacunas3(nombre, cant, ingreso);
		else if (nombre.equals("Astranezca"))
			rellenarVacunas3(nombre, cant, ingreso);
		else if (nombre.equals("Sputnik"))
			rellenarVacunas3(nombre, cant, ingreso);
	}
	//privados
	private void rellenarVacunas18(String nombre, int cant, Fecha ing) {
		for (int i = 0; i < cant; i++) {
			vacunas.get(nombre).add(new Vacuna18(nombre, ing));
		}
	}

	private void rellenarVacunas3(String nombre, int cant, Fecha ing) {
		for (int i = 0; i < cant; i++) {
			vacunas.get(nombre).add(new Vacuna3(nombre, ing));
		}
	}
	//privados
	public int obtenerCantidadDevacunasPorNombre(String nombre) { //listo
		return vacunas.get(nombre).size();
	}

	private void descontarVacuna(String nombre) {
	}

	public String toString() {
		return null;
	}

	public static void main(String[] args) {

	}
}
