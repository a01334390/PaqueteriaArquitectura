package COP;

import java.util.ArrayList;
import java.util.List;

import BUI.Envio;

public abstract class ComponenteOrden {
Envio envio;
	
	List<ComponenteOrden> componentesOrden = new ArrayList<>();

	public Envio getEnvio() {
		return envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}
	
	public abstract String toString();
	
	String print(ComponenteOrden componenteOrden) {
		return envio.toString();
	}
}
