package prUrna;

public class Urna {
	private int bblanca;
	private int bnegra;
	private static int ID = 0;
	
	public Urna() {
		bblanca = 0;
		bnegra = 0;
		ID = getID();
	}
	
	private static int getID() {
		ID++;
		return ID;
	}
	
	public Urna(int b, int n) {
		bblanca = b;
		bnegra = n;
	}
	
	
	@Override
	public String toString() {
		return "Urna" + ID + ": "+ bblanca +  " : " + bnegra; 
	}
	
	public void introducir(boolean a, int x) {
		if (a == false) {
			bblanca += x;
		} else {
			bnegra += x;
		}
	}
	
	public void sacar(int x) {
		int cont = 0;
		try {
			while (cont != x){
				if (Math.random()<0.5) {
					if (bblanca > 0) {
						bblanca--;	
					} else {
						throw new SinBolas("No quedan Bolas Blancas");
					}
				} else {
					if (bnegra > 0) {
						bnegra--;
					} else {
						throw new SinBolas("No quedan Bolas Negras");
					}
				}
				cont++;
			}
		} catch (SinBolas e) {
			System.out.println(e);
			System.out.printf("\nSolo se han sacado %s bolas.\n", cont);
		}
	}
	
	public boolean getVacia() {
		boolean res = false;
		if (bblanca + bnegra == 0) {
			res = true;
		}
		return res;
	}
	
	public int getNumBolas() {
		return bblanca+bnegra;
	}
	

}
