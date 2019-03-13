package COP;

import BUI.Envio;

public class Orden extends ComponenteOrden {
	
	public Orden(Envio envio) {
		this.envio = envio;
	}
	
	public ComponenteOrden add(ComponenteOrden componenteOrden) {
		componentesOrden.add(componenteOrden);
		return componenteOrden;
	}
	
	public ComponenteOrden remove(ComponenteOrden componenteOrden) {
		componentesOrden.remove(componenteOrden);
		return componenteOrden;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(print(this));
		builder.append("\n");
		
		for(ComponenteOrden componenteOrden : componentesOrden) {
			builder.append(componenteOrden.toString());
			builder.append("\n");
		}
		return builder.toString();
	}

	@Override
	public double getFinalCost() {
		double fincost = 0;
		for(ComponenteOrden componenteOrden : componentesOrden) {
			fincost+= componenteOrden.getFinalCost();
		}
		return fincost;
	}

}
