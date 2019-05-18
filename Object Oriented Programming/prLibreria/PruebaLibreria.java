package prLibreria;

public class PruebaLibreria {
	public static void main(String[] args) {
		Libreria test = new Libreria();
			
		test.addLibro("Titulo 2", "autor2", 10.20);
		test.addLibro("Titulo 3", "autor2", 10.20);
		test.addLibro("Titulo 4", "autor2", 10.20);
		test.addLibro("Titulo 5", "autor2", 10.20);
		
		test.remLibro("Titulo 4", "autor2");
		
		test.toString();
	}

}
