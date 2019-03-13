package COR;

public class PastesGo extends Handler{

	@Override
	void handleRequest(Request request) {
		if (request.getRequestType() == RequestType.PACHUCA) {
			System.out.println("PastesGo puede manejar este envio");
		} else {
			System.err.println("No podemos realizar envios a otra zona");
		}
	}

}
