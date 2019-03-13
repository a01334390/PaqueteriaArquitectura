package BUI;

public class Cliente {
	private final String rfc;

	private Cliente(Builder builder) {
		this.rfc = builder.rfc;
	}

	public String getRfc() {
		return rfc;
	}
	
	@Override public String toString() {
		return this.getRfc();
	}
	
	public static class Builder {
		private String rfc;
		
		public Builder(String rfc) {
			this.rfc = rfc;
		}
		
		public Cliente build() {
			return new Cliente(this);
		}
	}
	
}
