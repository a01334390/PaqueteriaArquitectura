package COR;

import BUI.Envio;

public class PastesGo extends Handler{

	@Override
	Envio handleRequest(Request request) {
		if(request.getRequestType() == RequestType.PACHUCA) {
			System.out.println("Pastes Go puede hacer envios a Pachuca!");
			
			double costoFinal = 0.0;
			int unidades = (int) Math.round(request.getPeso()/250);
			
			switch(request.getTipo()) {
			case DOCUMENTO:
				costoFinal = unidades * 59;
				break;
			case CAJA:
				costoFinal = unidades * 19;
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
					.withTipo(request.getTipo()).build();
		} else {
			return null;
		}
	}

}
