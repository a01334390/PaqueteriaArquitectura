package COP;

import java.util.ArrayList;
import java.util.UUID;

import BUI.Envio;

public class Orden extends ComponenteOrden {
	
	public Orden() {
		this.envio = null;
	}
	
	public ComponenteOrden add(ComponenteOrden componenteOrden) {
		componentesOrden.add(componenteOrden);
		return componenteOrden;
	}
	
	public ComponenteOrden remove(ComponenteOrden componenteOrden) {
		componentesOrden.remove(componenteOrden);
		return componenteOrden;
	}
	
	public ComponenteOrden get(UUID id) {
		for(ComponenteOrden componenteOrden : componentesOrden) {
			if(componenteOrden.getEnvio().getId() == id) {
				return componenteOrden;
			}
		}
		
		return null;
	}
	
	public ArrayList<Envio> get() {
		ArrayList<Envio> envios = new ArrayList<>();
		for(ComponenteOrden componenteOrden : componentesOrden) {
			envios.add(componenteOrden.getEnvio());
		}
		return envios;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
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
