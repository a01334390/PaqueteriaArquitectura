package COP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import BUI.Envio;
import BUI.Reservacion;
import ITE.RepositorioReservaciones;

public class Orden extends ComponenteOrden {
	
	RepositorioReservaciones rr;
	
	public Orden(RepositorioReservaciones rr) {
		this.rr = rr;
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
	
	public void realizarEnvios() {
		for(ComponenteOrden componenteOrden : componentesOrden) {
			rr.addReservacion(componenteOrden.getEnvio());
		}
		
		Iterator<Reservacion> reservacionIterator = rr.iterator();
		while(reservacionIterator.hasNext()) {
			Reservacion act = reservacionIterator.next();
			System.out.println("El envio: "+act.getEnvio().getId()+", sera enviado el dia: "+act.getFecha().toString());
		}
	}

}
