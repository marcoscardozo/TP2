package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Inscripcion {

	private Map<Integer, Paciente> inscripcionesListaEspera; // se uso
	protected Map<Integer, ArrayList<Paciente>> ListaEsperaConPrioridad; // se uso
	protected Map<Fecha, ArrayList<Paciente>> turnosConFecha; // guardaria la fecha y pacientes aun no se uso
	private Map<Integer, Paciente> pacientesVacunados; // aun no se uso

	private Fecha fecha;

	public Inscripcion() {
		inscripcionesListaEspera = new HashMap<Integer, Paciente>();
		ListaEsperaConPrioridad = new HashMap<Integer, ArrayList<Paciente>>();
		ListaEsperaConPrioridad.put(1, new ArrayList<Paciente>());
		ListaEsperaConPrioridad.put(2, new ArrayList<Paciente>());
		ListaEsperaConPrioridad.put(3, new ArrayList<Paciente>());
		ListaEsperaConPrioridad.put(4, new ArrayList<Paciente>());
		turnosConFecha = new HashMap<Fecha, ArrayList<Paciente>>();
		turnosConFecha.put(new Fecha(), new ArrayList<Paciente>());
		fecha = new Fecha();

	}

	public void inscribirCiudadano(int dni, Fecha edad, boolean enfermedad, boolean personal) {
		if (Fecha.diferenciaAnios(fecha, edad) < 18)
			throw new RuntimeException("El paciente debe ser mayor de 18 años");
		if (inscripcionesListaEspera.containsKey(dni)) {
			throw new RuntimeException("El paciente ya se encuentra inscripto en el sistema");
		}
//		if (inscripcionesListaEspera.get(dni).vacunado)
//			throw new RuntimeException("El paciente ya fue vacunado");
		inscripcionesListaEspera.put(dni, new Paciente(dni, edad, enfermedad, personal));
	}

	public void crearListaPorPrioridad() {
		for (Integer paciente : inscripcionesListaEspera.keySet()) {
			if (inscripcionesListaEspera.get(paciente).isPersonalSalud())
				inscripcionesListaEspera.get(paciente).setPrioridad(1);
			else if (Fecha.diferenciaAnios(fecha, inscripcionesListaEspera.get(paciente).getEdad()) >= 60)
				inscripcionesListaEspera.get(paciente).setPrioridad(2);
			else if (inscripcionesListaEspera.get(paciente).isEnfermedadPreexistente())
				inscripcionesListaEspera.get(paciente).setPrioridad(3);
			else
				inscripcionesListaEspera.get(paciente).setPrioridad(4);
		}
		// ingreso todos los que existen a una lista por prioridad, primero los 1, 2, 3
		// y 4
		for (Integer paciente : inscripcionesListaEspera.keySet()) {
			ListaEsperaConPrioridad.get(inscripcionesListaEspera.get(paciente).getPrioridad())
					.add(inscripcionesListaEspera.get(paciente));
		}

	}

	public Map<Integer, ArrayList<Paciente>> verListaPorPrioridad() { // listo
		HashMap<Integer, ArrayList<Paciente>> n = (HashMap<Integer, ArrayList<Paciente>>) ListaEsperaConPrioridad;
		return n;
	}

	public ArrayList<Integer> dniDePacientesConTurno(Fecha f) { // aun no, es necesario la asignacion de turnos
		ArrayList<Integer> dniPacientes = new ArrayList<Integer>();
		turnosConFecha.get(fecha);
		for (Paciente paciente : turnosConFecha.get(fecha)) { // aun no tiene nada porque tengo que ver como le asigno
																// fecha de turno, se hace en otro metodo esto solo
																// devuelve la lista
			dniPacientes.add(paciente.getDni());
		}
		return dniPacientes;
	}

	public ArrayList<Integer> pacientesInscriptos() { // se uso pero no recuerdo donde
		ArrayList<Integer> ingresados = new ArrayList<Integer>();
		// pacientes inscriptos, me devuelve los dni solo
		for (Integer paciente : inscripcionesListaEspera.keySet()) {
			ingresados.add(paciente);
			System.out.println(inscripcionesListaEspera.get(paciente).toString());
		}

		return ingresados;
	}

	@Override
	public String toString() {
		return "Inscrripcion [inscripciones=" + inscripcionesListaEspera + ", listaSinTurnoPrioritariaOrdenada="
				+ ListaEsperaConPrioridad + ", prioridad=" + "]";
	}

}
