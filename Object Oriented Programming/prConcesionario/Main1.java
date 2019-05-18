package prConcesionario;

public class Main1 {

	public static void main(String[] args) {
		ConcesionarioSimple concesionario = new ConcesionarioSimple();
		concesionario.anyadir(new CocheOcasion("Seat-Marbella", 9000, 20));
		concesionario.anyadir(new Coche("Seat-Leon", 15000));
		concesionario.anyadir(new CocheImportado("Porsche-911", 39000, 1000));

		
		System.out.println("Precio Seat-Marbella: "+concesionario.getPrecio("Seat-Marbella"));
		System.out.println("Precio Seat-Leon: "+concesionario.getPrecio("Seat-Leon"));
		System.out.println("Precio Porsche-911: "+concesionario.getPrecio("Porsche-911"));
		System.out.println("Concesionario: "+concesionario.toString());

	}

}
