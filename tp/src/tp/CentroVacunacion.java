package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CentroVacunacion {

	private String nombre; //
	public int capacidadVacunacionDiaria; //
	private Map<String,Paciente> vacunasAplicadas; 
	private CentroAlmacenamiento centroAlmacenamiento;
	private Inscripcion inscripciones;

	public CentroVacunacion(String nombreCentro, int capacidadVacunacionDiaria) {
		if (nombreCentro.equals("") || capacidadVacunacionDiaria <= 0)
			throw new RuntimeException(
					"Por favor, ingrese los datos correctamente y la cantidad debe ser mayor a 0");
		else
			this.nombre = nombreCentro;
		this.capacidadVacunacionDiaria = capacidadVacunacionDiaria;
		centroAlmacenamiento = new CentroAlmacenamiento();
		inscripciones = new Inscripcion();

	}

	public void ingresarVacunas(String nombreVacuna, int cantidad, Fecha fechaIngreso) {
		centroAlmacenamiento.agregarVacunas(nombreVacuna, cantidad, fechaIngreso);
	}


	public int vacunasDisponibles(String nombreVacuna) {
		return centroAlmacenamiento.obtenerCantidadDevacunasPorNombre(nombreVacuna);
	}

	public void inscribirPersona(int dni, Fecha nacimiento, boolean tienePadecimientos, boolean esEmpleadoSalud) {
		inscripciones.inscribirCiudadano(dni, nacimiento, tienePadecimientos, esEmpleadoSalud);
	}

	public ArrayList<Integer> listaDeEspera() {
		return inscripciones.pacientesInscriptos(); // para ver los que voy ingresando, es para test solo
	}
	

	public void iniciarVacunacion(Fecha fecha, int limiteDiario) {
		inscripciones.crearListaPorPrioridad(); // le setea la prioridad a los pacientes
		System.out.println(inscripciones.verListaPorPrioridad()); // devuelve un hash
		//con <int prioridad, lista de pacientes con esa prioridad>
		
	}

	public void generarTurnos(Fecha fechaInicial) {

	}

	public List<Integer> turnosConFecha(Fecha fecha) {
		return null;
	}

	public void vacunarInscripto(int dni, Fecha fechaVacunacion) {
		
	}

	public Map<Integer, String> reporteVacunacion() {
		return null;
	}

	public Map<String, Integer> reporteVacunasVencidas() {
		return null;
	}

	public static void main(String[] args) {
		CentroVacunacion centro = new CentroVacunacion("Hospital San Miguel", 120);
//		centro.ingresarVacunas("Pfizer", 200, new Fecha(24,05,2021));
//		centro.ingresarVacunas("Moderna", 130, new Fecha(21,05,2021));
//		System.out.println(centro.vacunasDisponibles("Pfizer"));
//		System.out.println(centro.vacunasDisponibles("Moderna"));
//		centro.ingresarVacunas("Pfizer", 400, new Fecha(24,05,2021));
//		System.out.println(centro.vacunasDisponibles("Pfizer"));
//		System.out.println("-----");
//		centro.ingresarVacunas("Sputnik", 3, new Fecha(21,05,2021));
//		System.out.println(centro.vacunasDisponibles("Sputnik"));
		centro.inscribirPersona(13768612, new Fecha(13,06,1960), false, false); //60 -> prior: 2
		centro.inscribirPersona(45307940, new Fecha(9,05,2001), false, false);  //20 -> prior: 4
		centro.inscribirPersona(22124064, new Fecha(31,01,1970), true, false);  //54 -> prior: 3  
		centro.inscribirPersona(40124064, new Fecha(15,01,1970), false, true);  //54 -> prior: 1
		centro.inscribirPersona(00104064, new Fecha(25,01,1970), false, true);  //54 -> prior: 1
//		System.out.println(centro.listaDeEspera());
		centro.iniciarVacunacion(new Fecha(13,06,1960), 10);
		System.out.println(centro.listaDeEspera());
	}
}
