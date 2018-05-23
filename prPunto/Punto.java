package prPunto;

public class Punto {
	double x, y;
	
	public Punto() {
		x = 0;
		y = 0;
	}
	
	public Punto(double coordx, double coordy) {
		x = coordx;
		y = coordy;
	}
	
	public void desplazar(double a,  double b) {
		x += a;
		y += b;
	}
	
	public double distancia(Punto p) {
		double distx = Math.abs(x-p.x);
		double disty = Math.abs(y-p.y);
		return Math.sqrt(Math.pow(disty, 2) + Math.pow(distx, 2));
	}
	
}
