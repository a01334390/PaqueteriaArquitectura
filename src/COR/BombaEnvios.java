package COR;

import BUI.Envio;

public class BombaEnvios extends Handler {

	@Override
	Envio handleRequest(Request request) {
		if(request.getRequestType() == RequestType.YUCATAN) {
			System.out.println("Bomba Envios puede hacer envios a Yucatan!");
			
			double costoFinal = 0.0;
			int unidades = (int) Math.round(request.getPeso()/250);
			
			switch(request.getTipo()) {
			case DOCUMENTO:
				costoFinal = unidades * 42;
				break;
			case CAJA:
				costoFinal = unidades * 20;
				break;
			default:
				System.err.println("Soy un error!");
				System.exit(1);
			}
			
			// Crear un objeto Envio y regresar
			return new Envio.Builder(request.getRequestType(), request.getDireccionRemitente())
					.withCliente(request.getRfcCliente())
				 	.withCodigoPostal(request.getCodigoPostal())
					.withCosto(costoFinal)
					.withPeso(request.getPeso())
					.withTipo(request.getTipo())
					.esEntregaNoAtendida(request.isEsEntregaNoAtendida())
					.esFirmaContraEntrega(request.isEsFirmaContraEntrega())
					.esFragil(request.isEsFirmaContraEntrega())
					.build();
		} else {
			return successor.handleRequest(request);
		}
	}
	
}
