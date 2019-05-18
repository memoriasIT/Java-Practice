package prConcesionario;

public class CocheOcasion extends Coche {
	private double porcDescuento;
	public CocheOcasion(String m, double p, double desc) {
		super(m, p);
		porcDescuento = desc;
	}
	
	
	@Override
	public double getPrecio() {
		return super.getPrecio()* ((100-porcDescuento)/100);
	}
	
}
