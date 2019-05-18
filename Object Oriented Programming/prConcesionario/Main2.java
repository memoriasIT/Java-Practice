package prConcesionario;

public class Main2 {

	public static void main(String[] args) {
			ConcesionarioIva concesionario = new ConcesionarioIva(10);
			concesionario.anyadir(new CocheOcasion("Seat-Marbella", 9000, 20));
			concesionario.anyadir(new Coche("Seat-Leon", 15000));
			concesionario.anyadir(new CocheImportado("Porsche-911", 39000, 1000));
			System.out.println("Concesionario: "+concesionario.toString());

	}

}
