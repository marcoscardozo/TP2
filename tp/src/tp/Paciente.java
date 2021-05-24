package tp;

import java.util.Date;

public class Paciente {
	private boolean enfermedadPreexistente;
	private boolean personalSalud;
	private int dni;
	private int edad;
	private Fecha fechaTurno;
	private Vacuna vacuna;
	private int prioridad;

	public Paciente(int dni, int edad, boolean enfermedadPreexistente, boolean personalSalud) {
		this.dni = dni;
		this.edad = edad;
		this.enfermedadPreexistente = enfermedadPreexistente;
		this.personalSalud = personalSalud;
	}

// Informacion personal del Paciente----------------------------------//

	public int getDni() {
		return this.dni;
	}

	public int getEdad() {
		return this.edad;
	}

	public boolean isEnfermedadPreexistente() {
		return this.enfermedadPreexistente;
	}

	public boolean isPersonalSalud() {
		return this.personalSalud;
	}

// fin Informacion personal del Paciente----------------------------------//

// Informacion vacunacion del Paciente----------------------------------//

	public Vacuna obtenerVacunaDePaciente() {
		return null; // llenar
	}

	public Fecha getFechaTurno() {
		return null;
	}

	public boolean setFechaTurno(Fecha t) {
		if (this.fechaTurno == null) {
			this.fechaTurno = t;
			return true;
		}
		return false;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getPrioridad() {
		return this.prioridad;
	}

// fin Informacion vacunacion del Paciente----------------------------------//

// asignacion vacunacion del Paciente----------------------------------//
	public boolean asignarTurno(Fecha f) {
		return true;
	}

	public boolean asignarVacuna(Vacuna v) {
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [enfermedadPreexistente=" + enfermedadPreexistente + ", personalSalud=" + personalSalud
				+ ", dni=" + dni + ", edad=" + edad + ", fechaTurno=" + fechaTurno + ", vacuna=" + vacuna
				+ ", prioridad=" + prioridad + "]";
	}

//	public Date getFechaTurno() {
//		return null; //llenar
//	}

// fin asignacion vacunacion del Paciente------------------------------------//

	// comparable <--

	public static void main(String[] args) {
		Paciente n = new Paciente(45307940, 20, false, false);
		System.out.println(n.toString());
	}
}
