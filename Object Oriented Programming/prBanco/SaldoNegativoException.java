package prBanco;

public class SaldoNegativoException extends CuentaException {
	public SaldoNegativoException(String a) {
		super(a);
	}
	
	public SaldoNegativoException() {
		super();
	}
}
