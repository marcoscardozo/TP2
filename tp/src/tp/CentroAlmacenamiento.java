package tp;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class CentroAlmacenamiento {

	private HashMap<String, LinkedList<Vacuna>> vacunas; 
	protected HashMap<String, Integer> vacunasVencidas;


	public CentroAlmacenamiento() {
		vacunas = new HashMap<String, LinkedList<Vacuna>>();
		vacunas.put("Pfizer", new LinkedList<Vacuna>());
		vacunas.put("Moderna", new LinkedList<Vacuna>());
		vacunas.put("Astranezca", new LinkedList<Vacuna>());
		vacunas.put("Sputnik", new LinkedList<Vacuna>());
		vacunas.put("Sinopharm", new LinkedList<Vacuna>());
		vacunasVencidas = new HashMap<String, Integer>();
		vacunasVencidas.put("Pfizer", 0); // el 0 es el contador de vacunas de ese tipo que estan vencidas
		vacunasVencidas.put("Moderna", 0);
		vacunasVencidas.put("Astranezca", 0);
		vacunasVencidas.put("Sputnik", 0);
		vacunasVencidas.put("Sinopharm", 0);

	}

	public void agregarVacunas(String nombre, int cant, Fecha ingreso) {// listo
		if (cant <= 0)
			throw new RuntimeException("La cantidad debe ser mayor a 0");
		else if (nombre.equals("Pfizer"))
			rellenarVacunas18(nombre, cant, ingreso);
		else if (nombre.equals("Moderna"))
			rellenarVacunas18(nombre, cant, ingreso);
		else if (nombre.equals("Sinopharm"))
			rellenarVacunas3(nombre, cant, ingreso);
		else if (nombre.equals("Astranezca"))
			rellenarVacunas3(nombre, cant, ingreso);
		else if (nombre.equals("Sputnik"))
			rellenarVacunas3(nombre, cant, ingreso);
		else
			throw new RuntimeException("Ingrese nuevamente el nombre");
	}

	
	public void quitarVacunasVencidas(Fecha fecha) {
		quitarVacunasVencidas(fecha, "Pfizer");
		quitarVacunasVencidas(fecha, "Moderna");
		quitarVacunasVencidas(fecha, "Astranezca");
		quitarVacunasVencidas(fecha, "Sputnik");
		quitarVacunasVencidas(fecha, "Sinopharm");
	}

	private void quitarVacunasVencidas(Fecha fecha, String nombre) { //sobreCarga 
		Iterator tipoDeVacuna = vacunas.get(nombre).iterator(); // un tipo de vacuna en especial
		while (tipoDeVacuna.hasNext()) {
			Vacuna claveValor = (Vacuna) tipoDeVacuna.next();
			if (Fecha.diferenciaMes(claveValor.getFechaIngreso(), fecha) >= 1) { // 1 es el mes -> 30 dias
				vacunasVencidas.put(nombre, vacunasVencidas.get(nombre) + 1); // incremento el contador de vencidas de ese tipo
				tipoDeVacuna.remove(); // elimino del hashmap esa vacuna vencida
			}
		}
	}


	public int obtenerCantidadDevacunasPorNombre(String nombre) {
		if (!compararN(nombre))
			throw new RuntimeException("No existe la vacuna: " + nombre);
		else
			quitarVacunasVencidas(new Fecha()); // fecha actual
		return vacunas.get(nombre).size(); 
	}
	// privados
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
	private boolean compararN(String nombre) { 
		String[] nombres = { "Pfizer", "Moderna", "Astranezca", "Sputnik", "Sinopharm" };
		boolean algunNombre = false;
		for (int i = 0; i < nombres.length; i++) {
			algunNombre = algunNombre || nombre.equals(nombres[i]);
		}
		return algunNombre;
	}



	public static void main(String[] args) {
		//test para CentroAlmacenamiento
		CentroAlmacenamiento n = new CentroAlmacenamiento();
		n.agregarVacunas("Pfizer", 12, new Fecha(26, 01, 2021)); // no vencidas = 12
		n.agregarVacunas("Pfizer", 6, new Fecha(26, 06, 2021)); // vencidas = 6
		n.agregarVacunas("Moderna", 2, new Fecha(26, 06, 2021)); // vencidas = 2
		n.agregarVacunas("Moderna", 10, new Fecha(26, 01, 2021)); // no vencidas = 10
		n.agregarVacunas("Sputnik", 9, new Fecha(26, 01, 2022)); // vencidas = 9

		System.out.println("Vacunas Pfizer totales: " + n.obtenerCantidadDevacunasPorNombre("Pfizer"));
		System.out.println("Vacunas Moderna totales: " + n.obtenerCantidadDevacunasPorNombre("Moderna"));
		System.out.println("Vacunas Sputnik totales: " + n.obtenerCantidadDevacunasPorNombre("Sputnik"));
		System.out.println("Vacunas Sinopharm totales: " + n.obtenerCantidadDevacunasPorNombre("Psinopharm"));
		System.out.println("Vacunas Astranezca totales: " + n.obtenerCantidadDevacunasPorNombre("Astranezca"));

	}
}
