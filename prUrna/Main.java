package prUrna;

public class Main {

	public static void main(String[] args) {
		Urna urna1 = new Urna();
		Urna urna2 = new Urna(5, 5);

		
		System.out.println(urna1.toString());
		System.out.println(urna2.toString());
		
		urna1.introducir(false, 12);
		System.out.println(urna1.toString());
		
		urna1.sacar(5);
		urna2.sacar(10);
	}

}
