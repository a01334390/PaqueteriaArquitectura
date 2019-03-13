import BUI.*;
import COP.*;
import COR.*;

public class Main {

	public static void main(String[] args) {
		EnvioExpress ee = new EnvioExpress();
		BombaEnvios be = new BombaEnvios();
		PastesGo pg = new PastesGo();
		
		ee.setSuccessor(be);
		be.setSuccessor(pg);
		
		Request request = new Request(RequestType.YUCATAN);
		ee.handleRequest(request);
		
		//Test ClienteCreation
		Cliente cliente = new Cliente.Builder("123").build();
		
		// Test EnvioCreation
		Envio envio1 = new Envio.Builder(RequestType.YUCATAN,"CDMX")
				.withCodigoPostal("06234")
				.withPeso(4553)
				.withCliente(cliente).build();
		
		Envio envio2 = new Envio.Builder(RequestType.PACHUCA,"CDMX")
				.withCodigoPostal("09890")
				.withPeso(235.9)
				.withCliente(cliente).build();
		
		Envio envio3 = new Envio.Builder(RequestType.SONORA,"CDMX")
				.withCodigoPostal("21334")
				.withPeso(400.9)
				.withCliente(cliente).build();
		
		// TEST COR
		Orden orden = new Orden(envio1);
		ElementoOrden eo1 = new ElementoOrden(envio2);
		orden.add(eo1);
		ElementoOrden eo2 = new ElementoOrden(envio3);
		orden.add(eo2);
		
		System.out.println(orden.toString());
		
	}
}
