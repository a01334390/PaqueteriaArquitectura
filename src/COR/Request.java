package COR;

import BUI.Cliente;
import BUI.Tipo;

public class Request {
	private RequestType requestType;
	private String direccionRemitente;
	private String codigoPostal;
	private double peso;
	private Cliente rfcCliente;
	private Tipo tipo;
	private boolean esFragil = false;
	private boolean esFirmaContraEntrega = false;
	private boolean esEntregaNoAtendida = false;
	
	public Request(RequestType requestType, String direccionRemitente, String codigoPostal, double peso,
			Cliente rfcCliente, Tipo tipo, boolean esFragil, boolean esFirmaContraEntrega, boolean esEntregaNoAtendida) {
		this.requestType = requestType;
		this.direccionRemitente = direccionRemitente;
		this.codigoPostal = codigoPostal;
		this.peso = peso;
		this.rfcCliente = rfcCliente;
		this.tipo = tipo;
		this.esFragil = esFragil;
		this.esFirmaContraEntrega = esFirmaContraEntrega;
		this.esEntregaNoAtendida = esEntregaNoAtendida;
	}
	
	public RequestType getRequestType() {
		return requestType;
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
	
	public Tipo getTipo() {
		return tipo;
	}

	public boolean isEsFragil() {
		return esFragil;
	}

	public boolean isEsFirmaContraEntrega() {
		return esFirmaContraEntrega;
	}

	public boolean isEsEntregaNoAtendida() {
		return esEntregaNoAtendida;
	}
	
	
}
