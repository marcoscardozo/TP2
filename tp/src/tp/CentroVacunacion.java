package tp;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;


public class CentroVacunacion {

	private String nombre; //
	public int capacidadVacunacionDiaria; //
	private ArrayList<Paciente> vacunasAplicadas; 
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

	}

	public void ingresarVacunas(String nombreVacuna, int cantidad, Fecha fechaIngreso) {
		centroAlmacenamiento.agregarVacunas(nombreVacuna, cantidad, fechaIngreso);
	}


	public int vacunasDisponibles(String nombreVacuna) {
		return centroAlmacenamiento.obtenerCantidadDevacunasPorNombre(nombreVacuna);
	}

	public void inscribirPersona(int dni, Fecha nacimiento, boolean tienePadecimientos, boolean esEmpleadoSalud) {

	}

	public List<Integer> listaDeEspera() {
		return null;
	}
	// ****

	public void iniciarVacunacion(Fecha fecha, int limiteDiario) {

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
		centro.ingresarVacunas("Pfizer", 200, new Fecha(24,05,2021));
		centro.ingresarVacunas("Moderna", 130, new Fecha(21,05,2021));
		System.out.println(centro.vacunasDisponibles("Pfizer"));
		System.out.println(centro.vacunasDisponibles("Moderna"));
		centro.ingresarVacunas("Pfizer", 400, new Fecha(24,05,2021));
		System.out.println(centro.vacunasDisponibles("Pfizer"));
		System.out.println("-----");
	}
}
