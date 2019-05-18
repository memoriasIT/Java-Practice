package prAgenda;

public class SelTfn implements Seleccion {
	
	@Override
	public boolean seleccionable(persona a) {
		boolean ok = false;
		if (a.tfn() != 0) {
			ok = true;
		}
		return ok;
	}

}
