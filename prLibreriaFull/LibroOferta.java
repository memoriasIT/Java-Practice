package prLibreriaFull;

public class LibroOferta extends Libro{
	private double porcDescuento;
	
	public LibroOferta(String a, String b, double c, double d) {
		super(a, b, c);
		porcDescuento = c;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	@Override
	public double getPrecioFinal() {
		
	}
	
	@Override
	public String toString() {
		
	}
	
}
