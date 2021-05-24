package tp;

import java.util.ArrayList;

public class Vacuna18 extends Vacuna {
	public Vacuna18(String nombre, Fecha ingreso) {
		super(nombre, ingreso);
		if(nombre.equals("Pfizer")|| nombre.equals("Moderna"))
			super.temp = -18;
		else
			throw new RuntimeException("Nombre de vacuna erroneo");
	}
	
//	public static void main(String[] args) {
//		//prueba 
//		ArrayList<Vacuna> v = new ArrayList<Vacuna>();
//		v.add(new Vacuna18("Moderna", new Fecha(11,2,1220)));
//		v.add(new Vacuna18("Pfizer", new Fecha(12,2,1220)));
//		v.add(new Vacuna3("Sinopharm", new Fecha(12,2,1220)));
//		v.add(new Vacuna3("Sputnik", new Fecha(12,2,1220)));
//		for (Vacuna vacuna : v) {
//				System.out.println(vacuna.verNombre());
//		}
//	//	
//	}
}
