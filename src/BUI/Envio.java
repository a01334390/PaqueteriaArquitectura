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
	
	private Envio(Builder builder) {
		this.id = builder.id;
		this.direccionEntrega = builder.direccionEntrega;
		this.direccionRemitente = builder.direccionRemitente;
		this.codigoPostal = builder.codigoPostal;
		this.peso = builder.peso;
		this.rfcCliente = builder.rfcCliente;
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
	
	@Override public String toString() {
		return "(envio (cliente "+rfcCliente+"(peso "+peso+"(codigoPostal "+codigoPostal+"(direccionRemitente "+direccionRemitente+"(direccionEntrega "+direccionEntrega+"(id "+id+")))))))";
		
	}
	
	public static class Builder {
		private UUID id;
		private RequestType direccionEntrega;
		private String direccionRemitente;
		private String codigoPostal;
		private double peso;
		private Cliente rfcCliente;
		
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
		
		public Envio build() {
			return new Envio(this);
		}
		
	}
	
}
