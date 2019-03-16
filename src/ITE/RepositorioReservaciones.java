package ITE;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import BUI.Envio;
import BUI.Reservacion;

public class RepositorioReservaciones implements Iterable<Reservacion> {
	private Reservacion[] reservaciones;
	private int index;
	
	public RepositorioReservaciones() {
		reservaciones = new Reservacion[10];
        index = 0;
    }
	
	public void addReservacion(Envio envio) {
		
		//Determine the next day to the previous date
		Date dt;
			if(index == 0) {
			dt = new Date();
			} else {
			dt = reservaciones[index-1].getFecha();
			}
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
		
		
		if(index == reservaciones.length){
			Reservacion[] largerReservaciones = new Reservacion[reservaciones.length + 5];
            System.arraycopy(reservaciones, 0, largerReservaciones, 0, reservaciones.length);
            reservaciones = largerReservaciones;
            largerReservaciones = null;
		}
		
		//Now we really add it
		reservaciones[index] = new Reservacion.Builder(dt).withEnvio(envio).build();
		index++;
	}

	@Override
	public Iterator<Reservacion> iterator() {
		Iterator<Reservacion> it = new Iterator<Reservacion>() {
			
			private int currentIndex = 0;
			
			@Override
			public boolean hasNext() {
				return currentIndex < reservaciones.length && reservaciones[currentIndex] !=null;
			}

			@Override
			public Reservacion next() {
				return reservaciones[currentIndex++];
			}
			
		};
		return it;
	}

}
