package FAC;

import COP.*;

import java.util.ArrayList;
import java.util.UUID;

import BUI.*;
import COR.*;
import FAC.*;
import ITE.RepositorioReservaciones;

/**
 * Fachada para la paqueteria
 * @author A01334390
 */
public class PaqueteriaFacade {
	private Orden orden;
	private EnvioExpress ee;
	private BombaEnvios be;
	private PastesGo pg;
	private Cliente cliente;
	RepositorioReservaciones rr;

	public PaqueteriaFacade(String rfc) {
		// Crea el repositorio de reservaciones
		rr = new RepositorioReservaciones();
		// Crea la nueva orden
		orden = new Orden(rr);
		// Establece la precedencia del COR
		ee = new EnvioExpress();
		be = new BombaEnvios();
		pg = new PastesGo();
		// Crear los sucesores
		ee.setSuccessor(be);
		be.setSuccessor(pg);
		// Crea al cliente que realizara el pedido
		cliente = new Cliente.Builder(rfc).build();
	}
	
	/**
	 * Genera un envio a una direccion y lo añade a la orden (con tags)
	 * @param direccionEnvio Direccion de envio, 0 -> Envio express  1 -> BombaEnvios  2 -> PastesGo
	 * @param direccionRemitente Direccion del remitente en una oracion
	 * @param codigoPostal Codigo Postal de 5 digitos
	 * @param peso Peso en gramos
	 * @param tipo Documento o Caja
	 * @param esFragil
	 * @param esFirmaContraEntrega
	 * @param esEntregaNoAtendida
	 */
	
	public void añadirEnvio(int direccionEnvio, String direccionRemitente, String codigoPostal, double peso, int tipo, boolean esFragil, boolean esFirmaContraEntrega, boolean esEntregaNoAtendida) {
		Request request = new Request(RequestType.values()[direccionEnvio-1], direccionRemitente, codigoPostal,peso,this.cliente,Tipo.values()[tipo-1],esFragil,esFirmaContraEntrega,esEntregaNoAtendida);
		ElementoOrden en = new ElementoOrden(ee.handleRequest(request));
		orden.add(en);
	}
	
	/**
	 * Obtiene un envio de la orden
	 * @param id unica del Envio
	 * @return el objeto Envio o nulo
	 */
	public Envio obtenerEnvio(UUID id) {
		return orden.get(id).getEnvio();
	}
	
	/**
	 * Remueve un envio dado su identificador unico
	 * @param id del Envio
	 * @return true si pudo borrarse false si no
	 */
	public boolean removerEnvio(UUID id) {
		return orden.remove(orden.get(id)) == null? false : true;
	}
	
	/**
	 * Obtiene un ArrayList con envios
	 * @return una lista de Envios en la orden
	 */
	public ArrayList<Envio> obtenerEnvios(){
		return orden.get();
	}
	
	/**
	 * Regresa un string con todas las ordenes y sus detalles
	 * @return Ordenes y sus detalles
	 */
	public String verEnvios() {
		return orden.toString();
	}
	
	/**
	 * Regresa un double con el valor final del envio
	 * @return Valor final del envio
	 */
	public double verCostoFinal() {
		return orden.getFinalCost();
	}
	
	public void realizarEnvio() {
		System.out.println("## Los envios estan siendo programados ##");
		orden.realizarEnvios();
	}
	
}
