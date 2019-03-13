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
	
	public Request(RequestType requestType, String direccionRemitente, String codigoPostal, double peso,
			Cliente rfcCliente, Tipo tipo) {
		this.requestType = requestType;
		this.direccionRemitente = direccionRemitente;
		this.codigoPostal = codigoPostal;
		this.peso = peso;
		this.rfcCliente = rfcCliente;
		this.tipo = tipo;
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
	
	
}
