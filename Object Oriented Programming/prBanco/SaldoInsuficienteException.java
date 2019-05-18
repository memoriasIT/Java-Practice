package prBanco;

public class SaldoInsuficienteException extends CuentaException {
	public SaldoInsuficienteException(String a) {
		super(a);
	}
	
	public SaldoInsuficienteException() {
		super();
	}
}
