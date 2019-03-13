package COR;

public class EnvioExpress extends Handler {

	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.SONORA) {
			System.out.println("Envio Express puede hacer envios a Sonora");
		} else {
			successor.handleRequest(request);
		}
		
	}
	
}
