package tp;


public class Paciente {
	private boolean enfermedadPreexistente;
	private boolean personalSalud;
	private int dni;
	private Fecha edad;
	private Fecha fechaTurno;
	private String vacuna;
	private int prioridad;
	protected boolean vacunado;

	public Paciente(int dni, Fecha edad, boolean enfermedadPreexistente, boolean personalSalud) {
		this.dni = dni;
		this.edad = edad;
		this.enfermedadPreexistente = enfermedadPreexistente;
		this.personalSalud = personalSalud;
		this.vacunado = false;
	}

// Informacion personal del Paciente----------------------------------//

	public int getDni() {
		return this.dni;
	}

	public Fecha getEdad() {
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

	public void asignarVacuna(String v) {
		this.vacuna = v;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (dni != other.dni)
			return false;
		return true;
	}
}
