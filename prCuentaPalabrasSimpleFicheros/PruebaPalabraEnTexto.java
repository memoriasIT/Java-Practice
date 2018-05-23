package prCuentaPalabrasSimpleFicheros;

public class PruebaPalabraEnTexto {
	PalabrasEnTexto pal1 = new PalabrasEnTexto("gorra");
	PalabrasEnTexto pal2 = new PalabrasEnTexto("Gorra");
	pal1.incrementa();
	System.out.println(pal1.equals(pal2));
	
	
}
