package prConcesionario;

public class ConcesionarioOferta extends ConcesionarioIva {
	private double porcDescuento;
	private String modeloOferta;
	
	public ConcesionarioOferta(double iva, double p, String m) {
		super(iva);
		porcDescuento = p;
		modeloOferta = m;
	}
	
	@Override
	protected double calcPrecioIva(Coche c) {
		double p = super.calcPrecioIva(c);
		if (modeloOferta.equals(c.getModelo())) {
			p = p - p*porcDescuento/100;
		}
		return p;
	}
	
	@Override
	public String toString() {
		return "Oferta(" + modeloOferta + ", " + porcDescuento+ "%) " + super.toString();
	}
	
}
