import COR.*;
import STT.*;

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
		Envio envio = new Envio.Builder(RequestType.PACHUCA,"CDMX")
				.withCodigoPostal("09890")
				.withPeso(235.9)
				.withCliente(cliente).build();
		
		System.out.println(envio);
	}
}
