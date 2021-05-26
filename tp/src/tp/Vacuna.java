package tp;




public abstract class Vacuna {

	private String nombre;
	protected int temp;
	private Fecha ingreso;
	private boolean vencida = false;
	
	public Vacuna(String nombre, Fecha ingreso) {
		this.nombre = nombre;
		this.ingreso = ingreso;

	}
	public String verNombre() {
		return this.nombre;
	}
	public int verTemperatura() {
		return this.temp;
	}
	public Fecha getFechaIngreso() {
		return ingreso;
	}
	public void cambiarAvencida() {
		vencida = true;
	}
	
	@Override
	public String toString() {
		return "Vacuna [nombre==" + nombre + ", temp=" + temp + ", ingreso=" + ingreso + ", vencida=" + vencida + "]";
	}
	
}
