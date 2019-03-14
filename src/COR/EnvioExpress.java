package COR;

import BUI.Envio;
import BUI.Tipo;

public class EnvioExpress extends Handler {

	@Override
	public Envio handleRequest(Request request) {
		if(request.getRequestType() == RequestType.SONORA) {
			System.out.println("Envio Express puede hacer envios a Sonora!");
			
			double costoFinal = 0.0;
			int unidades = (int) Math.round(request.getPeso()/250);
			
			switch(request.getTipo()) {
			case DOCUMENTO:
				costoFinal = unidades * 39;
				break;
			case CAJA:
				costoFinal = unidades * 25;
				break;
			default:
				System.err.println("Soy un error!");
				System.exit(1);
			}
			
			//Manejar sobrecostos
			if(request.getPeso() > 5000) {
				int sobreUnidad = (int) Math.round((request.getPeso() - 5000)/250);
				costoFinal += sobreUnidad * 500;
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
