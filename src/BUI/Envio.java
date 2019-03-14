package BUI;

import java.util.UUID;
import COR.RequestType;

public class Envio {
	private final UUID id;
	private final RequestType direccionEntrega;
	private final String direccionRemitente;
	private final String codigoPostal;
	private final double peso;
	private final Cliente rfcCliente;
	private final double costo;
	private final Tipo tipo;
	private final boolean esFragil;
	private final boolean esFirmaContraEntrega;
	private final boolean esEntregaNoAtendida;
	
	private Envio(Builder builder) {
		this.id = builder.id;
		this.direccionEntrega = builder.direccionEntrega;
		this.direccionRemitente = builder.direccionRemitente;
		this.codigoPostal = builder.codigoPostal;
		this.peso = builder.peso;
		this.rfcCliente = builder.rfcCliente;
		this.costo = builder.costo;
		this.tipo = builder.tipo;
		this.esFragil = builder.esFragil;
		this.esFirmaContraEntrega = builder.esFirmaContraEntrega;
		this.esEntregaNoAtendida = builder.esEntregaNoAtendida;
	}

	public UUID getId() {
		return id;
	}

	public RequestType getDireccionEntrega() {
		return direccionEntrega;
	}

	public String getDireccionRemitente() {
		return direccionRemitente;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public double getPeso() {
		return peso;
	}

	public Cliente getRfcCliente() {
		return rfcCliente;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public boolean esFragil() {
		return esFragil;
	}

	public boolean esFirmaContraEntrega() {
		return esFirmaContraEntrega;
	}

	public boolean esEntregaNoAtendida() {
		return esEntregaNoAtendida;
	}

	@Override public String toString() {
		return "{Envio: "+id+"\n"
				+ "\tDireccion de Entrega: "+direccionEntrega+"\n"
			    + "\tCodigo Postal: "+codigoPostal+"\n"
			    + "\tPeso: "+peso+"\n"
			    + "\tRFC: "+rfcCliente.toString()+"\n"
			    + "\tCosto:"+costo+"\n"
			    + "\tTipo: "+tipo+"\n"
			    + "\tesFragil?: "+esFragil+"\n"
			    + "\tSe firma contra entrega?: "+esFirmaContraEntrega+"\n"
			    + "\tSe puede entregar sin firma?: "+esEntregaNoAtendida+"}";
				
		
	}
	
	public static class Builder {
		private UUID id;
		private RequestType direccionEntrega;
		private String direccionRemitente;
		private String codigoPostal;
		private double peso;
		private Cliente rfcCliente;
		private double costo;
		private Tipo tipo;
		private boolean esFragil = false;
		private boolean esFirmaContraEntrega = false;
		private boolean esEntregaNoAtendida = false;
		
		public Builder(RequestType direccionEntrega, String direccionRemitente) {
			this.id = UUID.randomUUID();
			this.direccionEntrega = direccionEntrega;
			this.direccionRemitente = direccionRemitente;
		}
		
		public Builder withCodigoPostal(String codigoPostal) {
			this.codigoPostal = codigoPostal;
			return this;
		}
		
		public Builder withPeso(double peso) {
			this.peso = peso;
			return this;
		}
		
		public Builder withCliente(Cliente rfcCliente) {
			this.rfcCliente = rfcCliente;
			return this;
		}
		
		public Builder withCosto(double costo) {
			this.costo = costo;
			return this;
		}
		
		public Builder withTipo(Tipo tipo) {
			this.tipo = tipo;
			return this;
		}
		
		public Builder esFragil(boolean e) {
			this.esFragil = true;
			return this;
		}
		
		public Builder esFirmaContraEntrega(boolean e) {
			this.esFirmaContraEntrega = true;
			return this;
		}
		
		public Builder esEntregaNoAtendida(boolean e) {
			this.esEntregaNoAtendida = e;
			return this;
		}
		
		public Envio build() {
			return new Envio(this);
		}
		
	}
	
}
