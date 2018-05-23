package prBanco;

public class Cuenta {
	String nombre;
	int num;
	double saldo;
	
	public Cuenta(String t, int n, double s) throws SaldoNegativoException {
		nombre = t;
		num = n;
		if (s < 0) {
			throw new SaldoNegativoException("Saldo negativo");
		} else {
			saldo = s;	
		}
	}
	
	public void ingresar(double c) throws IngresoNegativoException {
		if (c < 0) {
			throw new IngresoNegativoException("Ingreso Negativo");
		} else {
			saldo += c;
		}
	}
	
	public void extraer(double c) throws SaldoInsuficienteException, ExtraerNegativoException {
		if (c < 0) {
			throw new ExtraerNegativoException("Extraer Negativo");
		}
		if (c > saldo) {
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		} else {
			saldo -= c;
		}
		
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " ; Num. Cuenta: " + num + " ; Saldo: " + saldo;
		
	}
	
	
}
