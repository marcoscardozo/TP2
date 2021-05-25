package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Inscripcion {

	private Map<Integer, Paciente> inscripciones; // se uso
	private Map<Integer, ArrayList<Paciente>> listaSinTurnoPrioritariaOrdenada; // se uso
	private Map<Fecha, Set<Paciente>> turnosConFecha; // guardaria la fecha y pacientes
	private ArrayList<Paciente> listaConTurnosOrdenada; // todavia no se uso
	private Fecha fecha;

	// la lista de espera cual es?
	public Inscripcion() {
		inscripciones = new HashMap<Integer, Paciente>();
		listaSinTurnoPrioritariaOrdenada = new HashMap<Integer, ArrayList<Paciente>>();
		listaSinTurnoPrioritariaOrdenada.put(1, new ArrayList<Paciente>());
		listaSinTurnoPrioritariaOrdenada.put(2, new ArrayList<Paciente>());
		listaSinTurnoPrioritariaOrdenada.put(3, new ArrayList<Paciente>());
		listaSinTurnoPrioritariaOrdenada.put(4, new ArrayList<Paciente>());
		fecha = new Fecha();
//		this.listaSinTurnoPrioritariaCiudadano = new ArrayList<Ciudadano>();
//		
//		this.listaPrioritaria = new HashMap<String, ArrayList<Ciudadano>>();
//		listaPrioritaria.put("PersonalSalud", new ArrayList<Ciudadano>());
//		listaPrioritaria.put("MayoresDeSesenta", new ArrayList<Ciudadano>());
//		listaPrioritaria.put("PersonasConEnfermedadPre", new ArrayList<Ciudadano>());
//		listaPrioritaria.put("RestoPoblacion", new ArrayList<Ciudadano>());
	}

	public boolean inscribirCiudadano(int dni, Fecha edad, boolean enfermedad, boolean personal) {
		if (!inscripciones.containsKey(dni)) {
			inscripciones.put(dni, new Paciente(dni, edad, enfermedad, personal));
			return true;
		} else
			return false;
	}

	public void crearListaPorPrioridad() {
		for (Integer paciente : inscripciones.keySet()) {
			if (inscripciones.get(paciente).isPersonalSalud())
				inscripciones.get(paciente).setPrioridad(1);
			else if (Fecha.diferenciaAnios(fecha, inscripciones.get(paciente).getEdad()) >= 60)
				inscripciones.get(paciente).setPrioridad(2);
			else if (inscripciones.get(paciente).isEnfermedadPreexistente())
				inscripciones.get(paciente).setPrioridad(3);
			else
				inscripciones.get(paciente).setPrioridad(4);
		}
		// ingreso todos los que existen a una lista por prioridad, primero los 1, 2, 3
		// y 4
		for (Integer paciente : inscripciones.keySet()) {
			listaSinTurnoPrioritariaOrdenada.get(inscripciones.get(paciente).getPrioridad())
					.add(inscripciones.get(paciente));
		}

	}

	public Map<Integer, ArrayList<Paciente>> verListaPorPrioridad() {
		return listaSinTurnoPrioritariaOrdenada;
	}

	private ArrayList<Paciente> crearListaConTurnosOrdenada(CentroAlmacenamiento c) {
		return null;
	}

	private ArrayList<Paciente> obtenerListaConTurnosEnEspera(Inscripcion x) {
		return null;
	}

	public ArrayList<Paciente> obtenerListadoConTurnosPorFecha(Fecha f, int cantPacientesPorDia) {
		//
		//
		//
		//
		// listaSinTurnoPrioritariaOrdenada
		//
		//
		//
		return null;
	}

	public ArrayList<Integer> pacientesInscriptos() { // test para ver ingreso Pacientes
		ArrayList<Integer> ingresados = new ArrayList<Integer>();
		// pacientes inscriptos, me devuelve los dni solo
		for (Integer paciente : inscripciones.keySet()) {
			ingresados.add(paciente);
			System.out.println(inscripciones.get(paciente).toString());
		}

		return ingresados;
	}

	private void crearFechaPorTurnos() {

	}

	@Override
	public String toString() {
		return "Inscrripcion [inscripciones=" + inscripciones + ", listaSinTurnoPrioritariaOrdenada="
				+ listaSinTurnoPrioritariaOrdenada + ", listaConTurnosOrdenada=" + listaConTurnosOrdenada
				+ ", prioridad=" + "]";
	}

}
