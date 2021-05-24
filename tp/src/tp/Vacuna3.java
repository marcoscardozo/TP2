package tp;

public class Vacuna3 extends Vacuna{

	public Vacuna3(String nombre, Fecha ingreso) {
		super(nombre, ingreso);
		if(nombre.equals("Sinopharm")|| nombre.equals("Astranezca") || 
				nombre.equals("Sputnik"))
			super.temp = 3;
		else
			throw new RuntimeException("Nombre de vacuna erroneo");
	}//

}
