package BUI;

import java.util.Date;

public class Reservacion {
	private final Date fecha;
	private final Envio envio;
	
	private Reservacion(Builder builder) {
		this.fecha = builder.fecha;
		this.envio = builder.envio;
	}

	public Date getFecha() {
		return fecha;
	}

	public Envio getEnvio() {
		return envio;
	}
	
	@Override public String toString() {
		return "{Envio: "+envio.toString()+" | Fecha: "+fecha.toString()+"}";
	}
	
	public static class Builder {
		private Date fecha;
		private Envio envio;
		
		public Builder(Date fecha) {
			this.fecha = fecha;
		}
		
		public Builder withEnvio(Envio envio) {
			this.envio = envio;
			return this;
		}
		
		public Reservacion build() {
			return new Reservacion(this);
		}
		
		
	}
}
