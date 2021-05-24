package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CentroAlmacenamiento {

	private ArrayList<Vacuna18> vacunas18;
	private ArrayList<Vacuna3> vacunas3;
	public TipoVacuna t;

	public CentroAlmacenamiento() {
		vacunas18 = new ArrayList<Vacuna18>();
		vacunas3 = new ArrayList<Vacuna3>();
	}

	public void agregarVacunas(String nombre, int cant, Fecha ingreso) {
		if (nombre.equals("Pfizer") || nombre.equals("Moderna"))
			for (int i = 0; i < cant; i++)
				vacunas18.add(new Vacuna18(nombre, ingreso));
		else if (nombre.equals("Sinopharm") || nombre.equals("Astranezca") || nombre.equals("Sputnik"))
			for (int i = 0; i < cant; i++)
				vacunas3.add(new Vacuna3(nombre, ingreso));
	}

	public int obtenerCantidadDevacunasPorNombre(String nombre) {
		int vacunas = 0;
		if (nombre.equals("Pfizer"))
			for (Vacuna18 vacuna18 : vacunas18) {
				if (vacuna18.verNombre().equals("Pfizer"))
					vacunas += 1;
			}
		if (nombre.equals("Moderna"))
			for (Vacuna18 vacuna181 : vacunas18) {
				if (vacuna181.verNombre().equals("Moderna"))
					vacunas += 1;
			}
		return vacunas;
	}

	private void descontarVacuna(String nombre) {
	}

	public String toString() {
		return null;
	}//

	// enum--------------------------------------------------------------------------------------------------
	enum TipoVacuna {
		PZIFER("pzifer"), SPUTNIK("sputnik"), SINOPHARM("sinopharm"), MODERNA("moderna"), ASTRANEZCA("astranezca");
// recibe en mayusculas y devuelve lo de adentro, en minuscula.

		private TipoVacuna(String nombre) {
			this.tipoVacuna = nombre;

		}

		private String tipoVacuna;

		public String getTipoVacuna() {
			return tipoVacuna;
		}
	}
	// ----------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
//		TipoVacuna tipo = Enum.valueOf(TipoVacuna.class, "MODERNA");
//		System.out.println(tipo.getTipoVacuna());

	}
}
