package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CentroVacunacion {

	private String nombre; 
	public int capacidadVacunacionDiaria; 
	private Map<String,Paciente> vacunasAplicadas; //aun no se uso, es necesario los turnos
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

	public void ingresarVacunas(String nombreVacuna, int cantidad, Fecha fechaIngreso) { //listo
		centroAlmacenamiento.agregarVacunas(nombreVacuna, cantidad, fechaIngreso);
	}


	public int vacunasDisponibles(String nombreVacuna) { //listo
		return centroAlmacenamiento.obtenerCantidadDevacunasPorNombre(nombreVacuna);
	}

	public void inscribirPersona(int dni, Fecha nacimiento, boolean tienePadecimientos, boolean esEmpleadoSalud) {
		inscripciones.inscribirCiudadano(dni, nacimiento, tienePadecimientos, esEmpleadoSalud);
	} //listo

	public ArrayList<Integer> listaDeEspera() { // falta quitarlos cuando se asigne turno
		return inscripciones.pacientesInscriptos(); 
	}

	public void generarTurnos(Fecha fechaInicial) { // falta la asignacion de turnos.
		//para generar turnos es necesario recorrer la lista de prioridad de centroAlmacenamiento
		inscripciones.crearListaPorPrioridad();
		System.out.println(inscripciones.verListaPorPrioridad());
		//
	}

	public List<Integer> turnosConFecha(Fecha fecha) { //falta
		return inscripciones.dniDePacientesConTurno(fecha); // modificar por dentro
	}
	

	public void vacunarInscripto(int dni, Fecha fechaVacunacion) {
		
	}

	public Map<Integer, String> reporteVacunacion() {
		return null; //luego de asignar turnos ya que ahi le indico la vacuna y se la seteo
	}

	public Map<String, Integer> reporteVacunasVencidas() { // listo
		centroAlmacenamiento.quitarVacunasVencidas(new Fecha());
		return centroAlmacenamiento.vacunasVencidas;
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
//		centro.inscribirPersona(13768612, new Fecha(13,06,1960), false, false); //60 -> prior: 2
//		centro.inscribirPersona(45307940, new Fecha(9,05,2001), false, false);  //20 -> prior: 4
//		centro.inscribirPersona(22124064, new Fecha(31,01,1970), true, false);  //54 -> prior: 3  
//		centro.inscribirPersona(40124064, new Fecha(15,01,1970), false, true);  //54 -> prior: 1
//		centro.inscribirPersona(00104064, new Fecha(25,01,1970), false, true);  //54 -> prior: 1
//		System.out.println(centro.listaDeEspera());
//		centro.iniciarVacunacion(new Fecha(13,06,1960), 10);
//		System.out.println(centro.listaDeEspera());
		
		//prueba para vacunas vencidas :
		
		centro.ingresarVacunas("Sputnik", 10, new Fecha(26,07,2021)); // Estan vencidas, la fecha actual es 26/05/2021
		centro.ingresarVacunas("Sputnik", 3, new Fecha(26,01,2021)); // NO Estan vencidas, la fecha actual es 26/05/2021
		System.out.println("Sputnik: " + centro.vacunasDisponibles("Sputnik")); // -> solo quedan 3 Sputnik
		centro.ingresarVacunas("Moderna", 10, new Fecha(26,07,2021)); // Estan vencidas, la fecha actual es 26/05/2021
		centro.ingresarVacunas("Moderna", 3, new Fecha(26,01,2021)); // NO Estan vencidas, la fecha actual es 26/05/2021
		System.out.println("Moderna: " + centro.vacunasDisponibles("Moderna")); // -> solo quedan 3 Moderna
		System.out.println("Vencidas: ");
		System.out.println(centro.reporteVacunasVencidas()); // devuelve el hash pedido en el enunciado
		
	}
}
