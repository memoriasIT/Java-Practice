package prDatos;
import java.util.Arrays;

public class Datos {
	private double max;
	private double min;
	private double[] datos;
	private String[] errores;
	
	
	public Datos(String[] a, double b, double c) {
		//Get data from string
		datos = new double[a.length];
		errores = new String[a.length];
		//Number data & errors
		int nd = 0;
		int ne = 0;
		
		for (String item : a) {
			try {
				//String to Array of double 
				
					datos[nd] = Double.parseDouble(item);	
					nd++;
			} catch (NumberFormatException e) {
			//Array of errors
			errores[ne] = item;
			ne++;
			}
		}
		
		datos = Arrays.copyOf(datos, nd);
		errores = Arrays.copyOf(errores, ne);
		
		if (maximo(b, c)) {
			max = b;
			min = c;
		} else {
			max = c;
			min = b;
		}
	}
	
	
	private static boolean maximo(double a, double b) {
		return a>b;
	}
	
	private double calcMedia() {
		double sum = 0;
		int cont = 0;
		
		for (double x : datos) {
			sum += x;
			cont++;
		}		
		try {
			return sum/cont;
		} catch (Exception e) {
			throw new DatosException("0");
		}
		
	}
	
	private void setRango(String a) {
		//Gets string with "min;max" 
		int index = a.indexOf(";");
		min = Double.parseDouble(a.substring(0, index));
		max = Double.parseDouble(a.substring(index+1, a.length()));
		
	}
	
	@Override
	public String toString() {
		String res = "";
		try {
			res += "Min: " + min + "; Max: " + max + "; \n" + Arrays.toString(datos) + ", \n" + Arrays.toString(errores) + "; \n Media: ";
			res += calcMedia() + "; Desviación Media: ";
		} catch (DatosException e) {
			res += "Error en media";
		}
		return res;
	}
	
	
}
