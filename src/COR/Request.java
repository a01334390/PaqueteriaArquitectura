package COR;

public class Request {
	private RequestType requestType;
	
	public Request(RequestType requestType, double amount) {
		this.requestType = requestType;
	}
	
	public RequestType getRequestType() {
		return requestType;
	}
}
