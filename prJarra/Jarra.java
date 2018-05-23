package prJarra;

public class Jarra {
	private int contenido;
	private int capacidad = 10;
	
	public Jarra(int a) {
		capacidad = a;
		contenido = 0;
	}
	
	public int capacidad() {
		return capacidad;
	}
	
	public int contenido() {
		return contenido;
	}
	
	public void llena() {
		contenido = capacidad;
	}
	
	public void vacia() {
		contenido = 0;
	}
	
	public void llenaDesde(Jarra a) {
//		int incap = capacidad-contenido;
//		if (a.contenido > incap) {
//			contenido = capacidad;
//			a.contenido = a.contenido-incap;
//		} else {
//			contenido += a.contenido;
//			a.contenido = 0;
//		}
		
		int c = Math.min(a.contenido, (this.capacidad - this.contenido));
		a.contenido -= c;
		this.contenido += c;

	}
	
	@Override
	public String toString() {
		return "J("+capacidad+","+contenido+")";
	}
}
