import java.util.ArrayList;

import BUI.Envio;
import FAC.*;

public class Main {

	public static void main(String[] args) {
		PaqueteriaFacade fac = new PaqueteriaFacade("123");
		fac.añadirEnvio(3, "CDMX", "09890", 1000, 2, true, false, false);
		fac.añadirEnvio(2, "CDMX", "09890", 29849, 1, true, true, true);
		ArrayList<Envio> envios = fac.obtenerEnvios();
		System.out.println(fac.verCostoFinal());
		System.out.println(fac.verEnvios());
		fac.removerEnvio(envios.get(0).getId());
		System.out.println(fac.verEnvios());
		fac.añadirEnvio(1, "CDMX", "09890", 50000, 1, true, true, false);
		System.out.println(fac.verEnvios());
		System.out.println(fac.verCostoFinal());
	}
}
