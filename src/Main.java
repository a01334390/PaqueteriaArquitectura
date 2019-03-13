import BUI.*;
import COP.*;
import COR.*;

public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente.Builder("123").build();
		
		EnvioExpress ee = new EnvioExpress();
		BombaEnvios be = new BombaEnvios();
		PastesGo pg = new PastesGo();
		
		ee.setSuccessor(be);
		be.setSuccessor(pg);
		
		Request request0 = new Request(RequestType.PACHUCA, "CDMX", "0624",500,cliente,Tipo.DOCUMENTO);
		Envio en0 = ee.handleRequest(request0);
		
		Request request = new Request(RequestType.PACHUCA, "CDMX", "0624",500,cliente,Tipo.CAJA);
		ElementoOrden en1 = new ElementoOrden(ee.handleRequest(request));
		
		Request request2 = new Request(RequestType.YUCATAN, "CDMX", "0624",1273,cliente,Tipo.DOCUMENTO);
		ElementoOrden en2 = new ElementoOrden(ee.handleRequest(request2));
		
		Request request3 = new Request(RequestType.SONORA, "CDMX", "0624",12937,cliente,Tipo.CAJA);
		ElementoOrden en3 = new ElementoOrden(ee.handleRequest(request3));
		
		Orden orden = new Orden(en0);
		orden.add(en1);
		orden.add(en2);
		orden.add(en3);
		
		System.out.println(orden.toString());
		System.out.println(orden.getFinalCost());
		
		
		//Test ClienteCreation

		
		// Test EnvioCreation
//		Envio envio1 = new Envio.Builder(RequestType.YUCATAN,"CDMX")
//				.withCodigoPostal("06234")
//				.withPeso(4553)
//				.withCliente(cliente).build();
//		
//		Envio envio2 = new Envio.Builder(RequestType.PACHUCA,"CDMX")
//				.withCodigoPostal("09890")
//				.withPeso(235.9)
//				.withCliente(cliente).build();
//		
//		Envio envio3 = new Envio.Builder(RequestType.SONORA,"CDMX")
//				.withCodigoPostal("21334")
//				.withPeso(400.9)
//				.withCliente(cliente).build();
//		
		// TEST COR
//		Orden orden = new Orden(envio1);
//		ElementoOrden eo1 = new ElementoOrden(envio2);
//		orden.add(eo1);
//		ElementoOrden eo2 = new ElementoOrden(envio3);
//		orden.add(eo2);
//		
//		System.out.println(orden.toString());
		
	}
}
