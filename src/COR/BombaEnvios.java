package COR;

public class BombaEnvios extends Handler {

	@Override
	void handleRequest(Request request) {
		if (request.getRequestType() == RequestType.YUCATAN) {
			System.out.println("BombaEnvios puede manejar este envio");
		} else {
			successor.handleRequest(request);
		}
	}
	
}
