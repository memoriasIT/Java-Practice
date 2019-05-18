package prConcesionario;

public class CocheImportado extends Coche {
	private double costeHomolog;
	public CocheImportado(String m, double p, double c) {
		super(m, p);
		costeHomolog = c;
	}

	@Override
	public double getPrecio() {
		return super.getPrecio()+costeHomolog;
	}
}
