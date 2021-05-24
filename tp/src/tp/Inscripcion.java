package tp;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Inscripcion {

	private Map<Integer, Paciente> inscripciones;
	private ArrayList<Paciente> listaSinTurnoPrioritariaOrdenada;
	private ArrayList<Paciente> listaConTurnosOrdenada;
	private Prioridad prioridad;

	public Inscripcion() {

	}

	enum Prioridad {

		PERSONALSALUD("salud"), MAYORESDESESENTA("sesenta"), ENFERMEDADPREEXISTENTE("enfermo"), RESTOPOBLACION("resto");

		private Prioridad(String prioridad) {
			this.prioridad = prioridad;
		}

		private String prioridad;

		public String damePrioridad() {
			return this.prioridad;
		}
	};

	public boolean inscribirCiudadano(int dni, int edad, boolean enfermedad, boolean personal) {
		// incripciones
		//
		//
		// no me interesa, pero aca ingreso solo si cantVacunas >= inscripciones+1 (hay
		// vacunas)
		//
		//
		return false;
	}
		
	public void crearListaPorPrioridad(Inscripcion x){
		//mirar
	}
	private ArrayList<Paciente> crearListaConTurnosOrdenada(CentroAlmacenamiento c){
		return null;
	}
	private ArrayList<Paciente> obtenerListaConTurnosEnEspera(Inscripcion x){
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
	private void crearFechaPorTurnos() {
		
	}

	@Override
	public String toString() {
		return "Inscrripcion [inscripciones=" + inscripciones + ", listaSinTurnoPrioritariaOrdenada="
				+ listaSinTurnoPrioritariaOrdenada + ", listaConTurnosOrdenada=" + listaConTurnosOrdenada
				+ ", prioridad=" + prioridad + "]";
	}
	




}
