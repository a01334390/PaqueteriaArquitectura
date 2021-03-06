package COR;
import BUI.Envio;

public abstract class Handler {
	protected Handler successor;
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	abstract Envio handleRequest(Request request);
}
