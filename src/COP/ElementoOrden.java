package COP;

import BUI.Envio;

public class ElementoOrden extends ComponenteOrden {

	public ElementoOrden(Envio envio) {
		this.envio = envio;
	}
	
	@Override
	public String toString() {
		return print(this);
	}
	
}
