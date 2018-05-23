package prAgenda;

public class persona {
	private String nombre;
	private int tfn;
	
	public persona() {
		nombre = "";
		tfn = 0;
	}
	
	public persona(String nom, int tf) {
		nombre = nom;
		tfn = tf;
	}
		

	public persona(String parse) {
		nombre = parse.substring(0, parse.indexOf(" # "));
		try {
			tfn = Integer.parseInt(parse.substring(parse.indexOf(" # "), parse.length()));
		} catch (NumberFormatException e) {
			tfn = 0;
		}
	}
	
	public int tfn() {
		return this.tfn;
	}
	
	@Override
	public String toString() {
		return "[" + nombre + ", "+ tfn +" ]";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof persona) {
			persona x = (persona) o;
			ok = nombre.equalsIgnoreCase(x.nombre);
		}
		return ok;
	}
	
	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode();
	}
}